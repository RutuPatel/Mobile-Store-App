package com.example.assignment5;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Walk_Activity extends AppCompatActivity {

    private ViewPager mSliderViewPager;
    private LinearLayout mDotLayout;

    private SliderAdapter sliderAdapter;

    private TextView[] mdots;

    TextView Skip;

    TextView Next;

    TextView prev;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walk_);

        mDotLayout = (LinearLayout) findViewById(R.id.dotslayout);
        mSliderViewPager=(ViewPager) findViewById(R.id.slideViewPager);

        sliderAdapter = new SliderAdapter(this);
        mSliderViewPager.setAdapter(sliderAdapter);
        addDotsIndicator(position);

        mSliderViewPager.addOnPageChangeListener(ViewListner);

        Next =(TextView) findViewById(R.id.nextbtn);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadNextSlide();

            }
        });

        Skip =(TextView) findViewById(R.id.skipbtn);
        Skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadHome();
            }
        });

        prev =(TextView) findViewById(R.id.previousbtn);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadPrev();
            }
        });

    }

    public  void  loadPrev(){
        int prevSlide = mSliderViewPager.getCurrentItem() - 1 ;
        if(prevSlide < mdots.length){
            mSliderViewPager.setCurrentItem(prevSlide);
        }

    }

    public  void  loadHome(){
        Intent intent = new Intent(this,NavigationActivity.class);
        startActivity(intent);
        finish();
    }
    public  void  loadNextSlide(){
        int nextSlide = mSliderViewPager.getCurrentItem() + 1 ;
        if(nextSlide < mdots.length){
            mSliderViewPager.setCurrentItem(nextSlide);
        }
        else{
            loadHome();
        }

    }
    public  void addDotsIndicator(int position){
        mdots = new TextView[3];
        mDotLayout.removeAllViews();
        for(int i =0 ; i < mdots.length;i++){
            mdots[i] = new TextView(this);
            mdots[i].setText(Html.fromHtml("&#8226;"));
            mdots[i].setTextSize(35);
            mdots[i].setTextColor(getResources().getColor(R.color.colorWhite));
            mDotLayout.addView(mdots[i]);
        }

        if(mdots.length >0){
            mdots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }


    }

    ViewPager.OnPageChangeListener  ViewListner = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {

            addDotsIndicator(i);

            if(i == mdots.length-1){
                Next.setText("Get Started");
                prev.setVisibility(View.INVISIBLE);
                Skip.setVisibility(View.INVISIBLE);
            }
            else{
                Next.setText("Next");
                prev.setVisibility(View.VISIBLE);
                Skip.setVisibility(View.VISIBLE);
            }


        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
