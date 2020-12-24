package cn.xysf.window;

import java.awt.EventQueue;
import cn.xysf.db.DataBaseOp;

import javax.swing.*;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RateQuery {

    public JFrame frame;
    public JTable table;
    public DefaultTableModel model;

    /**
     * Create the application.
     */
    public RateQuery() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("比率查询");
        frame.setBounds(600, 300, 691, 466);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btnNewButton = new JButton("\u67E5\u8BE2");//排序按钮
        btnNewButton.setBounds(520, 31, 100, 43);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        frame.getContentPane().setLayout(null);
        btnNewButton.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        btnNewButton.setFocusPainted(false);
        btnNewButton.setBorderPainted(false);
        frame.getContentPane().add(btnNewButton);

        JComboBox comboBox_1 = new JComboBox();//班级下拉框
        comboBox_1.setBounds(149, 31, 178, 43);
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"\u8BA1\u79D11801", "\u8BA1\u79D11802", "\u8BA1\u79D11803", "\u7269\u80541801", "\u7269\u80541802", "\u8F6F\u4EF61801", "\u8F6F\u4EF61802"}));
        comboBox_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        frame.getContentPane().add(comboBox_1);

        JScrollPane scrollPane;
        scrollPane = new JScrollPane();
        scrollPane.setBounds(14, 160, 649, 81);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        table.setRowHeight(56);
        model = new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null},
                },
                new String[] {
                        "\u73ED\u7EA7", "\u8BED\u6587", "\u6570\u5B66", "\u82F1\u8BED"
                }
        );
        table.setModel(model);
        table.getColumnModel().getColumn(2).setPreferredWidth(79);
        scrollPane.setViewportView(table);

        JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");//重置按钮
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnNewButton_1.setBounds(137, 348, 119, 43);
        btnNewButton_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        btnNewButton_1.setFocusPainted(false);
        btnNewButton_1.setBorderPainted(false);
        frame.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("\u8FD4\u56DE");//返回按钮
        btnNewButton_2.setBounds(414, 348, 119, 43);
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton_2.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        btnNewButton_2.setFocusPainted(false);
        btnNewButton_2.setBorderPainted(false);
        frame.getContentPane().add(btnNewButton_2);

        JLabel lblNewLabel_1 = new JLabel("\u73ED\u7EA7\uFF1A");//班级 框
        lblNewLabel_1.setForeground(new Color(178, 34, 34));
        lblNewLabel_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        lblNewLabel_1.setBounds(46, 31, 100, 43);
        frame.getContentPane().add(lblNewLabel_1);

        JComboBox comboBox_1_1 = new JComboBox();
        comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"\u4F18\u79C0\u7387", "\u4E0D\u53CA\u683C\u7387"}));
        comboBox_1_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        comboBox_1_1.setBounds(330, 31, 176, 43);
        frame.getContentPane().add(comboBox_1_1);

        JLabel lblNewLabel_11 = new JLabel("");
        lblNewLabel_11.setIcon(new ImageIcon("F:\\JavaCode\\学生成绩管理系统\\images\\ScoreOp\\rate_bg.jpg"));//背景图
        lblNewLabel_11.setBounds(0, 0, 673, 419);
        frame.getContentPane().add(lblNewLabel_11);

        addActionListener(comboBox_1, comboBox_1_1,btnNewButton,table,btnNewButton_1,btnNewButton_2,frame,model);
    }

    public static void resetTable(JTable table,DefaultTableModel model){
        int cols = model.getRowCount();
        for(int i=0; i<cols; i++){
            model.removeRow(0);
        }
        Object[] obj = new Object[] {null, null, null, null};
        model.insertRow(0, obj);
        table.setModel(model);
    }

    public static void addActionListener(JComboBox sclass, JComboBox rate,JButton query,JTable table,
                                         JButton reset,JButton ret,JFrame frame,DefaultTableModel model){
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sclass.setSelectedItem("计科1801");
                rate.setSelectedItem("优秀率");
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

        query.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RateQuery.resetTable(table,model);
                String Sclass = sclass.getSelectedItem().toString();
                int Rate = rate.getSelectedIndex(); // 0/1
                Object[] obj = {};

                if(!DataBaseOp.scoreExist("sclass",Sclass)){
                    JOptionPane.showMessageDialog(null, "亲，该班级的成绩数据为空！", "数率数据信息提示",JOptionPane.WARNING_MESSAGE);
                }else{
                    if(Rate == 0){
                        obj = new Storage().getAdm().ExceRate(Sclass);
                    }else{
                        obj = new Storage().getAdm().FailRate(Sclass);
                    }
                    model.removeRow(0);
                    model.insertRow(0,obj);
                }
            }
        });

        sclass.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == e.SELECTED){
                    RateQuery.resetTable(table,model);
                }

            }
        });

        rate.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == e.SELECTED){
                    RateQuery.resetTable(table,model);
                }

            }
        });
    }
}
