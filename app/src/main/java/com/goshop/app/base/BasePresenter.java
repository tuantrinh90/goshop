package com.goshop.app.base;

/**
 * Created by winniseptiani on 3/19/17.
 */

@SuppressWarnings("ALL")
public interface BasePresenter <V extends BaseView>{
    void attachView(V mvpView);
    void detachView();
}
