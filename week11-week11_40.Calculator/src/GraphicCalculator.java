
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GraphicCalculator implements Runnable{
    private JFrame frame;
    private JButton add;
    private JButton subtract;
    private JButton z;
    private JTextField input;
    private JTextField output;
    
    @Override
    public void run() {
        this. frame = new JFrame("Calculator");
        GridLayout layout = new GridLayout(3,1);
        frame.setLayout(layout);
        
        frame.setPreferredSize(new Dimension(300, 150));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
       JPanel panel = createPanel();
       initializeComponents();
       setInitialState();
       setEvents();
       addComponents(container);
       container.add(panel);
    }
    
    public void initializeComponents()
    {
        this.output = new JTextField("0");
        
        this.input = new JTextField("");
    }
    
    public void addComponents(Container container)
    {
        container.add(this.output);
        container.add(this.input);
    }
    
    public void setEvents()
    {
        add.addActionListener(new EventIncrease(this.z, this.input, this.output));
        subtract.addActionListener(new EventDecrease(this.z, this.input, this.output));
        z.addActionListener(new EventReset(this.z, this.input, this.output));
    }
    
    public void setInitialState()
    {
        this.z.setEnabled(false);
        this.output.setEnabled(false);
    }
    
    public JPanel createPanel()
    {
        JPanel panel = new JPanel(new GridLayout(1,3));
        this.add = new JButton("+");
        this.subtract = new JButton("-");
        this.z = new JButton("Z");
        
        panel.add(add);
        panel.add(subtract);
        panel.add(z);
        
        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
}