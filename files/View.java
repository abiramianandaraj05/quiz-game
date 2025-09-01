import javax.swing.*;
import java.awt.*;

public class View {
    JFrame welcomeFrame = new JFrame();

    public void DisplayWelcomeScreen(){
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeFrame.setLocationRelativeTo(null);
        welcomeFrame.setSize(new Dimension(400,600));
        welcomeFrame.setTitle("The History Quiz!!");

        JPanel TitlePanel = new JPanel();
        JLabel welcomeLabel = new JLabel();
        welcomeLabel.setText("WELCOME TO THE HISTORY QUIZ!");
        welcomeLabel.setFont(new Font("Verdana", Font.PLAIN, 200));
        TitlePanel.add(welcomeLabel);

        welcomeFrame.add(TitlePanel);
        //welcomeFrame.pack();

        welcomeFrame.setVisible(true);
    }
}
