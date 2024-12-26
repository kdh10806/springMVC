package com.kdh10806.mvc.controller;

import com.kdh10806.mvc.model.User;
import com.kdh10806.mvc.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserCreateController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
        //user 추가
        UserRepository.save(new User(req.getParameter("userId"), req.getParameter("name")));

        return "redirect:/users";
    }
}
