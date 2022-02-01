package com.axat.starbarn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.axat.starbarn.R;
import com.axat.starbarn.databinding.ActivityOtpactivityBinding;

public class OTPActivity extends AppCompatActivity {
    ActivityOtpactivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_otpactivity);

        addTextWatcher(binding.otpEditText1);
        addTextWatcher(binding.otpEditText2);
        addTextWatcher(binding.otpEditText3);
        addTextWatcher(binding.otpEditText4);
        addTextWatcher(binding.otpEditText5);
        addTextWatcher(binding.otpEditText6);

        binding.backimg.setOnClickListener(view -> {
            onBackPressed();
        });

        binding.textcontinue.setOnClickListener(view -> {
            startActivity(new Intent(OTPActivity.this,NameActivity.class));
        });

    }

    private void addTextWatcher(final EditText one) {
        one.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                switch (one.getId()) {
                    case R.id.otp_edit_text1:
                        if (one.length() == 1) {
                            binding.otpEditText2.requestFocus();
                        }
                        break;
                    case R.id.otp_edit_text2:
                        if (one.length() == 1) {
                            binding.otpEditText3.requestFocus();
                        } else if (one.length() == 0) {
                            binding.otpEditText1.requestFocus();
                        }
                        break;
                    case R.id.otp_edit_text3:
                        if (one.length() == 1) {
                            binding.otpEditText4.requestFocus();
                        } else if (one.length() == 0) {
                            binding.otpEditText2.requestFocus();
                        }
                        break;
                    case R.id.otp_edit_text4:
                        if (one.length() == 1) {
                            binding.otpEditText5.requestFocus();
                        } else if (one.length() == 0) {
                            binding.otpEditText3.requestFocus();
                        }
                        break;
                    case R.id.otp_edit_text5:
                        if (one.length() == 1) {
                            binding.otpEditText6.requestFocus();
                        } else if (one.length() == 0) {
                            binding.otpEditText4.requestFocus();
                        }
                        break;
                    case R.id.otp_edit_text6:
                        if (one.length() == 1) {
                            InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                            inputManager.hideSoftInputFromWindow(OTPActivity.this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                        } else if (one.length() == 0) {
                            binding.otpEditText5.requestFocus();
                        }
                        break;
                }
            }
        });
    }
}