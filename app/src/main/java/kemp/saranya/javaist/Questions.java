package kemp.saranya.javaist;

//this class will contain the questions itself
//this class is a bridge between the app and the database
public class Questions {

    private  String question;
    private String option1;
    private String option2;
    private String option3;
    //Answer number object = we are saving the correct answer in form of number
    //number 1 if option 1 if correct, 2 for option 2, and 3 for option 3
    private int answerNo;

    //here for pasting no value
    public Questions(){

    }


    public Questions(String question, String option1, String option2, String option3, int answerNo) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.answerNo = answerNo;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public int getAnswerNo() {
        return answerNo;
    }

    public void setAnswerNo(int answerNo) {
        this.answerNo = answerNo;
    }
}
