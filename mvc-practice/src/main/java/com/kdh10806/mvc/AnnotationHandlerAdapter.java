package com.kdh10806.mvc;

import com.kdh10806.mvc.view.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnnotationHandlerAdapter implements HandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        //AnnotationHandler이어야만 사용할 수 있다.
        return handler instanceof AnnotationHandler;
    }

    @Override
    public ModelAndView handle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        String viewName = ((AnnotationHandler) handler).handle(req, res);

        return new ModelAndView(viewName);
    }
}
