package com.axat.starbarn.fragment.YourVideos;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.axat.starbarn.R;
import com.axat.starbarn.databinding.FragmentYourVideosBinding;
import com.axat.starbarn.fragment.allvideo.AllImageAdapter;
import com.axat.starbarn.fragment.setting.SettingViewModel;

import java.util.ArrayList;


public class yourVideosFragment extends Fragment {
    FragmentYourVideosBinding binding;
    RecyclerView rcv;
    yourVideoAdapter adapter;
    ArrayList<Integer> modelList;

   View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        view=inflater.inflate(R.layout.fragment_your_videos, container, false);
//        return view;

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_your_videos, container, false);
        return binding.getRoot();
    }
Context context;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        rcv = view.findViewById(R.id.yourVideosRec);
        modelList=new ArrayList<Integer>();
//        rcv.setLayoutManager(new LinearLayoutManager(view.getContext()));
        modelList.add(0,R.drawable.ladder_video1);
        modelList.add(1,R.drawable.ladder_video3);
        modelList.add(2,R.drawable.ladder_video2);
        modelList.add(3,R.drawable.ladder_video1);
        modelList.add(4,R.drawable.ladder_video3);
        modelList.add(5,R.drawable.ladder_video2);



        GridLayoutManager gridLayoutManager=new GridLayoutManager(view.getContext(),3);
        rcv.setLayoutManager(gridLayoutManager);

        adapter = new yourVideoAdapter(modelList);
        rcv.setAdapter(adapter);
    }


}