import javax.swing.*;
import java.awt.*;

public class BorderLayoutJFrame extends JFrame {

    public static final int WIDTH = 500;
    public static final int HEIGHT = 400;

    public BorderLayoutJFrame() {
        super("BorderLayout Demonstration");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel jPanel = new JPanel();
        jPanel.setPreferredSize(new Dimension(500,100));
        jPanel.setBackground(Color.red);
        jPanel.setLayout(new BorderLayout());
        JLabel label1 = new JLabel("First");
        jPanel.add(label1);
        add(jPanel,BorderLayout.NORTH);

        JLabel label2 = new JLabel("Second");
        add(label2, BorderLayout.SOUTH);

        JLabel label3 = new JLabel("Third");
        add(label3, BorderLayout.CENTER);

        JLabel label4 = new JLabel("Fourth");
        add(label4, BorderLayout.EAST);

        JLabel label5 = new JLabel("Fifth");
        add(label5, BorderLayout.WEST);


    }

    public static void main(String[] args) {
        BorderLayoutJFrame borderLayoutJFrame = new BorderLayoutJFrame();
        borderLayoutJFrame.setVisible(true);
    }
}
