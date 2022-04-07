package com.axat.starbarn.activity.Challenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.axat.starbarn.R;
import com.axat.starbarn.activity.HomeActivity;
import com.axat.starbarn.databinding.ActivityChallengeRequestBinding;

public class Challenge_request_Activity extends AppCompatActivity {
    ActivityChallengeRequestBinding binding;
    Uri myUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_challenge_request);
//        setContentView(R.layout.activity_challenge_request);



        Intent intent=getIntent();
        int valuw=intent.getIntExtra("value",0);
//        Log.e("path", intent.getStringExtra("path"));

        binding.uploadbtn.setEnabled(false);

        if (valuw==2)
        {

            Log.e("path", intent.getStringExtra("path"));
            myUri = Uri.parse(intent.getStringExtra("path"));
//        binding.video1.setVideoURI(myUri);

           binding.views.setVisibility(View.GONE);
           binding.videociew1.setVisibility(View.VISIBLE);


            binding.videociew1.setVideoPath(String.valueOf(myUri));
            binding.videociew1.start();
            binding.uploadbtn.setEnabled(true);

            binding.uploadbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Challenge_request_Activity.this, HomeActivity.class));
                }
            });


        }
        binding.plusBlckBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Challenge_request_Activity.this,UploadChallengeActivity.class));

            }
        });
    }
}