package cn.xysf.user;
import cn.xysf.db.DataBaseOp;
import javax.swing.JOptionPane;

public class Student{
    protected String sno;
    protected String passwd;

    public Student(String sno, String passwd){
        this.sno = sno;
        this.passwd = passwd;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPasswd() {
        return passwd;
    }

    public void queryInfo(){
        new DataBaseOp().queryStudentInfo("sno", this.sno);
    }


    public static void main(String[] args) {
        Student stu = new Student("1810014102","123456");
        stu.queryInfo();
    }
}