package cn.xysf.window;

import cn.xysf.db.DataBaseOp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;


import javax.swing.DropMode;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import cn.xysf.db.DataBaseOp;
import cn.xysf.user.*;

public class Login extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JLabel lblNewLabel_1;
    private JPasswordField passwordField;
    public JFrame frame;
    /**
     * Create the frame.
     */
    public Login() {

        frame = new JFrame("登录界面");
        frame.setBounds(600, 300, 691, 466);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setForeground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.getContentPane().add(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("\u8D26\u53F7: ");
        lblNewLabel.setFont(new Font("楷体", Font.BOLD | Font.ITALIC, 30));
        lblNewLabel.setForeground(Color.DARK_GRAY);
        lblNewLabel.setBounds(222, 90, 98, 60);
        lblNewLabel.setBorder(null);
        frame.getContentPane().add(lblNewLabel);


        textField = new JTextField();
        textField.setToolTipText("由10位数字组成");
        textField.setBackground(new Color(245, 222, 179));
        textField.setForeground(Color.DARK_GRAY);
        textField.setHorizontalAlignment(SwingConstants.LEFT);
        textField.setFont(new Font("楷体", Font.BOLD | Font.ITALIC, 30));
        textField.setBounds(324, 102, 199, 36);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        lblNewLabel_1 = new JLabel("\u5BC6\u7801: ");
        lblNewLabel_1.setForeground(Color.DARK_GRAY);
        lblNewLabel_1.setFont(new Font("楷体", Font.BOLD | Font.ITALIC, 30));
        lblNewLabel_1.setBounds(212, 173, 98, 60);
        frame.getContentPane().add(lblNewLabel_1);

        JButton btnNewButton = new JButton("\u767B\u5F55");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnNewButton.setBackground(Color.LIGHT_GRAY);
        btnNewButton.setFont(new Font("楷体", Font.BOLD | Font.ITALIC, 30));
        btnNewButton.setForeground(new Color(204, 0, 0));
        btnNewButton.setBounds(207, 308, 113, 40);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1_1 = new JButton("退出");
        btnNewButton_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton_1_1.setBackground(Color.LIGHT_GRAY);
        btnNewButton_1_1.setForeground(new Color(204, 0, 0));
        btnNewButton_1_1.setFont(new Font("楷体", Font.BOLD | Font.ITALIC, 30));
        btnNewButton_1_1.setBounds(403, 308, 98, 40);
        frame.getContentPane().add(btnNewButton_1_1);

        passwordField = new JPasswordField();
        passwordField.setToolTipText("由6~14位字母、数字组成");
        passwordField.setBackground(new Color(245, 222, 179));
        passwordField.setFont(new Font("楷体", Font.BOLD | Font.ITALIC, 15));
        passwordField.setBounds(324, 181, 199, 36);
        frame.getContentPane().add(passwordField);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("F:\\JavaCode\\学生成绩管理系统\\images\\login\\1.png"));
        lblNewLabel_2.setBounds(176, 90, 32, 60);
        frame.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon("F:\\JavaCode\\学生成绩管理系统\\images\\login\\2.png"));
        lblNewLabel_3.setBounds(176, 181, 32, 36);
        frame.getContentPane().add(lblNewLabel_3);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("\u5B66\u751F");
        rdbtnNewRadioButton.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 20));
        rdbtnNewRadioButton.setContentAreaFilled(false);
        rdbtnNewRadioButton.setBorderPainted(false);
        rdbtnNewRadioButton.setBounds(222, 242, 77, 27);
        frame.getContentPane().add(rdbtnNewRadioButton);

        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\u7BA1\u7406\u5458");
        rdbtnNewRadioButton_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 20));
        rdbtnNewRadioButton_1.setContentAreaFilled(false);
        rdbtnNewRadioButton_1.setBorderPainted(false);
        rdbtnNewRadioButton_1.setBounds(403, 242, 91, 27);
        rdbtnNewRadioButton.setBorderPainted(false);
        rdbtnNewRadioButton.setFocusPainted(false);
        frame.getContentPane().add(rdbtnNewRadioButton_1);

        JButton btnNewButton_1 = new JButton("\u82E5\u6CA1\u6709\u8D26\u53F7,\u70B9\u51FB\u6CE8\u518C");
        btnNewButton_1.setForeground(new Color(0, 0, 153));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 20));
        btnNewButton_1.setContentAreaFilled(false);//背景
        btnNewButton_1.setBorderPainted(false);//去边框
        btnNewButton_1.setFocusPainted(false);//去外框
        btnNewButton_1.setBounds(220, 381, 244, 27);
        rdbtnNewRadioButton_1.setBorderPainted(false);
        rdbtnNewRadioButton_1.setFocusPainted(false);
        frame.getContentPane().add(btnNewButton_1);

        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon("F:\\JavaCode\\学生成绩管理系统\\images\\login\\bg.png"));
        lblNewLabel_4.setBounds(-80, 0, 771, 445);
        frame.getContentPane().add(lblNewLabel_4);
        final ButtonGroup buttonGroup = new ButtonGroup();


        // 单选框互斥
        rdbtnNewRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if(rdbtnNewRadioButton.isSelected()){
                    rdbtnNewRadioButton_1.setSelected(false);
                }
            }
        });

        rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if(rdbtnNewRadioButton_1.isSelected()){
                    rdbtnNewRadioButton.setSelected(false);
                }
            }
        });

        // 事件监听
        addActionListener(textField, passwordField,rdbtnNewRadioButton,rdbtnNewRadioButton_1,btnNewButton_1, btnNewButton, btnNewButton_1_1, frame);
    }

    public static void addActionListener(JTextField sno, JPasswordField passwd,JRadioButton stu , JRadioButton adm,
                                         JButton register, JButton login, JButton exit, Frame frame) {

        // 为按钮绑定监听器
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Sno = sno.getText();
                if ( (Sno.length() != 10) || !(Sno.matches("[0-9]+")) ) {
                    JOptionPane.showMessageDialog(null, "亲，请检查账号的合法性！", "登录信息提示", JOptionPane.WARNING_MESSAGE);
                } else {
                    String Passwd = passwd.getText();
                    if ( !Passwd.matches("([A-Za-z0-9]+){6,14}") ) {
                        JOptionPane.showMessageDialog(null, "亲，请检查密码的合法性！", "登录信息提示", JOptionPane.WARNING_MESSAGE);
                    } else {
                        if (stu.isSelected() || adm.isSelected()){
                            // 登录账号（调用静态方法）
                            int flag = DataBaseOp.loginUser(Sno,Passwd);
                            switch (flag){
                                case 1:
                                    if(adm.isSelected()){
                                        if (!DataBaseOp.isAdmin(Sno)){
                                            JOptionPane.showMessageDialog(null, "亲，你还没有管理员权限！", "登录信息提示", JOptionPane.WARNING_MESSAGE);
                                            break;
                                        }else {
                                            new Storage().setAdmin(true);
                                            new Storage().setAdm(Sno,Passwd);
                                        }
                                    }else {
                                        new Storage().setAdmin(false);
                                        new Storage().setStu(Sno,Passwd);
                                    }
                                    new Storage().setSno(Sno);
                                    new Menu().frame.setVisible(true);
                                    frame.setVisible(false);
//                                    JOptionPane.showMessageDialog(null, "亲，登录成功！", "登录信息提示",JOptionPane.INFORMATION_MESSAGE);
                                    break;
                                case 2:
                                    JOptionPane.showMessageDialog(null, "亲，账号输入有误（若无账号可以点击下方注册）！", "登录信息提示", JOptionPane.WARNING_MESSAGE);
                                    break;
                                case 3:
                                    JOptionPane.showMessageDialog(null, "亲，密码输入有误，请重新检查！", "登录信息提示", JOptionPane.WARNING_MESSAGE);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "亲，请检查是否进行了权限选择！", "登录信息提示", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Exit window = new Exit();
                window.frame.setVisible(true);
                frame.setVisible(false);
            }
        });

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Register window = new Register();
                window.frame.setVisible(true);
                frame.setVisible(false);
            }
        });
    }
}