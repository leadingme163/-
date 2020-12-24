package cn.xysf.window;

import cn.xysf.db.DataBaseOp;
import cn.xysf.user.ScoreInfo;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Update {

    public JFrame frame;
    private JTextField textField_1;
    private JTextField textField;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;


    /**
     * Create the application.
     */
    public Update() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("修改数据");
        frame.setBounds(600, 300, 691, 466);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("\u5B66\u751F\u4FE1\u606F");
        lblNewLabel.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel.setBounds(288, 13, 91, 43);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("\u5B66\u751F\u6210\u7EE9");
        lblNewLabel_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel_1.setBounds(288, 170, 91, 34);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("\u5B66\u53F7\uFF1A");
        lblNewLabel_2.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel_2.setBounds(187, 42, 69, 43);
        frame.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("\u59D3\u540D\uFF1A");
        lblNewLabel_3.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel_3.setBounds(187, 84, 69, 43);
        frame.getContentPane().add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("\u73ED\u7EA7\uFF1A");
        lblNewLabel_4.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel_4.setBounds(187, 132, 69, 43);
        frame.getContentPane().add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("\u8BED\u6587\uFF1A");
        lblNewLabel_5.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel_5.setBounds(187, 203, 69, 43);
        frame.getContentPane().add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("\u6570\u5B66\uFF1A");
        lblNewLabel_6.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel_6.setBounds(187, 251, 69, 43);
        frame.getContentPane().add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("\u82F1\u8BED\uFF1A");
        lblNewLabel_7.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel_7.setBounds(187, 296, 69, 43);
        frame.getContentPane().add(lblNewLabel_7);

        JButton btnNewButton = new JButton("\u4FEE\u6539");//添加按钮
        btnNewButton.setBorderPainted(false);//去内框
        btnNewButton.setFocusPainted(false);//去外框
        btnNewButton.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        btnNewButton.setBounds(160, 352, 109, 42);
        frame.getContentPane().add(btnNewButton);

        textField_1 = new JTextField();//姓名文本框
        textField_1.setForeground(Color.LIGHT_GRAY);
        textField_1.setText("(\u9ED8\u8BA4\u4E0D\u505A\u4FEE\u6539)");
        textField_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 20));
        textField_1.setColumns(10);
        textField_1.setBounds(250, 95, 263, 27);
        frame.getContentPane().add(textField_1);

        textField = new JTextField();//学号文本框
        textField.setForeground(Color.LIGHT_GRAY);
        textField.setText("(学号必须填写)");
        textField.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 20));
        textField.setColumns(10);
        textField.setBounds(250, 53, 263, 27);
        frame.getContentPane().add(textField);

        textField_3 = new JTextField();//语文文本框
        textField_3.setForeground(Color.LIGHT_GRAY);
        textField_3.setText("(\u9ED8\u8BA4\u4E0D\u505A\u4FEE\u6539)");
        textField_3.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 20));
        textField_3.setColumns(10);
        textField_3.setBounds(250, 210, 263, 27);
        frame.getContentPane().add(textField_3);

        textField_4 = new JTextField();//数学文本框
        textField_4.setForeground(Color.LIGHT_GRAY);
        textField_4.setText("(\u9ED8\u8BA4\u4E0D\u505A\u4FEE\u6539)");
        textField_4.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 20));
        textField_4.setColumns(10);
        textField_4.setBounds(250, 259, 263, 27);
        frame.getContentPane().add(textField_4);

        textField_5 = new JTextField();//英语文本框
        textField_5.setForeground(Color.LIGHT_GRAY);
        textField_5.setText("(\u9ED8\u8BA4\u4E0D\u505A\u4FEE\u6539)");
        textField_5.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 20));
        textField_5.setColumns(10);
        textField_5.setBounds(250, 307, 263, 27);
        frame.getContentPane().add(textField_5);

        JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");//重置按钮
        btnNewButton_1.setBorderPainted(false);//去内框
        btnNewButton_1.setFocusPainted(false);//去外框
        btnNewButton_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        btnNewButton_1.setBounds(300, 352, 111, 42);
        frame.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_1_1 = new JButton("\u8FD4\u56DE");//返回按钮
        btnNewButton_1_1.setBorderPainted(false);//去内框
        btnNewButton_1_1.setFocusPainted(false);//去外框
        btnNewButton_1_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        btnNewButton_1_1.setBounds(443, 352, 111, 42);
        frame.getContentPane().add(btnNewButton_1_1);

        JComboBox comboBox = new JComboBox();//班级下拉框
        comboBox.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 20));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"                ", "\u8BA1\u79D11801", "\u8BA1\u79D11802", "\u8BA1\u79D11803", "\u7269\u80541801", "\u7269\u80541802", "\u8F6F\u4EF61801", "\u8F6F\u4EF61802"}));
        comboBox.setBounds(250, 143, 263, 24);
        frame.getContentPane().add(comboBox);

        JLabel lblNewLabel_8 = new JLabel("");
        lblNewLabel_8.setIcon(new ImageIcon("F:\\JavaCode\\学生成绩管理系统\\images\\ScoreOp\\update_bg.png"));
        lblNewLabel_8.setBounds(0, 0, 700, 440);
        frame.getContentPane().add(lblNewLabel_8);

        addActionListener(textField,textField_1,textField_3,textField_4,textField_5,comboBox,btnNewButton
                ,btnNewButton_1,btnNewButton_1_1,frame);
    }

    public static void LegalInspection(String Sno, String Sname, String Sclass, String Chinese, String Math, String English){
        if(Sno.equals("(默认不做修改)")){
            JOptionPane.showMessageDialog(null, "亲，修改学生学号不能为空", "修改数据信息提示",JOptionPane.WARNING_MESSAGE);
        }
        else if((Sno.length() != 10) || !(Sno.matches("[0-9]+"))){
            JOptionPane.showMessageDialog(null, "亲，请检查修改学生学号合法性！", "修改数据信息提示",JOptionPane.WARNING_MESSAGE);
        }else if( !DataBaseOp.scoreExist("sno",Sno)){
            JOptionPane.showMessageDialog(null, "亲，该学生的成绩未被录入，无法修改！", "修改数据信息提示",JOptionPane.WARNING_MESSAGE);
        }else if (!Sname.equals("(默认不做修改)") && (Sname.length() < 2 || Sname.length() > 4)){
            JOptionPane.showMessageDialog(null, "亲，请检查修改学生的姓名合法性！", "修改数据信息提示",JOptionPane.WARNING_MESSAGE);
        }else if (!Chinese.equals("(默认不做修改)") && !Chinese.matches("[0-9]+")){
            JOptionPane.showMessageDialog(null, "亲，修改学生的成绩值不合法！", "修改数据信息提示",JOptionPane.WARNING_MESSAGE);
        }else if (!Math.equals("(默认不做修改)") && !Math.matches("[0-9]+")){
            JOptionPane.showMessageDialog(null, "亲，修改学生的成绩值不合法！", "修改数据信息提示",JOptionPane.WARNING_MESSAGE);
        }else if (!English.equals("(默认不做修改)") && !English.matches("[0-9]+")){
            JOptionPane.showMessageDialog(null, "亲，修改学生的成绩值不合法！", "修改数据信息提示",JOptionPane.WARNING_MESSAGE);
        }else if (!Chinese.equals("(默认不做修改)") && (Integer.parseInt(Chinese) < 0 || Integer.parseInt(Chinese) > 100)){
            JOptionPane.showMessageDialog(null, "亲，修改学生的成绩值必须在0~100之间！", "修改数据信息提示",JOptionPane.WARNING_MESSAGE);
        }else if (!Math.equals("(默认不做修改)") && (Integer.parseInt(Math) < 0 || Integer.parseInt(Math) > 100)){
            JOptionPane.showMessageDialog(null, "亲，修改学生的成绩值必须在0~100之间！", "修改数据信息提示",JOptionPane.WARNING_MESSAGE);
        }else if (!English.equals("(默认不做修改)") && (Integer.parseInt(English) < 0 || Integer.parseInt(English) > 100)){
            JOptionPane.showMessageDialog(null, "亲，修改学生的成绩值必须在0~100之间！", "修改数据信息提示",JOptionPane.WARNING_MESSAGE);
        }else{
            Storage stor = new Storage();
            if(!Sclass.trim().equals("")){
                stor.getAdm().updateInfo(Sno,"sclass",Sclass);
            }
            if(!Sname.equals("(默认不做修改)")){
                stor.getAdm().updateInfo(Sno,"sname",Sname);
            }
            if(!Chinese.equals("(默认不做修改)")){
                stor.getAdm().updateInfo(Sno,"chineseScore",Chinese);
            }
            if(!Math.equals("(默认不做修改)")){
                stor.getAdm().updateInfo(Sno,"mathScore",Math);
            }
            if(!English.equals("(默认不做修改)")){
                stor.getAdm().updateInfo(Sno,"englishScore",English);
            }
            JOptionPane.showMessageDialog(null, "亲，修改数据成功！", "修改数据信息提示",JOptionPane.INFORMATION_MESSAGE);
        }
    };

    public static void addActionListener(JTextField sno,JTextField sname,JTextField chinese,JTextField math,
                                         JTextField english,JComboBox sclass ,JButton update,JButton reset ,
                                         JButton ret, JFrame frame){
        sno.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(sno.getText().trim().equals("(学号必须填写)")){
                    sno.setForeground(Color.BLACK);
                    sno.setText("");//让文本为空白
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(sno.getText().trim().equals("")){
                    sno.setForeground(Color.LIGHT_GRAY);
                    sno.setText("(学号必须填写)");
                }
            }
        });

        sname.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(sname.getText().trim().equals("(默认不做修改)")){
                    sname.setForeground(Color.BLACK);
                    sname.setText("");//让文本为空白
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(sname.getText().trim().equals("")){
                    sname.setForeground(Color.LIGHT_GRAY);
                    sname.setText("(默认不做修改)");
                }
            }
        });

        chinese.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(chinese.getText().trim().equals("(默认不做修改)")){
                    chinese.setForeground(Color.BLACK);
                    chinese.setText("");//让文本为空白
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(chinese.getText().trim().equals("")){
                    chinese.setForeground(Color.LIGHT_GRAY);
                    chinese.setText("(默认不做修改)");
                }
            }
        });

        math.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(math.getText().trim().equals("(默认不做修改)")){
                    math.setForeground(Color.BLACK);
                    math.setText("");//让文本为空白
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(math.getText().trim().equals("")){
                    math.setForeground(Color.LIGHT_GRAY);
                    math.setText("(默认不做修改)");
                }
            }
        });

        english.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(english.getText().trim().equals("(默认不做修改)")){
                    english.setForeground(Color.BLACK);
                    english.setText("");//让文本为空白
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(english.getText().trim().equals("")){
                    english.setForeground(Color.LIGHT_GRAY);
                    english.setText("(默认不做修改)");
                }
            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Sno = sno.getText();
                String Sname = sname.getText();
                String Sclass = sclass.getSelectedItem().toString();
                String Chinese = chinese.getText();
                String Math = math.getText();
                String English = english.getText();
                // 合法性检查
                Update.LegalInspection(Sno,Sname,Sclass,Chinese,Math,English);
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sno.setText("(学号必须填写)");
                sno.setForeground(Color.LIGHT_GRAY);
                sname.setText("(默认不做修改)");
                sname.setForeground(Color.LIGHT_GRAY);
                chinese.setText("(默认不做修改)");
                chinese.setForeground(Color.LIGHT_GRAY);
                math.setText("(默认不做修改)");
                math.setForeground(Color.LIGHT_GRAY);
                english.setText("(默认不做修改)");
                english.setForeground(Color.LIGHT_GRAY);
                sclass.setSelectedItem("                ");
            }
        });

        ret.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Menu().frame.setVisible(true);
                frame.setVisible(false);
            }
        });
    }
}
