package com.example.mysmartlab.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.mysmartlab.R;

public class OnBoardAdapter extends PagerAdapter {
    Context context;

    public OnBoardAdapter(Context context) {
        this.context = context;
    }
    int sliderAllImages[] = {
            R.drawable.img_3,
            R.drawable.img_4,
            R.drawable.img_5,

    };
    int svipe [] = {

            R.drawable.img_2,
            R.drawable.img_6,
            R.drawable.img_7,

    };
    int sliderAllTitle[] = {
            R.string.screen1,
            R.string.screen2,
            R.string.screen3,
    };
    int sliderAllDesc[] = {
            R.string.screen1desc,
            R.string.screen2desc,
            R.string.screen3desc,
    };
    @Override
    public int getCount() {
        return sliderAllImages.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.onboatd_model,container,false);
        ImageView sliderImage = (ImageView) view.findViewById(R.id.imageView3);//1 картинка
        ImageView slider = (ImageView) view.findViewById(R.id.imageView2); //2 картинка
        TextView sliderTitle = (TextView) view.findViewById(R.id.textView5); //1
        TextView sliderDesc = (TextView) view.findViewById(R.id.textView6);
        sliderImage.setImageResource(sliderAllImages[position]);//2
        slider.setImageResource(svipe [position]);
        sliderTitle.setText(this.sliderAllTitle[position]);
        sliderDesc.setText(this.sliderAllDesc[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
