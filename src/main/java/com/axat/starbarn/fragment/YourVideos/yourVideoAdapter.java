package com.axat.starbarn.fragment.YourVideos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.axat.starbarn.R;
import com.axat.starbarn.activity.SavedActivity.MyVivewHolderClass;
import com.axat.starbarn.fragment.allvideo.viewHolder;

import java.util.ArrayList;

public class yourVideoAdapter extends RecyclerView.Adapter<holder> {
    ArrayList<Integer> data;

    public yourVideoAdapter(ArrayList<Integer> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.your_video_single_item,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        holder.allImg.setImageResource(data.get(position));
    }




    @Override
    public int getItemCount() {
        return data.size();
    }
}
