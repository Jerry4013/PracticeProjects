
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeUI extends JFrame {

    TicTacToeService ticTacToeService = new TicTacToeService();

    public static final int WIDTH = 210;
    public static final int HEIGHT = 300;
    public static final int RESULT_HEIGHT = 45;
    public static final int CLEAR_HEIGHT = 45;
    private JPanel result = new JPanel();
    private JPanel checker = new JPanel();
    private JPanel clear = new JPanel();
    private boolean circleRound = true;
    private final JButton clearButton;
    private JButton[] buttons = new JButton[9];
    private JLabel label = new JLabel("");
    private playListener[] playListeners = new playListener[9];

    public class clearListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ticTacToeService.clear();
            displayChecker();
            label.setText("");
            for (int k = 0; k < 9; k++) {
                buttons[k].removeActionListener(playListeners[k]);
                buttons[k].addActionListener(playListeners[k]);
            }
            if(circleRound==false)
                circleRound = true;
        }
    }
    public class playListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int i = Integer.parseInt(e.getActionCommand())/3;
            int j = Integer.parseInt(e.getActionCommand())%3;
            if(circleRound){
                ticTacToeService.toCircle(new Point(i,j));
            }else
                ticTacToeService.toCross(new Point(i,j));
            circleRound = !circleRound;
            displayChecker();
            if(ticTacToeService.getResult()==1){
                label.setText("Circle Wins! 儿童节快乐！");
                label.setForeground(Color.GREEN);
                for (int k = 0; k < 9; k++) {
                    buttons[k].removeActionListener(playListeners[k]);
                }
            }else if(ticTacToeService.getResult()==2){
                label.setText("Cross Wins! 儿童节快乐！");
                label.setForeground(Color.GREEN);
                for (int k = 0; k < 9; k++) {
                    buttons[k].removeActionListener(playListeners[k]);
                }
            }
        }
    }

    public TicTacToeUI(){
        super("Tic Tac Toe");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        setResizable(false);
        setLayout(new BorderLayout());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width-WIDTH)/2, (screenSize.height - HEIGHT)/2);

        result.setPreferredSize(new Dimension(WIDTH, RESULT_HEIGHT));
        result.setBackground(Color.WHITE);
        result.add(label);
        add(result, BorderLayout.NORTH);

        checker.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].setActionCommand(String.valueOf(i));
            playListeners[i] = new playListener();
            buttons[i].addActionListener(playListeners[i]);

            int[][] temp = ticTacToeService.get();
            if(temp[i/3][i%3]==1){
                buttons[i].setText("O");
            }else if(temp[i/3][i%3]==2)
                buttons[i].setText("X");
            checker.add(buttons[i]);
        }
        add(checker, BorderLayout.CENTER);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(new clearListener());
        clear.setLayout(new FlowLayout());
        clear.setPreferredSize(new Dimension(WIDTH, CLEAR_HEIGHT));
        clear.add(clearButton);
        add(clear, BorderLayout.SOUTH);
    }

    private void displayChecker(){
        for (int i = 0; i < 9; i++) {
            int[][] temp = ticTacToeService.get();
            if(temp[i/3][i%3]==1){
                buttons[i].setText("O");
            }else if(temp[i/3][i%3]==2)
                buttons[i].setText("X");
            else
                buttons[i].setText("");
        }
    }

    public static void main(String[] args) {
        TicTacToeUI ticTacToeUI = new TicTacToeUI();
        ticTacToeUI.setVisible(true);
    }

}
