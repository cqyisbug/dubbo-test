package com.cqy.exp;

/**
 * @author caiqy
 * @date 2020/7/15 10:23 上午
 */
public class Ce extends Exception {

    public Ce() {
        super();
    }

    public Ce(String message) {
        super(message);
    }

    public Ce(String message, Throwable cause) {
        super(message, cause);
    }

    public Ce(Throwable cause) {
        super(cause);
    }

    protected Ce(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
