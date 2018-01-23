package injection.modules;

import com.goshop.app.domian.AccountDataRepository;
import com.goshop.app.presentation.account.LoginContract;
import com.goshop.app.presentation.account.LoginPresenter;
import com.goshop.app.presentation.home.HomeContract;
import com.goshop.app.presentation.home.HomePresenter;
import com.goshop.app.presentation.home.PromotionContract;
import com.goshop.app.presentation.home.PromotionPresenter;
import com.goshop.app.presentation.login.LoginComplementEmailContract;
import com.goshop.app.presentation.login.LoginComplementEmailPresenter;
import com.goshop.app.presentation.login.LoginResetPasswordContract;
import com.goshop.app.presentation.login.LoginResetPasswordPresenter;
import com.goshop.app.presentation.login.LoginSendConfirmationLinkContract;
import com.goshop.app.presentation.login.LoginSendConfirmationLinkPresenter;
import com.goshop.app.presentation.login.RegisterContract;
import com.goshop.app.presentation.login.RegisterPresenter;
import com.goshop.app.presentation.shopping.ProductDetailContract;
import com.goshop.app.presentation.shopping.ProductDetailPresenter;

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
    public LoginContract.Presenter provideLoginPresenter(AccountDataRepository dataRepository) {
        return new LoginPresenter(dataRepository);
    }
    @Provides
    @ActivityScope
    public RegisterContract.Presenter provideRegisterPresenter(
        AccountDataRepository dataRepository) {
        return new RegisterPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public LoginComplementEmailContract.Presenter provideLoginComplementEmailPresenter(
        AccountDataRepository dataRepository) {
        return new LoginComplementEmailPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public LoginResetPasswordContract.Presenter provideLoginResetPasswordPresenter(
        AccountDataRepository dataRepository) {
        return new LoginResetPasswordPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public LoginSendConfirmationLinkContract.Presenter provideLoginSendConfirmationLinkPresenter(
        AccountDataRepository dataRepository) {
        return new LoginSendConfirmationLinkPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public ProductDetailContract.Presenter provideProductDetailPresenter(
        AccountDataRepository dataRepository) {
        return new ProductDetailPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public PromotionContract.Presenter providePromotionPresenter(
        AccountDataRepository dataRepository) {
        return new PromotionPresenter(dataRepository);
    }

}
