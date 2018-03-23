package com.goshop.app.presentation.model;

public class MenuHearderVM extends MenuModel {

    private boolean loginState = true;

    public MenuHearderVM() {
        super(MenuModel.MENU_HEADER);
    }

    public boolean isLoginState() {
        return loginState;
    }

    public void setLoginState(boolean loginState) {
        this.loginState = loginState;
    }
}
