package HomeWork_08;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;


public class ActionButtonListener implements ActionListener  {
    private JTextField output;
    private StringBuilder strBld ;

    ActionButtonListener(JTextField output){
        this.output = output;
        this.strBld = new StringBuilder();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        if(btn.getText() == "C") {
            output.setText("");
            return;
        }

        if(btn.getText() == "Submit"){
            String str = ParseExpression.getResult(output.getText());
            output.setText(str) ;
            return;
        }

        String val = strBld.append(output.getText()).append(btn.getText()).toString();
        output.setText(val);
        strBld.setLength(0);
    }
}
