package kemp.saranya.javaist;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private TextView textViewQuestion;
    private TextView textViewScore;
    private TextView textViewQuestionCount;
    private TextView textViewCountDown;

    private RadioGroup rGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;

    private Button btnConfirmNxt;

    private ColorStateList textColorDefaultRb; // changing the color based on if students' input answers are correct or wrong

    private List<Questions> questionsList;

    private int questionCounter; //showing how many questions has been shown

    private int questionCountTotal; //the total questions in our arraylist

    private Questions currentQuestionNo;// the number of current question

    private int score;//scores gained

    private boolean answered;//to detect if a question has been answered yet

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //getting the intent from last activity/ies
        Intent intent = getIntent();

        //assigning the variables to their XML components
        textViewQuestion = findViewById(R.id.quiz_question_view);
        textViewScore = findViewById(R.id.text_view_score);
        textViewQuestionCount = findViewById(R.id.text_view_question_count);
        textViewCountDown = findViewById(R.id.text_view_countdown);

        rGroup = findViewById(R.id.quiz1_radio_group);
        rb1 = findViewById(R.id.quiz1_radio_btn1);
        rb2 = findViewById(R.id.quiz1_radio_btn2);
        rb3 = findViewById(R.id.quiz1_radio_btn3);

        btnConfirmNxt = findViewById(R.id.quiz_btn_next);

        btnConfirmNxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!answered){
                    if(rb1.isChecked() || rb2.isChecked() || rb3.isChecked()){
                        checkAnswer();
                    } if(btnConfirmNxt.getText().toString().equals("NEXT")){
                        showNextQuestion();
                    }
                }
            }
        });

        //just the default text colour of radio button
        textColorDefaultRb = rb1.getTextColors();

        QuizDatabaseHelper quizDatabaseHelper = new QuizDatabaseHelper(this);
        // implement all the 5 questions
        questionsList = quizDatabaseHelper.getAllQuestions();

        questionCountTotal = questionsList.size();
        //to shuffle our question list
        Collections.shuffle(questionsList);

        //call showNextQuestion to go to the next question if there are any questions left
        showNextQuestion();

    }

    private void checkAnswer(){
        answered = true;

        //this will return the ID of the radio button that was checked (selected)
        //and assigned the ID to this 'rbSelected' variable.
        RadioButton rbSelected = findViewById(rGroup.getCheckedRadioButtonId());
        //return the index of the radio button that was selected
        //since index starts at '0' we are adding 1 at the end.
        int answerNr = rGroup.indexOfChild(rbSelected) + 1;

        //if the selected answer was the same as the correct answer
        //then we increase the score
        if(answerNr == currentQuestionNo.getAnswerNo()){
            score++;
            //updating the TextView
            textViewScore.setText("score: "+score);
        }

        showSolution();
    }

    private void showSolution(){
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);

        switch (currentQuestionNo.getAnswerNo()){
            case 1:
                rb1.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
        }

        //checking if we have any questions left.
        if(questionCounter<questionCountTotal){
            btnConfirmNxt.setText("NEXT");
        } else{
            btnConfirmNxt.setText("FINISH");
        }
    }

    private void showNextQuestion(){
        //set all colours of the buttons back to the default colour.
        rb1.setTextColor(textColorDefaultRb);
        rb2.setTextColor(textColorDefaultRb);
        rb3.setTextColor(textColorDefaultRb);

        //clear the selection(UNSELECT) once the process of answering questions is done,
        // so it can move onto the next question without the color from the last question
        rGroup.clearCheck();

        // if statement is to detect if there is any question left,
        // if not(the number of current question is less than the number of total questions), then the quiz will be stopped
        if (questionCounter < questionCountTotal){

            currentQuestionNo = questionsList.get(questionCounter);

            //(continue to the last comment) if yes,then keeps showing the next question
            textViewQuestion.setText(currentQuestionNo.getQuestion());
            rb1.setText(currentQuestionNo.getOption1());
            rb2.setText(currentQuestionNo.getOption2());
            rb3.setText(currentQuestionNo.getOption3());

            questionCounter++;
            textViewQuestionCount.setText("Question: " + questionCounter + " / " + questionCountTotal);
            // e.g. 3 / 5 which means, it is
            // the third question the student is
            //answering out of 5 questions in total

            //move to the next question
            answered = false;

            btnConfirmNxt.setText("Confirm");
        } else { //finish the quiz if questionCounter !< questionCountTotal
            finishQuiz(); //call the method finishQuiz() to close the quiz
        }
    }

    private void finishQuiz(){
        //closes the activity
        finish();
    }
}
