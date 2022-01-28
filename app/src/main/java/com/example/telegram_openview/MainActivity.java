package com.example.telegram_openview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.telegram_openview.Adapters.ViewPagerAdapter;
import com.example.telegram_openview.Fragments.FifthsFragment;
import com.example.telegram_openview.Fragments.FirstFragment;
import com.example.telegram_openview.Fragments.FourthFragment;
import com.example.telegram_openview.Fragments.SecondFragment;
import com.example.telegram_openview.Fragments.SixthFragment;
import com.example.telegram_openview.Fragments.ThirdFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ViewPagerAdapter viewPagerAdapter;
    ViewPager viewPager;
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    public void initViews(){
        viewPager = findViewById(R.id.viewpager);

        sliderDotspanel = (LinearLayout) findViewById(R.id.SliderDots);

        viewPagerAdapter = new  ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.add(new FirstFragment(),"First");
        viewPagerAdapter.add(new SecondFragment(),"Second");
        viewPagerAdapter.add(new ThirdFragment(),"Third");
        viewPagerAdapter.add(new FourthFragment(),"Fourth");
        viewPagerAdapter.add(new FifthsFragment(),"Five");
        viewPagerAdapter.add(new SixthFragment(),"Sixth");

        viewPager.setAdapter(viewPagerAdapter);

        indicator();

    }

    public void indicator(){
        dotscount = viewPagerAdapter.getCount(); // activityda nechta page borligi

        dots = new ImageView[dotscount];

        for (int i = 0; i < dotscount; i++){
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nonactive_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8,0,8,0);

//            @Override
//            public void addView(View child, ViewGroup.LayoutParams params) {
//                addView(child, -1, params);
//            }

            sliderDotspanel.addView(dots[i],params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nonactive_dot)); // active bo'lmagan page'ga nonaactive_dot xml qo'yish
                }
                // active bo'lgan page'ga active_dot xml i qo'yiladi
                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTas(),2000,4000); // page'lar qancha vaqtda almashishi
    }

    public class MyTimerTas extends TimerTask { // page'larni ma'lum vaqtda o'tkazish uchun

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(() ->{
                if (viewPager.getCurrentItem() == 0){
                    viewPager.setCurrentItem(1);
                }else if (viewPager.getCurrentItem() == 1){
                    viewPager.setCurrentItem(2);
                }else if (viewPager.getCurrentItem() == 2){
                    viewPager.setCurrentItem(3);
                }else if (viewPager.getCurrentItem() == 3){
                    viewPager.setCurrentItem(4);
                }else if (viewPager.getCurrentItem() == 4){
                    viewPager.setCurrentItem(5);
                }else if (viewPager.getCurrentItem() == 5){
                    viewPager.setCurrentItem(6);
                }else{
                    viewPager.setCurrentItem(0);
                }
            });
        }
    }

}