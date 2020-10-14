package HomeWork_08;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionButtonListener implements ActionListener {
    private JTextField output;
    private StringBuilder strBld ;

    ActionButtonListener(JTextField output){
        this.output = output;
        this.strBld = new StringBuilder();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        String textBtn = btn.getText();
        String textOutput = output.getText();

        if(textBtn == "C"){
            output.setText("");
            return;
        }

        if(textBtn == "Submit"){
            textOutput = Сalculate.getResult(textOutput);
            output.setText(textOutput);
            return;
        }

        if(textBtn == "+" || textBtn == "-"){
            if(textOutput.endsWith("+") || textOutput.endsWith("-")) return;
            if(textOutput.length()==0) return;
        }

        if(textBtn.charAt(0)> 42 && textBtn.charAt(0) < 58) {
            String val = strBld.append(output.getText()).append(textBtn).toString();
            output.setText(val);
            strBld.setLength(0);
        }
    }
}
