package injection.components;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Subcomponent;
import injection.modules.NetModule;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by Ray on 2018/1/5.
 */
@Subcomponent(modules = NetModule.class)
@Singleton
public interface NetwrokComponent {

    @Named("DefaultRetrofit")
    Retrofit defaultRetrofit();

    @Named("DefaultOkHttpClient")
    OkHttpClient defaultOkhttpClient();
}
