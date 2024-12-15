package com.kdh10806;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class UserTest {

    @DisplayName("패스워드 초기화 여부를 판단.")
    @Test
    void passwordTest() {
        //given
        User user = new User();
        //when
        //functional 인터페이스를 구현한 구현체이므로
//        user.initPassword(new CorrectFixedPasswordGenerator());
        user.initPassword(() -> "abcdefgh");
        //then
        assertThat(user.getPassword()).isNotNull();
    }

    @DisplayName("패스워드가 요구사항에 부합하지 않아 초기화 되지 않는다.")
    @Test
    void passwordTest2() {
        //given
        User user = new User();
        //when
//        user.initPassword(new WrongFixedPasswordGenerator());
        user.initPassword(() -> "ab");
        //then
        assertThat(user.getPassword()).isNull();
    }
}