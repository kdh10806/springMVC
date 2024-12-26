package com.kdh10806.mvc;

import com.kdh10806.mvc.controller.HandlerKey;
import com.kdh10806.mvc.controller.RequestMethod;
import com.kdh10806.mvc.view.JspViewResolver;
import com.kdh10806.mvc.view.ModelAndView;
import com.kdh10806.mvc.view.View;
import com.kdh10806.mvc.view.ViewResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * -Front Controller Pattern-
 * 모든 요청을 단일 Handler에서 처리하도록 하는 패턴
 * Dispatcher Servlet이 FCP로 구현되어 있다.
 *
 * -Flow-
 * 1. DS에서 요청을 받으면 Handler Mapping을 먼저 간다.(hanlder를 가져온다.)
 * 2. Handler Adapter를 통해 handler 실행.
 * 3. ModelAndView 값을 리턴 받고 View Resovler에게 전달.
 * 4. View Resolver는 View를 return 한다.
 * 5. View 를 render하면 결과가 화면에 보이게 된다.
 *
 * -Interface를 구현하는 방법에서 Annotation으로 변경-
 * Annotation Handler Adapter과 Annotation Handler Mapping 만 추가하면 된다.(OCP)
 */

//모든 경로로 호출하더라도 DS를 거치게 된다.
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(DispatcherServlet.class);

    //클래스 X / 인터페이스
    private List<HandlerMapping> handlerMappings;
    private List<HandlerAdapter> handlerAdapters;
    private List<ViewResolver> viewResolvers;


    //초기화
    //Tomcat은 Http Servlet을 싱글톤으로 만드는데 그때 init()이 호출됨.
    @Override
    public void init() throws ServletException {
        //초기화
        RequestMappingHandlerMapping requestMappingHandlerMapping = new RequestMappingHandlerMapping();
        requestMappingHandlerMapping.init();

        AnnotationHandlerMapping ahm = new AnnotationHandlerMapping("com.kdh10806"); //com.kdh10806 밑이 하위 패키지
        ahm.initialize();

        handlerMappings = List.of(requestMappingHandlerMapping, ahm);
        handlerAdapters = List.of(new SimpleControllerHandlerAdapter(), new AnnotationHandlerAdapter());
        viewResolvers = Collections.singletonList(new JspViewResolver());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        log.info("[DisPatcherServlet] service started");
        String requestURI = req.getRequestURI();
        RequestMethod requestMethod = RequestMethod.valueOf(req.getMethod());

        try {
            //1. DS에서 요청을 받으면 Handler Mapping을 먼저 간다.(handler를 가져온다.)
            //요청 URI에 대한 컨트롤러 반환
            Object handler = handlerMappings.stream()
                    .filter(hm -> hm.findHandler(new HandlerKey(requestMethod, requestURI)) != null)
                    .map(hm -> hm.findHandler(new HandlerKey(requestMethod, requestURI)))
                    .findFirst()
                    .orElseThrow(() -> new ServletException("No handler for [" + requestMethod + ", " + requestURI + "]"));

            //2. Handler Adapter를 통해 handler 실행.
            HandlerAdapter handlerAdapter = handlerAdapters.stream()
                    .filter(ha -> ha.supports(handler))
                    .findFirst()
                    .orElseThrow(() -> new ServletException("No hanlder for [" + handler + "]"));

            //3. ModelAndView 값을 리턴 받고 View Resovler에게 전달.
            ModelAndView modelAndView = handlerAdapter.handle(req, res, handler);

            for (ViewResolver viewResolver : viewResolvers) {
                //4. View Resolver는 View를 return 한다.
                View view = viewResolver.resolveView(modelAndView.getViewName());
                //5. View 를 render하면 결과가 화면에 보이게 된다.
                view.render(modelAndView.getModel(), req, res);
            }
        } catch (Exception e) {
            log.error("Exception occurred : [{}]", e.getMessage(), e);
            throw new ServletException(e);
        }
    }

}
