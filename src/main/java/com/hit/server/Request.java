package com.hit.server;

import java.util.Map;

public class Request {
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



