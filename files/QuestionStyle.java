import java.util.ArrayList;
import java.util.List;

public interface QuestionStyle {
    List<String> answerList = new ArrayList<>();
    List <Integer> nums = new ArrayList<>();
    public String getType();
    public String getLine(int index);
    public int getGridRow();
    public int getGridCol();
    public void displayQuestion(View gameView);
    public void setAnswer();

    public default String getQuestion(int index){
        String[] question;
        String text = getLine(index);
        question = text.split("\\,");
        return question[0];
    }

    public default List<String> getAnswer(){
        return answerList;
    }
    public default int getSize(){
        return nums.size();
    }
    public default void getRandomNumbers(){
        for(int i= 0;i<5;i++) {
            int randomNum = getUniqueNumber();
            nums.add(randomNum);
        }
    }
    public default int getUniqueNumber(){
        int randomNum = (int) (Math.random() * 10);
        while (nums.contains(randomNum)){
            randomNum = (int) (Math.random() * 10);
        }
        return randomNum;
    }

}
