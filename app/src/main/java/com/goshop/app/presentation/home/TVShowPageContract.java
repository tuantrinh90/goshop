package com.goshop.app.presentation.home;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.TVVideoLeftVM;
import com.goshop.app.presentation.model.TVVideoRightVM;

import java.util.List;
import java.util.Map;

public class TVShowPageContract {

    interface View extends BaseView {

        void showRightVideoResult(List<TVVideoRightVM> videoRightVMS);

        void showLeftVideoResult(List<TVVideoLeftVM> videoLeftVMS);
    }

    public interface Presenter extends BasePresenter<View> {

        void rightVideoRequest(Map<String, Object> params);

        void leftVideoRequest(Map<String, Object> params);
    }
}
