package com.axat.starbarn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.axat.starbarn.R;
import com.axat.starbarn.databinding.ActivityOtpactivityBinding;
import com.axat.starbarn.model.OTP_Model;
import com.axat.starbarn.service.Api;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OTPActivity extends AppCompatActivity {
    ActivityOtpactivityBinding binding;

    Api api;
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

        Intent intent=getIntent();
        String Phone=intent.getStringExtra("phone");

        binding.textnumber.setText(Phone);


        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .connectTimeout(8, TimeUnit.MINUTES)
                .writeTimeout(8,TimeUnit.MINUTES)
                .readTimeout(8,TimeUnit.MINUTES)
                .build();


        Gson gson=new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();

        api=retrofit.create(Api.class);

        binding.backimg.setOnClickListener(view -> {
            onBackPressed();
        });

        binding.textcontinue.setOnClickListener(view -> {

           String otp1=binding.otpEditText1.getText().toString();
           String otp2=binding.otpEditText2.getText().toString();
           String otp3=binding.otpEditText3.getText().toString();
           String otp4=binding.otpEditText4.getText().toString();
           String otp5=binding.otpEditText5.getText().toString();
           String otp6=binding.otpEditText6.getText().toString();



           String OTP=otp1+otp2+otp3+otp4+otp5+otp6;
            Log.e("otp",OTP);
            
            JsonObject jsonObject=new JsonObject();
            jsonObject.addProperty("otp_number",OTP);

            Call<OTP_Model> call=api.verifyOTP(jsonObject);
            call.enqueue(new Callback<OTP_Model>() {
                @Override
                public void onResponse(Call<OTP_Model> call, Response<OTP_Model> response) {
                    if (response.code()==200)
                    {
                        OTP_Model model= response.body();
                        Toast.makeText(OTPActivity.this, ""+model.getMeassage(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(OTPActivity.this,NameActivity.class));

                    }else
                        Toast.makeText(OTPActivity.this, ""+response.message(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<OTP_Model> call, Throwable t) {
                    Toast.makeText(OTPActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

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