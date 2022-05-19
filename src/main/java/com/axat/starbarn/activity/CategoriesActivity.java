package com.axat.starbarn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.axat.starbarn.Instructions.InstructionsActivity1;
import com.axat.starbarn.R;
import com.axat.starbarn.activity.VideoDetails.VideoDetailActivity;
import com.axat.starbarn.databinding.ActivityCategoriesBinding;
import com.axat.starbarn.model.CategoryModel;
import com.axat.starbarn.model.saveProfileModel;
import com.axat.starbarn.service.Api;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import org.json.JSONArray;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CategoriesActivity extends AppCompatActivity {

    ActivityCategoriesBinding binding;
    Api api;
    LayoutInflater inflater;
    int value;
    Intent intent;
    ArrayList<Integer> category_array;
    String cat="";
    int rb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_categories);


        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(8, TimeUnit.MINUTES)
                .writeTimeout(8, TimeUnit.MINUTES)
                .readTimeout(8, TimeUnit.MINUTES)
                .build();


        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();

        api = retrofit.create(Api.class);
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        category_array= new ArrayList<Integer>();
        Call<CategoryModel> call = api.getCategory();
        call.enqueue(new Callback<CategoryModel>() {
            @Override
            public void onResponse(Call<CategoryModel> call, Response<CategoryModel> response) {
                if (response.code() == 200) {
                    CategoryModel model = response.body();
                    for (int i = 0; i < model.getData().size(); i++) {
                        RadioGroup group = new RadioGroup(CategoriesActivity.this);
                        group.setOrientation(RadioGroup.VERTICAL);
//                        RadioButton btn1 = new RadioButton(new ContextThemeWrapper(CategoriesActivity.this, R.style.MyRadioButton), null, 0);
                        RadioButton btn1 = (RadioButton) inflater.inflate(R.layout.radio_butt, null);
                        btn1.setTextColor(Color.WHITE);
                        btn1.setText(model.data.get(i).getTitle());
                        btn1.setId(model.data.get(i).getCategoriesId());

                        group.addView(btn1);
                        binding.CategoryLayout.addView(group);
                        group.setOnCheckedChangeListener(mCheckedListner);
                    }


                } else
                    Toast.makeText(CategoriesActivity.this, "error" + response.message(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<CategoryModel> call, Throwable t) {
                Toast.makeText(CategoriesActivity.this, "fail" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

         intent = getIntent();
        value = intent.getIntExtra("activity", 0);

            binding.backimg.setOnClickListener(view -> onBackPressed());

            binding.textcontinue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nextTask();
                }
            });





    }
    RadioGroup.OnCheckedChangeListener mCheckedListner = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            JSONArray actionArray = new JSONArray();
            if(group.findViewById(checkedId)!=null) {
                CharSequence rb = ((RadioButton) group.findViewById(checkedId)).getText();
                Log.e("rb",""+rb);
                Log.e("value",""+value);
//Your Code here
                if (value == 1)
                {
                    Uri myUri = Uri.parse(intent.getStringExtra("path"));
                    //videoDetails
                    RadioButton radioButton = (RadioButton) findViewById(checkedId);
////                                                               Toast.makeText(getBaseContext(), radioButton.getText(), Toast.LENGTH_SHORT).show();
                    Intent intent1=new Intent(CategoriesActivity.this, VideoDetailActivity.class);
                    intent1.putExtra("result",radioButton.getText().toString());
                    intent1.putExtra("value",1);
                    intent1.putExtra("path",String.valueOf(myUri));
                    startActivity(intent1);
                    binding.textcontinue.setBackgroundColor(getResources().getColor(R.color.btn_orange));

                }
                if (value==2)
                {



                    rb2 = ((RadioButton) group.findViewById(checkedId)).getId();
                    category_array.add(rb2);
                    Log.e("rb",""+rb2);




                }

            }
        }

};

    public void nextTask()
    {

        if (value==2)
        {

            for (int i=0;i<category_array.size();i++)
            {
                Log.e("btn_value",""+category_array.get(i));
            }
            cat=category_array.toString().replaceAll("\\[|\\]", "").replaceAll(", ",",");
            Log.e("cat",""+cat);
            SharedPreferences preferences = CategoriesActivity.this.getSharedPreferences("goat",Context.MODE_PRIVATE);
            String retrivedToken  = preferences.getString("token",null);//second parameter default value.


            String name = intent.getStringExtra("name");
            String imageurl = intent.getStringExtra("profile");

            RequestBody name1 = RequestBody.create(MediaType.parse("text/plain"), name);
//            RequestBody category_id = RequestBody.create(MediaType.parse("text/plain"), String.valueOf(rb2));
            RequestBody category_id = RequestBody.create(MediaType.parse("text/plain"), String.valueOf(cat));




            File file = new File(imageurl);
            MultipartBody.Part imagePart = MultipartBody.Part.createFormData("profile", file.getName(), RequestBody.create(MediaType.parse("image/*"), file));
            Log.e("bearer",retrivedToken);
            Log.e("name",name);
            Log.e("imageurl",imageurl);


            Call<saveProfileModel> calll=api.saveProfile2("Bearer "+retrivedToken,name1,category_id,imagePart);

                    calll.enqueue(new Callback<saveProfileModel>() {
                        @Override
                        public void onResponse(Call<saveProfileModel> call, Response<saveProfileModel> response) {
                            if (response.code()==200)
                            {
                                Toast.makeText(CategoriesActivity.this,"success",Toast.LENGTH_SHORT).show();

                                startActivity(new Intent(CategoriesActivity.this, InstructionsActivity1.class));

                            }else
                            {
                                Toast.makeText(CategoriesActivity.this,"error"+response.message(),Toast.LENGTH_SHORT).show();
                                Log.e("error",""+response.errorBody());
                            }

                        }

                        @Override
                        public void onFailure(Call<saveProfileModel> call, Throwable t) {
                            Toast.makeText(CategoriesActivity.this,"fail"+t.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    });


        }
    }
}