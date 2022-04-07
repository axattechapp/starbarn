package com.axat.starbarn.fragment.challenge;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.axat.starbarn.R;
import com.axat.starbarn.databinding.ChallengeFragmentBinding;

public class ChallengeFragment extends Fragment {

    private ChallengeViewModel mViewModel;
    ChallengeFragmentBinding binding;

    public static ChallengeFragment newInstance() {
        return new ChallengeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater,R.layout.challenge_fragment,container,false);
//        return inflater.inflate(R.layout.challenge_fragment, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ChallengeViewModel.class);
        // TODO: Use the ViewModel
    }

}