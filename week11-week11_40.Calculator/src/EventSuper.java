
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
abstract public class EventSuper implements ActionListener{
    
    protected JButton button;
    protected JTextField input;
    protected JTextField output;
    
    public EventSuper(JButton button, JTextField input, JTextField output)
    {
        this.button = button;
        this.input = input;
        this.output = output;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){}
    
    public boolean isOutputZero()
    {
        return Integer.parseInt(this.output.getText()) == 0;
    }
    
    public boolean isInputEmpty()
    {
        return this.input.getText().isEmpty();
    }
    
    public boolean isInputInteger()
    {
        int i = Integer.parseInt(this.input.getText());
        return i == (int) i;
    }
    
    public void clear()
    {
        this.input.setText("");
    }
    
    public void setZero()
    {
        this.output.setText("0");
    }
    
    public void updateButtonStatus()
    {
        button.setEnabled(!isOutputZero());
    }
}