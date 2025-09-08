import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class View {
    JFrame gameFrame = new JFrame();
    Model gameModel;
    JPanel gamePanel = new JPanel();
    //JPanel buttonPanel = new JPanel();
    JPanel displayPanel = new JPanel();
    List<ButtonGroup> buttonGroups = new ArrayList<>();

    public void setModel(Model model){
        gameModel = model;
    }
    public void DisplayWelcomeScreen(){
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setSize(new Dimension(400,600));
        gameFrame.setTitle("The History Quiz!!");
        //gameFrame.setResizable(false);

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
        ButtonPanel.setLayout(new GridLayout(3,1));
        JButton multichoiceButton = new JButton();
        multichoiceButton.setText("Multiple choice qs");
        ButtonPanel.add(multichoiceButton);
        multichoiceButton.addActionListener(e ->{
            clearScreen();
            gameModel.multiple();
        } );
        JButton shortAnswerButton = new JButton();
        shortAnswerButton.setText("Short Answer qs");
        ButtonPanel.add(shortAnswerButton);
        shortAnswerButton.addActionListener(e -> {
            clearScreen();
            gameModel.shortAnswer();
        });

        JButton trueFalseButton = new JButton();
        trueFalseButton.setText("True or False qs");
        ButtonPanel.add(trueFalseButton);
        trueFalseButton.addActionListener(e -> {
            clearScreen();
            gameModel.trueFalse();
        });

        welcomePanel.add(ButtonPanel);

        // add panel to the frame
        gameFrame.getContentPane().add(welcomePanel);

        gameFrame.setVisible(true);
    }

    public void clearScreen(){
        gameFrame.getContentPane().removeAll();
        gameFrame.repaint();

    }


    public void setGameUp(String text){
        JPanel qsStyleName = new JPanel();
        gamePanel.setLayout(new BorderLayout());

        JLabel heading = new JLabel(text);
        heading.setFont(new Font("Verdana", Font.BOLD, 40));
        qsStyleName.add(heading);
        gamePanel.add(qsStyleName, BorderLayout.NORTH);
        gamePanel.add(displayPanel,BorderLayout.CENTER);
        displayPanel.setLayout(new BoxLayout(displayPanel,BoxLayout.Y_AXIS));
        gamePanel.setBackground(Color.CYAN);
        gameFrame.getContentPane().add(gamePanel);
        gameFrame.setVisible(true);
    }

    public void displayQs(String text){
        JLabel question = new JLabel(text);
        question.setFont(new Font("Verdana", Font.BOLD, 25));
        displayPanel.add(question);
        gamePanel.revalidate();
        gamePanel.repaint();
    }

    public JPanel addGrid(int row, int col){
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(row,col));
        displayPanel.add(buttonPanel);
        gamePanel.revalidate();
        gamePanel.repaint();
        return buttonPanel;
    }

    public ButtonGroup createButtonGroup(){
        ButtonGroup group = new ButtonGroup();
        buttonGroups.add(group);
        return group;
    }

    public void addButton(String text, ButtonGroup group, JPanel buttonPanel){
        JRadioButton button = new JRadioButton();
        button.setText(text);
        button.setActionCommand(text);
        group.add(button);
        buttonPanel.add(button);
        displayPanel.add(buttonPanel);
        gamePanel.revalidate();
        gamePanel.repaint();

    }
    public  void submitButton(){
        JButton submit = new JButton();
        submit.setText("Submit");
        submit.addActionListener(e -> {
            List<String> answer = new ArrayList<>();
            for(int i =0; i< buttonGroups.size();i++)
            {
                String choice = buttonGroups.get(i).getSelection().getActionCommand();
                answer.add(choice);
            }
            gameModel.setUserAnswers(answer);
            gameModel.validateAnswers();
        });
        displayPanel.add(submit);
        gamePanel.revalidate();
        gamePanel.repaint();

    }

}
