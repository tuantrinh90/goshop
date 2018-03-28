package com.goshop.app.presentation.model;

public class GoLoyaltyTopVM extends GoLoyaltyModel {

    private int userIcon;

    private String userId;

    private String userName;

    private String userPoints;

    private String userUrl;

    public GoLoyaltyTopVM(String userUrl, int userIcon, String userName, String userId,
        String userPoints) {
        super(GoLoyaltyModel.VIEW_TYPE_TOP);
        this.userName = userName;
        this.userId = userId;
        this.userPoints = userPoints;
        this.userUrl = userUrl;
        this.userIcon = userIcon;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    public int getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(int userIcon) {
        this.userIcon = userIcon;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPoints() {
        return userPoints;
    }

    public void setUserPoints(String userPoints) {
        this.userPoints = userPoints;
    }
}
