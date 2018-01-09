package com.goshop.app.data.retrofit;


@SuppressWarnings("ALL")
public class ServiceApiFail extends Throwable {

    private String errorMessage;

    private String errorCode;

    public ServiceApiFail(String errorMessage,
                          String errorCode) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public ServiceApiFail(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
