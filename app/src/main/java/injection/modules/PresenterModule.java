package injection.modules;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.goshop.app.domian.AccountDataRepository;
import com.goshop.app.presentation.account.LoginContract;
import com.goshop.app.presentation.account.LoginPresenter;
import com.goshop.app.presentation.home.HomeContract;
import com.goshop.app.presentation.home.HomePresenter;

import dagger.Module;
import dagger.Provides;
import injection.ActivityScope;

/**
 * Created by ray on 2017/5/5.
 */
@Module

public class PresenterModule {

    private Activity mActivity;

    private Fragment fragment;

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
    public LoginContract.Presenter provideLoginPresenter(AccountDataRepository dataRepository) {
        return new LoginPresenter(dataRepository);
    }

}
