package cn.xysf.test;

import cn.xysf.window.RateQuery;

import java.awt.*;

public class Test_Rate {
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RateQuery window = new RateQuery();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
