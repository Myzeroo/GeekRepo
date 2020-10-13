package Lesson_08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow_5 extends JFrame {
    public MyWindow_5() {
        setBounds(500, 500, 500, 300);
        setTitle("BoxLayoutDemo");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JTextField field = new JTextField();
        add(field);

        JButton[] jbs = new JButton[10];
        setLayout(new GridLayout(4, 3));
        for (int i = 0; i < jbs.length; i++) {
            jbs[i] = new JButton("@" + i);
            add(jbs[i]);
        }
//Поэтому нет необходимости отслеживать именно нажатие кнопки Enter, например, через addKeyListener(…), с указанием кода этой клавиши.
        JButton btnC = new JButton("C");
        add(btnC);
        btnC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText("Push the button");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        MyWindow_5 mw5 = new MyWindow_5();
    }
}
