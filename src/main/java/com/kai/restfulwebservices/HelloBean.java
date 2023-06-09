package com.kai.restfulwebservices;

public class HelloBean {
    private String message;

    public HelloBean(String helloWorld) {
        this.message = helloWorld;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "HelloBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
