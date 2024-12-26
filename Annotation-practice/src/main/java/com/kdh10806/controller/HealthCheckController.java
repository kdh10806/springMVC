package com.kdh10806.controller;

import com.kdh10806.annotation.Controller;
import com.kdh10806.annotation.RequestMapping;
import com.kdh10806.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HealthCheckController {

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public String home(HttpServletRequest request, HttpServletResponse response){
        return "ok";
    }
}
