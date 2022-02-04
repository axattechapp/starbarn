package com.axat.starbarn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.axat.starbarn.R;
import com.axat.starbarn.activity.VideoDetails.VideoDetailActivity;
import com.axat.starbarn.databinding.ActivityCategoriesBinding;

public class CategoriesActivity extends AppCompatActivity {

    ActivityCategoriesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_categories);

       Intent intent=getIntent();
       int value=intent.getIntExtra("activity",0);
       if (value == 1)
       {
         Uri myUri = Uri.parse(intent.getStringExtra("path"));
           //videoDetails
           binding.radioall.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                                           @Override
                                                           public void onCheckedChanged(RadioGroup group, int checkedId)
                                                           {
                                                               RadioButton radioButton = (RadioButton) findViewById(checkedId);
                                                               Toast.makeText(getBaseContext(), radioButton.getText(), Toast.LENGTH_SHORT).show();
                                                               Intent intent1=new Intent(CategoriesActivity.this, VideoDetailActivity.class);
                                                               intent1.putExtra("result",radioButton.getText().toString());
                                                               intent1.putExtra("value",1);
                                                               intent1.putExtra("path",String.valueOf(myUri));
                                                               startActivity(intent1);
                                                           }
                                                       }
           );

       }else
       {
           binding.radioall.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                                           @Override
                                                           public void onCheckedChanged(RadioGroup group, int checkedId)
                                                           {
                                                               RadioButton radioButton = (RadioButton) findViewById(checkedId);
                                                               Toast.makeText(getBaseContext(), radioButton.getText(), Toast.LENGTH_SHORT).show();
                                                           }
                                                       }
           );
           binding.textcontinue.setOnClickListener(view -> {
               startActivity(new Intent(CategoriesActivity.this,HomeActivity.class));
           });
       }

       binding.backimg.setOnClickListener(view -> onBackPressed());




    }
}