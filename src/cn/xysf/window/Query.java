package cn.xysf.window;

import cn.xysf.db.DataBaseOp;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.Arrays;
import java.util.List;

public class Query {

    public JFrame frame;
    public DefaultTableModel model;
    private JTextField textField;
    public JTable table;


    /**
     * Create the application.
     */
    public Query() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("字段查询");
        frame.setBounds(600, 300, 691, 466);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnNewButton = new JButton("\u67E5\u8BE2");//查询按钮
        btnNewButton.setBounds(516, 29, 119, 43);
        btnNewButton.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        btnNewButton.setFocusPainted(false);
        btnNewButton.setBorderPainted(false);
        frame.getContentPane().add(btnNewButton);

        JComboBox comboBox_1 = new JComboBox();//下拉框子 学号 姓名等等
        comboBox_1.setBounds(137, 29, 160, 43);
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"\u5B66\u53F7", "\u59D3\u540D", "\u73ED\u7EA7", "单科排名"}));
        comboBox_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        frame.getContentPane().add(comboBox_1);
        if(!new Storage().isAdmin()){
            comboBox_1.setEnabled(false);
            comboBox_1.setForeground(Color.BLACK);
        }

        JLabel lblNewLabel = new JLabel("\u5173\u952E\u5B57\uFF1A");
        lblNewLabel.setForeground(new Color(178, 34, 34));
        lblNewLabel.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        lblNewLabel.setBounds(14, 29, 128, 43);
        frame.getContentPane().add(lblNewLabel);

        textField = new JTextField();//填 计科1801 李恒威等等文本框
        textField.setText("(必填项)");
        textField.setForeground(Color.LIGHT_GRAY);
        textField.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        textField.setBounds(311, 29, 191, 43);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        if (!new Storage().isAdmin()){
            textField.setEditable(false);
            textField.setForeground(Color.BLACK);
            textField.setText(new Storage().getSno());
        }

        JScrollPane scrollPane;
        scrollPane = new JScrollPane();
        scrollPane.setBounds(14, 85, 649, 280);
        frame.getContentPane().add(scrollPane);


        table = new JTable();
        table.setBackground(new Color(173, 216, 230));
        table.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 18));
        table.setRowHeight(35);
        scrollPane.setViewportView(table);
        model = new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                },
                new String[] {
                        "\u5B66\u53F7", "\u59D3\u540D", "\u73ED\u7EA7", "\u8BED\u6587\u6210\u7EE9", "\u6570\u5B66\u6210\u7EE9", "\u82F1\u8BED\u6210\u7EE9"
                });
        table.setModel(model);
        table.getColumnModel().getColumn(0).setPreferredWidth(89);

        JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");//重置按钮
        btnNewButton_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        btnNewButton_1.setFocusPainted(false);
        btnNewButton_1.setBorderPainted(false);
        //btnNewButton_1.setContentAreaFilled(false);//背景透明
        btnNewButton_1.setBounds(137, 369, 119, 43);
        frame.getContentPane().add(btnNewButton_1);


        JButton btnNewButton_2 = new JButton("\u8FD4\u56DE");//返回按钮
        btnNewButton_2.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        btnNewButton_2.setFocusPainted(false);
        btnNewButton_2.setBorderPainted(false);
        //btnNewButton_2.setContentAreaFilled(false);//背景透明
        btnNewButton_2.setBounds(419, 369, 119, 43);
        frame.getContentPane().add(btnNewButton_2);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("F:\\JavaCode\\学生成绩管理系统\\images\\ScoreOp\\query_bg.jpg"));//背景图
        lblNewLabel_1.setBounds(0, 0, 673, 419);
        frame.getContentPane().add(lblNewLabel_1);

        addActionListener(comboBox_1,textField,btnNewButton,table,btnNewButton_1,btnNewButton_2,frame,model);
    }

    public static void LegalInspection(int num, String KeyValue,DefaultTableModel model){
        switch (num){
            case 0:
                if(KeyValue.equals("(必填项)")){
                    JOptionPane.showMessageDialog(null, "亲，查询学生学号不能为空", "查询数据信息提示",JOptionPane.WARNING_MESSAGE);
                }else if ((KeyValue.length() != 10) || !(KeyValue.matches("[0-9]+"))){
                    JOptionPane.showMessageDialog(null, "亲，请检查查询学生学号合法性！", "查询数据信息提示",JOptionPane.WARNING_MESSAGE);
                }else if( !DataBaseOp.scoreExist("sno",KeyValue)) {
                    JOptionPane.showMessageDialog(null, "亲，该学生的不存在，无法查询！", "查询数据信息提示", JOptionPane.WARNING_MESSAGE);
                } else {
                    Object[][] obj = new DataBaseOp().queryStudentInfo("sno",KeyValue);
                    Object[] tmp = obj[0];
                    model.insertRow(0,tmp);
                    // 查询数据
                    JOptionPane.showMessageDialog(null, "亲，查询数据成功！", "查询数据信息提示",JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            case 1:
                if(KeyValue.equals("(必填项)")){
                    JOptionPane.showMessageDialog(null, "亲，查询学生姓名不能为空", "查询数据信息提示",JOptionPane.WARNING_MESSAGE);
                }else if (KeyValue.length() < 2 || KeyValue.length() > 4){
                    JOptionPane.showMessageDialog(null, "亲，请检查添加学生的姓名合法性！", "插入数据信息提示",JOptionPane.WARNING_MESSAGE);
                }else if (!DataBaseOp.scoreExist("sname",KeyValue)){
                    JOptionPane.showMessageDialog(null, "亲，该学生的不存在，无法查询！", "查询数据信息提示", JOptionPane.WARNING_MESSAGE);
                }else {
                    Object[][] obj = new DataBaseOp().queryStudentInfo("sname",KeyValue);

                    for (Object[] tmp: obj){
                        if(tmp[0] != null){
                            model.insertRow(0,tmp);
                        }
                    }
                    // 查询数据
                    JOptionPane.showMessageDialog(null, "亲，查询数据成功！", "查询数据信息提示",JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            case 2:
                String[] strs = new String[] {"计科1801","计科1802","计科1803","软件1801","软件1802","物联1801","物联1802"};
                List list = Arrays.asList(strs);
                if(KeyValue.equals("(必填项)")){
                    JOptionPane.showMessageDialog(null, "亲，查询班级不能为空", "查询数据信息提示",JOptionPane.WARNING_MESSAGE);
                }else if (!list.contains(KeyValue)){
                    JOptionPane.showMessageDialog(null, "亲，请检查查询班级是否存在！", "查询数据信息提示",JOptionPane.WARNING_MESSAGE);
                }else if (!DataBaseOp.scoreExist("sclass",KeyValue)){
                    JOptionPane.showMessageDialog(null, "亲，该班级不存在，无法查询！", "查询数据信息提示", JOptionPane.WARNING_MESSAGE);
                }else {
                    Object[][] obj = new DataBaseOp().queryStudentInfo("sclass",KeyValue);
                    for (Object[] tmp: obj){
                        if(tmp[0] != null){
                            model.insertRow(0,tmp);
                        }
                    }
                    // 查询数据
                    JOptionPane.showMessageDialog(null, "亲，查询数据成功！", "查询数据信息提示",JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            case 3:
                String[] strs2 = new String[] {"语文","数学","英语"};
                List list2 = Arrays.asList(strs2);
                if(KeyValue.equals("(必填项)")) {
                    JOptionPane.showMessageDialog(null, "亲，排序学科不能为空", "查询数据信息提示", JOptionPane.WARNING_MESSAGE);
                }else if(!list2.contains(KeyValue)){
                    JOptionPane.showMessageDialog(null, "亲，请检查排序学科是否存在！", "查询数据信息提示",JOptionPane.WARNING_MESSAGE);
                }else {
                    Object[][] obj;
                    if(KeyValue.equals("语文")){
                        obj = new Storage().getAdm().bySingleOfScore("chineseScore");
                    }else if(KeyValue.equals("数学")){
                        obj = new Storage().getAdm().bySingleOfScore("mathScore");
                    }else {
                        obj = new Storage().getAdm().bySingleOfScore("englishScore");
                    }
                    for (Object[] tmp: obj){
                        if(tmp[0] != null){
                            model.insertRow(0,tmp);
                        }
                    }
                    JOptionPane.showMessageDialog(null, "亲，查询数据成功！", "查询数据信息提示",JOptionPane.INFORMATION_MESSAGE);
                }
                break;
        }
    }

    public static void resetTable(JTable table,DefaultTableModel model){
        int cols = model.getRowCount();
        for(int i=0; i<cols; i++){
            model.removeRow(0);
        }
        for (int j=0; j<7; j++){
            Object[] obj = new Object[] {null, null, null, null, null};
            model.insertRow(0, obj);
        }
        table.setModel(model);
    }

    public static void addActionListener(JComboBox keyWord, JTextField keyValue, JButton query, JTable table,
                                         JButton reset, JButton ret, JFrame frame, DefaultTableModel model){
        keyValue.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(keyValue.getText().trim().equals("(必填项)")){
                    keyValue.setForeground(Color.BLACK);
                    keyValue.setText("");//让文本为空白
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(keyValue.getText().trim().equals("")){
                    keyValue.setForeground(Color.LIGHT_GRAY);
                    keyValue.setText("(必填项)");
                }
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(new Storage().isAdmin()){
                    keyValue.setText("(必填项)");
                    keyValue.setForeground(Color.LIGHT_GRAY);
                }
                keyWord.setSelectedItem("学号");
                Query.resetTable(table,model);
            }
        });

        ret.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Menu().frame.setVisible(true);
                frame.setVisible(false);
            }
        });

        query.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Query.resetTable(table,model);
                if(!new Storage().isAdmin()){
                    new Storage().getStu().queryInfo();
                    Object[][] obj = new DataBaseOp().queryStudentInfo("sno",new Storage().getSno());
                    for (Object[] tmp: obj){
                        if(tmp[0] != null){
                            model.insertRow(0,tmp);
                        }
                    }
                    // 查询数据
                    JOptionPane.showMessageDialog(null, "亲，查询数据成功！", "查询数据信息提示",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    int num = keyWord.getSelectedIndex();
                    String KeyValue = keyValue.getText();
                    // 合法性检查
                    Query.LegalInspection(num,KeyValue,model);
                }
            }
        });

        keyWord.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == e.SELECTED){
                    keyValue.setForeground(Color.LIGHT_GRAY);
                    keyValue.setText("(必填项)");
                    Query.resetTable(table,model);
                }
            }
        });
    }
}
