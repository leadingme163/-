package cn.xysf.db;

public interface SortOp {
    public Object[][] bySumOfScore();
    public Object[][] byAvgOfScore();
    public Object[][] bySno();
    public Object[][] bySingleOfScore(String subject);
}
