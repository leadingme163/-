package cn.xysf.window;

import cn.xysf.db.DataBaseOp;
import cn.xysf.user.ScoreInfo;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.Color;

public class Delete {

    public JFrame frame;
    public DefaultTableModel model;
    private JTextField textField;
    public JTable table;

    /**
     * Create the application.
     */
    public Delete() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("删除界面");
        frame.setBounds(600, 300, 691, 466);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnNewButton = new JButton("\u5220\u9664");//删除按钮
        btnNewButton.setBounds(435, 29, 119, 43);
        btnNewButton.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        btnNewButton.setFocusPainted(false);
        btnNewButton.setBorderPainted(false);
        frame.getContentPane().add(btnNewButton);

        JLabel lblNewLabel = new JLabel("\u5B66 \u53F7\uFF1A");
        lblNewLabel.setForeground(new Color(0, 0, 0));
        lblNewLabel.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        lblNewLabel.setBounds(109, 29, 128, 43);
        frame.getContentPane().add(lblNewLabel);

        textField = new JTextField();//填 学号文本框
        textField.setText("(必填项)");
        textField.setForeground(Color.LIGHT_GRAY);
        textField.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        textField.setBounds(216, 29, 191, 43);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JScrollPane scrollPane;
        scrollPane = new JScrollPane();
        scrollPane.setBounds(14, 197, 649, 101);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        table.setBackground(new Color(230, 230, 250));
        table.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 18));
        table.setRowHeight(70);
        scrollPane.setViewportView(table);
        DefaultTableModel model = new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null}
                },
                new String[] {
                        "\u5B66\u53F7", "\u59D3\u540D", "\u73ED\u7EA7", "\u8BED\u6587\u6210\u7EE9", "\u6570\u5B66\u6210\u7EE9", "\u82F1\u8BED\u6210\u7EE9"
                }
        );
        table.setModel(model);

        JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");//重置按钮
        btnNewButton_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        btnNewButton_1.setFocusPainted(false);
        btnNewButton_1.setBorderPainted(false);
        //btnNewButton_1.setContentAreaFilled(false);//背景透明
        btnNewButton_1.setBounds(137, 341, 119, 43);
        frame.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_3 = new JButton("撤销");//撤销按钮
        btnNewButton_3.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        btnNewButton_3.setFocusPainted(false);
        btnNewButton_3.setBorderPainted(false);
        //btnNewButton_3.setContentAreaFilled(false);//背景透明
        btnNewButton_3.setBounds(277, 341, 119, 43);
        frame.getContentPane().add(btnNewButton_3);

        JButton btnNewButton_2 = new JButton("\u8FD4\u56DE");//返回按钮
        btnNewButton_2.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        btnNewButton_2.setFocusPainted(false);
        btnNewButton_2.setBorderPainted(false);
        //btnNewButton_2.setContentAreaFilled(false);//背景透明
        btnNewButton_2.setBounds(417, 341, 119, 43);
        frame.getContentPane().add(btnNewButton_2);

        JLabel lblNewLabel_1 = new JLabel("\u5220\u9664\u7684\u5B66\u751F\u4FE1\u606F\u5982\u4E0B\uFF1A");
        lblNewLabel_1.setForeground(new Color(255, 0, 0));
        lblNewLabel_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        lblNewLabel_1.setBounds(14, 105, 373, 43);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("F:\\JavaCode\\学生成绩管理系统\\images\\ScoreOp\\add_bg.jpg"));//背景图片
        lblNewLabel_2.setBounds(0, 0, 673, 430);
        frame.getContentPane().add(lblNewLabel_2);

        addActionListener(textField, btnNewButton,btnNewButton_1,btnNewButton_3,btnNewButton_2,table,frame,model);
    }

    public static void LegalInspection(String sno,JTable table, DefaultTableModel model){
        if(sno.equals("(必填项)")){
            JOptionPane.showMessageDialog(null, "亲，删除学生学号不能为空", "删除数据信息提示",JOptionPane.WARNING_MESSAGE);
        }else if ((sno.length() != 10) || !(sno.matches("[0-9]+"))){
            JOptionPane.showMessageDialog(null, "亲，请检查删除学生学号合法性！", "删除数据信息提示",JOptionPane.WARNING_MESSAGE);
        }else if( !DataBaseOp.scoreExist("sno",sno)) {
            JOptionPane.showMessageDialog(null, "亲，该学生的成绩未被录入，无法删除！", "删除数据信息提示", JOptionPane.WARNING_MESSAGE);
        } else {
            Object[][] obj = new DataBaseOp().queryStudentInfo("sno",sno);
            Object[] tmp = obj[0];
            model.removeRow(0);
            model.insertRow(0,tmp);
            new Storage().getAdm().delInfo(sno);
            ScoreInfo stu = new ScoreInfo(tmp[0].toString(),tmp[1].toString(),tmp[2].toString(),
                    Integer.parseInt(tmp[3].toString()),Integer.parseInt(tmp[4].toString()),Integer.parseInt(tmp[5].toString()));
            new Storage().setInfo(stu);
            JOptionPane.showMessageDialog(null, "亲，删除数据成功！", "删除数据信息提示",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void resetTable(JTable table,DefaultTableModel model){
        int cols = model.getRowCount();
        for(int i=0; i<cols; i++){
            model.removeRow(0);
        }
        Object[] obj = new Object[] {null, null, null, null, null};
        model.insertRow(0, obj);
        table.setModel(model);
    }

    public static void addActionListener(JTextField sno,JButton delBtn, JButton reset, JButton revoke, JButton ret, JTable table,
                                         JFrame frame, DefaultTableModel model){
        sno.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(sno.getText().trim().equals("(必填项)")){
                    sno.setForeground(Color.BLACK);
                    sno.setText("");//让文本为空白
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(sno.getText().trim().equals("")){
                    sno.setForeground(Color.LIGHT_GRAY);
                    sno.setText("(必填项)");
                }
            }
        });

        delBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Sno = sno.getText();
                // 合法性检验
                Delete.LegalInspection(Sno,table,model);
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sno.setText("(必填项)");
                sno.setForeground(Color.LIGHT_GRAY);
                Delete.resetTable(table,model);
            }
        });

        ret.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Menu().frame.setVisible(true);
                frame.setVisible(false);
            }
        });

        revoke.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScoreInfo stu = new Storage().getInfo();
                new DataBaseOp().addStudentInfo(stu);
                JOptionPane.showMessageDialog(null, "亲，撤销数据成功！", "删除数据信息提示",JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
