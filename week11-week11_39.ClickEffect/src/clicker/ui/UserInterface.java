 package clicker.ui;

import clicker.applicationlogic.Calculator;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class UserInterface implements Runnable {
    private JFrame frame;
    private Calculator calculator;

    public UserInterface(Calculator calculator)
    {
        this.calculator = calculator;
    }
    
    @Override
    public void run() {
        frame = new JFrame("Click Effect");
        frame.setPreferredSize(new Dimension(200, 100));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        
        GridLayout layout = new GridLayout(2,1);
        container.setLayout(layout);
        JLabel label = new JLabel(String.valueOf(calculator.giveValue()));//0
        
        JButton button = new JButton("Click!");
        
        //add event
        
        ClickListener clicker = new ClickListener(this.calculator, label);
        button.addActionListener(clicker);
        
        container.add(label);
        container.add(button);
    }

    public JFrame getFrame() {
        return frame;
    }
}
