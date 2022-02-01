package com.axat.starbarn.fragment.allvideo;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.axat.starbarn.R;

public class viewHolder extends RecyclerView.ViewHolder {
    public ImageView allImg;


    public viewHolder(@NonNull View itemView) {
        super(itemView);
        allImg=itemView.findViewById(R.id.allImg);

    }
}
