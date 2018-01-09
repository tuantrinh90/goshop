package injection.modules;

import com.goshop.app.domian.AccountDataRepository;
import com.goshop.app.presentation.home.HomeContract;
import com.goshop.app.presentation.home.HomePresenter;
import com.goshop.app.presentation.login.RegisterContract;
import com.goshop.app.presentation.login.RegisterPresenter;

import android.app.Activity;
import android.support.v4.app.Fragment;

import dagger.Module;
import dagger.Provides;
import injection.ActivityScope;

/**
 * Created by ray on 2017/5/5.
 */
@Module

public class PresenterModule {

    private Fragment fragment;

    private Activity mActivity;

    public PresenterModule(Activity activity) {
        this.mActivity = activity;
    }

    public PresenterModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @ActivityScope
    public Fragment provideFrament() {
        return fragment;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @ActivityScope
    public HomeContract.Presenter provideHomePresenter(AccountDataRepository dataRepository) {
        return new HomePresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public RegisterContract.Presenter provideRegisterPresenter(
        AccountDataRepository dataRepository) {
        return new RegisterPresenter(dataRepository);
    }


}
