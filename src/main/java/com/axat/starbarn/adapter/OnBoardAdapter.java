package com.axat.starbarn.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.axat.starbarn.R;
import com.axat.starbarn.databinding.ItemOnboardLayoutBinding;
import com.axat.starbarn.model.OnBoarModel;
import com.bumptech.glide.Glide;

import java.util.List;

public class OnBoardAdapter extends PagerAdapter {

    Context context;
    List<OnBoarModel> list;
    public OnBoardAdapter(Context context, List<OnBoarModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_onboard_layout, null);
        ItemOnboardLayoutBinding itemOnboardLayoutBinding = ItemOnboardLayoutBinding.bind(view);

        OnBoarModel onBoardModel = list.get(position);


        Glide.with(context).load(onBoardModel.getImageResource()).into(itemOnboardLayoutBinding.itemOnboardImageview);
        itemOnboardLayoutBinding.itemOnboardSubtitle.setText(onBoardModel.getSubtitle());
        itemOnboardLayoutBinding.itemOnboardTitle.setText(onBoardModel.getTitle());

        container.addView(itemOnboardLayoutBinding.getRoot());

        return itemOnboardLayoutBinding.getRoot();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
