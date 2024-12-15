package com.kdh10806;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import static org.assertj.core.api.Assertions.assertThat;

public class UserDaoTest {

    @BeforeEach
    void setUp() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        //sql 스크립트 파일을 읽어와서 스크립트에 추가한다.
        populator.addScript(new ClassPathResource("db_schema.sql"));
        DatabasePopulatorUtils.execute(populator, ConnectionManager.getDataSource());
    }

    @Test
    void createTest() throws Exception {
        UserDao userDao = new UserDao();

        userDao.create(new User("wizard", "password", "name", "email"));

        User user = userDao.findByUserId("wizard");

        assertThat(user).isEqualTo(new User("wizard", "password", "name", "email"));
    }
}
