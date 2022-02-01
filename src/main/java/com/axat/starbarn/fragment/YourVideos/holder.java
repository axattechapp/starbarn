package com.axat.starbarn.fragment.YourVideos;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.axat.starbarn.R;

public class holder  extends RecyclerView.ViewHolder{
    public ImageView allImg;
    public holder(@NonNull View itemView) {
        super(itemView);
        allImg=itemView.findViewById(R.id.allImg);
    }
}
