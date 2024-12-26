package com.kdh10806;

import com.kdh10806.annotation.Controller;
import com.kdh10806.annotation.Service;
import com.kdh10806.model.User;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Controller 어노테이션이 붙은 모든 클래스를 찾아 출력한다.
 */
public class ReflectionTest {
    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);

    @Test
    void componentScanTest() {
        Set<Class<?>> beans = getTypesAnnotatedWith(List.of(Controller.class, Service.class));

        logger.debug("beans: [{}]", beans);
    }

    @Test
    void showClass() {
        Class<User> clazz = User.class;
        logger.debug(clazz.getName());

        logger.debug("User all declared fields : [{}]", Arrays.stream(clazz.getDeclaredFields()).collect(Collectors.toList()));
        logger.debug("User all declared constructors : [{}]", Arrays.stream(clazz.getDeclaredConstructors()).collect(Collectors.toList()));
        logger.debug("User all declared methods : [{}]", Arrays.stream(clazz.getDeclaredMethods()).collect(Collectors.toList()));
    }

    @Test
    void load() throws ClassNotFoundException {
        //힙영역에서 클래스 정보 가져오는 법
        //1
        Class<User> clazz = User.class;
        //2
        User user = new User("kdh10806", "kim");
        Class<? extends User> clazz2 = user.getClass();
        //3
        Class<?> clazz3 = Class.forName("com.kdh10806.model.User");

        logger.debug("clazz : [{}]", clazz);
        logger.debug("clazz2 : [{}]", clazz2);
        logger.debug("clazz3 : [{}]", clazz3);

        //3개 모두 같은 객체이다.
        assertThat(clazz == clazz2).isTrue();
        assertThat(clazz2 == clazz3).isTrue();
        assertThat(clazz3 == clazz).isTrue();

    }

    private static Set<Class<?>> getTypesAnnotatedWith(List<Class<? extends Annotation>> annotations) {
        //com.kdh10806 패키지 안의 모든 파일에서 reflection 사용
        Reflections reflections = new Reflections("com.kdh10806");

        Set<Class<?>> beans = new HashSet<>();
        //Controller 어노테이션이 붙은 클래스들을 찾는다.
        beans.addAll(reflections.getTypesAnnotatedWith(Controller.class));
        beans.addAll(reflections.getTypesAnnotatedWith(Service.class));
        return beans;
    }
}
