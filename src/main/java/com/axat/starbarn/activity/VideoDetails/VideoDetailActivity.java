package com.axat.starbarn.activity.VideoDetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.axat.starbarn.R;
import com.axat.starbarn.activity.CategoriesActivity;
import com.axat.starbarn.databinding.ActivityVideoDetailBinding;

public class VideoDetailActivity extends AppCompatActivity {
    ActivityVideoDetailBinding binding;
    Uri myUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_video_detail);
//        setContentView(R.layout.activity_video_detail);

        Intent intent=getIntent();
        int valuw=intent.getIntExtra("value",0);
        Log.e("path", intent.getStringExtra("path"));
        myUri = Uri.parse(intent.getStringExtra("path"));
//        binding.video1.setVideoURI(myUri);

        binding.video1.setVideoPath(String.valueOf(myUri));
        binding.video1.start();


        if (valuw==2)
        {

            Log.e("path", intent.getStringExtra("path"));
            myUri = Uri.parse(intent.getStringExtra("path"));
//        binding.video1.setVideoURI(myUri);

            binding.video1.setVideoPath(String.valueOf(myUri));
            binding.video1.start();



        }else
        {

            String text=intent.getStringExtra("result");
            binding.category.setText(text);
            Log.e("result",text);
        }


        binding.arrowIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(VideoDetailActivity.this, CategoriesActivity.class);
                intent1.putExtra("activity",1);
                intent1.putExtra("path",String.valueOf(myUri));
                startActivity(intent1);

            }
        });
    }
}