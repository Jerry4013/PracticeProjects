import javax.swing.*;
import java.awt.*;

public class ColoredWindow extends JFrame {
    public static final int WINDOW_WIDTH = 300;
    public static final int WINDOW_HEIGHT = 200;

    public ColoredWindow(Color theColor){
        super("No Charge for Color");
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(theColor);
        JLabel label = new JLabel("Close Window");
        add(label);
    }

    public ColoredWindow(){
        this(Color.BLUE);
    }


}
