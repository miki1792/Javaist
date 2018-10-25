package kemp.saranya.javaist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LearnMenuActivity extends AppCompatActivity {

    //declaring the buttons in java class
    private Button btn_learn_if_else;
    private Button btn_learn_loop;
    private Button btn_back_menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Linking the XML view to this java class.
        setContentView(R.layout.activity_learn_menu);

        //assigning the XML buttons to the java objects that were previously declared
        btn_learn_if_else = (Button) findViewById(R.id.learn_menu_btn1);
        btn_learn_loop = (Button) findViewById(R.id.learn_menu_btn2);
        btn_back_menu = (Button) findViewById(R.id.learn_menu_back_to_button);


        //getting the intent from last activity/ies
        Intent intent = getIntent();

        //setting an onClick method for the first button of the activity.
        btn_learn_if_else.setOnClickListener(new View.OnClickListener() {
            @Override
            //creating an intent to open a new activity (LearnIfElseActivity)
            public void onClick(View v) {
                Intent intent = new Intent (LearnMenuActivity.this, LearnIfElseActivity.class);
                startActivity(intent);
                    }});

        //setting an onClick method for the second button of the activity.
        btn_learn_loop.setOnClickListener(new View.OnClickListener() {
            @Override
            //creating an intent to open a new activity (LearnLoopActivity)
            public void onClick(View v) {
                Intent intent = new Intent (LearnMenuActivity.this, LearnLoopActivity.class);
                startActivity(intent);

            }
        });

        //setting an onClick method for the second button of the activity.
        btn_back_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (LearnMenuActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });



    }
}
