package com.example.epda3.view.fragmen.splashCycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.example.epda3.R;
import com.example.epda3.adpter.SliderAdapter;
import com.example.epda3.view.activity.userCycle;
import com.example.epda3.view.fragmen.BaseFragment;


public class SliderFragment extends BaseFragment {
    SliderAdapter sliderAdapter;
    ViewPager viewPager;

    View v ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initFrag();
        v= inflater.inflate(R.layout.fragment_slider , container, false);
        sliderAdapter=new SliderAdapter(getActivity());
        sliderAdapter.addPage(R.drawable.group85,"اول فراجمنت يمكنك وضع التوجيهات التي تريدها او معلةمات عن كيفية استخدام التطبيق");
        sliderAdapter.addPage(R.drawable.group84,"ثاني فراجمنت يمكنك وضع التوجيهات التي تريدها او معلةمات عن كيفية استخدام التطبيق");
        sliderAdapter.addPage(R.drawable.group85,"ثالث فراجمنت يمكنك وضع التوجيهات التي تريدها او معلةمات عن كيفية استخدام التطبيق");
        viewPager=v.findViewById(R.id.fragment_slider_vp_slider);
        viewPager.setAdapter(sliderAdapter);
        return v;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final ImageView []dots = {v.findViewById(R.id.dot_1),v.findViewById(R.id.dot_2),v.findViewById(R.id.dot_3)};
        dots[0].setImageResource(R.drawable.ellipse12);

        final ImageView logo=v.findViewById(R.id.logo);

        ImageView but =v.findViewById(R.id.button);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewPager.getCurrentItem()==sliderAdapter.getCount()-1){
                    startActivity(new Intent(getActivity(), userCycle.class));
                    getActivity().finish();
                }else {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                }
            }
        });



        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==dots.length-1){


                }

                for(int i=0;i<dots.length;i++){
                    dots[i].setImageResource(R.drawable.ellipse11);
                }
                dots[position].setImageResource(R.drawable.ellipse12);
            }

            @Override
            public void onPageScrollStateChanged(int state) {


            }
        });
    }

    @Override
    public void onBack() {
        baseActivity.finish();
    }
}
