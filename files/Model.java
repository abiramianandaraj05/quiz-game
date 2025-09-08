import java.util.List;
import java.util.Objects;

public class Model {

    QuestionStyle gameChoice;
    View gameView;
    QuestionFactory factory;
    int score = 0;
    List<String> userAnswer;
    List<String> realAnswer;

    Model(){
        factory = new QuestionFactory();
    }
    public void multiple(){
        //setQuestionStyle(factory.createMultiChoice());
        setUpQuiz();
    }

    public void trueFalse(){
        setQuestionStyle(factory.createTrueFalse());
        setUpQuiz();
    }

    public void shortAnswer(){
        //setQuestionStyle(factory.createShortAnswer());
        setUpQuiz();
    }

    public void setView(View view){
        gameView = view;

    }
    public void setQuestionStyle(QuestionStyle userChoice){
        gameChoice= userChoice;
    }

    public void setUpQuiz(){
        gameView.setGameUp(gameChoice.getType());
        gameView.addGrid(gameChoice.getGridRow(), gameChoice.getGridCol());
        gameChoice.setAnswer();
        gameChoice.displayQuestion(gameView);
    }
    public void setUserAnswers(List<String> answer ){
        userAnswer = answer;
    }
    public void getRealAnswer(){
        realAnswer = gameChoice.getAnswer();
    }
    public void validateAnswers(){
        int size = gameChoice.getSize();
        getRealAnswer();
        for(int i = 0;i<size;i++){
            if (Objects.equals(userAnswer.get(i), realAnswer.get(i))){
                score ++;
            }
        }
    }

    public int getScore(){
        return score;
    }

}
