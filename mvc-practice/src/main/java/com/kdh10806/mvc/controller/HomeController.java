package com.kdh10806.mvc.controller;

import com.kdh10806.mvc.annotation.Controller;
import com.kdh10806.mvc.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//인터페이스 -> 어노테이션
@Controller
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
        return "home";
    }
}
