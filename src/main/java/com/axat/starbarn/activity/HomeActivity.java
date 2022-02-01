package com.axat.starbarn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;

import com.axat.starbarn.R;
import com.axat.starbarn.databinding.ActivityHomeBinding;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;


public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding binding;

    private NavController navController;

    private NavHostFragment navHostFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        setupBottomNavigation();

        Menu navView = binding.mainNavigation.getMenu();
        navView.findItem(R.id.navigation_upload).setIcon(R.drawable.upload);
        //Add custom tab menu
        BottomNavigationMenuView bottomNavigationMenuView=(BottomNavigationMenuView) binding.mainNavigation.getChildAt(0);

        View view=bottomNavigationMenuView.getChildAt(2);

        BottomNavigationItemView itemView = (BottomNavigationItemView) view;

        View viewCustom = LayoutInflater.from(this).inflate(R.layout.uploadvideocustom, bottomNavigationMenuView, false);
        itemView.addView(viewCustom);
    }

    private void setupBottomNavigation() {

        navHostFragment = (NavHostFragment)
                getSupportFragmentManager()
                        .findFragmentById(R.id.main_container);

        if (navHostFragment != null) {

            navController = navHostFragment.getNavController();

            NavigationUI.setupWithNavController(binding.mainNavigation, navController);


        }

    }
}
