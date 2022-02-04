package com.axat.starbarn.fragment.uploadvideo;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.axat.starbarn.R;
import com.axat.starbarn.activity.VideoDetails.VideoDetailActivity;
import com.axat.starbarn.databinding.UploadVideoDialogFragmentBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class UploadVideoDialogFragment extends BottomSheetDialogFragment {

    UploadVideoDialogFragmentBinding binding;
    private UploadVideoDialogViewModel mViewModel;
    int SELECT_IMAGE_CODE=1;
    final static int REQUEST_VIDEO_CAPTURED = 1;
    Uri uriVideo = null;

    public static UploadVideoDialogFragment newInstance() {
        return new UploadVideoDialogFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding= DataBindingUtil.inflate(inflater,R.layout.upload_video_dialog_fragment,container,false);
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

                Intent intent = new Intent(android.provider.MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(intent, REQUEST_VIDEO_CAPTURED);

            }
        });

        binding.textuploadvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent intent=new Intent();
//                intent.setType("video/*");
//                intent.setAction(Intent.ACTION_GET_CONTENT);
//                startActivityForResult(Intent.createChooser(intent,"Title"),SELECT_IMAGE_CODE);

                Intent intent = new Intent(android.provider.MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(intent, REQUEST_VIDEO_CAPTURED);

            }
        });




    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==1)
        {
            Uri uri=data.getData();
            Intent intent=new Intent(getContext(), VideoDetailActivity.class);
            Log.e("path", String.valueOf(uri));
            intent.putExtra("path",String.valueOf(uri));
            intent.putExtra("value",2);

            startActivity(intent);
        }
    }
}