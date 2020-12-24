package cn.xysf.window;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Exit{

    public JFrame frame;

    public Exit(){
        Initialize();
    }

    /**
     * Initialize the contents of the frame.
     */

    private void Initialize(){
        frame = new JFrame("退出界面");
        frame.setBounds(600, 300, 691, 466);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("\u5B66\u751F\u6210\u7EE9\u7BA1\u7406\u7CFB\u7EDF");
        lblNewLabel_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 50));
        lblNewLabel_1.setBounds(110, 101, 464, 167);
        frame.getContentPane().add(lblNewLabel_1);

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

        JLabel lblNewLabel_3 = new JLabel("\u518D");
        lblNewLabel_3.setForeground(new Color(51, 153, 255));
        lblNewLabel_3.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        lblNewLabel_3.setBounds(111, 41, 37, 34);
        frame.getContentPane().add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("\u6B21");
        lblNewLabel_4.setForeground(new Color(204, 51, 255));
        lblNewLabel_4.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        lblNewLabel_4.setBounds(162, 29, 37, 43);
        frame.getContentPane().add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("\u4F7F");
        lblNewLabel_5.setForeground(Color.RED);
        lblNewLabel_5.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        lblNewLabel_5.setBounds(213, 29, 43, 59);
        frame.getContentPane().add(lblNewLabel_5);

        JLabel lblNewLabel_2_1 = new JLabel("\u7528");
        lblNewLabel_2_1.setForeground(new Color(255, 102, 51));
        lblNewLabel_2_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
        lblNewLabel_2_1.setBounds(270, 29, 43, 35);
        frame.getContentPane().add(lblNewLabel_2_1);

        JLabel lblNewLabel_6 = new JLabel("");
        lblNewLabel_6.setIcon(new ImageIcon("F:\\JavaCode\\学生成绩管理系统\\images\\enter\\bg.png"));//背景
        lblNewLabel_6.setBounds(0, 0, 690, 450);
        frame.getContentPane().add(lblNewLabel_6);

        JTextField textField = new JTextField();
        textField.setBorder(null);
        textField.setOpaque(false);
        textField.setBounds(361, 82, 86, 24);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        addActionListener(textField, frame);
    }

    public static void addActionListener(JTextField exit, JFrame frame){
        exit.addFocusListener(new FocusListener() {
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

            }
        });
    }
}
