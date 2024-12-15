package com.kdh10806;

/**
 * 프로덕션엔 사용되지 않고 테스트에만 사용된다
 */
public class CorrectFixedPasswordGenerator implements PasswordGenerator {
    @Override
    public String generatePassword(){
        return "abcdefgh"; //8글자
    }
}
