import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelDemo extends JFrame implements ActionListener {
    private JPanel bluePanel;
    private JPanel whitePanel;
    private JPanel grayPanel;

    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;

    public static void main(String[] args) {
        PanelDemo panelDemo = new PanelDemo();
        panelDemo.setVisible(true);
    }

    public PanelDemo(){
        super("Change Color");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel biggerPanel = new JPanel();
        biggerPanel.setLayout(new GridLayout(1, 3));

        bluePanel = new JPanel();
        bluePanel.setBackground(Color.LIGHT_GRAY);
        biggerPanel.add(bluePanel);

        whitePanel = new JPanel();
        whitePanel.setBackground(Color.LIGHT_GRAY);
        biggerPanel.add(whitePanel);

        grayPanel = new JPanel();
        grayPanel.setBackground(Color.LIGHT_GRAY);
        biggerPanel.add(grayPanel);

        add(biggerPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        buttonPanel.setLayout(new FlowLayout());

        JButton blueButton = new JButton("Blue");
        blueButton.setBackground(Color.BLUE);
        blueButton.addActionListener(this);
        buttonPanel.add(blueButton);

        JButton whiteButton = new JButton("White");
        whiteButton.setBackground(Color.WHITE);
        whiteButton.addActionListener(this);
        buttonPanel.add(whiteButton);

        JButton grayButton = new JButton("Gray");
        grayButton.setBackground(Color.GRAY);
        grayButton.addActionListener(this);
        buttonPanel.add(grayButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonString = e.getActionCommand();

        if(buttonString.equals("Blue")){
            bluePanel.setBackground(Color.BLUE);
        }else if(buttonString.equals("White")){
            whitePanel.setBackground(Color.WHITE);
        }else if (buttonString.equals("Gray")){
            grayPanel.setBackground(Color.GRAY);
        }else
            System.out.println("Error");
    }
}
