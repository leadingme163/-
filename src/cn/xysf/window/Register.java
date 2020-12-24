package cn.xysf.window;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import cn.xysf.db.DataBaseOp;

public class Register extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JLabel lblNewLabel_1;
    private JPasswordField passwordField;
    public JFrame frame;

    /**
     * Create the frame.
     */
    public Register() {

        frame = new JFrame("注册界面");
        frame.setBounds(600, 300, 691, 466);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(244, 164, 96));
        contentPane.setForeground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.getContentPane().add(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("\u8D26\u53F7: ");
        lblNewLabel.setFont(new Font("楷体", Font.BOLD | Font.ITALIC, 30));
        lblNewLabel.setForeground(Color.DARK_GRAY);
        lblNewLabel.setBounds(222, 90, 98, 60);
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

        JButton btnNewButton = new JButton("\u6CE8\u518C");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnNewButton.setBackground(Color.LIGHT_GRAY);
        btnNewButton.setFont(new Font("楷体", Font.BOLD | Font.ITALIC, 30));
        btnNewButton.setForeground(Color.RED);
        btnNewButton.setBounds(207, 273, 113, 40);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1_1 = new JButton("返回");
        btnNewButton_1_1.setBackground(Color.LIGHT_GRAY);
        btnNewButton_1_1.setForeground(Color.RED);
        btnNewButton_1_1.setFont(new Font("楷体", Font.BOLD | Font.ITALIC, 30));
        btnNewButton_1_1.setBounds(391, 273, 113, 40);
        frame.getContentPane().add(btnNewButton_1_1);

        passwordField = new JPasswordField();
        passwordField.setToolTipText("由6~14位字母、数字组成");
        passwordField.setBackground(new Color(245, 222, 179));
        passwordField.setFont(new Font("楷体", Font.BOLD | Font.ITALIC, 15));
        passwordField.setBounds(324, 181, 199, 36);
        frame.getContentPane().add(passwordField);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("F:\\JavaCode\\学生成绩管理系统\\images\\register\\1.png"));
        lblNewLabel_2.setBounds(176, 90, 32, 60);
        frame.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon("F:\\JavaCode\\学生成绩管理系统\\images\\register\\2.png"));
        lblNewLabel_3.setBounds(176, 181, 32, 36);
        frame.getContentPane().add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon("F:\\JavaCode\\学生成绩管理系统\\images\\register\\bg.jpg"));
        lblNewLabel_4.setBounds(-53, 0, 769, 501);
        frame.getContentPane().add(lblNewLabel_4);
        final ButtonGroup buttonGroup = new ButtonGroup();

        addActionListener(textField,passwordField,btnNewButton,btnNewButton_1_1,frame);
    }

    public static void addActionListener(JTextField sno, JPasswordField passwd, JButton signIn, JButton exit, Frame frame){
        // 为按钮绑定监听器
        signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Sno = sno.getText();
                if((Sno.length() != 10) || !(Sno.matches("[0-9]+"))){
                    JOptionPane.showMessageDialog(null, "亲，请检查账号的合法性！", "注册信息提示",JOptionPane.WARNING_MESSAGE);
                }else{
                    String Passwd = passwd.getText();
                    if(!Passwd.matches("([A-Za-z0-9]+){6,14}")){
                        JOptionPane.showMessageDialog(null, "亲，请检查密码的合法性！", "注册信息提示",JOptionPane.WARNING_MESSAGE);
                    }else {
                        // 注册账号（调用静态方法）
                        if(DataBaseOp.snoExist(Sno)){
                            JOptionPane.showMessageDialog(null, "亲，该用户已经被注册！", "注册信息提示",JOptionPane.WARNING_MESSAGE);
                        }else{
                            DataBaseOp.addUser(Sno,Passwd);
                            JOptionPane.showMessageDialog(null, "恭喜，注册成功！", "注册信息提示",JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
            }
        });

        // 为按钮绑定监听器
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                Login window = new Login();
                window.frame.setVisible(true);
            }
        });
    }
}
