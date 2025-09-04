import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TrueFalse implements QuestionStyle{

    TrueFalse(){
        getRandomNumbers();
    }
    @Override
    public String getQuestion(int index){
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
}
