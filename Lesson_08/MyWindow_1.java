package Lesson_08;

import javax.swing.*;

class MyWindow_1 extends JFrame {
    MyWindow_1(){
        setTitle("Set title text");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100,200,300,400);
        setVisible(true);
    }
}

class Test{
    public static void main(String[] args) {
        MyWindow_1 mw1 = new MyWindow_1();
    }
}
