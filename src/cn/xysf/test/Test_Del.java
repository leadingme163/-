package cn.xysf.test;

import cn.xysf.window.Delete;

import java.awt.*;

public class Test_Del {
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Delete window = new Delete();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
