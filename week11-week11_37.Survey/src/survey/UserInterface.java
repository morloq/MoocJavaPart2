package survey;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        // Create your app here
        frame = new JFrame("");
        frame.setPreferredSize(new Dimension(400,600));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponents(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public void createComponents(Container container)
    {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);

        container.add(new JLabel("Are you?"));
        
        JCheckBox yes = new JCheckBox("Yes!");
        JCheckBox no = new JCheckBox("No!");
        
        ButtonGroup buttonGroup = new ButtonGroup();
        
        buttonGroup.add(yes);
        buttonGroup.add(no);
        
        container.add(yes);
        container.add(no);
        
        container.add(new JLabel("Why?"));
        
        JRadioButton reason = new JRadioButton("No reason.");
        JRadioButton fun = new JRadioButton("Because it is fun!");
        
        ButtonGroup buttonGroup2 = new ButtonGroup();
        
        buttonGroup2.add(reason);
        buttonGroup2.add(fun);
        
        container.add(reason);
        container.add(fun);
        
        container.add(new JButton ("Done!"), BorderLayout.WEST);
        
        
    }

    public JFrame getFrame() {
        return frame;
    }
}