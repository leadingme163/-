package cn.xysf.db;
import java.sql.*;

public class JDBCUtils{
    // 加载驱动，并建立数据库连接
    public static Connection getConnection(){  // 返回Connection类对象
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sms?serverTimezone=UTC";
            String username = "root";
            String passwd = "lhw200915";
            Connection conn = DriverManager.getConnection(url, username, passwd);
            return conn;
        }catch (SQLException e1){
            e1.printStackTrace();
            return null;
        }catch (ClassNotFoundException e2){
            e2.printStackTrace();
            return null;
        }
    }
    // 关闭数据库连接，释放资源
    public static void release(Statement stmt, Connection conn){
        if (stmt != null){
            try{
                stmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            stmt = null;
        }
        if (conn != null){
            try {
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            conn = null;
        }
    }

    public static void release(PreparedStatement preStmt, Connection conn){
        if (preStmt != null){
            try{
                preStmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            preStmt = null;
        }
        if (conn != null){
            try {
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            conn = null;
        }
    }

    public static void release(ResultSet rs, Statement stmt, Connection conn){
        if(rs != null){
            try {                rs.close();

            }catch (SQLException e){
                e.printStackTrace();
            }
            rs = null;
        }
        // 方法重载
        release(stmt,conn);
    }

    public static void release(ResultSet rs, PreparedStatement Prestmt, Connection conn){
        if (Prestmt != null){
            try{
                Prestmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            Prestmt = null;
        }
        if (conn != null){
            try {
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            conn = null;
        }
        if(rs != null){
            try {
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            rs = null;
        }
    }
}