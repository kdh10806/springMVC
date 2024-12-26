package com.kdh10806.mvc;

import com.kdh10806.mvc.controller.*;

import java.util.HashMap;
import java.util.Map;

//URI와 컨트롤러 매핑
public class RequestMappingHandlerMapping implements HandlerMapping {
    // key : /users, value : UserController
    private Map<HandlerKey, Controller> mapping = new HashMap<>();

    //경로 설정을 해주지 않으면 HomeController로 간다.
    void init(){
//        mapping.put(new HandlerKey(RequestMethod.GET, "/"), new HomeController());
        mapping.put(new HandlerKey(RequestMethod.GET, "/users"), new UserListController());
        mapping.put(new HandlerKey(RequestMethod.POST, "/users"), new UserCreateController());
        mapping.put(new HandlerKey(RequestMethod.GET, "/user/form"), new ForwardController("/user/form"));

    }

    //uriPath에 대응되는 Controller를 반환하는 메서드
    public Controller findHandler(HandlerKey handlerKey){
        return mapping.get(handlerKey); //uriPath로 찾을때 equals & hashcode로 비교함
    }
}
