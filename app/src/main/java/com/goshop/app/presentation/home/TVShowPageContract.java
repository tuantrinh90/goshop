package com.goshop.app.presentation.home;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.TVShowVM;

import java.util.List;
import java.util.Map;

public class TVShowPageContract {

    interface View extends BaseView {

        void showTvShowResult(List<TVShowVM> tvShowVMS);
    }

    public interface Presenter extends BasePresenter<View> {

        void tvShowRequest(Map<String, Object> params);
    }
}
