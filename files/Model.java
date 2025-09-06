public class Model {

    QuestionStyle gameChoice;
    View gameView;
    QuestionFactory factory;
    int index = 0;
    int score = 0;

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

    public void statementEnding(){
        //setQuestionStyle(factory.createStatementEnding());
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
        gameChoice.displayFirstQ(gameView);
    }
}
