package com.kdh10806;

public class User {
    private String password;

    public String getPassword() {
        return password;
    }

    public void initPassword(PasswordGenerator passwordGenerator){
        //높은 결합도 as-is
        //RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();

        //낮은 결합도(주입) to-be
        String password = passwordGenerator.generatePassword();

        /**
         * 비밀번호는 최소 8자 이상 12자 이하여야 한다.
         */
        if(password.length() >= 8 && password.length() <= 12){
            this.password = password;
        }
    }
}
