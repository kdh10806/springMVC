package com.kdh10806.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE}) //클래스, 인터페이스, enum 타입에 쓸 수 있다.
@Retention(RetentionPolicy.RUNTIME) //유지기간 - 런타임
public @interface Controller {
}
