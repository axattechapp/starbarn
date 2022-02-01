package com.axat.starbarn.fragment.allvideo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.axat.starbarn.R;

import java.util.ArrayList;

public class AllImageAdapter extends RecyclerView.Adapter<viewHolder> {

    ArrayList<Integer> data;

    public AllImageAdapter(ArrayList<Integer> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.all_vieos_img_item,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.allImg.setImageResource(data.get(position));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
