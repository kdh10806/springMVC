package com.kdh10806.mvc;

import com.kdh10806.mvc.controller.Controller;
import com.kdh10806.mvc.view.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleControllerHandlerAdapter implements HandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof Controller); //컨트롤러를 구현한 구현체여야만 지원이 가능하다.
    }

    @Override
    public ModelAndView handle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        String viewName = ((Controller) handler).handleRequest(req, res);
        return new ModelAndView(viewName);

    }
}
