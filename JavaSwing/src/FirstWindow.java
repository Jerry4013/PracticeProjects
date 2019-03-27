import javax.swing.*;
import java.awt.*;

public class FirstWindow extends JFrame{
    public static final int WINDOW_WIDTH = 300;
    public static final int WINDOW_HEIGHT = 200;

    public FirstWindow(){
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("First Window Class");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(screenSize);
        setLocation((screenSize.width-WINDOW_WIDTH)/2, (screenSize.height - WINDOW_HEIGHT)/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton endButton = new JButton("Click to end the program.");
        endButton.addActionListener(new EndingListener());
        add(endButton);

    }



}
