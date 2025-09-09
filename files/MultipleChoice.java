import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class MultipleChoice implements QuestionStyle {
    MultipleChoice() {
        getRandomNumbers();
    }


    public String getType() {
        return "Multiple Choice";
    }

    @Override
    public String getLine(int index) {
        String text = "";
        try {
            text = Files.readAllLines(Paths.get("files/textFiles/MultipleChoice.txt")).get(index);


        } catch (IOException e) {
            System.out.println("Error");
        }
        return text;
    }

    @Override
    public int getGridRow() {
        return 2;
    }

    @Override
    public int getGridCol() {
        return 2;
    }

    @Override
    public void displayQuestion(View gameView) {
        int size = getSize();
        String text;
        for (int i = 0; i < size; i++) {
            text = getQuestion(nums.get(i));
            gameView.displayQs(text);
            JPanel buttonPanel = gameView.addGrid(getGridRow(), getGridCol());
            String[] choices = getChoices(nums.get(i));
            ButtonGroup group = gameView.createButtonGroup();
            gameView.addButton(choices[0], group, buttonPanel);
            gameView.addButton(choices[1], group, buttonPanel);
            gameView.addButton(choices[2], group, buttonPanel);
            gameView.addButton(choices[3], group, buttonPanel);
        }
        gameView.submitButton();

    }

    public String[] getChoices(int index) {
        String[] choices;
        String text = getLine(index);
        choices = text.split("\\,");
        return Arrays.copyOfRange(choices, 1, 5);
    }

    @Override
    public void setAnswer() {
        for(int i=0;i<getSize();i++)
        {
            String[] answer;
            String text = getLine(nums.get(i));
            answer = text.split("\\,");
            System.out.println(answer);
            answerList.add(answer[5]);
        }
    }

}