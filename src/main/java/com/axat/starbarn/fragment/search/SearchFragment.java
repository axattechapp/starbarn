package com.axat.starbarn.fragment.search;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.axat.starbarn.R;
import com.axat.starbarn.databinding.SearchFragmentBinding;
import com.axat.starbarn.fragment.All.AllFragment;
import com.axat.starbarn.fragment.CategoryFragment;
import com.axat.starbarn.fragment.YourVideos.yourVideosFragment;

public class SearchFragment extends Fragment {

    private SearchViewModel mViewModel;
    SearchFragmentBinding binding;

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater,R.layout.search_fragment,container,false);



        binding.SelectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                binding.SelectText.getBackground().setColorFilter(getResources().getColor(R.color.tabbg_selected), PorterDuff.Mode.SRC_ATOP);
//                binding.allText.getBackground().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);
                binding.SelectText.setBackgroundResource(R.drawable.textback);
                binding.SelectText.setTextColor(Color.BLACK);

                binding.allText.setBackgroundResource(R.drawable.laddder_bg);
                binding.categoryText.setBackgroundResource(R.drawable.laddder_bg);

                replaceFragment(new yourVideosFragment());



            }
        });

        binding.allText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                binding.allText.getBackground().setColorFilter(getResources().getColor(R.color.tabbg_selected), PorterDuff.Mode.SRC_ATOP);
//                binding.SelectText.getBackground().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);
                binding.allText.setBackgroundResource(R.drawable.textback);
                binding.allText.setTextColor(Color.BLACK);

                replaceFragment(new AllFragment());

                binding.SelectText.setBackgroundResource(R.drawable.laddder_bg);
                binding.categoryText.setBackgroundResource(R.drawable.laddder_bg);
            }
        });

        binding.categoryText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                binding.categoryText.getBackground().setColorFilter(getResources().getColor(R.color.tabbg_selected), PorterDuff.Mode.SRC_ATOP);
//                binding.SelectText.getBackground().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);

                binding.categoryText.setBackgroundResource(R.drawable.textback);
                binding.categoryText.setTextColor(Color.BLACK);

                binding.SelectText.setBackgroundResource(R.drawable.laddder_bg);

                binding.allText.setBackgroundResource(R.drawable.laddder_bg);

                replaceFragment(new CategoryFragment());



            }
        });
        return binding.getRoot();



    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SearchViewModel.class);
        // TODO: Use the ViewModel
    }
    private void replaceFragment(Fragment fragment) {

        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout1,fragment);
        fragmentTransaction.commit();

    }

}