package com.kdh10806.mvc;

import com.kdh10806.mvc.annotation.Controller;
import com.kdh10806.mvc.annotation.RequestMapping;
import com.kdh10806.mvc.controller.HandlerKey;
import com.kdh10806.mvc.controller.RequestMethod;
import org.reflections.Reflections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnnotationHandlerMapping implements HandlerMapping {

    private final Object[] basePackage;

    private Map<HandlerKey, AnnotationHandler> handlers = new HashMap<>();

    public AnnotationHandlerMapping(Object... basePackage){
        this.basePackage = basePackage;
    }

    //Map 초기화
    public void initialize() {
        //basePackage 밑의 Controller 어노테이션이 붙은 모든 클래스를 가져옴.
        Reflections reflections = new Reflections(basePackage);
        Set<Class<?>> clazzesWithControllerAnnotation = reflections.getTypesAnnotatedWith(Controller.class);

        //가져온 클래스들 중에서 RequestMapping 어노테이션이 붙은 모든 클래스를 가져온다.
        clazzesWithControllerAnnotation.forEach(clazz ->
                Arrays.stream(clazz.getDeclaredMethods()).forEach(declaredMethod -> {
                    RequestMapping requestMapping = declaredMethod.getDeclaredAnnotation(RequestMapping.class);

                    //@RequestMapping(value = "/", method = RequestMethod.GET)
                    Arrays.stream(getRequestMethods(requestMapping))
                            .forEach(requestMethod -> handlers.put(
                                    new HandlerKey(requestMethod,requestMapping.value()), new AnnotationHandler(clazz, declaredMethod)
                            ));
                })
        );
    }

    //GET과 POST 모두 되는 경우 고려하여 배열로 받는다.
    private RequestMethod[] getRequestMethods(RequestMapping requestMapping) {
        return requestMapping.method();
    }


    @Override
    public Object findHandler(HandlerKey handlerKey) {
        return handlers.get(handlerKey);
    }
}
