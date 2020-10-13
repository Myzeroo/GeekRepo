package Lesson_08;

import javax.swing.*;
import java.awt.*;

public class MyWindow_4 extends JFrame {
    public MyWindow_4() {
        setBounds(500, 500, 500, 300);
        setTitle("BoxLayoutDemo");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton[] jbs1 = new JButton[10];
        //setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); // одну из строк надо закомментировать
        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS)); // одну из строк надо закомментировать

        for (int i = 0; i < jbs1.length; i++) {
            jbs1[i] = new JButton("#" + i);
            jbs1[i].setAlignmentX(CENTER_ALIGNMENT);
            add(jbs1[i]);
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        MyWindow_4 mw4 = new MyWindow_4();
    }
}
