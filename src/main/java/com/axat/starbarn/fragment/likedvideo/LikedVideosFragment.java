package com.axat.starbarn.fragment.likedvideo;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.axat.starbarn.R;
import com.axat.starbarn.fragment.allvideo.AllImageAdapter;

import java.util.ArrayList;

public class LikedVideosFragment extends Fragment {

    private LikedVideosViewModel mViewModel;
    RecyclerView rcv;
    LikeAdapter adapter;
    ArrayList<Integer> modelList;

    public static LikedVideosFragment newInstance() {
        return new LikedVideosFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.liked_videos_fragment, container, false);
        return view;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LikedVideosViewModel.class);


        rcv = view.findViewById(R.id.allLikesRecy);
        modelList=new ArrayList<Integer>();
//        rcv.setLayoutManager(new LinearLayoutManager(view.getContext()));
        modelList.add(0,R.drawable.allvideo1);
        modelList.add(1,R.drawable.allvideo2);
        modelList.add(2,R.drawable.allvideo1);
        modelList.add(3,R.drawable.allvideo1);
        modelList.add(4,R.drawable.allvideo2);
        modelList.add(5,R.drawable.allvideo1);
        modelList.add(6,R.drawable.allvideo1);
        modelList.add(7,R.drawable.allvideo2);
        modelList.add(8,R.drawable.allvideo1);
        modelList.add(9,R.drawable.allvideo1);
        modelList.add(10,R.drawable.allvideo2);
        modelList.add(11,R.drawable.allvideo1);
        modelList.add(12,R.drawable.allvideo1);
        modelList.add(13,R.drawable.allvideo2);
        modelList.add(14,R.drawable.allvideo1);


        GridLayoutManager gridLayoutManager=new GridLayoutManager(view.getContext(),3);
        rcv.setLayoutManager(gridLayoutManager);

        adapter = new LikeAdapter(modelList);
        rcv.setAdapter(adapter);
    }
}