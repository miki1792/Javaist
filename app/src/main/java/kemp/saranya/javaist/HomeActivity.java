package kemp.saranya.javaist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    //declaring the buttons in java class
    private Button btn_learn;
    private Button btn_quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Linking the XML view to this java class.
        setContentView(R.layout.activity_home);

        //getting the intent from last activity/ies
        Intent intent = getIntent();

        //assigning the XML buttons to the java objects that were previously declared
        btn_learn = (Button) findViewById(R.id.learn_button);
        btn_quiz = (Button) findViewById(R.id.test_button);

        //setting an onClick method for the first button of the activity.
        btn_learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creating an intent to open a new activity (LearnMenuActivity)
                Intent intent = new Intent (HomeActivity.this, LearnMenuActivity.class);
                startActivity(intent);
            }
        });

        //setting an onClick method for the second button.
        btn_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creating an intent to open a new activity (TestMenuActivity)
                Intent intent = new Intent (HomeActivity.this, TestMenuActivity.class);
                startActivity(intent);
            }
        });
    }
}
