package com.goshop.app.presentation.model;

public class MenuHeaderVM extends MenuModel {

    private boolean loginState = true;

    private String userName;

    private String userHeadUrl;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserHeadUrl() {
        return userHeadUrl;
    }

    public void setUserHeadUrl(String userHeadUrl) {
        this.userHeadUrl = userHeadUrl;
    }

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
