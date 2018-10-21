package kemp.saranya.javaist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

//Ref. https://www.youtube.com/watch?v=byLKoPgB7yA
public class SlideAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    public SlideAdapter(Context context) {
        this.context = context;
    }

    //Creating the array for the image on each slide
    public int[] slide_image = {
            R.drawable.youtube,
            R.drawable.quiz,
            R.drawable.fb
    };

    public String[] slide_headings = {
            "Video Tutorial",
            "MCQs",
            "Facebook Sharing"
    };

    public String[] slide_intro = {
            "Simply click a video lesson to start your journey!",
            "Do the MCQs to test your understanding to the lesson!",
            "Share the scores you have gained to compete with your friends!"
    };


    @Override
    public int getCount() {
        return slide_image.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {


        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.activity_slideshows, container,false);


        ImageView slideImage = (ImageView)view.findViewById(R.id.slide_image);
        TextView heading = (TextView)view.findViewById(R.id.slide_heading);
        TextView intro = (TextView)view.findViewById(R.id.slide_intro);


        slideImage.setImageResource(slide_image[position]);
        heading.setText(slide_headings[position]);
        intro.setText(slide_intro[position]);


        container.addView(view);

        return view;
    }


    //stop the slideshow as the 3 slides finished
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
