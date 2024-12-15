package com.kdh10806;

import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.*;

public class UserDao {

//    public void create(User user) throws SQLException {
//        Connection con = null;
//        PreparedStatement pstmt = null;
//
//        try{
//            con = ConnectionManager.getConnection();
//            String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
//            pstmt = con.prepareStatement(sql);
//            pstmt.setString(1, user.getUserId());
//            pstmt.setString(2, user.getPassword());
//            pstmt.setString(3, user.getName());
//            pstmt.setString(4, user.getEmail());
//
//            pstmt.executeUpdate();
//        }finally {
//            if(pstmt != null){
//                //자원 해제
//                pstmt.close();
//            }
//
//            if(con != null){
//                //자원 해제
//                con.close();
//            }
//        }
//    }

    public void create(User user) throws SQLException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
        jdbcTemplate.executeUpdate(user, sql, new PreparedStatementSetter() {
            @Override
            public void setter(PreparedStatement pstmt) throws SQLException {
                pstmt.setString(1, user.getUserId());
                pstmt.setString(2, user.getPassword());
                pstmt.setString(3, user.getName());
                pstmt.setString(4, user.getEmail());
            }
        });
    }

//    public User findByUserId(String userId) throws SQLException {
//        Connection con = null;
//        PreparedStatement pstmt = null;
//        //조회된 값 저장
//        ResultSet rs = null;
//
//        try{
//            con = ConnectionManager.getConnection();
//            String sql = "SELECT * FROM USERS WHERE userId = ?";
//            pstmt = con.prepareStatement(sql);
//            pstmt.setString(1, userId);
//
//            rs = pstmt.executeQuery();
//
//            User user = null;
//
//            if(rs.next()){
//                user = new User(rs.getString("userId"),
//                        rs.getString("password"),
//                        rs.getString("name"),
//                        rs.getString("email"));
//            }
//
//            return user;
//        } finally {
//            if(rs != null){
//                rs.close();
//            }
//            if(pstmt != null){
//                //자원 해제
//                pstmt.close();
//            }
//            if(con != null){
//                //자원 해제
//                con.close();
//            }
//        }
//    }

    public User findByUserId(String userId) throws SQLException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        String sql = "SELECT * FROM USERS WHERE userId = ?";
        return (User)jdbcTemplate.executeQuery(sql, new PreparedStatementSetter() {
            @Override
            public void setter(PreparedStatement pstmt) throws SQLException {
                pstmt.setString(1, userId);
            }
        }, new RowMapper() {
            @Override
            public Object map(ResultSet resultSet) throws SQLException{
                return new User(resultSet.getString("userId"),
                        resultSet.getString("password"),
                        resultSet.getString("name"),
                        resultSet.getString("email"));
            }
        });
    }
}
