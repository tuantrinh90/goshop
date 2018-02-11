package injection.components;

import com.goshop.app.presentation.account.AddAddressActivity;
import com.goshop.app.presentation.account.ChangePasswordActivity;
import com.goshop.app.presentation.account.ContactUsActivity;
import com.goshop.app.presentation.account.EditProfileActivity;
import com.goshop.app.presentation.account.FAQActivity;
import com.goshop.app.presentation.account.HelpSupportActivity;
import com.goshop.app.presentation.account.LoginActivity;
import com.goshop.app.presentation.account.MyAddressBookActivity;
import com.goshop.app.presentation.account.MyPointsActivity;
import com.goshop.app.presentation.account.NotificationActivity;
import com.goshop.app.presentation.account.TermsConditionsActivity;
import com.goshop.app.presentation.account.WebContentActivity;
import com.goshop.app.presentation.category.CategoryActivity;
import com.goshop.app.presentation.category.CategoryTreeDetailActivity;
import com.goshop.app.presentation.checkout.CheckoutActivity;
import com.goshop.app.presentation.checkout.CheckoutSelectAddressActivity;
import com.goshop.app.presentation.checkout.PaymentStatusActivity;
import com.goshop.app.presentation.home.HomeActivity;
import com.goshop.app.presentation.home.HomePageFragment;
import com.goshop.app.presentation.home.PromotionBannerActivity;
import com.goshop.app.presentation.home.PromotionLandingListActivity;
import com.goshop.app.presentation.login.LoginComplementEmailActivity;
import com.goshop.app.presentation.login.LoginResetPasswordActivity;
import com.goshop.app.presentation.login.LoginSendConfirmationLinkActivity;
import com.goshop.app.presentation.login.RegisterActivity;
import com.goshop.app.presentation.myorder.MyOrderDetailActivity;
import com.goshop.app.presentation.myorder.MyOrderListActivity;
import com.goshop.app.presentation.search.SearchActivity;
import com.goshop.app.presentation.search.SearchResultActivity;
import com.goshop.app.presentation.settings.SettingsActivity;
import com.goshop.app.presentation.shopping.ProductDetailActivity;
import com.goshop.app.presentation.shopping.ShoppingCartActivity;

import android.app.Activity;

import dagger.Component;
import injection.ActivityScope;
import injection.modules.PresenterModule;

@ActivityScope
@Component(modules = PresenterModule.class, dependencies = ApplicationComponent.class)
public interface PresenterComponent {

    Activity getActivity();

    void inject(HomePageFragment homePageFragment);

    void inject(MyOrderListActivity myOrderListActivity);

    void inject(MyOrderDetailActivity myOrderDetailActivity);

    void inject(NotificationActivity notificationActivity);

    void inject(LoginActivity loginActivity);

    void inject(CheckoutActivity checkoutActivity);

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

    void inject(ChangePasswordActivity changePasswordActivity);

    void inject(EditProfileActivity editProfileActivity);

    void inject(AddAddressActivity addAddressActivity);

    void inject(MyAddressBookActivity myAddressBookActivity);

    void inject(ShoppingCartActivity shoppingCartActivity);

    void inject(WebContentActivity webContentActivity);

    void inject(HelpSupportActivity helpSupportActivity);

    void inject(FAQActivity faqActivity);

    void inject(TermsConditionsActivity termsConditionsActivity);

    void inject(ContactUsActivity contactUsActivity);

    void inject(SettingsActivity settingsActivity);

    void inject(MyPointsActivity myPointsActivity);

    void inject(PaymentStatusActivity paymentStatusActivity);

    void inject(CheckoutSelectAddressActivity checkoutSelectAddressActivity);

    void inject(CategoryActivity categoryActivity);

    void inject(CategoryTreeDetailActivity categoryTreeDetailActivity);

}
