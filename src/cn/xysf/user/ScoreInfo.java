package cn.xysf.user;

public class ScoreInfo {
    private String sno;
    private String sname;
    private String sclass;
    private int chineseScore;
    private int mathScore;
    private int englishScore;

    public ScoreInfo(String sno, String sname, String sclass,
                     int chineseScore, int mathScore, int englishScore){
        this.sno = sno;
        this.sname = sname;
        this.sclass = sclass;
        this.chineseScore = chineseScore;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
    }

    public ScoreInfo(){
        super();
    }

    public String getSno() {
        return sno;
    }
    public String getSname() {
        return sname;
    }
    public String getSclass() {
        return sclass;
    }
    public int getChineseScore() {
        return chineseScore;
    }
    public int getMathScore() {
        return mathScore;
    }
    public int getEnglishScore() {
        return englishScore;
    }
}