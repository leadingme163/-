package cn.xysf.window;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {

    public JFrame frame;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;

    /**
     * Create the application.
     */
    public Menu() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("菜单页面");
        frame.setBounds(600, 300, 691, 466);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnNewButton = new JButton("\u589E\u52A0\u6570\u636E");
        btnNewButton.setIcon(new ImageIcon("F:\\JavaCode\\学生成绩管理系统\\images\\menu\\jt.png"));
        btnNewButton.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        btnNewButton.setBorderPainted(false);//去内框
        btnNewButton.setFocusPainted(false);//去外框
        btnNewButton.setBounds(63, 96, 210, 66);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("\u4FEE\u6539\u6570\u636E");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnNewButton_1.setIcon(new ImageIcon("F:\\JavaCode\\学生成绩管理系统\\images\\menu\\jt.png"));
        btnNewButton_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        btnNewButton_1.setBorderPainted(false);//去内框
        btnNewButton_1.setFocusPainted(false);//去外框
        btnNewButton_1.setBounds(63, 175, 210, 66);
        frame.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("\u5220\u9664\u6570\u636E");
        btnNewButton_2.setBorderPainted(false);//去内框
        btnNewButton_2.setFocusPainted(false);//去外框
        btnNewButton_2.setIcon(new ImageIcon("F:\\JavaCode\\学生成绩管理系统\\images\\menu\\jt.png"));
        btnNewButton_2.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        btnNewButton_2.setBounds(397, 96, 210, 66);
        frame.getContentPane().add(btnNewButton_2);

        JButton btnNewButton_1_1 = new JButton("字段查询");
        btnNewButton_1_1.setBorderPainted(false);//去内框
        btnNewButton_1_1.setFocusPainted(false);//去外框
        btnNewButton_1_1.setIcon(new ImageIcon("F:\\JavaCode\\学生成绩管理系统\\images\\menu\\jt.png"));
        btnNewButton_1_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        btnNewButton_1_1.setBounds(397, 175, 210, 66);
        frame.getContentPane().add(btnNewButton_1_1);

        lblNewLabel = new JLabel("\u4EB2\u7231\u7684");
        lblNewLabel.setForeground(new Color(204, 0, 51));
        lblNewLabel.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 19));
        lblNewLabel.setBounds(78, 44, 66, 18);
        lblNewLabel.setOpaque(false);
        frame.getContentPane().add(lblNewLabel);

        lblNewLabel_1 = new JLabel("1810014126");
        lblNewLabel_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel_1.setBounds(144, 44, 116, 18);
//        System.out.println(new Storage().getSno());
        // 获取权限用户调用方法获取账号
        lblNewLabel_1.setText(new Storage().getSno());
        frame.getContentPane().add(lblNewLabel_1);

        lblNewLabel_2 = new JLabel("\u7BA1\u7406\u5458");
        lblNewLabel_2.setForeground(new Color(255, 0, 0));
        lblNewLabel_2.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel_2.setBounds(262, 44, 66, 18);
        if(new Storage().isAdmin()){
            lblNewLabel_2.setText("管理员");
        }else {
            lblNewLabel_2.setText(" 用户");
        }

        frame.getContentPane().add(lblNewLabel_2);

        lblNewLabel_3 = new JLabel("\u6B22\u8FCE\u4F60!!");
        lblNewLabel_3.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel_3.setBounds(330, 44, 91, 18);
        frame.getContentPane().add(lblNewLabel_3);

        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setBounds(78, 259, 72, 18);
        frame.getContentPane().add(lblNewLabel_5);

        JButton btnNewButton_3 = new JButton("\u5207\u6362\u7528\u6237");
        btnNewButton_3.setBorderPainted(false);//去内框
        btnNewButton_3.setFocusPainted(false);//去外框
        btnNewButton_3.setForeground(new Color(204, 0, 51));
        btnNewButton_3.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 18));
        btnNewButton_3.setBounds(271, 347, 116, 46);
        frame.getContentPane().add(btnNewButton_3);

        JButton btnNewButton_3_1 = new JButton("\u9000  \u51FA");
        btnNewButton_3_1.setBorderPainted(false);//去内框
        btnNewButton_3_1.setFocusPainted(false);//去外框
        btnNewButton_3_1.setForeground(new Color(204, 0, 51));
        btnNewButton_3_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 18));
        btnNewButton_3_1.setBounds(412, 347, 116, 46);
        frame.getContentPane().add(btnNewButton_3_1);

        JButton btnNewButton_1_2 = new JButton("\u6210\u7EE9\u6392\u5E8F");
        btnNewButton_1_2.setIcon(new ImageIcon("F:\\JavaCode\\学生成绩管理系统\\images\\menu\\jt.png"));
        btnNewButton_1_2.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        btnNewButton_1_2.setFocusPainted(false);
        btnNewButton_1_2.setBorderPainted(false);
        btnNewButton_1_2.setBounds(63, 254, 210, 66);
        frame.getContentPane().add(btnNewButton_1_2);

        JButton btnNewButton_1_3 = new JButton("比率查询");
        btnNewButton_1_3.setIcon(new ImageIcon("F:\\JavaCode\\学生成绩管理系统\\images\\menu\\jt.png"));
        btnNewButton_1_3.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        btnNewButton_1_3.setFocusPainted(false);
        btnNewButton_1_3.setBorderPainted(false);
        btnNewButton_1_3.setBounds(397, 254, 210, 66);
        frame.getContentPane().add(btnNewButton_1_3);


        //btnNewButton_3.setBounds(271, 347, 116, 46);

        //btnNewButton_3_1.setBounds(470, 347, 116, 46);





        JButton btnNewButton_3_2 = new JButton("\u6279\u91CF\u5BFC\u5165");//批量导入
        btnNewButton_3_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });

        btnNewButton_3_2.setForeground(new Color(204, 0, 51));
        btnNewButton_3_2.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 18));
        btnNewButton_3_2.setFocusPainted(false);
        btnNewButton_3_2.setBorderPainted(false);
        btnNewButton_3_2.setBounds(128, 347, 116, 46);
        frame.getContentPane().add(btnNewButton_3_2);

        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon("F:\\JavaCode\\学生成绩管理系统\\images\\menu\\bg.png"));
        lblNewLabel_4.setBounds(0, 0, 684, 429);
        frame.getContentPane().add(lblNewLabel_4);
        addActionListener(btnNewButton,btnNewButton_2,btnNewButton_1,btnNewButton_1_1,btnNewButton_1_2,
                btnNewButton_1_3,btnNewButton_3_2,btnNewButton_3,btnNewButton_3_1,frame);
    }

    public static void addActionListener(JButton add,JButton del,JButton update,JButton query, JButton sort,
                                         JButton rate,JButton batchInput,JButton switches,JButton exit, JFrame frame){
        switches.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new Login().frame.setVisible(true);
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ret = JOptionPane.showConfirmDialog(null,"确定要退出吗？","退出系统提示",2,1);
                if( ret < 1){
                    frame.setVisible(false);
                    new Exit().frame.setVisible(true);
                }
            }
        });

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(new Storage().isAdmin()){
                    new Add().frame.setVisible(true);
                    frame.setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null, "亲，您的权限不够！", "功能权限提示",JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(new Storage().isAdmin()){
                    new Update().frame.setVisible(true);
                    frame.setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null, "亲，您的权限不够！", "功能权限提示",JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(new Storage().isAdmin()){
                    new Delete().frame.setVisible(true);
                    frame.setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null, "亲，您的权限不够！", "功能权限提示",JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        query.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    new Query().frame.setVisible(true);
                    frame.setVisible(false);
            }
        });

        sort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(new Storage().isAdmin()){
                    new Sort().frame.setVisible(true);
                    frame.setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null, "亲，您的权限不够！", "功能权限提示",JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        rate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(new Storage().isAdmin()){
                    new RateQuery().frame.setVisible(true);
                    frame.setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null, "亲，您的权限不够！", "功能权限提示",JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        batchInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(new Storage().isAdmin()){
                    new Storage().getAdm().BatchInput();
                    JOptionPane.showMessageDialog(null, "亲，批量导入数据库成功！", "导入数据信息提示",JOptionPane.INFORMATION_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(null, "亲，您的权限不够！", "功能权限提示",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
}
