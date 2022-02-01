package com.axat.starbarn.fragment.uploadvideo;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.axat.starbarn.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class UploadVideoDialogFragment extends BottomSheetDialogFragment {

    private UploadVideoDialogViewModel mViewModel;

    public static UploadVideoDialogFragment newInstance() {
        return new UploadVideoDialogFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.upload_video_dialog_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(UploadVideoDialogViewModel.class);


    }
}