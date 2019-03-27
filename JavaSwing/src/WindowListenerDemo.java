import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class WindowListenerDemo extends JFrame implements WindowListener{

    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;
    public static final int SMALL_WIDTH = 200;
    public static final int SMALL_HEIGHT = 100;

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        ConfirmWindow confirmWindow = new ConfirmWindow();
        confirmWindow.setVisible(true);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    public class ConfirmWindow extends JFrame implements ActionListener{

        public ConfirmWindow(){
            setSize(SMALL_WIDTH, SMALL_HEIGHT);
            getContentPane().setBackground(Color.YELLOW);
            setLayout(new BorderLayout());

            JLabel confirmLabel = new JLabel("Are you sure you want to exit?");
            add(confirmLabel, BorderLayout.CENTER);

            JPanel buttonPanel = new JPanel();
            buttonPanel.setBackground(Color.ORANGE);
            buttonPanel.setLayout(new FlowLayout());

            JButton exitButton = new JButton("Yes");
            exitButton.addActionListener(this);
            buttonPanel.add(exitButton);

            JButton cancelButton = new JButton("No");
            cancelButton.addActionListener(this);
            buttonPanel.add(cancelButton);

            add(buttonPanel, BorderLayout.SOUTH);

        }
        @Override
        public void actionPerformed(ActionEvent e) {
            String actionCommand = e.getActionCommand();

            if(actionCommand.equals("Yes")){
                System.exit(0);
            }else if(actionCommand.equals("No")){
                dispose();
            }else
                System.out.println("Unexpected Error in Confirm Window.");
        }
    }

    public static void main(String[] args) {
        WindowListenerDemo windowListenerDemo = new WindowListenerDemo();
        windowListenerDemo.setVisible(true);
    }

    public WindowListenerDemo(){
        setSize(WIDTH, HEIGHT);
        setTitle("Window Listener Demonstration");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(this);

        getContentPane().setBackground(Color.LIGHT_GRAY);
        JLabel label = new JLabel("I like to be sure you are sincere.");
        add(label);
    }
}
