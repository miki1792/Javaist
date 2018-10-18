package kemp.saranya.javaist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TestMenuActivity extends AppCompatActivity {

    //declaring the buttons in java class
    private Button btn_test_if_else;
    private Button btn_test_loop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Linking the XML view to this java class.
        setContentView(R.layout.activity_test_menu);

        //assigning the XML buttons to the java objects that were previously declared
        btn_test_if_else = (Button) findViewById(R.id.test_menu_btn1);
        btn_test_loop = (Button) findViewById(R.id.test_menu_btn2);

        //getting the intent from last activity/ies
        Intent intent = getIntent();

        //setting an onClick method for the first button of the activity.
        btn_test_if_else.setOnClickListener(new View.OnClickListener() {
            @Override
            //creating an intent to open a new activity (LearnIfElseActivity)
            public void onClick(View v) {
                Intent intent = new Intent (TestMenuActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });

        //setting an onClick method for the second button of the activity.
        btn_test_loop.setOnClickListener(new View.OnClickListener() {
            @Override
            //creating an intent to open a new activity (LearnLoopActivity)
            public void onClick(View v) {
                Intent intent = new Intent (TestMenuActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });
    }
}
