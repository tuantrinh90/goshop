package injection.modules;

import com.goshop.app.domian.AccountDataRepository;
import com.goshop.app.presentation.account.AddAddressContract;
import com.goshop.app.presentation.account.AddAddressPresenter;
import com.goshop.app.presentation.account.ChangePasswordContract;
import com.goshop.app.presentation.account.ChangePasswordPresenter;
import com.goshop.app.presentation.account.ContactUsContract;
import com.goshop.app.presentation.account.ContactUsPresenter;
import com.goshop.app.presentation.account.EditAddressContract;
import com.goshop.app.presentation.account.EditAddressPresenter;
import com.goshop.app.presentation.account.EditProfileContract;
import com.goshop.app.presentation.account.EditProfilePresenter;
import com.goshop.app.presentation.account.FAQContract;
import com.goshop.app.presentation.account.FAQPresenter;
import com.goshop.app.presentation.account.HelpSupportContract;
import com.goshop.app.presentation.account.HelpSupportPresenter;
import com.goshop.app.presentation.account.MyAddressBookContract;
import com.goshop.app.presentation.account.MyAddressBookPresenter;
import com.goshop.app.presentation.account.MyEGiftCardContract;
import com.goshop.app.presentation.account.MyEGiftCardPresenter;
import com.goshop.app.presentation.account.MyPointsContract;
import com.goshop.app.presentation.account.MyPointsPresenter;
import com.goshop.app.presentation.account.MyWishlistContract;
import com.goshop.app.presentation.account.MyWishlistPresenter;
import com.goshop.app.presentation.account.NotificationContract;
import com.goshop.app.presentation.account.NotificationPresenter;
import com.goshop.app.presentation.account.TermsConditionsContract;
import com.goshop.app.presentation.account.TermsConditionsPresenter;
import com.goshop.app.presentation.account.WebContentContract;
import com.goshop.app.presentation.account.WebContentPresenter;
import com.goshop.app.presentation.category.CategoryContract;
import com.goshop.app.presentation.category.CategoryPresenter;
import com.goshop.app.presentation.category.CategoryTreeDetailContract;
import com.goshop.app.presentation.category.CategoryTreeDetailPresenter;
import com.goshop.app.presentation.checkout.CheckoutContract;
import com.goshop.app.presentation.checkout.CheckoutPresenter;
import com.goshop.app.presentation.checkout.CheckoutSelectContract;
import com.goshop.app.presentation.checkout.CheckoutSelectPresenter;
import com.goshop.app.presentation.checkout.PaymentStatusContract;
import com.goshop.app.presentation.checkout.PaymentStatusPresenter;
import com.goshop.app.presentation.goloyalty.AllDealsContract;
import com.goshop.app.presentation.goloyalty.AllDealsPresenter;
import com.goshop.app.presentation.goloyalty.CardRedeemContract;
import com.goshop.app.presentation.goloyalty.CardRedeemPresenter;
import com.goshop.app.presentation.goloyalty.ExpiredContract;
import com.goshop.app.presentation.goloyalty.ExpiredPresenter;
import com.goshop.app.presentation.goloyalty.GoLoyaltyContract;
import com.goshop.app.presentation.goloyalty.GoLoyaltyPresenter;
import com.goshop.app.presentation.goloyalty.PendingContract;
import com.goshop.app.presentation.goloyalty.PendingPresenter;
import com.goshop.app.presentation.goloyalty.RedeemedContract;
import com.goshop.app.presentation.goloyalty.RedeemedPresenter;
import com.goshop.app.presentation.goloyalty.RewardsDetailContract;
import com.goshop.app.presentation.goloyalty.RewardsDetailPresenter;
import com.goshop.app.presentation.home.BrandsContract;
import com.goshop.app.presentation.home.BrandsDetailContract;
import com.goshop.app.presentation.home.BrandsDetailPresenter;
import com.goshop.app.presentation.home.BrandsPresenter;
import com.goshop.app.presentation.home.PromotionContract;
import com.goshop.app.presentation.home.PromotionPresenter;
import com.goshop.app.presentation.home.TVShowPageContract;
import com.goshop.app.presentation.home.TVShowPagePresenter;
import com.goshop.app.presentation.home.TrendingNowContract;
import com.goshop.app.presentation.home.TrendingNowPresenter;
import com.goshop.app.presentation.login.LoginComplementEmailContract;
import com.goshop.app.presentation.login.LoginComplementEmailPresenter;
import com.goshop.app.presentation.login.LoginContract;
import com.goshop.app.presentation.login.LoginPresenter;
import com.goshop.app.presentation.login.LoginResetPasswordContract;
import com.goshop.app.presentation.login.LoginResetPasswordPresenter;
import com.goshop.app.presentation.login.LoginSendConfirmationLinkContract;
import com.goshop.app.presentation.login.LoginSendConfirmationLinkPresenter;
import com.goshop.app.presentation.login.RegisterContract;
import com.goshop.app.presentation.login.RegisterPresenter;
import com.goshop.app.presentation.myorder.MyOrderContract;
import com.goshop.app.presentation.myorder.MyOrderPresenter;
import com.goshop.app.presentation.myorder.MyOrdersContract;
import com.goshop.app.presentation.myorder.MyOrdersPresenter;
import com.goshop.app.presentation.myorder.OrderDetailContract;
import com.goshop.app.presentation.myorder.OrderDetailPresenter;
import com.goshop.app.presentation.search.SearchContract;
import com.goshop.app.presentation.search.SearchPresenter;
import com.goshop.app.presentation.search.SearchResultContract;
import com.goshop.app.presentation.search.SearchResultPresenter;
import com.goshop.app.presentation.settings.SettingsContract;
import com.goshop.app.presentation.settings.SettingsPresenter;
import com.goshop.app.presentation.shopping.AllReviewsContract;
import com.goshop.app.presentation.shopping.AllReviewsPresenter;
import com.goshop.app.presentation.shopping.PDPDetailContract;
import com.goshop.app.presentation.shopping.PDPDetailPresenter;
import com.goshop.app.presentation.shopping.ProductDetailContract;
import com.goshop.app.presentation.shopping.ProductDetailPresenter;
import com.goshop.app.presentation.shopping.ShoppingCartContract;
import com.goshop.app.presentation.shopping.ShoppingCartPresenter;

import android.app.Activity;
import android.support.v4.app.Fragment;

import dagger.Module;
import dagger.Provides;
import injection.ActivityScope;

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
    public TrendingNowContract.Presenter provideHomePagePresenter(
        AccountDataRepository dataRepository) {
        return new TrendingNowPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public BrandsContract.Presenter provideBrandsPagePresenter(
        AccountDataRepository dataRepository) {
        return new BrandsPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public BrandsDetailContract.Presenter provideBrandsDetailPresenter(
        AccountDataRepository dataRepository) {
        return new BrandsDetailPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public MyEGiftCardContract.Presenter provideMyEGiftCardPresenter(
        AccountDataRepository dataRepository) {
        return new MyEGiftCardPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public GoLoyaltyContract.Presenter provideGoLoyaltyPresenter(
        AccountDataRepository dataRepository) {
        return new GoLoyaltyPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public MyWishlistContract.Presenter provideMyWishlistPresenter(
        AccountDataRepository dataRepository) {
        return new MyWishlistPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public AllDealsContract.Presenter provideAllDealsPresenter(
        AccountDataRepository dataRepository) {
        return new AllDealsPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public PendingContract.Presenter providePendingPresenter(AccountDataRepository dataRepository) {
        return new PendingPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public RedeemedContract.Presenter provideRedeemedPresenter(
        AccountDataRepository dataRepository) {
        return new RedeemedPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public CardRedeemContract.Presenter provideCardRedeemPresenter(
        AccountDataRepository dataRepository) {
        return new CardRedeemPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public ExpiredContract.Presenter provideExpiredPresenter(AccountDataRepository dataRepository) {
        return new ExpiredPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public AllReviewsContract.Presenter provideAllReviewsPresenter(
        AccountDataRepository dataRepository) {
        return new AllReviewsPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public RewardsDetailContract.Presenter provideRewardsDetailPresenter(
        AccountDataRepository dataRepository) {
        return new RewardsDetailPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public PDPDetailContract.Presenter providePDPDetailPresenter(
        AccountDataRepository dataRepository) {
        return new PDPDetailPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public CheckoutContract.Presenter provideCheckoutPresenter(
        AccountDataRepository dataRepository) {
        return new CheckoutPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public MyOrderContract.Presenter provideMyOrderPresenter(AccountDataRepository dataRepository) {
        return new MyOrderPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public MyOrdersContract.Presenter providerMyOrdersPresenter(
        AccountDataRepository dataRepository) {
        return new MyOrdersPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public OrderDetailContract.Presenter providerOrderDetailPresenter(
        AccountDataRepository dataRepository) {
        return new OrderDetailPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public NotificationContract.Presenter provideNotificationPresenter(
        AccountDataRepository dataRepository) {
        return new NotificationPresenter(dataRepository);
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
    public EditAddressContract.Presenter provideEditAddressPresenter(
        AccountDataRepository dataRepository) {
        return new EditAddressPresenter(dataRepository);
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

    @Provides
    @ActivityScope
    public ContactUsContract.Presenter provideTContactUsPresenter(
        AccountDataRepository dataRepository) {
        return new ContactUsPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public SettingsContract.Presenter provideSettingsContractPresenter(
        AccountDataRepository dataRepository) {
        return new SettingsPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public PaymentStatusContract.Presenter providePaymentStatusPresenter(
        AccountDataRepository dataRepository) {
        return new PaymentStatusPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public MyPointsContract.Presenter provideMyPointsContractPresenter(
        AccountDataRepository dataRepository) {
        return new MyPointsPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public CheckoutSelectContract.Presenter provideCheckoutSelectPresenter(
        AccountDataRepository dataRepository) {
        return new CheckoutSelectPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public CategoryContract.Presenter provideCategoryPresenter(
        AccountDataRepository dataRepository) {
        return new CategoryPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public CategoryTreeDetailContract.Presenter provideCategoryTreeDetailPresenter(
        AccountDataRepository dataRepository) {
        return new CategoryTreeDetailPresenter(dataRepository);
    }

    @Provides
    @ActivityScope
    public TVShowPageContract.Presenter provideTVShowPresenter(
        AccountDataRepository dataRepository) {
        return new TVShowPagePresenter(dataRepository);
    }

}
