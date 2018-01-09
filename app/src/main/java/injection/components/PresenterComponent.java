package injection.components;

import com.goshop.app.presentation.home.HomeActivity;
import com.goshop.app.presentation.login.RegisterActivity;

import android.app.Activity;

import dagger.Component;
import injection.ActivityScope;
import injection.modules.PresenterModule;

/**
 * Created by Administrator on 2017/10/10.
 */
@ActivityScope
@Component(modules = PresenterModule.class, dependencies = ApplicationComponent.class)
public interface PresenterComponent {

    Activity getActivity();

    void inject(HomeActivity homeActivity);

    void inject(RegisterActivity registerActivity);
}
