package Lesson_08;

import javax.swing.*;
import java.awt.*;

public class MyWindow_3 extends JFrame {
    MyWindow_3(){
        setTitle("NAME");
        setDefaultCloseOperation(3);
        setBounds(300,300,400,500);

        JButton button = new JButton("Button 1 (PAGE_START)");
        add(button, BorderLayout.PAGE_START);
        button = new JButton("Button 2 (CENTER)");
        button.setPreferredSize(new Dimension(200, 100));
        add(button, BorderLayout.CENTER);
        button = new JButton("Button 3 (LINE_START)");
        add(button, BorderLayout.LINE_START);
        button = new JButton("Long-Named Button 4 (PAGE_END)");
        add(button, BorderLayout.PAGE_END);
        button = new JButton("5 (LINE_END)");
        add(button, BorderLayout.LINE_END);
        setVisible(true);
    }

    public static void main(String[] args) {
        MyWindow_3 mw3 = new MyWindow_3();
    }
}
