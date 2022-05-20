package com.axat.starbarn.activity.SavedActivity;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.axat.starbarn.R;

import java.util.ArrayList;

public class SavedAdapter extends RecyclerView.Adapter<MyVivewHolderClass> {
    ArrayList<Integer> data;
    ArrayList<String> data1;
    boolean select;
    boolean select1;


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
//        holder.allImg.setImageBitmap(data.get(position));

//        try {
//            Bitmap thumb = ThumbnailUtils.createVideoThumbnail(String.valueOf(data.get(position)), MediaStore.Video.Thumbnails.MICRO_KIND);
//
//
//            holder.allImg.setImageBitmap(thumb);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
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
