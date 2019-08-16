package edu.neu.ccs.cs5500.util;


public class BaseException extends RuntimeException {
    private String errorCode;

    public BaseException() {
    }

    public BaseException(String message) {
        this("-1", message);
    }

    public BaseException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
