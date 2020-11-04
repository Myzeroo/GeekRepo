package HomeWork_2_04.Chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyChat {

    private JTextArea bigTextField;
    private JTextField inputLineText;
    private JButton buttonSend;

    private JPanel panelUp;
    private JPanel panelDown;

    private JFrame mainFrame;

    public MyChat() {
        mainFrame = new JFrame("Chat");
        mainFrame.setSize(600, 400);
        mainFrame.setLocationRelativeTo(null);
        //mainFrame.setBounds(300, 200, 400, 500);
        mainFrame.setDefaultCloseOperation(3);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setMinimumSize(new Dimension(500, 400));

        bigTextField = new JTextArea();
        bigTextField.setEditable(false);
        bigTextField.setFocusable(false);
        bigTextField.setBorder(BorderFactory.createLoweredBevelBorder());
        inputLineText = new JTextField();
        buttonSend = new JButton("Отправить >>");

        panelUp = new JPanel();
        panelUp.setPreferredSize(new Dimension(550, 350));
        panelUp.setLayout(new BorderLayout());
        panelUp.add(bigTextField, BorderLayout.CENTER);

        panelDown = new JPanel();
        panelDown.setPreferredSize(new Dimension(550, 40));
        panelDown.setLayout(new BorderLayout());
        panelDown.add(inputLineText, BorderLayout.CENTER);
        panelDown.add(buttonSend, BorderLayout.EAST);

        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(panelUp, BorderLayout.CENTER);
        mainFrame.add(panelDown, BorderLayout.SOUTH);

        buttonSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String msg = "\n" + inputLineText.getText();
                bigTextField.append(msg);
                inputLineText.setText("");
            }
        });

        inputLineText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String msg = "\n" + inputLineText.getText();
                    bigTextField.append(msg);
                    inputLineText.setText("");
                }
            }
        });

        mainFrame.setVisible(true);


    }
}
