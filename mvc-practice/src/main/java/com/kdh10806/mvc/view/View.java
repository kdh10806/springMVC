package com.kdh10806.mvc.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface View {
    void render(Map<String, ?> model, HttpServletRequest req, HttpServletResponse res) throws Exception;
}
