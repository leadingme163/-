package cn.xysf.user;

import cn.xysf.db.DataBaseOp;

public class Admin extends Student{

    public Admin(String sno, String passwd){
        super(sno,passwd);
    }

    /* 学生信息查询 */
    public void queryInfo(String queryKey,String queryValue){
        new DataBaseOp().queryStudentInfo(queryKey,queryValue);
    }
    public void queryInfo(String queryKey,int queryValue){
        new DataBaseOp().queryStudentInfo(queryKey,queryValue);
    }


    /* 学生信息添加 */
    public void addInfo(ScoreInfo stu){
        new DataBaseOp().addStudentInfo(stu);
    }

    /* 学生信息删除 */
    public void delInfo(String delSno){
        new DataBaseOp().delStudentInfo(delSno);
    }

    /* 学生信息修改 */
    public void updateInfo(String updSno, String updKey, int updValue){
        new DataBaseOp().updateStudentInfo(updSno, updKey, updValue);
    }
    public void updateInfo(String updSno, String updKey, String updValue){
        new DataBaseOp().updateStudentInfo(updSno, updKey, updValue);
    }

    /* 通过总成绩排序（逆序）*/
    public Object[][] bySumOfScore(){
        return new DataBaseOp().bySumOfScore();
    }

    /* 通过平均成绩排序（逆序）*/
    public Object[][] byAvgOfScore(){
        return new DataBaseOp().byAvgOfScore();
    }

    /* 通过学号排序（顺序）*/
    public Object[][] bySno(){
        return new DataBaseOp().bySno();
    }

    /*通过单科成绩排序*/
    public Object[][] bySingleOfScore(String subject){
        return new DataBaseOp().bySingleOfScore(subject);
    }

    /* 各科优秀率 */
    public Object[] ExceRate(String sclass){
        return new DataBaseOp().ExceRate(sclass);
    }

    /* 各科不及格率 */
    public Object[] FailRate(String sclass){
        return new DataBaseOp().FailRate(sclass);
    }

    /* 各科的最高最低分学生信息 */
    public void peakScore(String subject,boolean peakFlag){
        new DataBaseOp().peakScore(subject, peakFlag);
    }

    /* 批量导入 */
    public void BatchInput(){
        new DataBaseOp().BatchInput();
    }

    public static void main(String[] args) {
        Admin ad = new Admin("1810014102","123456");
        ad.queryInfo("sclass","计科1801");
        ad.peakScore("chineseScore",true);
    }
}