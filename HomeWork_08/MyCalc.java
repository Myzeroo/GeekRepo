package HomeWork_08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MyCalc {
    private JFrame mainFarame;

    public MyCalc(){
        mainFarame = new JFrame();

        mainFarame.setBounds(200,200,300,500);
        mainFarame.setTitle("Calc");
        mainFarame.setDefaultCloseOperation(3);
        mainFarame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        mainFarame.add(topPanel, BorderLayout.NORTH);

        JTextField output = new JTextField();
        output.setEditable(false);
        topPanel.add(output, BorderLayout.CENTER); /* check NORTH */

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(5,3));
        mainFarame.add(centerPanel, BorderLayout.CENTER);

        ActionListener abListener = new ActionButtonListener(output);
        for (int i = 0; i <= 9; i++) {
            JButton digitBtn = new JButton(String.valueOf(i));
            centerPanel.add(digitBtn);
            digitBtn.addActionListener(abListener);
        }

        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new GridLayout(5,1));
        mainFarame.add(eastPanel, BorderLayout.EAST);


        JButton plusBtn = new JButton("+");
        plusBtn.addActionListener(abListener);
        eastPanel.add(plusBtn);

        JButton minusBtn = new JButton("-");
        minusBtn.addActionListener(abListener);
        eastPanel.add(minusBtn);

        JButton timesBtn = new JButton("*");
        timesBtn.addActionListener(abListener);
        eastPanel.add(timesBtn);

        JButton dividedBtn = new JButton("/");
        dividedBtn.addActionListener(abListener);
        eastPanel.add(dividedBtn);



        JButton cancelBtn = new JButton("C");
        cancelBtn.addActionListener(abListener);
        centerPanel.add(cancelBtn);

        JButton submitBtn = new JButton("Submit");
        submitBtn.addActionListener(abListener);
        centerPanel.add(submitBtn);

        mainFarame.setVisible(true);
    }

}
