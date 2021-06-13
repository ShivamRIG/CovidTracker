package com.example.cowin_vac;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.smarteist.autoimageslider.SliderView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Urls of our images.
    String url1 = "https://images.unsplash.com/photo-1618961734760-466979ce35b0?crop=entropy&cs=tinysrgb&fit=crop&fm=jpg&h=900&ixid=MnwxfDB8MXxyYW5kb218fHx8fHx8fHwxNjIzNTg2MDg4&ixlib=rb-1.2.1&q=80&utm_campaign=api-credit&utm_medium=referral&utm_source=unsplash_source&w=1600";
    String url2 = "https://images.unsplash.com/flagged/photo-1573823448235-3e7ded467ad3?crop=entropy&cs=tinysrgb&fit=crop&fm=jpg&h=900&ixid=MnwxfDB8MXxyYW5kb218fHx8fHx8fHwxNjIzNTg2MTcx&ixlib=rb-1.2.1&q=80&utm_campaign=api-credit&utm_medium=referral&utm_source=unsplash_source&w=1600";
    String url3 = "https://images.unsplash.com/photo-1608326389514-d9d2514e1933?crop=entropy&cs=tinysrgb&fit=crop&fm=jpg&h=900&ixid=MnwxfDB8MXxyYW5kb218fHx8fHx8fHwxNjIzNTg2MTYy&ixlib=rb-1.2.1&q=80&utm_campaign=api-credit&utm_medium=referral&utm_source=unsplash_source&w=1600";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // we are creating array list for storing our image urls.
        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();

        // initializing the slider view.
        SliderView sliderView = findViewById(R.id.img);

        // adding the urls inside array list
        sliderDataArrayList.add(new SliderData(url1));
        sliderDataArrayList.add(new SliderData(url2));
        sliderDataArrayList.add(new SliderData(url3));

        // passing this array list inside our adapter class.
        SliderAdapter adapter = new SliderAdapter(this, sliderDataArrayList);

        // below method is used to set auto cycle direction in left to
        // right direction you can change according to requirement.
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);

        // below method is used to
        // setadapter to sliderview.
        sliderView.setSliderAdapter(adapter);

        // below method is use to set
        // scroll time in seconds.
        sliderView.setScrollTimeInSec(3);

        // to set it scrollable automatically
        // we use below method.
        sliderView.setAutoCycle(true);

        // to start autocycle below method is used.
        sliderView.startAutoCycle();
    }
}
