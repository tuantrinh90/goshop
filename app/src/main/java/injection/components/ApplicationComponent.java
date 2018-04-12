package injection.components;

import com.goshop.app.GoShopApplication;
import com.goshop.app.data.source.AccountDataSource;
import com.goshop.app.data.source.ProductDataSource;

import android.app.Application;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;
import injection.modules.ApplicationModule;
import injection.modules.NetModule;

@Component(modules = {ApplicationModule.class, NetModule.class})
@Singleton
public interface ApplicationComponent {

    @Named("localAccountDataSource")
    AccountDataSource getLocalAccountDataSource();

    @Named("cloudAccountDataSource")
    AccountDataSource getCloudAccountDataSource();

    @Named("localProductDataSource")
    ProductDataSource getLocalProductDataSource();

    @Named("cloudProductDataSource")
    ProductDataSource getCloudProductDataSource();

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
