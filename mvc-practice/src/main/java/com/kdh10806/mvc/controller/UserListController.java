package com.kdh10806.mvc.controller;

import com.kdh10806.mvc.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserListController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
        req.setAttribute("users", UserRepository.findAll());
        return "/user/list";
    }
}
