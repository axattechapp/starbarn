package com.axat.starbarn.activity.Challenge;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.axat.starbarn.R;
import com.axat.starbarn.activity.VideoDetails.VideoDetailActivity;
import com.axat.starbarn.databinding.ActivityUploadChallengeBinding;

public class UploadChallengeActivity extends AppCompatActivity {
    ActivityUploadChallengeBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_upload_challenge);
//        setContentView(R.layout.activity_upload_challenge);


       Upload_Video_From_Profile_Fragment upload_video_from_profile_fragment=new Upload_Video_From_Profile_Fragment();
       upload_video_from_profile_fragment.show(getSupportFragmentManager(),upload_video_from_profile_fragment.getTag());





    }



    }
