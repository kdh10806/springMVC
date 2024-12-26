package com.kdh10806.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardController implements Controller {
    private final String forwardUriPath;

    public ForwardController(String fowardUriPath) {
        this.forwardUriPath = fowardUriPath;
    }

    @Override
    public String handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
        return forwardUriPath;
    }
}
