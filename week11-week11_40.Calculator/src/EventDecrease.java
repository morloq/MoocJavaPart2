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
public class EventDecrease extends EventSuper{
    
    public EventDecrease(JButton button, JTextField input, JTextField output)
    {
        super(button, input, output);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        UpdateValue();
        updateButtonStatus();
        clear();
    }
    
    public void UpdateValue()
    {
        try{
            if(isInputInteger())
            {
                Calculator.subtract(Integer.parseInt(this.input.getText()));
                this.output.setText(String.valueOf(Calculator.getCurrentValue()));
            }
            else
                clear();
        }
        catch(Exception e)
        {
            clear();
        }
    }
}