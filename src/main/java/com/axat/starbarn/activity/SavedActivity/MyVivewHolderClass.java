package com.axat.starbarn.activity.SavedActivity;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.axat.starbarn.R;

public class MyVivewHolderClass extends RecyclerView.ViewHolder {

    public ImageView allImg;
    public CheckBox checkBox;
    public MyVivewHolderClass(@NonNull View itemView) {
        super(itemView);
        allImg=itemView.findViewById(R.id.allImg);
        checkBox=itemView.findViewById(R.id.checkbox);

    }
}
