package com.example.epda3.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

import com.example.epda3.R;

import java.util.ArrayList;
import java.util.List;

public class SliderAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater mLayoutInflater;

    public List<Integer> images = new ArrayList<>();
    public List<String> text=new ArrayList<String>();

    public SliderAdapter(Context context) {
        this.context = context;
        this.mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void addPage(Integer image,String tex) {

        images.add(image);
        text.add(tex);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        try {
            View itemView = mLayoutInflater.inflate(R.layout.item_slid, container, false);

            ImageView sliderAdapterIvSliderImage = itemView.findViewById(R.id.item_slider_iv);
            TextView sliderAdapterTvSliderText = itemView.findViewById(R.id.item_tx);

            sliderAdapterIvSliderImage.setImageResource(images.get(position));
            sliderAdapterTvSliderText.setText(text.get(position));

            container.addView(itemView);

            return itemView;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
