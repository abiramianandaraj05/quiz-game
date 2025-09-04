public class MultipleChoice implements QuestionStyle{
    MultipleChoice(){

    }
    public void setQs(){
        questionList.add("How many wives did Henry VIII have?");
    }
    @Override
    public String getType() {
        return "Multiple Choice";
    }

    @Override
    public String getQuestion(int index) {
        return "";
    }

}
