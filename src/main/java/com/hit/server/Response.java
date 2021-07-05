package com.hit.server;


public class Response {
    Headers headers;
    body body;
    class Headers {
        String action;
        public String getAction() {
            return action;
        }
    }
    class body {
        String json;
        public String getJson() {
            return json;
        }
    }
}


