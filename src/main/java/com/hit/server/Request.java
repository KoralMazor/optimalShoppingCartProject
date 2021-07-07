package com.hit.server;

import java.util.Map;

public class Request<T> {

    Headers headers;
    T body;

    public T getBody() {
        return body;
    }

    public Headers getHeaders() {
        return headers;
    }

    public enum ACTION {
        GET,
        CREATE
    }

    class Headers {
        private final ACTION action;

        public Headers(ACTION action){
            this.action = action;

        }
        public Request.ACTION getAction() {
            return action;
        }
    }

    public Request(ACTION action, T object) {
        headers = new Headers(action);
        body = object;
    }

}

