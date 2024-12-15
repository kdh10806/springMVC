package com.kdh10806;

public class PasswordValidator {

    public static final String WRONG_PASSWORD_LENGTH_EXCEPTION_MESSAGE = "비밀번호는 최소 8자 이상 12자 이내여야 한다.";

    public static void validate(String password) {
        //Extract - cmd,opt,v
        int length = password.length();
        if(length < 8 || length > 12) {
            //cmd,opt, c
            throw new IllegalArgumentException(WRONG_PASSWORD_LENGTH_EXCEPTION_MESSAGE);
        }



    }
}
