public class QuestionFactory {

    public MultipleChoice createMultiChoice(){return new MultipleChoice();}
    public QuestionStyle createTrueFalse(){return new TrueFalse();}
    public QuestionStyle createShortAnswer(){return new ShortAnswer();}
    //public QuestionStyle createStatementEnding(){return new StatementEnding();}
}
