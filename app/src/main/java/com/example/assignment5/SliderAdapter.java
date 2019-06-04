package com.example.assignment5;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    public  int[] slide_image ={
        R.drawable.track,
        R.drawable.mobileshop,
            R.drawable.cart,
    };

    public  String[] slide_heading ={
        "TRACK ORDERS",
        "SHOP ONLINE",
        "ADD TO CART"
    };

    public  String[] slide_text ={
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua"
    };

    @Override
    public int getCount() {
        return slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;
    }

    @Override
    public  Object instantiateItem(@NonNull ViewGroup container,@NonNull int position){

        layoutInflater =(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container,false);

        ImageView SlideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView SlideHeading =(TextView) view.findViewById(R.id.slide_heading);
        TextView SlideText = (TextView) view.findViewById(R.id.slide_text);

        SlideImageView.setImageResource(slide_image[position]);
        SlideHeading.setText(slide_heading[position]);
        SlideText.setText(slide_text[position]);

        container.addView(view);

        return  view;
    }

    @Override
    public  void  destroyItem(@NonNull ViewGroup container,@NonNull int position,@NonNull Object object){
        container.removeView((RelativeLayout)object);
    }
}
