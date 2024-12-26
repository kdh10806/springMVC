package com.kdh10806.mvc;

import com.kdh10806.mvc.controller.Controller;
import com.kdh10806.mvc.controller.HandlerKey;

public interface HandlerMapping {
    //Controller Annotation으로도 받으려면 Object로 써야함.
    Object findHandler(HandlerKey handlerKey);
}
