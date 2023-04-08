package com.example.mysmartlab.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mysmartlab.Adapter.OnBoardAdapter;
import com.example.mysmartlab.R;

public class OnBoardActivity extends AppCompatActivity {

    ViewPager slideViewPager;
    LinearLayout dotIndicator;
    TextView nextButton , finishButton;
     OnBoardAdapter viewPagerAdapter;
    ViewPager.OnPageChangeListener viewPagerListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }
        @Override
        public void onPageSelected(int position) {

            if (position > 0) {
                nextButton.setText("Пропустить") ;
            }
            if (position == 2){
                nextButton.setText("Завершить");
            } else {
                nextButton.setText("Пропустить");
            }
        }
        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);
        finishButton = findViewById(R.id.textView);
        nextButton = findViewById(R.id.textView);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getItem(0) > 0) {
                    slideViewPager.setCurrentItem(getItem(-1), true);
                }

            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getItem(0) < 2)
                    slideViewPager.setCurrentItem(getItem(1), true);
                else {
                    Intent i = new Intent(OnBoardActivity.this,  RegistrationActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });
        slideViewPager = (ViewPager) findViewById(R.id.slideViewPager);

        viewPagerAdapter = new OnBoardAdapter(this);
        slideViewPager.setAdapter(viewPagerAdapter);

        slideViewPager.addOnPageChangeListener(viewPagerListener);
    }
    private int getItem(int i) {
        return slideViewPager.getCurrentItem() + i;
    }
}