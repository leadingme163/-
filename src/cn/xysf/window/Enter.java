package cn.xysf.window;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Enter {
    public JFrame frame;
    /**
     * Create the application.
     */
    public Enter() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("欢迎界面");
        frame.setBounds(600, 300, 691, 466);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("学生成绩管理系统");
        lblNewLabel_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 50));
        lblNewLabel_1.setBounds(110, 116, 700, 167);
        frame.getContentPane().add(lblNewLabel_1);

        JButton btnNewButton = new JButton("\u70B9\u51FB\u8FDB\u5165");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 绑定事件
                frame.setVisible(false);
                Login window = new Login();
                window.frame.setVisible(true);
            }
        });
        btnNewButton.setContentAreaFilled(false);
        btnNewButton.setIcon(new ImageIcon("F:\\JavaCode\\学生成绩管理系统\\images\\enter\\jt.png"));
        btnNewButton.setFont(new Font("楷体", Font.BOLD | Font.ITALIC, 30));
        btnNewButton.setBounds(176, 281, 243, 43);
        btnNewButton.setBorderPainted(false);
        btnNewButton.setFocusPainted(false);
        frame.getContentPane().add(btnNewButton);

        JLabel lblNewLabel = new JLabel("\u6B22");
        lblNewLabel.setForeground(new Color(255, 0, 0));
        lblNewLabel.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        lblNewLabel.setBounds(24, 29, 43, 59);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_2 = new JLabel("\u8FCE");
        lblNewLabel_2.setForeground(new Color(255, 102, 51));
        lblNewLabel_2.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        lblNewLabel_2.setBounds(68, 29, 43, 35);
        frame.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("\u6765");
        lblNewLabel_3.setForeground(new Color(51, 153, 255));
        lblNewLabel_3.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        lblNewLabel_3.setBounds(111, 41, 37, 34);
        frame.getContentPane().add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("\u5230");
        lblNewLabel_4.setForeground(new Color(204, 51, 255));
        lblNewLabel_4.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        lblNewLabel_4.setBounds(162, 29, 37, 43);
        frame.getContentPane().add(lblNewLabel_4);

        JLabel lblNewLabel_7 = new JLabel("");
        lblNewLabel_7.setIcon(new ImageIcon("F:\\JavaCode\\学生成绩管理系统\\images\\enter\\5.png"));
        lblNewLabel_7.setBounds(310, 116, 32, 33);
        frame.getContentPane().add(lblNewLabel_7);

        JLabel lblNewLabel_7_1 = new JLabel("");
        lblNewLabel_7_1.setIcon(new ImageIcon("F:\\JavaCode\\学生成绩管理系统\\images\\enter\\6.png"));
        lblNewLabel_7_1.setBounds(353, 116, 37, 33);
        frame.getContentPane().add(lblNewLabel_7_1);

        JLabel lblNewLabel_7_2 = new JLabel("");
        lblNewLabel_7_2.setIcon(new ImageIcon("F:\\JavaCode\\学生成绩管理系统\\images\\enter\\4.png"));
        lblNewLabel_7_2.setBounds(261, 116, 37, 33);
        frame.getContentPane().add(lblNewLabel_7_2);

        JLabel lblNewLabel_7_2_1 = new JLabel("");
        lblNewLabel_7_2_1.setIcon(new ImageIcon("F:\\JavaCode\\学生成绩管理系统\\images\\enter\\4.png"));
        lblNewLabel_7_2_1.setBounds(107, 116, 37, 33);
        frame.getContentPane().add(lblNewLabel_7_2_1);

        JLabel lblNewLabel_7_2_2 = new JLabel("");
        lblNewLabel_7_2_2.setIcon(new ImageIcon("F:\\JavaCode\\学生成绩管理系统\\images\\enter\\5.png"));
        lblNewLabel_7_2_2.setBounds(158, 116, 37, 33);
        frame.getContentPane().add(lblNewLabel_7_2_2);

        JLabel lblNewLabel_7_2_2_1 = new JLabel("");
        lblNewLabel_7_2_2_1.setIcon(new ImageIcon("F:\\JavaCode\\学生成绩管理系统\\images\\enter\\6.png"));
        lblNewLabel_7_2_2_1.setBounds(209, 116, 37, 33);
        frame.getContentPane().add(lblNewLabel_7_2_2_1);

        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setIcon(new ImageIcon("F:\\JavaCode\\学生成绩管理系统\\images\\enter\\bg.png"));
        lblNewLabel_5.setBounds(-37, -114, 722, 543);
        frame.getContentPane().add(lblNewLabel_5);

        addActionListener(lblNewLabel_5, frame);
    }

    public static void addActionListener(JLabel bg, JFrame frame){
        bg.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                frame.dispose();
            }

            @Override
            public void focusLost(FocusEvent e) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                frame.dispose();
            }
        });
    }
}
