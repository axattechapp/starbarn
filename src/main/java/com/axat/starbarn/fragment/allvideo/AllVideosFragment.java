package com.axat.starbarn.fragment.allvideo;

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

import java.util.ArrayList;

public class AllVideosFragment extends Fragment {

    private AllVideosViewModel mViewModel;
    RecyclerView rcv;
    AllImageAdapter adapter;
    ArrayList<Integer> modelList;


    public static AllVideosFragment newInstance() {
        return new AllVideosFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.all_videos_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AllVideosViewModel.class);


        rcv = view.findViewById(R.id.allVideosRecy);
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

        adapter = new AllImageAdapter(modelList);
        rcv.setAdapter(adapter);
    }

    private ArrayList<ImgModel> dataqueue() {

        ArrayList<ImgModel> holder=new ArrayList<>();

        ImgModel ob1=new ImgModel();
        ob1.setImg(R.drawable.boy_with_cycle);
        holder.add(ob1);

        ImgModel ob2=new ImgModel();
        ob1.setImg(R.drawable.boy_with_cycle);
        holder.add(ob2);

        ImgModel ob3=new ImgModel();
        ob1.setImg(R.drawable.boy_with_cycle);
        holder.add(ob3);


        ImgModel ob4=new ImgModel();
        ob1.setImg(R.drawable.boy_with_cycle);
        holder.add(ob4);

        ImgModel ob5=new ImgModel();
        ob1.setImg(R.drawable.boy_with_cycle);
        holder.add(ob5);

        ImgModel ob6=new ImgModel();
        ob1.setImg(R.drawable.boy_with_cycle);
        holder.add(ob6);

        ImgModel ob7=new ImgModel();
        ob1.setImg(R.drawable.boy_with_cycle);
        holder.add(ob7);


        ImgModel ob8=new ImgModel();
        ob1.setImg(R.drawable.boy_with_cycle);
        holder.add(ob8);

        ImgModel ob9=new ImgModel();
        ob1.setImg(R.drawable.boy_with_cycle);
        holder.add(ob9);


        return holder;
    }
}