import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    public static final int WIDTH = 400;
    public static final int HEIGHT = 200;
    public static final int NUMBER_OF_DIGITS = 30;

    private JTextField ioField;
    private double result = 0.0;

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setVisible(true);
    }

    public Calculator(){
        setTitle("Simplified Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width-WIDTH)/2, (screenSize.height - HEIGHT)/2);
        setSize(WIDTH, HEIGHT);
        setLayout(new BorderLayout());

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new FlowLayout());
        ioField = new JTextField("Enter numbers here.", NUMBER_OF_DIGITS);
        ioField.setBackground(Color.WHITE);
        textPanel.add(ioField);
        add(textPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLUE);
        buttonPanel.setLayout(new FlowLayout());

        JButton addButton = new JButton("+");
        addButton.addActionListener(this);
        buttonPanel.add(addButton);

        JButton subtractButton = new JButton("-");
        subtractButton.addActionListener(this);
        buttonPanel.add(subtractButton);

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(this);
        buttonPanel.add(resetButton);

        add(buttonPanel, BorderLayout.CENTER);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            assumingCorrectNumberFormats(e);
        }catch (NumberFormatException e1){
            ioField.setText("Error: Reenter Number");
        }
    }

    public void assumingCorrectNumberFormats(ActionEvent e){
        String actionCommand = e.getActionCommand();

        if(actionCommand.equals("+")){
            result += stringToDouble(ioField.getText());
            ioField.setText(Double.toString(result));
        }else if(actionCommand.equals("-")){
            result -= stringToDouble(ioField.getText());
            ioField.setText(Double.toString(result));
        }else if (actionCommand.equals("Reset")){
            result = 0.0;
            ioField.setText("0.0");
        }else
            ioField.setText("Unexpected Error");
    }

    private static double stringToDouble(String object){
        return Double.parseDouble(object.trim());
    }
}
