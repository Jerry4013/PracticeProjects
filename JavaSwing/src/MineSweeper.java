import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class MineSweeper extends JFrame {
    public static final int WIDTH = 200;
    public static final int HEIGHT = 300;
    public static final int ROWS = 8;
    public static final int COLS = 8;
    public static final int SMILE_SQUARE = 30;

    public MineSweeper(){
        super("Minesweeper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width-WIDTH)/2, (screenSize.height - HEIGHT)/2);
        setResizable(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel upperPanel = new JPanel();
        upperPanel.setLayout(new BorderLayout());
        upperPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT/7));
        upperPanel.setBackground(Color.LIGHT_GRAY);

        JPanel timer = new JPanel();
        timer.setPreferredSize(new Dimension(WIDTH/3,upperPanel.getHeight()));
        upperPanel.add(timer, BorderLayout.WEST);

        JPanel counter = new JPanel();
        counter.setPreferredSize(new Dimension(WIDTH/3,upperPanel.getHeight()));
        upperPanel.add(counter, BorderLayout.EAST);

        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new FlowLayout());

        JButton smileButton = new JButton();
        smileButton.setPreferredSize(new Dimension(SMILE_SQUARE,SMILE_SQUARE));
        smileButton.setSize(SMILE_SQUARE, SMILE_SQUARE);
        smileButton.setContentAreaFilled(false);
        smileButton.setBackground(Color.WHITE);
        ImageIcon smileIcon = new ImageIcon("image/Smile (1).png");
        Image temp = smileIcon.getImage().getScaledInstance(smileButton.getWidth(),
                smileButton.getHeight(), smileIcon.getImage().SCALE_DEFAULT);
        smileIcon = new ImageIcon(temp);
        smileButton.setIcon(smileIcon);
        statusPanel.add(smileButton);

        upperPanel.add(statusPanel, BorderLayout.CENTER);

        mainPanel.add(upperPanel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(ROWS, COLS));

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                JButton button = new JButton();
                bottomPanel.add(button);
            }
        }
        mainPanel.add(bottomPanel, BorderLayout.CENTER);
        add(mainPanel);
    }

    public static void main(String[] args) {
        MineSweeper mineSweeper = new MineSweeper();
        mineSweeper.setVisible(true);
    }

}
