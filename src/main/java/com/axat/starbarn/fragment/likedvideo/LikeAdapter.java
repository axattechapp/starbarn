package com.axat.starbarn.fragment.likedvideo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.axat.starbarn.R;
import com.axat.starbarn.fragment.allvideo.viewHolder;

import java.util.ArrayList;

public class LikeAdapter extends RecyclerView.Adapter<MyviewHolder> {
    ArrayList<Integer> data;

    public LikeAdapter(ArrayList<Integer> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.all_vieos_img_item,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        holder.allImg.setImageResource(data.get(position));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
