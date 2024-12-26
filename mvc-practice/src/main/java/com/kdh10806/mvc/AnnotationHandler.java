package com.kdh10806.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationHandler {
    private final Class<?> clazz;
    private final Method targetMethod;

    public AnnotationHandler(Class<?> clazz, Method targetMethod) {
        this.clazz = clazz;
        this.targetMethod = targetMethod;
    }

    public String handle(HttpServletRequest req, HttpServletResponse res) throws Exception {
        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
        //객체생성
        Object handler = declaredConstructor.newInstance();

        //메서드 호출
        return (String)targetMethod.invoke(handler, req, res);
    }
}
