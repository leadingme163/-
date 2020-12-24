package cn.xysf.window;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Sort {

    public JFrame frame;
    public DefaultTableModel model;
    public JTable table;

    /**
     * Create the application.
     */
    public Sort() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("成绩排序");
        frame.setBounds(600, 300, 691, 466);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnNewButton = new JButton("\u6392\u5E8F");//排序按钮
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnNewButton.setBounds(467, 29, 119, 43);
        btnNewButton.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        btnNewButton.setFocusPainted(false);
        btnNewButton.setBorderPainted(false);
        frame.getContentPane().add(btnNewButton);

        JComboBox comboBox_1 = new JComboBox();//下拉框子 学号 姓名等等
        comboBox_1.setBounds(277, 29, 160, 43);
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"\u5B66\u53F7", "\u603B\u6210\u7EE9", "\u5E73\u5747\u6210\u7EE9"}));
        comboBox_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        frame.getContentPane().add(comboBox_1);

        JLabel lblNewLabel = new JLabel("\u6392\u5E8F\u5173\u952E\u5B57\uFF1A");//排序关键字
        lblNewLabel.setForeground(new Color(178, 34, 34));
        lblNewLabel.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        lblNewLabel.setBounds(80, 29, 198, 43);
        frame.getContentPane().add(lblNewLabel);

        JScrollPane scrollPane;
        scrollPane = new JScrollPane();
        scrollPane.setBounds(14, 85, 649, 265);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        table.setBackground(new Color(173, 216, 230));
        table.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 18));
        table.setRowHeight(35);
        scrollPane.setViewportView(table);
        model = new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                },
                new String[] {
                        "\u5B66\u53F7", "\u59D3\u540D", "\u73ED\u7EA7", "\u8BED\u6587\u6210\u7EE9", "\u6570\u5B66\u6210\u7EE9", "\u82F1\u8BED\u6210\u7EE9", ""
                }
        );
        table.setModel(model);
        table.getColumnModel().getColumn(0).setPreferredWidth(96);

        JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");//重置按钮
        btnNewButton_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        btnNewButton_1.setFocusPainted(false);
        btnNewButton_1.setBorderPainted(false);
        //btnNewButton_1.setContentAreaFilled(false);//背景透明
        btnNewButton_1.setBounds(137, 369, 119, 43);
        frame.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("\u8FD4\u56DE");//返回按钮
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton_2.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        btnNewButton_2.setFocusPainted(false);
        btnNewButton_2.setBorderPainted(false);
        //btnNewButton_2.setContentAreaFilled(false);//背景透明
        btnNewButton_2.setBounds(419, 369, 119, 43);
        frame.getContentPane().add(btnNewButton_2);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("F:\\JavaCode\\学生成绩管理系统\\images\\ScoreOp\\sort_bg.jpg"));//背景图
        lblNewLabel_1.setBounds(0, 0, 673, 419);
        frame.getContentPane().add(lblNewLabel_1);

        addActionListener(comboBox_1,btnNewButton,btnNewButton_1,btnNewButton_2,table,model,frame);
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

    public static void addActionListener(JComboBox sortKey, JButton sortBtn, JButton reset, JButton ret,
                                         JTable table, DefaultTableModel model, Frame frame){
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortKey.setSelectedItem("学号");
                Sort.resetTable(table,model);
            }
        });

        ret.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Menu().frame.setVisible(true);
                frame.setVisible(false);
            }
        });

        sortBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sort.resetTable(table,model);
                int num = sortKey.getSelectedIndex();
                Object[][] obj = {{}};
                switch (num){
                    case 0:
                        obj = new Storage().getAdm().bySno();
                        break;
                    case 1:
                        obj = new Storage().getAdm().bySumOfScore();
                        break;
                    case 2:
                        obj = new Storage().getAdm().byAvgOfScore();
                }
                for (Object[] tmp: obj){
                    if(tmp[0] != null){
                        model.insertRow(0,tmp);
                    }
                }
            }
        });

        sortKey.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == e.SELECTED){
                    Sort.resetTable(table,model);
                }

            }
        });
    }
}
