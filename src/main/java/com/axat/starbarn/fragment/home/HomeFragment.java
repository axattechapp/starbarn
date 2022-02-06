package com.axat.starbarn.fragment.home;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.axat.starbarn.R;
import com.axat.starbarn.adapter.VideosAdapter;
import com.axat.starbarn.databinding.HomeFragmentBinding;
import com.axat.starbarn.model.VideoItem;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;
    HomeFragmentBinding binding;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.home_fragment,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        List<VideoItem> videoItems = new ArrayList<>();

        VideoItem item = new VideoItem();
        item.videoURL = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4";
        item.videoTitle = "Women In Tech";
        item.videoDesc = "International Women's Day 2019";
        videoItems.add(item);

        VideoItem item2 = new VideoItem();
        item2.videoURL = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4";
        item2.videoTitle = "vishwa";
        item2.videoDesc = "How vishwa Became a Software Developer at AXAT";
        videoItems.add(item2);

        VideoItem item3 = new VideoItem();
        item3.videoURL = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4";
        item3.videoTitle = "Happy Hour Wednesday";
        item3.videoDesc = " Depth-First Search Algorithm";
        videoItems.add(item3);

        binding.viewPagerVideos.setAdapter(new VideosAdapter(videoItems,binding.viewPagerVideos.getContext()));
    }
}