package com.kdh10806.mvc.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class RedirectView implements View{
    public static final String DEFAULT_REDIRECT_PREFIX = "redirect:";
    private final String name;

    public RedirectView(String name) {
        this.name = name;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest req, HttpServletResponse res) throws Exception {
        res.sendRedirect(name.substring(DEFAULT_REDIRECT_PREFIX.length())); //redirect: 이후의 값을 substring으로 전달




    }
}
