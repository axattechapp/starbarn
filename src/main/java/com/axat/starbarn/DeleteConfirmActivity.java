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

import com.axat.starbarn.activity.Account;
import com.axat.starbarn.activity.EmailActivity;
import com.axat.starbarn.activity.Logout;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class DeleteConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_confirm);

        ViewGroup viewGroup=findViewById(R.id.content);

        Button Logout;
        Button Cancel;
        MaterialAlertDialogBuilder builder=new MaterialAlertDialogBuilder(DeleteConfirmActivity.this);
        View view= LayoutInflater.from(DeleteConfirmActivity.this).inflate(R.layout.logoutdialog_layout,viewGroup,false);

        Logout=view.findViewById(R.id.LogoutButton);
        Cancel=view.findViewById(R.id.cancelButton1);
        builder.setCancelable(false);
        builder.setView(view);

        final AlertDialog dialog=builder.create();

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DeleteConfirmActivity.this, EmailActivity.class));
            }
        });
//        dialog.getWindow().setGravity(Gravity.AXIS_Y_SHIFT);
        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DeleteConfirmActivity.this, Account.class));
            }
        });

        dialog.show();
    }
}