package com.example.android.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Hanson on 2018-08-27.
 */

public class SliderAdapter extends PagerAdapter {

    private Context context;

    SliderAdapter(Context context) {
        this.context = context;
    }

    // Arrays

    private int[] slide_images = {
            R.drawable.orm_icon,
            R.drawable.tdee_icon,
            R.drawable.wilks_icon
    };

    private String[] slide_headings = {
            "One Rep Max",
            "TDEE, BMI & Ideal BW",
            "Wilks Coefficient"
    };

    private String[] slide_desc = {
            "Calculate your one-rep maxes for your squat, bench, and deadlift.",
            "Find out your TDEE, BMI, and ideal bodyweight.",
            "See where you stand relative to other lifters with your Wilks coefficient."
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == (RelativeLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDesc = (TextView) view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDesc.setText(slide_desc[position]);

        container.addView(view);

        return view;


    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}


