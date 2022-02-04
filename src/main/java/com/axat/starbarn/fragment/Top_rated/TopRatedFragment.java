package com.axat.starbarn.fragment.Top_rated;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.axat.starbarn.R;
import com.axat.starbarn.databinding.FragmentTopRatedBinding;
import com.axat.starbarn.fragment.YourVideos.yourVideoAdapter;

import java.util.ArrayList;


public class TopRatedFragment extends Fragment {

    FragmentTopRatedBinding binding;
    RecyclerView rcv;
    yourVideoAdapter adapter;
    ArrayList<Integer> modelList;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_top_rated,container,false);


        return binding.getRoot();
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
        modelList.add(6,R.drawable.ladder_video2);
        modelList.add(7,R.drawable.ladder_video2);
        modelList.add(8,R.drawable.ladder_video2);
        modelList.add(9,R.drawable.ladder_video2);
        modelList.add(10,R.drawable.ladder_video2);
        modelList.add(11,R.drawable.ladder_video2);
        modelList.add(12,R.drawable.ladder_video2);
        modelList.add(13,R.drawable.ladder_video2);
        modelList.add(14,R.drawable.ladder_video2);



        GridLayoutManager gridLayoutManager=new GridLayoutManager(view.getContext(),3);
        rcv.setLayoutManager(gridLayoutManager);

        adapter = new yourVideoAdapter(modelList);
        rcv.setAdapter(adapter);
    }
}