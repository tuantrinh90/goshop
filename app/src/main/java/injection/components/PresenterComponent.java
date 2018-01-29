package injection.components;

import com.goshop.app.presentation.account.LoginActivity;
import com.goshop.app.presentation.home.DemoActivity;
import com.goshop.app.presentation.home.HomeActivity;
import com.goshop.app.presentation.home.PromotionBannerActivity;
import com.goshop.app.presentation.home.PromotionLandingListActivity;
import com.goshop.app.presentation.login.LoginComplementEmailActivity;
import com.goshop.app.presentation.login.LoginResetPasswordActivity;
import com.goshop.app.presentation.login.LoginSendConfirmationLinkActivity;
import com.goshop.app.presentation.login.RegisterActivity;
import com.goshop.app.presentation.search.SearchActivity;
import com.goshop.app.presentation.search.SearchResultActivity;
import com.goshop.app.presentation.shopping.ProductDetailActivity;

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

    void inject(DemoActivity homeActivity);

    void inject(LoginActivity loginActivity);

    void inject(HomeActivity loginActivity);

    void inject(RegisterActivity registerActivity);

    void inject(PromotionLandingListActivity promotionLandingListActivity);

    void inject(PromotionBannerActivity promotionBannerActivity);

    void inject(LoginComplementEmailActivity complementEmailActivity);

    void inject(LoginResetPasswordActivity resetPasswordActivity);

    void inject(LoginSendConfirmationLinkActivity sendConfirmationLinkActivity);

    void inject(ProductDetailActivity productDetailActivity);

    void inject(SearchActivity searchActivity);

    void inject(SearchResultActivity resultActivity);
}
