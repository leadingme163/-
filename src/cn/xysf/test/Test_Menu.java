package cn.xysf.test;

import cn.xysf.window.Menu;

import java.awt.*;
import cn.xysf.window.*;

public class Test_Menu {
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Menu window = new Menu();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
