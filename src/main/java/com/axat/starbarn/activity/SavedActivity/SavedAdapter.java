package com.axat.starbarn.activity.SavedActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.axat.starbarn.R;
import com.axat.starbarn.fragment.allvideo.viewHolder;

import java.util.ArrayList;

public class SavedAdapter extends RecyclerView.Adapter<MyVivewHolderClass> {
    ArrayList<Integer> data;
    boolean select;


    public SavedAdapter(ArrayList<Integer> data, boolean select) {
        this.data = data;
        this.select = select;
    }

    @NonNull
    @Override
    public MyVivewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.saved_img_single_item_layout,parent,false);
        return new MyVivewHolderClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVivewHolderClass holder, int position) {
        holder.allImg.setImageResource(data.get(position));
        holder.checkBox.setVisibility(View.VISIBLE);

        if (select)
        {
            holder.checkBox.setVisibility(View.VISIBLE);



        }

        else
        {
            holder.checkBox.setVisibility(View.INVISIBLE);

        }



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

public void showCheckbox()
{

}

}
