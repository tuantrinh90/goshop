package injection.components;

import com.goshop.app.GoShopApplication;

import android.app.Application;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;
import injection.modules.ApplicationModule;
import injection.modules.NetModule;
import retrofit2.Retrofit;

@Component(modules = {ApplicationModule.class, NetModule.class})
@Singleton
public interface ApplicationComponent {

    @Named("DefaultRetrofit")
    Retrofit defaultRetrofit();

    Application appliation();

    final class Initializer {

        private Initializer() {
        }

        public static ApplicationComponent init(GoShopApplication app) {
            return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(app)).netModule(new NetModule())
                .build();
        }
    }

}
