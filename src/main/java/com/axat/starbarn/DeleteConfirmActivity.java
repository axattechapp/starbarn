package com.axat.starbarn;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.axat.starbarn.activity.Account;
import com.axat.starbarn.activity.EmailActivity;
import com.axat.starbarn.activity.HomeActivity;
import com.axat.starbarn.activity.Logout;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class DeleteConfirmActivity extends AppCompatActivity {
    public int value;

    @Override
    protected void onCreate(Bundle HomeActivityInstanceState) {
        super.onCreate(HomeActivityInstanceState);
        setContentView(R.layout.activity_delete_confirm);

        Intent intent=getIntent();
        value=intent.getIntExtra("value",0);
        Log.e("deletevalue","dfs"+value);





        ViewGroup viewGroup=findViewById(R.id.content);

        Button Logout;
        Button Cancel;
        MaterialAlertDialogBuilder builder=new MaterialAlertDialogBuilder(DeleteConfirmActivity.this);
        View view= LayoutInflater.from(DeleteConfirmActivity.this).inflate(R.layout.delete_dialog_layout,viewGroup,false);

        Logout=view.findViewById(R.id.LogoutButton);
        Cancel=view.findViewById(R.id.cancelButton1);
        builder.setCancelable(false);
        builder.setView(view);
        if (value==1){
            Logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                        startActivity(new Intent(DeleteConfirmActivity.this, HomeActivity.class));

                }
            });
        }

        final AlertDialog dialog=builder.create();

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (value==1){
                    startActivity(new Intent(DeleteConfirmActivity.this, HomeActivity.class));
                }else
                startActivity(new Intent(DeleteConfirmActivity.this, HomeActivity.class));
            }
        });
//        dialog.getWindow().setGravity(Gravity.AXIS_Y_SHIFT);
        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (value==1){
                    startActivity(new Intent(DeleteConfirmActivity.this, HomeActivity.class));
                }else
                    startActivity(new Intent(DeleteConfirmActivity.this, HomeActivity.class));
            }

        });

        dialog.show();
    }
}