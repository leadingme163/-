package cn.xysf.test;

import cn.xysf.db.*;
import cn.xysf.user.*;


public class Test_DataBaseOp {
    public static void main(String[] args) {
//        ScoreInfo stu = new ScoreInfo("1810014103","亓乐","计科1801",4,14,50);
//        ScoreInfo stu2 = new ScoreInfo("1810014126","王长喜","计科1801",20,12,80);
//        ScoreInfo stu3 = new ScoreInfo("1810014124","李明","计科1802",89,78,80);
        DataBaseOp opdb = new DataBaseOp();
//        opdb.addStudentInfo(stu);
//        opdb.addStudentInfo(stu);
//        opdb.addStudentInfo(stu2);
//        opdb.addStudentInfo(stu3);
//        opdb.delStudentInfo("1810014103");
//        opdb.queryStudentInfo("sno","1810014102");
//        opdb.queryStudentInfo("sclass","计科1801");
//        opdb.queryStudentInfo("chineseScore",99);
//        opdb.updateStudentInfo("2010014125","sname","瑞文_");
//        opdb.updateStudentInfo("1810014103","sname","亓大大");
//        opdb.updateStudentInfo("2010014127","sname","亚索_");
//        opdb.updateStudentInfo("1810014124","sname","李明明");
//        opdb.bySumOfScore();
//        opdb.byAvgOfScore();
//        opdb.bySno();
//        opdb.bySingleOfScore("chineseScore");
//        opdb.bySingleOfScore("mathScore");
//        opdb.ExceRate();
//        opdb.FailRate();
//        opdb.peakScore("mathScore", false);
        opdb.BatchInput();
    }
}