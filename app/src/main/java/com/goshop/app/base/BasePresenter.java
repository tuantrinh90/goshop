package com.goshop.app.base;

@SuppressWarnings("ALL")
public interface BasePresenter <V extends BaseView>{
    void attachView(V mvpView);
    void detachView();
}
