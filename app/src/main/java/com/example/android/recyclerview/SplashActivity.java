package com.example.android.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {


    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;
    private SliderAdapter sliderAdapter;

    private TextView[] mDots;
    private Button mNextBtn;
    private Button mBackBtn;
    private Button mFinishBtn;
    private int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.dotsLayout);
        mNextBtn = (Button) findViewById(R.id.nextBtn);
        mBackBtn = (Button) findViewById(R.id.prevBtn);
        mFinishBtn = (Button) findViewById(R.id.finishBtn);

        sliderAdapter = new SliderAdapter(this);
        mSlideViewPager.setAdapter(sliderAdapter);
        addDotsIndicator(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);

        //onClickListener

        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSlideViewPager.setCurrentItem(mCurrentPage + 1);

            }
        });

        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSlideViewPager.setCurrentItem(mCurrentPage - 1);
            }
        });

        mFinishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void addDotsIndicator(int position) {
        mDots = new TextView[3];
        mDotLayout.removeAllViews();

        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransWhite));
            mDotLayout.addView(mDots[i]);
        }

        if (mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDotsIndicator(position);
            mCurrentPage = position;

            if (position == 0){
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(false);
                mFinishBtn.setEnabled(false);
                mNextBtn.setVisibility(View.VISIBLE);
                mFinishBtn.setVisibility(View.INVISIBLE);
                mBackBtn.setVisibility(View.INVISIBLE);
                mNextBtn.setText("Next");
                mBackBtn.setText("Back");
            }

            else if (position == mDots.length - 1) {
                mNextBtn.setEnabled(false);
                mFinishBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mFinishBtn.setVisibility(View.VISIBLE);
                mBackBtn.setVisibility(View.VISIBLE);
                mNextBtn.setVisibility(View.INVISIBLE);
                mFinishBtn.setText("Start");
                mBackBtn.setText("Back");
            }

            else {
                mFinishBtn.setEnabled(false);
                mNextBtn.setVisibility(View.VISIBLE);
                mFinishBtn.setVisibility(View.INVISIBLE);
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);
                mNextBtn.setText("Next");
                mBackBtn.setText("Back");
            }


        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}
