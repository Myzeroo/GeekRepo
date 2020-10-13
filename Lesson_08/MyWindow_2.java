package Lesson_08;

import javax.swing.*;
import java.awt.*;

public class MyWindow_2 extends JFrame{
    MyWindow_2(){
        setTitle("Set title text");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100,200,300,400);

        JButton[] arrButts = new JButton[5];

        for (int i = 0; i < 5; i++) {
            arrButts[i] = new JButton("#" + i);
        }

        BorderLayout BL = new BorderLayout();
        this.setLayout(BL);
        add(arrButts[0], BL.EAST);
        add(arrButts[1], BL.WEST);
        add(arrButts[2], BL.SOUTH);
        add(arrButts[3], BL.NORTH);
        add(arrButts[4], BL.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        MyWindow_2 mw1 = new MyWindow_2();
    }
}