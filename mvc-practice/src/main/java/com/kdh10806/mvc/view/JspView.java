package com.kdh10806.mvc.view;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class JspView implements View {
    private final String viewName;

    public JspView(String viewName) {
        this.viewName = viewName;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest req, HttpServletResponse res) throws Exception {
        model.forEach(req::setAttribute);

        //forward 방식
        //viewName으로 RequestDispatcher 가져오기
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(viewName);
        //viewName의 view로 foward수행
        requestDispatcher.forward(req, res);


    }
}
