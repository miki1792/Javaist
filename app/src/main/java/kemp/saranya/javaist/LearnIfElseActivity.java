package kemp.saranya.javaist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class LearnIfElseActivity extends YouTubeBaseActivity {

    //declaring the variable of type YouTubePlayerView
    private YouTubePlayerView youTubePlayerView;
    //declaring the variable of type YouTubePlayer.OnInitializedListener
    private YouTubePlayer.OnInitializedListener onInitializedListener;
    //declaring the buttons in java class
    private Button if_btn_back;
    private Button if_btn_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Linking the XML view to this java class.
        setContentView(R.layout.activity_learn_loop);

        //getting the intent from last activity/ies
        Intent intent = getIntent();

        //assigning the buttons
        if_btn_back = (Button) findViewById(R.id.button_loop_back);
        if_btn_test = (Button) findViewById(R.id.button_loop_test);
        //assigning the youtube player view to the XML file object
        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.learn_loop_view);

        //setting an onClick method for the Back button of the button.
        if_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creating an intent to open a new activity (LearnMenuActivity)
                Intent intent = new Intent (LearnIfElseActivity.this, LearnMenuActivity.class);
                startActivity(intent);
            }
        });

        //setting an onClick method for the Test button of the button.
        if_btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creating an intent to open a new activity (LearnMenuActivity)
                Intent intent = new Intent (LearnIfElseActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("WZXq5_9_JDs");
                youTubePlayer.setPlayerStateChangeListener(new YouTubePlayer.PlayerStateChangeListener() {
                    @Override
                    public void onLoading() {
                        //printing a toast message saying the video is loading
                        Toast.makeText(LearnIfElseActivity.this, "Video loading", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLoaded(String s) {
                        //printing a toast message saying the video has loaded
                        Toast.makeText(LearnIfElseActivity.this, "Video Loaded", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAdStarted() {
                    }

                    @Override
                    public void onVideoStarted() {
                        //printing a toast message saying the video has started
                        Toast.makeText(LearnIfElseActivity.this, "Video started", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onVideoEnded() {
                        //printing a toast message saying the video has ended
                        Toast.makeText(LearnIfElseActivity.this, "Video ended", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(YouTubePlayer.ErrorReason errorReason) {

                    }
                });
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };

        //initialises the youtube player view by giving it the API key
        youTubePlayerView.initialize("AIzaSyCG9g0RHV1veNLbgLRj5UPmBb-fhRhaNDo", onInitializedListener);

    }
}

