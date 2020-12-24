package cn.xysf.db;
import cn.xysf.user.*;

import java.sql.*;
import java.util.List;

import cn.xysf.db.*;

public class DataBaseOp implements SortOp,RateOp,PeakOp{

    /* 展示学生信息 */
    public void display(ResultSet rs){
        try {
            System.out.println("\t" + "学号" + "\t\t" + " " + "姓名" + "\t  " + "班级" + "\t\t" + "语文" + "\t\t" + "数学" + "\t\t" + "英语");
            while (rs.next()) {
                String sno = rs.getString("sno");
                String sname = rs.getString("sname");
                String sclass = rs.getString("sclass");
                int chineseScore = rs.getInt("chineseScore");
                int mathScore = rs.getInt("mathScore");
                int englishScore = rs.getInt("englishScore");
                System.out.println(sno + "\t" + sname + "\t" + sclass + "\t\t " + chineseScore + "\t\t " + mathScore + "\t\t" + englishScore);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Object[][] createObj(ResultSet rs){
        Object[][] objs = new Object[100][6];
        int i = 0;
        try {
            while (rs.next()) {
                String sno = rs.getString("sno");
                String sname = rs.getString("sname");
                String sclass = rs.getString("sclass");
                int chineseScore = rs.getInt("chineseScore");
                int mathScore = rs.getInt("mathScore");
                int englishScore = rs.getInt("englishScore");
                objs[i] = new Object[]{sno,sname,sclass,chineseScore,mathScore,englishScore};
                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return objs;
    }

    public Object[][] createObj_add(ResultSet rs){
        Object[][] objs = new Object[100][7];
        int i = 0;
        try {
            while (rs.next()) {
                String sno = rs.getString("sno");
                String sname = rs.getString("sname");
                String sclass = rs.getString("sclass");
                int chineseScore = rs.getInt("chineseScore");
                int mathScore = rs.getInt("mathScore");
                int englishScore = rs.getInt("englishScore");
                int addtion = rs.getInt("addtion");
                objs[i] = new Object[]{sno,sname,sclass,chineseScore,mathScore,englishScore,addtion};
                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return objs;
    }

    public void display(ResultSet rs, String addColumns,String scoreType){
        try {
            System.out.println("\t" + "学号" + "\t\t" + " " + "姓名" + "\t  " + "班级" + "\t\t" + "语文" + "\t\t" + "数学" + "\t\t" + "英语" + "\t\t" + scoreType);
            while (rs.next()) {
                String sno = rs.getString("sno");
                String sname = rs.getString("sname");
                String sclass = rs.getString("sclass");
                int chineseScore = rs.getInt("chineseScore");
                int mathScore = rs.getInt("mathScore");
                int englishScore = rs.getInt("englishScore");
                double score = rs.getInt(scoreType);
                System.out.println(sno + "\t" + sname + "\t" + sclass + "\t\t " + chineseScore + "\t\t " + mathScore + "\t\t" + englishScore + "\t\t" + score);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /* 学生信息添加 */
    public void addStudentInfo(ScoreInfo stu){
        Connection conn = null;
        Statement stmt = null;
        try {
            // 获得数据的连接
            conn = JDBCUtils.getConnection();
            // 获得Statement对象
            stmt = conn.createStatement();
            // SQL语句
            String sql = "insert into studentScore(sno,sname,sclass,chineseScore,mathScore,englishScore)"
                    +"values('"+ stu.getSno() + "','" + stu.getSname() + "','" + stu.getSclass() + "',"
                    + stu.getChineseScore() + "," + stu.getMathScore() + "," + stu.getEnglishScore()
                    + ")";
            if(!scoreExist("sno",stu.getSno())){
                int num = stmt.executeUpdate(sql);
                if (num > 0){
                    System.out.println(stu.getSno()+" 号学生数据插入成功！");
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.release(stmt,conn);
        }
    }

    /* 学生信息删除 */
    public void delStudentInfo(String delSno){
        Connection conn = null;
        Statement stmt = null;
        try{
            // 获取数据的连接
            conn = JDBCUtils.getConnection();
            // 获取Statement对象
            stmt = conn.createStatement();
            // SQL语句
            String sql = "delete from studentScore where sno=" + delSno;
            int num = stmt.executeUpdate(sql);
            if (num > 0){
                System.out.println(delSno+"号学生数据删除成功！");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(stmt,conn);
        }
    }

    /* 学生信息查询 */
    public Object[][] queryStudentInfo(String queryKey,String queryValue){
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        Object[][] obj = {{}};
        try{
            // 获取数据的连接
            conn = JDBCUtils.getConnection();
            // SQL语句
            String sql = "select * from studentScore where "+queryKey+ "= ?";
            // 获取prepareStatement对象
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1,queryValue);
            rs = preStmt.executeQuery();
            obj = createObj(rs);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(rs,preStmt,conn);
        }
        return obj;
    }

    public Object[][] queryStudentInfo(String queryKey,int queryValue){
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        Object[][] obj = {{}};
        try{
            // 获取数据的连接
            conn = JDBCUtils.getConnection();
            // SQL语句
            String sql = "select * from studentScore where "+queryKey+ "= ?";
            // 获取prepareStatement对象
            preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1,queryValue);
            rs = preStmt.executeQuery();
            obj = createObj(rs);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(rs,preStmt,conn);
        }
        return obj;
    }

    /* 学生信息修改 */
    public void updateStudentInfo(String updSno, String updKey, String updValue){
        Connection conn = null;
        Statement stmt = null;
        try {
            // 获取数据的连接
            conn = JDBCUtils.getConnection();
            // SQL语句
            String sql = "update studentScore set "+updKey+" = '"+updValue+"' where sno ="+updSno;
            // 获取prepareStatement对象
            stmt = conn.createStatement();
            int num = stmt.executeUpdate(sql);
            if (num > 0){
                System.out.println(updSno+"号学生修改数据成功！");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.release(stmt,conn);
        }
    }

    public void updateStudentInfo(String updSno, String updKey, int updValue){
        Connection conn = null;
        Statement stmt = null;
        try {
            // 获取数据的连接
            conn = JDBCUtils.getConnection();
            // SQL语句
            String sql = "update studentScore set "+updKey+"="+updValue+" where sno ="+updSno;
            // 获取prepareStatement对象
            stmt = conn.createStatement();
            int num = stmt.executeUpdate(sql);
            if (num > 0){
                System.out.println(updSno+"号学生修改数据成功！");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.release(stmt,conn);
        }
    }

    /* 通过总成绩排序（逆序）*/
    @Override
    public Object[][] bySumOfScore() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Object[][] obj = {{}};
        try {
            // 获取数据的连接
            conn = JDBCUtils.getConnection();
            // SQL语句
            String sql = "select *, sum(chineseScore+mathScore+englishScore) as addtion from studentScore group by sno order by addtion";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            obj = createObj_add(rs);
//            display(rs,"总成绩","allScore");
        } catch(SQLException throwables){
                throwables.printStackTrace();
        }catch(Exception e){
                e.printStackTrace();
        }finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return obj;
    }

    /* 通过平均成绩排序（逆序）*/
    @Override
    public Object[][] byAvgOfScore(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Object[][] obj = {{}};
        try {
            // 获取数据的连接
            conn = JDBCUtils.getConnection();
            // SQL语句
            String sql = "select *, sum(chineseScore+mathScore+englishScore)/3 as addtion from studentScore group by sno order by addtion";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
//            display(rs,"平均成绩","avgScore");
            obj = createObj_add(rs);
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return obj;
    }

    /*通过学号排序（顺序）*/
    @Override
    public Object[][] bySno(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Object[][] obj = {{}};
        try{
            // 获取数据的连接
            conn = JDBCUtils.getConnection();
            // SQL语句
            String sql = "select * from studentScore order by sno desc";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
//            display(rs);
            obj = createObj(rs);
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return obj;
    }

    /*通过单科成绩排序*/
    @Override
    public Object[][] bySingleOfScore(String subject){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Object[][] obj = {{}};
        try{
            // 获取数据的连接
            conn = JDBCUtils.getConnection();
            // SQL语句
            String sql = "select * from studentScore order by " +subject;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            obj = createObj(rs);
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return obj;
    }

    /* 各科优秀率 */
    @Override
    public Object[] ExceRate(String sclass){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Object[] objs = {};
        try {
            // 获取数据库连接
            conn = JDBCUtils.getConnection();
            // SQL语句
            stmt = conn.createStatement();

            String sql = "select count(sno) as allNum from studentScore where sclass = '"+sclass +"'";
            System.out.println(sql);
            rs = stmt.executeQuery(sql);
            rs.next();
            float allNum = rs.getInt("allNum");

            String sql2 = "select count(sno) as chineseExceNum from studentScore where chineseScore >= 90 and sclass = '"+sclass +"'";
            rs = stmt.executeQuery(sql2);
            rs.next();
            float chineseExceRate = rs.getInt("chineseExceNum")/allNum;
            float chinese = Float.parseFloat(String.format("%.2f", chineseExceRate));

            String sql3 = "select count(sno) as mathExceNum from studentScore where mathScore >= 90 and sclass = '"+sclass +"'";
            rs = stmt.executeQuery(sql3);
            rs.next();
            float mathExceNumRate = rs.getInt("mathExceNum")/allNum;
            float math = Float.parseFloat(String.format("%.2f", mathExceNumRate));


            String sql4 = "select count(sno) as englishExceNum from studentScore where englishScore >= 90 and sclass = '"+sclass +"'";
            rs = stmt.executeQuery(sql4);
            rs.next();
            float englishExceNumRate = rs.getInt("englishExceNum")/allNum;
            float english = Float.parseFloat(String.format("%.2f", englishExceNumRate));

            objs = new Object[] {sclass, chinese, math, english};
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return objs;
    }

    @Override
    public Object[] FailRate(String sclass){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Object[] objs = {};
        try {
            // 获取数据库连接
            conn = JDBCUtils.getConnection();
            // SQL语句
            stmt = conn.createStatement();

            String sql = "select count(sno) as allNum from studentScore where sclass = '"+sclass+"'";
            rs = stmt.executeQuery(sql);
            rs.next();
            float allNum = rs.getInt("allNum");

            String sql2 = "select count(sno) as chineseFailNum from studentScore where chineseScore < 60 and sclass = '"+sclass+"'";
            rs = stmt.executeQuery(sql2);
            rs.next();
            float chineseFailRate = rs.getInt("chineseFailNum")/allNum;
            float chinese = Float.parseFloat(String.format("%.2f", chineseFailRate));

            String sql3 = "select count(sno) as mathFailNum from studentScore where mathScore < 60 and sclass = '"+sclass+"'";
            rs = stmt.executeQuery(sql3);
            rs.next();
            float mathFailRate = rs.getInt("mathFailNum")/allNum;
            float math = Float.parseFloat(String.format("%.2f", mathFailRate));

            String sql4 = "select count(sno) as englishFailNum from studentScore where englishScore < 60 and sclass = '"+sclass+"'";
            rs = stmt.executeQuery(sql4);
            rs.next();
            float englishFailRate = rs.getInt("englishFailNum")/allNum;
            float english = Float.parseFloat(String.format("%.2f", englishFailRate));

            objs = new Object[] {sclass, chinese, math, english};

        }catch(SQLException throwables){
            throwables.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return objs;
    }

    @Override
    public void peakScore(String subject,boolean peakFlag){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String info,addSql;
        if(peakFlag){
            info = "最高";
            addSql = "desc";
        }else {
            info = "最低";
            addSql = "";
        }
        try {
            // 获取数据库连接
            conn = JDBCUtils.getConnection();
            // 获取Statement对象
            stmt = conn.createStatement();
            // SQL语句
            String sql = "select sno,sname,sclass from studentScore order by " + subject + " " + addSql + " limit 1";
            rs = stmt.executeQuery(sql);
            System.out.println(subject+info+"的学生信息如下显示: \n");
            System.out.println("\t" + "学号" + "\t\t" + " " + "姓名" + "\t  " + "班级");
            while(rs.next()){
                String sno = rs.getString("sno");
                String sname = rs.getString("sname");
                String sclass = rs.getString("sclass");
                System.out.println(sno + "\t" + sname + "\t" + sclass);
            }
            System.out.println();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(rs, stmt, conn);
        }
    }

    public static void addUser(String sno, String passwd){
        // 添加用户
        Connection conn = null;
        Statement stmt = null;
        try{
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "insert into user(sno,passwd) "+
                    "values('" + sno + "','" + passwd + "')";
            System.out.println(sql);
            int num = stmt.executeUpdate(sql);
            if (num > 0){
                System.out.println("用户注册成功！");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.release(stmt,conn);
        }
    }

    public static boolean snoExist(String sno){
        // 账号存在性检验
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from user where sno = "+sno;
            rs = stmt.executeQuery(sql);
            if(rs.next()) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.release(stmt,conn);
        }
        return false;
    }

    public static boolean scoreExist(String key, String value){
        // 学生成绩存在性检验
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from studentscore where "+ key + " = '" + value + "'";
            System.out.println(sql);
            rs = stmt.executeQuery(sql);
            if(rs.next()) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.release(stmt,conn);
        }
        return false;
    }

    public static int loginUser (String sno, String passwd){
        // 用户登录
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        int flag = 0;
        try{
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from user where sno = " + sno;
            rs = stmt.executeQuery(sql);
            if(rs.next()) {
                String password = rs.getString("passwd");
                if(password.equals(passwd)){
                    flag = 1;
//                    System.out.println("登录成功！");
                }else{
                    flag = 3;
//                    System.out.println("密码错误！");
                }
            }else {
                flag = 2;
//                System.out.println("账号不存在！");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.release(stmt,conn);
        }
        return flag;
    }

    public static boolean isAdmin(String sno){
        // 账号是否拥有管理员权限
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from user where sno = "+sno+" and admin = 1";
            rs = stmt.executeQuery(sql);
            if(rs.next()) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.release(stmt,conn);
        }
        return false;
    }

    public void BatchInput(){
        // 获取Excel表数据
        List<ScoreInfo> list = ReadExcel.getAllByExcel("F:\\JavaCode\\学生成绩管理系统\\images\\socreInfo.xls");
        for(ScoreInfo obj:list){
            addStudentInfo(obj);
        }
    }
}