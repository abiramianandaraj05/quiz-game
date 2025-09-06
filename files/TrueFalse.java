import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TrueFalse implements QuestionStyle{

    TrueFalse(){
        getRandomNumbers();
    }
    public String getQuestion(int index){
        String[] question;
        String text = getLine(index);
        question = text.split("\\,");
        System.out.println(question[0]);
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
        return 2;
    }
    public int getGridCol(){
        return 1;
    }

    @Override
    public void displayQuestion(View gameview) {

    }

    @Override
    public void displayFirstQ(View gameView) {
        String text = getQuestion(0);
        gameView.displayQs(text);
        gameView.addButton("True");
        gameView.addButton("False");
    }
}
