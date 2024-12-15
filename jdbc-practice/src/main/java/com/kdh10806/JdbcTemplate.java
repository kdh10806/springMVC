package com.kdh10806;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTemplate {
    public void executeUpdate(User user, String sql, PreparedStatementSetter pss) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;

        try{
            con = ConnectionManager.getConnection();
            pstmt = con.prepareStatement(sql);
            pss.setter(pstmt);

            pstmt.executeUpdate();
        }finally {
            if(pstmt != null){
                //자원 해제
                pstmt.close();
            }

            if(con != null){
                //자원 해제
                con.close();
            }
        }
    }

    public Object executeQuery(String sql, PreparedStatementSetter pss, RowMapper rowMapper) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        //조회된 값 저장
        ResultSet rs = null;

        try{
            con = ConnectionManager.getConnection();
            pstmt = con.prepareStatement(sql);
            pss.setter(pstmt);

            rs = pstmt.executeQuery();

            Object obj = null;
            if(rs.next()){
                return rowMapper.map(rs);
            }

            return obj;
        } finally {
            if(rs != null){
                rs.close();
            }
            if(pstmt != null){
                //자원 해제
                pstmt.close();
            }
            if(con != null){
                //자원 해제
                con.close();
            }
        }
    }
}
