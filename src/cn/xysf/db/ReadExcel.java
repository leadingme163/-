package cn.xysf.db;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jxl.Sheet;
import jxl.Workbook;
import cn.xysf.user.ScoreInfo;

public class ReadExcel {
    public static List<ScoreInfo> getAllByExcel(String file){
        List<ScoreInfo> list=new ArrayList<ScoreInfo>();
        try {
            Workbook rwb=Workbook.getWorkbook(new File(file));//得到文本文件
            Sheet rs=rwb.getSheet(0);//或者rwb.getSheet(0)
            int clos=rs.getColumns();//得到所有的列
            int rows=rs.getRows();//得到所有的行

            // 读取数据
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    //第一个是列数，第二个是行数
                    String sno=rs.getCell(j++, i).getContents();//默认最左边编号也算一列 所以这里得j++
                    String sname=rs.getCell(j++, i).getContents();
                    String sclass=rs.getCell(j++, i).getContents();
                    String chinese=rs.getCell(j++, i).getContents();
                    String math=rs.getCell(j++,i).getContents();
                    String english=rs.getCell(j++,i).getContents();

                    list.add(new ScoreInfo(sno, sname, sclass, Integer.parseInt(chinese),Integer.parseInt(math),Integer.parseInt(english)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
//    public static void main(String[] args) {
//        ReadExcel.getAllByExcel("F:\\JavaCode\\学生成绩管理系统\\images\\demo.xls");
//    }
}