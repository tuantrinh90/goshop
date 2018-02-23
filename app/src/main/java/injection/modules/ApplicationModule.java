package injection.modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class ApplicationModule {
    private Application mApplication;
    public ApplicationModule(Application application){
        this.mApplication= application;
    }

    @Provides
    @Singleton
    public Application providesApplication(){
        return this.mApplication;
    }

}
