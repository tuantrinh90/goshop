package injection.modules;

import com.goshop.app.domian.AccountDataRepository;
import com.goshop.app.presentation.account.AddAddressContract;
import com.goshop.app.presentation.account.AddAddressPresenter;
import com.goshop.app.presentation.account.ChangePasswordContract;
import com.goshop.app.presentation.account.ChangePasswordPresenter;
import com.goshop.app.presentation.account.EditProfileContract;
import com.goshop.app.presentation.account.EditProfilePresenter;
import com.goshop.app.presentation.account.WebContentContract;
import com.goshop.app.presentation.account.WebContentPresenter;
import com.goshop.app.presentation.account.LoginContract;
import com.goshop.app.presentation.account.LoginPresenter;
import com.goshop.app.presentation.home.DemoContract;
import com.goshop.app.presentation.home.DemoPresenter;
import com.goshop.app.presentation.account.MyAddressBookContract;
import com.goshop.app.presentation.account.MyAddressBookPresenter;
import com.goshop.app.presentation.account.FAQContract;
import com.goshop.app.presentation.account.FAQPresenter;
import com.goshop.app.presentation.account.HelpSupportContract;
import com.goshop.app.presentation.account.HelpSupportPresenter;
import com.goshop.app.presentation.account.LoginContract;
import com.goshop.app.presentation.account.LoginPresenter;
import com.goshop.app.presentation.account.TermsConditionsContract;
import com.goshop.app.presentation.account.TermsConditionsPresenter;
import com.goshop.app.presentation.account.WebContentContract;
import com.goshop.app.presentation.account.WebContentPresenter;
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
import com.goshop.app.presentation.myorder.MyOrderContract;
import com.goshop.app.presentation.myorder.MyOrderPresenter;
import com.goshop.app.presentation.search.SearchContract;
import com.goshop.app.presentation.search.SearchPresenter;
import com.goshop.app.presentation.search.SearchResultContract;
import com.goshop.app.presentation.search.SearchResultPresenter;
import com.goshop.app.presentation.shopping.ProductDetailContract;
import com.goshop.app.presentation.shopping.ProductDetailPresenter;
import com.goshop.app.presentation.shopping.ShoppingCartContract;
import com.goshop.app.presentation.shopping.ShoppingCartPresenter;

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
    public DemoContract.Presenter provideDemoPresenter(AccountDataRepository dataRepository) {
        return new DemoPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public HomeContract.Presenter provideHomePresenter(AccountDataRepository dataRepository) {
        return new HomePresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public MyOrderContract.Presenter provideMyOrderPresenter(AccountDataRepository dataRepository) {
        return new MyOrderPresenter(dataRepository);
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
    public SearchContract.Presenter provideSearchPresenter(AccountDataRepository dataRepository) {
        return new SearchPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public SearchResultContract.Presenter provideSearchResultPresenter(
        AccountDataRepository dataRepository) {
        return new SearchResultPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public PromotionContract.Presenter providePromotionPresenter(
        AccountDataRepository dataRepository) {
        return new PromotionPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public ChangePasswordContract.Presenter provideChangePasswordPresenter(
        AccountDataRepository dataRepository) {
        return new ChangePasswordPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public EditProfileContract.Presenter provideEditProfilePresenter(
        AccountDataRepository dataRepository) {
        return new EditProfilePresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public AddAddressContract.Presenter provideAddAddressPresenter(
        AccountDataRepository dataRepository) {
        return new AddAddressPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public MyAddressBookContract.Presenter provideMyAddressBookPresenter(
        AccountDataRepository dataRepository) {
        return new MyAddressBookPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public ShoppingCartContract.Presenter provideShoppingCartPresenter(
        AccountDataRepository dataRepository) {
        return new ShoppingCartPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public WebContentContract.Presenter provideWebContentPresenter(
        AccountDataRepository dataRepository) {
        return new WebContentPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public HelpSupportContract.Presenter provideHelpSupprotPresenter(
        AccountDataRepository dataRepository) {
        return new HelpSupportPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public FAQContract.Presenter provideFAQPresenter(AccountDataRepository dataRepository) {
        return new FAQPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public TermsConditionsContract.Presenter provideTermsConditionPresenter(
        AccountDataRepository dataRepository) {
        return new TermsConditionsPresenter(dataRepository);
    }
}
