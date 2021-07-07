package com.hit.server;


public class Response<T> {

  private String responseStatus;
    T body;
    boolean success;

    public String getResponseStatus() {
        return responseStatus;
    }

    public T getBody() {
        return body;
    }

    public Response(T object,boolean is_ok_status) {
        body = object;
        success = is_ok_status;
    }
}

