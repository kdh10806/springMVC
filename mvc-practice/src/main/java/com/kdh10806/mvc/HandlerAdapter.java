package com.kdh10806.mvc;

import com.kdh10806.mvc.view.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface HandlerAdapter {
    //해당 핸들러를 지원하는가?
    boolean supports(Object handler);
    //요청을 받으면 MV를 반환한다.
    ModelAndView handle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception;
}
