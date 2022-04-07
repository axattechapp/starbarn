package com.axat.starbarn.activity.Challenge;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.axat.starbarn.R;
import com.axat.starbarn.activity.VideoDetails.VideoDetailActivity;
import com.axat.starbarn.activity.Your_videos.YourVideosActivity;
import com.axat.starbarn.databinding.FragmentUploadVideoFromProfileBinding;
import com.axat.starbarn.fragment.uploadvideo.UploadVideoDialogFragment;
import com.fxn.pix.Options;
import com.fxn.pix.Pix;
import com.fxn.utility.PermUtil;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;


public class Upload_Video_From_Profile_Fragment extends BottomSheetDialogFragment {



    FragmentUploadVideoFromProfileBinding binding;
    final static int REQUEST_VIDEO_CAPTURED = 1;
    ArrayList<String> returnValue;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Upload_Video_From_Profile_Fragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_upload__video__from__profile_, container, false);
        returnValue=new ArrayList<>();
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.uploadImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent intent=new Intent();
//                intent.setType("video/*");
//                intent.setAction(Intent.ACTION_GET_CONTENT);
//                startActivityForResult(Intent.createChooser(intent,"Title"),SELECT_IMAGE_CODE);

//                Intent intent = new Intent(android.provider.MediaStore.ACTION_VIDEO_CAPTURE);
//                startActivityForResult(intent, REQUEST_VIDEO_CAPTURED);

                returnValue = new ArrayList<>();
                Options options = Options.init()
                        .setRequestCode(100)
                        .setCount(3)
                        .setFrontfacing(false)
                        .setPreSelectedUrls(returnValue)
                        .setExcludeVideos(false)
                        .setVideoDurationLimitinSeconds(30)
                        .setScreenOrientation(Options.SCREEN_ORIENTATION_PORTRAIT)
                        .setPath("/pix/images");

                Pix.start(Upload_Video_From_Profile_Fragment.this, options);


            }
        });

        binding.textuploadvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent intent=new Intent();
//                intent.setType("video/*");
//                intent.setAction(Intent.ACTION_GET_CONTENT);
//                startActivityForResult(Intent.createChooser(intent,"Title"),SELECT_IMAGE_CODE);

//                Intent intent = new Intent(android.provider.MediaStore.ACTION_VIDEO_CAPTURE);
//                startActivityForResult(intent, REQUEST_VIDEO_CAPTURED);

                returnValue = new ArrayList<>();
                Options options = Options.init()
                        .setRequestCode(100)
                        .setCount(3)
                        .setFrontfacing(false)
                        .setPreSelectedUrls(returnValue)
                        .setExcludeVideos(false)
                        .setVideoDurationLimitinSeconds(30)
                        .setScreenOrientation(Options.SCREEN_ORIENTATION_PORTRAIT)
                        .setPath("/pix/images");

                Pix.start(Upload_Video_From_Profile_Fragment.this, options);


            }
        });
        binding.uploadVideoFromProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), YourVideosActivity.class);
//                intent.putExtra("value",0);
                startActivity(intent);

            }
        });
        binding.textuploadfromProfilevideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), YourVideosActivity.class);
//                intent.putExtra("value",1);
                startActivity(intent);

            }
        });




    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode==1)
//        {
//            Uri uri=data.getData();
//            Intent intent=new Intent(getContext(), Challenge_request_Activity.class);
//            Log.e("path", String.valueOf(uri));
//            intent.putExtra("path",String.valueOf(uri));
//            intent.putExtra("value",2);
//
//            startActivity(intent);
//        }
//    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && requestCode == 100) {
            returnValue = data.getStringArrayListExtra(Pix.IMAGE_RESULTS);
            Log.e("returnValue", "r" + returnValue.toString().replaceAll("(^\\[|\\]$)", ""));
            Intent intent = new Intent(getContext(), Challenge_request_Activity.class);
            intent.putExtra("path", returnValue.toString().replaceAll("(^\\[|\\]$)", ""));
            intent.putExtra("value", 2);
            startActivity(intent);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PermUtil.REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Pix.start(Upload_Video_From_Profile_Fragment.this, Options.init().setRequestCode(100));
                } else {
                    Toast.makeText(getContext(), "Approve permissions to open Pix ImagePicker", Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }

}