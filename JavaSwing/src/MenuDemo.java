import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuDemo extends JFrame implements ActionListener {

    public static void main(String[] args) {
        MenuDemo menuDemo = new MenuDemo();
        menuDemo.setVisible(true);
    }


    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;

    private JPanel bluePanel;
    private JPanel whitePanel;
    private JPanel grayPanel;

    public MenuDemo(){
        super("Menu Demo");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1,3));

        bluePanel = new JPanel();
        bluePanel.setBackground(Color.LIGHT_GRAY);
        add(bluePanel);

        whitePanel = new JPanel();
        whitePanel.setBackground(Color.LIGHT_GRAY);
        add(whitePanel);

        grayPanel = new JPanel();
        grayPanel.setBackground(Color.LIGHT_GRAY);
        add(grayPanel);

        JMenu add_colors = new JMenu("Add Colors");

        JMenuItem blue = new JMenuItem("Blue");
        blue.addActionListener(this);
        add_colors.add(blue);

        JMenuItem white = new JMenuItem("White");
        white.addActionListener(this);
        add_colors.add(white);

        JMenuItem gray = new JMenuItem("Gray");
        gray.addActionListener(this);
        add_colors.add(gray);

        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.add(add_colors);
        setJMenuBar(jMenuBar);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        if(actionCommand.equals("Blue")){
            bluePanel.setBackground(Color.BLUE);
        }else if(actionCommand.equals("White")){
            whitePanel.setBackground(Color.WHITE);
        }else if(actionCommand.equals("Gray")){
            grayPanel.setBackground(Color.GRAY);
        }else
            System.out.println("Error");
    }


}
