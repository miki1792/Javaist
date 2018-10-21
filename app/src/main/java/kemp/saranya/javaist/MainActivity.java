package kemp.saranya.javaist;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager slideViewPage;
    private LinearLayout swipingDots;
    private TextView[] dot;
    private SlideAdapter slideAdapter;
    private Button skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slideViewPage =(ViewPager) findViewById(R.id.slideView);
        swipingDots = (LinearLayout)findViewById(R.id.dots);

        slideAdapter = new SlideAdapter(this);

        slideViewPage.setAdapter(slideAdapter);


        //call the method of addDots to display slideshow dots
        addDots(0);

        slideViewPage.addOnPageChangeListener(viewListener);

        skip = (Button) findViewById(R.id.btn_skip);

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    public void addDots(int position){
        dot = new TextView[3];
        swipingDots.removeAllViews();

        for(int i = 0; i < dot.length; i++){
            dot[i] = new TextView(this);
            dot[i].setText(Html.fromHtml("&#8226;")); //the code of bullet symbol is "&#8226;" in android studio
            // http://xahlee.info/js/html_chars.html


            //ContextCompat.getColor(context, R.color.your_color);
            dot[i].setTextSize(25);
            dot[i].setTextColor(getResources().getColor(R.color.colorGray));
            swipingDots.addView(dot[i]);
        }

        //if the users start to swipe the slideshows, the dot color of the current slide will be orange
        if(dot.length > 0){

            dot[position].setTextColor(getResources().getColor(R.color.colorAccent));
        }
    }

    //Method to indicate which slide users are turning to
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {
        }

        @Override
        public void onPageSelected(int i) {
            addDots(i);
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

}

