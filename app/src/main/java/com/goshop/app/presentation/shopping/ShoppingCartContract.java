package com.goshop.app.presentation.shopping;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.ShoppingCartModel;

import java.util.List;
import java.util.Map;

/**
 * Created by helen on 2018/1/24.
 */

public class ShoppingCartContract {

    interface View extends BaseView {

        void showCartDetail(List<ShoppingCartModel> cartModels);
    }

    public interface Presenter extends BasePresenter<View> {

        void shoppingCartRequest(Map<String, Object> params);
    }
}
