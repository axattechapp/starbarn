package com.axat.starbarn.activity.SavedActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.axat.starbarn.DeleteConfirmActivity;
import com.axat.starbarn.R;
import com.axat.starbarn.databinding.ActivitySavedBinding;

import java.util.ArrayList;

public class Saved extends AppCompatActivity {

    ActivitySavedBinding binding;
    SavedAdapter adapter;
    ArrayList<Integer> modelList;
    boolean select=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_saved);

        binding= DataBindingUtil.setContentView(this,R.layout.activity_saved);

        binding.imageView3.setOnClickListener(view -> onBackPressed());
        binding.deleteIcon.setClickable(false);

        binding.deleteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Saved.this, DeleteConfirmActivity.class));

            }
        });

        modelList=new ArrayList<Integer>();
//        rcv.setLayoutManager(new LinearLayoutManager(view.getContext()));
        modelList.add(0,R.drawable.saved1);
        modelList.add(1,R.drawable.saved2);
        modelList.add(2,R.drawable.saved3);
        modelList.add(3,R.drawable.saved4);
        modelList.add(4,R.drawable.saved5);
        modelList.add(5,R.drawable.saved6);
        modelList.add(6,R.drawable.saved1);
        modelList.add(7,R.drawable.saved2);
        modelList.add(8,R.drawable.saved3);
        modelList.add(9,R.drawable.saved4);
        modelList.add(10,R.drawable.saved5);
        modelList.add(11,R.drawable.saved6);
        modelList.add(12,R.drawable.saved1);
        modelList.add(13,R.drawable.saved2);
        modelList.add(14,R.drawable.saved3);
        modelList.add(15,R.drawable.saved4);
        modelList.add(16,R.drawable.saved5);
        modelList.add(17,R.drawable.saved6);
        modelList.add(18,R.drawable.saved1);
        modelList.add(19,R.drawable.saved2);
        modelList.add(20,R.drawable.saved3);


        GridLayoutManager gridLayoutManager=new GridLayoutManager(Saved.this,3);
        binding.savedVideosRec.setLayoutManager(gridLayoutManager);

        adapter = new SavedAdapter(modelList,select);
        binding.savedVideosRec.setAdapter(adapter);


        binding.SelectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (binding.SelectText.getText()=="Select")
                {
                    select=true;
                    GridLayoutManager gridLayoutManager=new GridLayoutManager(Saved.this,3);
                    binding.savedVideosRec.setLayoutManager(gridLayoutManager);
                    adapter = new SavedAdapter(modelList,select);
                    binding.savedVideosRec.setAdapter(adapter);

                    binding.SelectText.setText("Cancel");
                    binding.deleteIcon.setVisibility(View.VISIBLE);
                    binding.deleteIcon.setClickable(true);

                    binding.deleteIcon.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(Saved.this, DeleteConfirmActivity.class));

                        }
                    });
//                    Toast.makeText(Saved.this, "Clicked", Toast.LENGTH_SHORT).show();


                }else
                {
                    select=false;
                    GridLayoutManager gridLayoutManager=new GridLayoutManager(Saved.this,3);
                    binding.savedVideosRec.setLayoutManager(gridLayoutManager);
                    adapter = new SavedAdapter(modelList,select);
                    binding.savedVideosRec.setAdapter(adapter);

                    binding.SelectText.setText("Select");
//                    Toast.makeText(Saved.this, "Clicked", Toast.LENGTH_SHORT).show();

                }

            }
        });
        if (binding.SelectText.isPressed())
        binding.savedVideosRec.post(new Runnable() {
            @Override
            public void run() {
                adapter.notifyDataSetChanged();
            }
        });

    }
}