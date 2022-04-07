package com.axat.starbarn;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.axat.starbarn.activity.HomeActivity;
import com.axat.starbarn.activity.SavedActivity.Saved;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class deleteActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete2);

        ViewGroup viewGroup=findViewById(R.id.content);

        Button Delete;
        Button Cancel;
        MaterialAlertDialogBuilder builder=new MaterialAlertDialogBuilder(deleteActivity2.this);
        View view= LayoutInflater.from(deleteActivity2.this).inflate(R.layout.delete_dialog_layout,viewGroup,false);

        Delete=view.findViewById(R.id.DeleteButton);
        Cancel=view.findViewById(R.id.cancelButton1);
        builder.setCancelable(false);
        builder.setView(view);

        final AlertDialog dialog=builder.create();

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(deleteActivity2.this, Saved.class));
            }
        });
//        dialog.getWindow().setGravity(Gravity.AXIS_Y_SHIFT);
        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(deleteActivity2.this, Saved.class));
            }
        });

        dialog.show();
    }
}