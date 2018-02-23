package injection.modules;

import com.google.gson.Gson;

import com.goshop.app.BuildConfig;
import com.goshop.app.data.LocalApi;
import com.goshop.app.data.RestApi;
import com.goshop.app.data.realm.RealmDataSource;
import com.goshop.app.data.retrofit.RetrofitRestApiImpl;
import com.goshop.app.data.source.AccountDataSource;
import com.goshop.app.data.source.cloud.AccountCloudDataSource;
import com.goshop.app.data.source.local.AccountLocalDataSource;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetModule {

    private final static int CONNECTION_TIMEOUT = 60;

    private final static int READ_TIMEOUT = 25;

    private final static int WRITE_TIMEOUT = 25;

    public NetModule() {
    }

    @Provides
    @Named("DefaultOkHttpClient")
    @Singleton
    public OkHttpClient provideOkhttpClient() {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(loggingInterceptor);
        builder.addInterceptor(chain -> {
            Request original = chain.request();
            Request request = original.newBuilder()
                //TODO (ray) If you need to add public parameters, add them here
//                .header("", "")
                .method(original.method(), original.body())
                .build();
            return chain.proceed(request);
        });
        builder.connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS);
        builder.readTimeout(READ_TIMEOUT, TimeUnit.SECONDS);
        builder.writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(false);
        builder.retryOnConnectionFailure(true);
        return builder.build();
    }

    @Provides
    @Singleton
    public Gson provideGson() {
        return new Gson();
    }

    @Provides
    @Named("DefaultRetrofit")
    @Singleton
    public Retrofit provideDefaultRetrofit(Gson gson,
        @Named("DefaultOkHttpClient") OkHttpClient client) {
        return new Retrofit.Builder()
            .baseUrl(BuildConfig.SERVICE_API_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
    }

    @Provides
    public LocalApi provideLocalApi(RealmDataSource realmDataSource) {
        return realmDataSource;
    }

    @Provides
    public RestApi provideRestApi(@Named("DefaultRetrofit") Retrofit retrofit) {
        return new RetrofitRestApiImpl(retrofit);
    }

    @Provides
    @Named("localAccountDataSource")
    public AccountDataSource provideLocalAccountDataSource(LocalApi localApi) {
        return new AccountLocalDataSource(localApi);
    }

    @Provides
    @Named("cloudAccountDataSource")
    public AccountDataSource provideCloudAccountDataSource(RestApi restApi) {
        return new AccountCloudDataSource(restApi);
    }


}
