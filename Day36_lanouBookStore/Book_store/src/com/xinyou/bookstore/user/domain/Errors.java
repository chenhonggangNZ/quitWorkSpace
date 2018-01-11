package com.xinyou.bookstore.user.domain;

public class Errors {
    private String error;

    public Errors() {
    }

    public Errors(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "Errors{" +
                "error='" + error + '\'' +
                '}';
    }
}
