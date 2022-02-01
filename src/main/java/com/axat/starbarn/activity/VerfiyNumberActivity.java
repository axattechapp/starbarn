package com.axat.starbarn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.axat.starbarn.R;
import com.axat.starbarn.databinding.ActivityVerfiyNumberBinding;
import com.hbb20.CountryCodePicker;

public class VerfiyNumberActivity extends AppCompatActivity {
    ActivityVerfiyNumberBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_verfiy_number);

        binding.countrypicker.setCcpDialogShowTitle(true);

        String countrycode = binding.countrypicker.getSelectedCountryCode();

        binding.backimg.setOnClickListener(view -> {
            onBackPressed();
        });
        binding.textcontinue.setOnClickListener(view -> {
           startActivity(new Intent(VerfiyNumberActivity.this,OTPActivity.class));
        });
    }
}