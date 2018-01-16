package com.goshop.app.presentation.shopping;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.ProductDetailModel;

import java.util.List;
import java.util.Map;

/**
 * Created by helen on 2018/1/11.
 */

public class ProductDetailContract {

    interface View extends BaseView {

        void productDetailRequestSuccess(List<ProductDetailModel> detailDatas);
    }

    public interface Presenter extends BasePresenter<View> {

        void productDetailRequest(Map<String, Object> params);
    }

}
