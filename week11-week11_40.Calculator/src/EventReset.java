/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
import javax.swing.*;
import java.awt.event.*;
public class EventReset extends EventSuper{
    
    public EventReset(JButton button, JTextField input, JTextField output)
    {
        super(button, input, output);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Calculator.clear();
        output.setText("0");
        updateButtonStatus();
        clear();
    }
}