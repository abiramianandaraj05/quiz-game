import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TrueFalse implements QuestionStyle{


    TrueFalse(){
        getRandomNumbers();
    }
    public String getQuestion(int index){
        String[] question;
        String text = getLine(index);
        question = text.split("\\,");
        return question[0];
    }

    public String getLine(int index){
        String text = "";
        try {
            text = Files.readAllLines(Paths.get("files/textFiles/TrueFalseQs.txt")).get(index);


        }
        catch (IOException e){
            System.out.println("Error");
        }
        return text;
    }
    @Override
    public String getType() {
        return "True Or False Qs";
    }

    public int getGridRow(){
        return 1;
    }
    public int getGridCol(){
        return 2;
    }

    @Override
    public void displayQuestion(View gameView) {
        int size = getSize();
        String text;

        for(int i = 0;i< size;i++)
        {
            text = getQuestion(nums.get(i));
            gameView.displayQs(text);
            JPanel buttonPanel = gameView.addGrid(getGridRow(),getGridCol());
            ButtonGroup group = gameView.createButtonGroup();
            gameView.addButton("True", group,buttonPanel);
            gameView.addButton("False",group,buttonPanel);
        }
        gameView.submitButton();
    }

    @Override
    public void setAnswer(){
        for(int i=0;i<getSize();i++)
        {
            String[] answer;
            String text = getLine(i);
            answer = text.split("\\,");
            answerList.add(answer[1]);
        }
    }

}
