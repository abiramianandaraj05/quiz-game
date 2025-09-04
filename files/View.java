import javax.swing.*;
import java.awt.*;

public class View {
    JFrame welcomeFrame = new JFrame();

    public void DisplayWelcomeScreen(){
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeFrame.setLocationRelativeTo(null);
        welcomeFrame.setSize(new Dimension(400,600));
        welcomeFrame.setTitle("The History Quiz!!");
        welcomeFrame.setResizable(false);

        // create the welcome panel
        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new BorderLayout());

        // Panel to create text of the welcome screen
        JPanel TitlePanel = new JPanel();
        TitlePanel.setLayout(new BoxLayout(TitlePanel, BoxLayout.Y_AXIS));
        JLabel welcomeLabel1 = new JLabel();
        welcomeLabel1.setText("WELCOME");
        welcomeLabel1.setFont(new Font("Verdana", Font.PLAIN, 50));
        TitlePanel.add(welcomeLabel1);
        JLabel welcomeLabel2 = new JLabel();
        welcomeLabel2.setText("TO THE ");
        welcomeLabel2.setFont(new Font("Verdana", Font.PLAIN, 50));
        TitlePanel.add(welcomeLabel2);
        JLabel welcomeLabel3 = new JLabel();
        welcomeLabel3.setText("HISTORY");
        welcomeLabel3.setFont(new Font("Verdana", Font.PLAIN, 50));
        TitlePanel.add(welcomeLabel3);
        JLabel welcomeLabel4 = new JLabel();
        welcomeLabel4.setText("QUIZ!");
        welcomeLabel4.setFont(new Font("Verdana", Font.PLAIN, 50));
        TitlePanel.add(welcomeLabel4);
        JLabel instructionLabel = new JLabel();
        instructionLabel.setText("Choose the qs style you prefer");
        instructionLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
        TitlePanel.add(instructionLabel);
        TitlePanel.setBackground(Color.cyan);
        welcomePanel.add(TitlePanel,BorderLayout.NORTH);



        // panel to add buttons
        JPanel ButtonPanel = new JPanel();
        ButtonPanel.setLayout(new GridLayout(2,2));
        JButton multichoiceButton = new JButton();
        multichoiceButton.setText("Multiple choice qs");
        ButtonPanel.add(multichoiceButton);

        JButton shortAnswerButton = new JButton();
        shortAnswerButton.setText("Short Answer qs");
        ButtonPanel.add(shortAnswerButton);

        JButton matchEndingButton = new JButton();
        matchEndingButton.setText("Match statement endings qs");
        ButtonPanel.add(matchEndingButton);

        JButton trueFalseButton = new JButton();
        trueFalseButton.setText("True or False qs");
        ButtonPanel.add(trueFalseButton);

        welcomePanel.add(ButtonPanel);

        // add panel to the frame
        welcomeFrame.getContentPane().add(welcomePanel);

        welcomeFrame.setVisible(true);
    }
}
