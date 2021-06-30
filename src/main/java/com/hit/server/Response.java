package com.hit.server;

public class Response {
    private String action;
    private String body;

    public Response(String action, String body) {
        this.action = action;
        this.body = body;
    }

    public String getAction(){
        return action;
    }
    public String getBody(){
        return body;
    }
}
