package com.axat.starbarn.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.axat.starbarn.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class Logout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);



        ViewGroup viewGroup=findViewById(R.id.content);

        Button Logout;
        Button Cancel;
        MaterialAlertDialogBuilder builder=new MaterialAlertDialogBuilder(Logout.this);
        View view= LayoutInflater.from(Logout.this).inflate(R.layout.logoutdialog_layout,viewGroup,false);

        Logout=view.findViewById(R.id.LogoutButton);
        Cancel=view.findViewById(R.id.cancelButton1);
        builder.setCancelable(false);
        builder.setView(view);

        final AlertDialog dialog=builder.create();

       dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Logout.this,EmailActivity.class));
            }
        });
//        dialog.getWindow().setGravity(Gravity.AXIS_Y_SHIFT);
        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Logout.this,Account.class));
            }
        });

        dialog.show();
    }
}