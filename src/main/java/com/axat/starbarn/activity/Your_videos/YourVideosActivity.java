package com.axat.starbarn.activity.Your_videos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.axat.starbarn.DeleteConfirmActivity;
import com.axat.starbarn.R;
import com.axat.starbarn.activity.SavedActivity.Saved;
import com.axat.starbarn.activity.SavedActivity.SavedAdapter;
import com.axat.starbarn.databinding.ActivityYourVideosBinding;

import java.util.ArrayList;

public class YourVideosActivity extends AppCompatActivity {
    ActivityYourVideosBinding binding;
    ArrayList<Integer> modelList;
    SavedAdapter adapter;
    boolean select=false;
     public int value;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(YourVideosActivity.this,R.layout.activity_your_videos);
//        setContentView(R.layout.activity_your_videos);
        modelList=new ArrayList<Integer>();
        binding.imageView3.setOnClickListener(view -> onBackPressed());
        binding.deleteIcon.setClickable(false);

//        Intent intent=getIntent();
//         value=intent.getIntExtra("value",0);

        binding.deleteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(YourVideosActivity.this,DeleteConfirmActivity.class);
                intent.putExtra("value",1);
                startActivity(intent);
//                startActivity(new Intent(YourVideosActivity.this, DeleteConfirmActivity.class));

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


        GridLayoutManager gridLayoutManager=new GridLayoutManager(YourVideosActivity.this,3);
        binding.savedVideosRec.setLayoutManager(gridLayoutManager);

        adapter = new SavedAdapter(modelList,select);
        binding.savedVideosRec.setAdapter(adapter);


        binding.SelectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (binding.SelectText.getText()=="Select")
                {
                    select=true;
                    GridLayoutManager gridLayoutManager=new GridLayoutManager(YourVideosActivity.this,3);
                    binding.savedVideosRec.setLayoutManager(gridLayoutManager);
                    adapter = new SavedAdapter(modelList,select);
                    binding.savedVideosRec.setAdapter(adapter);

                    binding.SelectText.setText("Cancel");
                    binding.deleteIcon.setVisibility(View.VISIBLE);
                    binding.deleteIcon.setClickable(true);

                    binding.deleteIcon.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(YourVideosActivity.this, DeleteConfirmActivity.class));

                        }
                    });
//                    Toast.makeText(Saved.this, "Clicked", Toast.LENGTH_SHORT).show();


                }else
                {
                    select=false;
                    GridLayoutManager gridLayoutManager=new GridLayoutManager(YourVideosActivity.this,3);
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