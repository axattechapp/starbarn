package com.axat.starbarn.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.DatabaseUtils;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.axat.starbarn.R;
import com.axat.starbarn.RealPathUtil;
import com.axat.starbarn.activity.VideoDetails.VideoDetailActivity;
import com.axat.starbarn.databinding.ActivityImageUploadBinding;

import java.io.FileNotFoundException;

public class ImageUploadActivity extends AppCompatActivity {
    ActivityImageUploadBinding binding;
    String imageurl = "";
    String name="";
    private static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 1;
    private static final Integer REQUEST_SHERGIL = 1234;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_image_upload);

        binding.backimg.setOnClickListener(view -> {
            onBackPressed();
        });
        Intent intent=getIntent();
         name=intent.getStringExtra("name");
        binding.cameraimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(binding.getRoot().getContext(),
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {


                    ActivityCompat.requestPermissions(ImageUploadActivity.this,
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                            MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
                } else {
//                    Intent intent = new Intent();
//                    intent.setType("image/*");
//                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    pickIntent.setType("image/*");

                    startActivityForResult(pickIntent, 10);


                }
            }
        });
        binding.textcontinue.setOnClickListener(view -> {
            Log.e("profile",imageurl);
            Log.e("name",name);

            Intent intent1=new Intent(ImageUploadActivity.this, CategoriesActivity.class);
            intent1.putExtra("activity",2);
            intent1.putExtra("profile",imageurl);
            intent1.putExtra("name",name);
            startActivity(intent1);
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 && resultCode == RESULT_OK)
        {
            Uri uri=data.getData();


            if (Build.VERSION.SDK_INT < 11)
            {
                imageurl = RealPathUtil.getRealPathFromURI_BelowAPI11(binding.getRoot().getContext(), uri);
            }
            // SDK >= 11 && SDK < 19
            else if (Build.VERSION.SDK_INT < 19)
            {
                imageurl = RealPathUtil.getRealPathFromURI_API11to18(binding.getRoot().getContext(), uri);
            }
            // SDK > 19 (Android 4.4)
            else
            {
                imageurl = RealPathUtil.getRealPathFromURI_API19(binding.getRoot().getContext(), uri);
            }
            Log.e("path", "File Path: " + imageurl);
            Bitmap bitmap= null;
            try {
                bitmap = BitmapFactory.decodeStream(this.getContentResolver().openInputStream(uri));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            binding.profileimg.setImageBitmap(bitmap);
//

        }
    }
}