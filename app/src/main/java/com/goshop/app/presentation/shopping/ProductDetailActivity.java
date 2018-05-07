package com.goshop.app.presentation.shopping;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.CustomPagerCircleIndicator;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.presentation.checkout.CheckoutActivity;
import com.goshop.app.presentation.login.LoginActivity;
import com.goshop.app.presentation.model.ColorVM;
import com.goshop.app.presentation.model.ProductDetailModel;
import com.goshop.app.presentation.model.ProductDetailTopVM;
import com.goshop.app.presentation.model.ProfileVM;
import com.goshop.app.presentation.model.SizeVM;
import com.goshop.app.utils.KeyBoardUtils;
import com.goshop.app.utils.PopWindowUtil;
import com.goshop.app.utils.UserHelper;
import com.goshop.app.widget.listener.OnProductDetailItemClickListener;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class ProductDetailActivity extends BaseActivity<ProductDetailContract.Presenter>
    implements ProductDetailContract.View, OnProductDetailItemClickListener,
    PdpBannerAdapter.OnPdpBannerClickListener, PopWindowUtil.OnAttributeItemClickListener {

    @BindView(R.id.appbarlayout_product_detail)
    AppBarLayout appBarLayoutProductDetail;

    @BindView(R.id.indicator_product_detail_top)
    CustomPagerCircleIndicator circleIndicator;

    @BindView(R.id.rcv_pdp_details)
    RecyclerView rcvPdpDetails;

    @BindView(R.id.textview_cart_counter)
    RobotoMediumTextView textviewCartCounter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.viewpager_product_detail_top)
    ViewPager viewPager;

    @BindView(R.id.view_pdp_divider)
    View viewPdpDivider;

    @BindView(R.id.rl_product_detail_data)
    RelativeLayout rlProductDetailData;

    @BindView(R.id.fl_connection_break)
    FrameLayout flConnectionBreak;

    @BindView(R.id.tv_btn_add_to_cart)
    RobotoMediumTextView tvBtnAddToCart;

    private PdpBannerAdapter bannerAdapter;

    private ProductDetailAdapter pdpAdapter;

    private OnDeliveryCheckSuccessListener onDeliveryCheckSuccessListener;

    private OnAttributeSelectListener onAttributeSelectListener;

    private List<ColorVM> colorVMS;

    private List<SizeVM> sizeVMS;

    private String sku;

    private OnAddCartClickListener onAddCartClickListener;

    private OnWishlistListener onWishlistListener;

    private List<ProductDetailModel> productDetailModels;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //todo(helen) wait for api
        mPresenter.getProductDetails();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_product_detail;
    }

    @Override
    public void inject() {
        productDetailModels = new ArrayList<>();
        initPresenter();
        initRecyclerView();
        appBarLayoutActionListener();
        initPageAdapter();
    }

    @Override
    public String getScreenTitle() {
        return null;
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvPdpDetails.setLayoutManager(layoutManager);
        pdpAdapter = new ProductDetailAdapter(this, this, new ArrayList<>());
        rcvPdpDetails.setAdapter(pdpAdapter);
    }

    private void appBarLayoutActionListener() {
        appBarLayoutProductDetail
            .addOnOffsetChangedListener((AppBarLayout appBarLayout, int verticalOffset) ->
                viewPdpDivider.setVisibility(Math.abs(verticalOffset) >= appBarLayout
                    .getTotalScrollRange() ? View.VISIBLE : View.GONE));
    }

    private void initPageAdapter() {
        bannerAdapter = new PdpBannerAdapter(new ArrayList<>(), this::onBannerClick);
        viewPager
            .setAdapter(bannerAdapter);
    }

    @OnClick({R.id.imageview_left_menu, R.id.imageview_right_menu, R
        .id.tv_btn_add_to_cart, R.id.tv_btn_buy_now, R.id.tv_net_refresh})
    public void onProductDetailClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.imageview_right_menu:
                if(UserHelper.isLogin()) {
                    startActivity(new Intent(this, ShoppingCartActivity.class));
                } else {
                    startActivity(new Intent(this, LoginActivity.class));
                }
                break;

            case R.id.tv_btn_buy_now:
                if(UserHelper.isLogin()) {
                    startActivity(new Intent(this, CheckoutActivity.class));
                } else {
                    startActivity(new Intent(this, LoginActivity.class));
                }
                break;
            case R.id.tv_btn_add_to_cart:
                if(UserHelper.isLogin()) {
                    onAddCartClickListener.onAddClick();
                } else {
                    startActivity(new Intent(this, LoginActivity.class));
                }

                break;
            case R.id.tv_net_refresh:
                updateLayoutStatus(flConnectionBreak, false);
                mPresenter.getProductDetails();
                break;
        }
    }

    @Override
    public void getProductDetailSuccess(List<ProductDetailModel> detailDatas) {
        productDetailModels.clear();
        productDetailModels = detailDatas;
        mPresenter.getReviews();

    }

    private void showDetailDatas() {
        rlProductDetailData.setVisibility(View.VISIBLE);
        for (ProductDetailModel detailModel: productDetailModels) {
            if(detailModel instanceof ProductDetailTopVM) {
                sku = ((ProductDetailTopVM) detailModel).getSku();
                break;
            }
        }
        pdpAdapter.setUpdateDatas(productDetailModels);
    }

    @Override
    public void productBannerResult(List<String> imageUrls) {
        rlProductDetailData.setVisibility(View.VISIBLE);
        bannerAdapter.setImageUrls(imageUrls);
        circleIndicator.setViewPager(viewPager);
    }

    @Override
    public void addWishlistSuccess() {
        onWishlistListener.onWishlistClick(true);
    }

    @Override
    public void removeWishlistSuccess() {
        onWishlistListener.onWishlistClick(false);
    }

    @Override
    public void addWishlistFailed(String errorMessage) {
        PopWindowUtil.showRequestMessagePop(rcvPdpDetails, errorMessage);
    }

    @Override
    public void removeWishlistFailed(String errorMessage) {
        PopWindowUtil.showRequestMessagePop(rcvPdpDetails, errorMessage);
    }

    @Override
    public void deliveryCheckRequestSuccess() {
        Toast.makeText(this, getResources().getString(R.string.success), Toast.LENGTH_LONG).show();
        onDeliveryCheckSuccessListener.success();
    }

    @Override
    public void deliveryCheckRequestFailed(String errorMessage) {
        PopWindowUtil.showRequestMessagePop(rcvPdpDetails, errorMessage);
    }

    @Override
    public void showNetError() {
        updateLayoutStatus(flConnectionBreak, true);
    }

    @Override
    public void showFailedMessage(String errorMessage) {
        PopWindowUtil.showRequestMessagePop(rcvPdpDetails, errorMessage);
    }

    @Override
    public void hideDataLayout() {
        rlProductDetailData.setVisibility(View.GONE);
    }

    @Override
    public void setColorDatas(List<ColorVM> colorVMS) {
        this.colorVMS = colorVMS;
    }

    @Override
    public void setSizeDatas(List<SizeVM> sizeVMS) {
        this.sizeVMS = sizeVMS;
    }

    @Override
    public void addToCartSuccess(int cartNum) {
        if(cartNum > 0) {
            textviewCartCounter.setVisibility(View.VISIBLE);
            textviewCartCounter.setText(cartNum + "");
        } else {
            textviewCartCounter.setVisibility(View.GONE);
        }
    }

    @Override
    public void getUserProfileSuccess(ProfileVM profileVM) {
        int cartCount = profileVM.getCartCount();
        if(cartCount > 0) {
            textviewCartCounter.setVisibility(View.VISIBLE);
            textviewCartCounter.setText(cartCount + "");
        } else {
            textviewCartCounter.setVisibility(View.GONE);
        }
    }

    @Override
    public void getReviewsSuccess(List<ProductDetailModel> detailDatas) {
        productDetailModels.addAll(detailDatas);
        mPresenter.getQA();
    }

    @Override
    public void getQASuccess(List<ProductDetailModel> detailDatas) {
        productDetailModels.addAll(detailDatas);
        showDetailDatas();
    }

    @Override
    public void onBannerClick() {
        startActivity(new Intent(this, PDPDetailImagesActivity.class));
    }

    @Override
    public void onWriteAReviewClick() {
        startActivity(new Intent(this, RatingActivity.class));
    }

    @Override
    public void onMoreReviewClick() {
        startActivity(new Intent(this, AllReviewsActivity.class));
    }

    @Override
    public void onAskQuestionClick() {
        startActivity(new Intent(this, AllQAActivity.class));
    }

    @Override
    public void onMoreQuestionClick() {
        startActivity(new Intent(this, AllQAActivity.class));
    }

    @Override
    public void onWishlistSelect(boolean isSelect) {
        if(UserHelper.isLogin()){
            if (isSelect) {
                mPresenter.addWishlistRequest(sku);
            } else {
                mPresenter.removeWishlistRequest(sku);
            }
        } else {
            startActivity(new Intent(this, LoginActivity.class));
        }
    }

    @Override
    public void onDeliveryCheckClick(String zipcode) {
        KeyBoardUtils.hideKeyboard(this);
        if (TextUtils.isEmpty(zipcode)) {
            Toast.makeText(this, getResources().getString(R.string.empty_error), Toast.LENGTH_LONG)
                .show();
            return;
        }
        mPresenter.deliveryCheckRequest(zipcode);
    }

    @Override
    public void onProductColorClick(View parentView, String name) {
        PopWindowUtil.showColorPop(parentView, name, colorVMS, this::onAttributeItemClick);
    }

    @Override
    public void onProductSizeClick(View parentView, String name) {
        PopWindowUtil.showSizePop(parentView, name, sizeVMS, this::onAttributeItemClick);
    }

    @Override
    public void setAddCartQty(String qty) {
        mPresenter.addToCartRequest(sku, qty);
    }

    @Override
    public void onAttributeItemClick(int position, String type) {
        if (type.equals(PopWindowUtil.COLOR)) {
            String colorName = colorVMS.get(position).getColorName();
            onAttributeSelectListener.onColorSelect(colorName);
        } else if (type.equals(PopWindowUtil.SIZE)) {
            String sizeName = sizeVMS.get(position).getSizeName();
            onAttributeSelectListener.onSizeSelect(sizeName);
        }
    }

    public interface OnAttributeSelectListener {

        void onColorSelect(String color);

        void onSizeSelect(String size);
    }

    public interface OnDeliveryCheckSuccessListener {

        void success();
    }

    public void setOnDeliveryCheckSuccessListener(OnDeliveryCheckSuccessListener listener) {
        this.onDeliveryCheckSuccessListener = listener;
    }

    public void setOnAttributeSelectListener(OnAttributeSelectListener listener) {
        this.onAttributeSelectListener = listener;
    }

    public interface OnAddCartClickListener {

        void onAddClick();
    }

    public void setOnAddCartClickListener(OnAddCartClickListener addCartClickListener) {
        this.onAddCartClickListener = addCartClickListener;
    }

    public interface OnWishlistListener{
        void onWishlistClick(boolean isAdd);
    }

    public void setOnWishlistListener(OnWishlistListener onWishlistListener) {
        this.onWishlistListener = onWishlistListener;
    }

}
