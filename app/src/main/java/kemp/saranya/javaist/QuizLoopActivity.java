package kemp.saranya.javaist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class QuizLoopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_loop);

        //getting the intent from last activity/ies
        Intent intent = getIntent();
    }
}
