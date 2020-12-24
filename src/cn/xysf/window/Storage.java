package cn.xysf.window;
import cn.xysf.user.*;


// 用来存放页面间跳转的参数
public class Storage {
    private static boolean Admin = false;
    private static String sno;
    private static Student stu;
    private static Admin adm;
    private static ScoreInfo info;

    public void setSno(String sno) {
        Storage.sno = sno;
    }

    public String getSno() {
        return sno;
    }

    public void setAdmin(boolean admin) {
        Storage.Admin = admin;
    }

    public boolean isAdmin() {
        return Admin;
    }

    public void setStu(String sno, String passwd) {
        Storage.stu = new Student(sno, passwd);
    }

    public Student getStu() {
        return stu;
    }

    public static void setAdm(String sno, String passwd) {
        Storage.adm = new Admin(sno, passwd);
    }

    public static Admin getAdm() {
        return adm;
    }

    public ScoreInfo getInfo() {
        return info;
    }

    public void setInfo(ScoreInfo info) {
        Storage.info = info;
    }
}