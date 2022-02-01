package com.axat.starbarn.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.axat.starbarn.fragment.allvideo.AllVideosFragment;
import com.axat.starbarn.fragment.likedvideo.LikedVideosFragment;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentStateAdapter {


    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new AllVideosFragment();
            case 1:
                return new LikedVideosFragment();

        }
        return new AllVideosFragment();
    }


    @Override
    public int getItemCount() {
        return 2;
    }


}
