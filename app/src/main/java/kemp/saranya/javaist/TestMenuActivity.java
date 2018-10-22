package kemp.saranya.javaist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TestMenuActivity extends AppCompatActivity {

    //declaring the buttons in java class
    private Button btn_test;
    private Button btn_back_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Linking the XML view to this java class.
        setContentView(R.layout.activity_test_menu);

        //assigning the XML button to the java objects that were previously declared
        btn_test = (Button) findViewById(R.id.test_menu_btn2);
        btn_back_menu = (Button) findViewById(R.id.test_menu_back_to_button);

        //getting the intent from last activity/ies
        Intent intent = getIntent();

        //setting an onClick method for the first button of the activity.
        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            //creating an intent to open a new activity (LearnIfElseActivity)
            public void onClick(View v) {
                Intent intent = new Intent (TestMenuActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });

        btn_back_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (TestMenuActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }
}
