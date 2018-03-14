package com.goshop.app.presentation.home;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.data.model.PromotionSkuModel;

import java.util.List;
import java.util.Map;

public class PromotionSkuContract {

    interface View extends BaseView {

        void showPromotionResult(List<PromotionSkuModel> skuModels);
    }

    public interface Presenter extends BasePresenter<View> {

        void promotionSkuRequest(Map<String, Object> params);
    }

}
