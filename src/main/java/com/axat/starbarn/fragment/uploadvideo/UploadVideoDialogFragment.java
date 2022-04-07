package com.axat.starbarn.fragment.uploadvideo;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.axat.starbarn.R;

import com.axat.starbarn.activity.TakeVideo.PixxxxccActivity;

import com.axat.starbarn.activity.VideoDetails.VideoDetailActivity;
import com.axat.starbarn.databinding.UploadVideoDialogFragmentBinding;
import com.fxn.pix.Options;
import com.fxn.pix.Pix;
import com.fxn.utility.PermUtil;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

public class UploadVideoDialogFragment extends BottomSheetDialogFragment {

    UploadVideoDialogFragmentBinding binding;
    private UploadVideoDialogViewModel mViewModel;
    int SELECT_IMAGE_CODE = 1;
    final static int REQUEST_VIDEO_CAPTURED = 1;
    Uri uriVideo = null;
    ArrayList<String> returnValue;

    public static UploadVideoDialogFragment newInstance() {
        return new UploadVideoDialogFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.upload_video_dialog_fragment, container, false);

        returnValue=new ArrayList<>();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(UploadVideoDialogViewModel.class);

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

                Pix.start(UploadVideoDialogFragment.this, options);

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

                Pix.start(UploadVideoDialogFragment.this, options);


            }
        });


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && requestCode == 100) {
            returnValue = data.getStringArrayListExtra(Pix.IMAGE_RESULTS);
            Log.e("returnValue", "r" + returnValue.toString().replaceAll("(^\\[|\\]$)", ""));
            Intent intent = new Intent(getContext(), VideoDetailActivity.class);
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
                    Pix.start(UploadVideoDialogFragment.this, Options.init().setRequestCode(100));
                } else {
                    Toast.makeText(getContext(), "Approve permissions to open Pix ImagePicker", Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }
}

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode==1)
//        {
//            Uri uri=data.getData();
//            Intent intent=new Intent(getContext(), VideoDetailActivity.class);
//            Log.e("path", String.valueOf(uri));
//            intent.putExtra("path",String.valueOf(uri));
//            intent.putExtra("value",2);
//
//            startActivity(intent);
//        }
//    }
