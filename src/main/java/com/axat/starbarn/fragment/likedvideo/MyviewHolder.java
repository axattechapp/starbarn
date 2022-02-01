package com.axat.starbarn.fragment.likedvideo;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.axat.starbarn.R;

public class MyviewHolder extends RecyclerView.ViewHolder {
    public ImageView allImg;


    public MyviewHolder(@NonNull View itemView) {
        super(itemView);
        allImg=itemView.findViewById(R.id.allImg);
    }
}
