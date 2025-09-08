import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ShortAnswer implements QuestionStyle{

    ShortAnswer(){
        getRandomNumbers();
    }
    public String getType() {
        return "Short Answer qs";
    }

    public String getLine(int index){
        String text = "";
        try {
            text = Files.readAllLines(Paths.get("files/textFiles/ShortAnswer.txt")).get(index);


        }
        catch (IOException e){
            System.out.println("Error");
        }
        return text;
    }

    @Override
    public int getGridRow() {
        return 0;
    }

    @Override
    public int getGridCol() {
        return 0;
    }

    @Override
    public void displayQuestion(View gameView) {
        int size = getSize();
        String text;
        for(int i = 0;i< size;i++)
        {
            text = getQuestion(nums.get(i));
            gameView.displayQs(text);
            gameView.createEntry();
        }
        gameView.submitEntryButton();

    }

    @Override
    public void setAnswer() {
        for(int i=0;i<getSize();i++)
        {
            String[] answer;
            String text = getLine(nums.get(i));
            answer = text.split("\\,");
            answerList.add(answer[1]);
        }
    }
}
