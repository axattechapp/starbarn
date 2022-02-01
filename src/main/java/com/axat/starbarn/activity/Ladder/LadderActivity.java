package com.axat.starbarn.activity.Ladder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.axat.starbarn.R;
import com.axat.starbarn.databinding.ActivityLadderBinding;
import com.axat.starbarn.fragment.All.AllFragment;
import com.axat.starbarn.fragment.CategoryFragment;
import com.axat.starbarn.fragment.YourVideos.yourVideosFragment;

public class LadderActivity extends AppCompatActivity {
    ActivityLadderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_ladder);

        binding= DataBindingUtil.setContentView(this,R.layout.activity_ladder);

        binding.imageView3.setOnClickListener(view -> onBackPressed());


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
    }
    private void replaceFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout1,fragment);
        fragmentTransaction.commit();

    }
}