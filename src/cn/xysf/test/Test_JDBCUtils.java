package cn.xysf.test;

import cn.xysf.db.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test_JDBCUtils {
    public static void main(String[] args) {
        Connection conn = JDBCUtils.getConnection();
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM student";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                int userId = rs.getInt("userId");
                int age = rs.getInt("age");
                System.out.println("UserId:"+userId+'\t'+"age:"+age);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
