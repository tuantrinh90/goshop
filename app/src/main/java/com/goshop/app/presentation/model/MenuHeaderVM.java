package com.goshop.app.presentation.model;

public class MenuHeaderVM extends MenuModel {

    private boolean loginState = true;

    public MenuHeaderVM() {
        super(MenuModel.MENU_HEADER);
    }

    public MenuHeaderVM(String menuType) {
        super(MenuModel.MENU_HEADER, menuType);
    }

    public boolean isLoginState() {
        return loginState;
    }

    public void setLoginState(boolean loginState) {
        this.loginState = loginState;
    }
}
