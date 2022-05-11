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
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);

                    startActivityForResult(intent, REQUEST_SHERGIL);


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
        if (requestCode==REQUEST_SHERGIL && resultCode == Activity.RESULT_OK && data != null)
        {


            Uri uri=data.getData();
//             imageFile = new File(path.getPath());
//             imageurl=path.getPath().toString();
//               imageurl= new File(getRealPathFromURI(path));
//            imageurl = getRealPathFromUri(requireActivity(),path);

//            imageurl= RealPathUtil.getRealPath(binding.getRoot().getContext(),uri);
//            Log.e("imgUrlResult","i"+imageurl);
//            String path = getRealPathFromURI(getActivity(), uri);
//            if (imageurl==null)
//            {
//
//            }
//            imageurl=getImagePathFromInputStreamUri(uri);
            String path = null;
            if (Build.VERSION.SDK_INT < 11)
            {
                imageurl = RealPathUtil.getRealPathFromURI_BelowAPI11(ImageUploadActivity.this, uri);
            }
            // SDK >= 11 && SDK < 19
            else if (Build.VERSION.SDK_INT < 19)
            {
                imageurl = RealPathUtil.getRealPathFromURI_API11to18(ImageUploadActivity.this, uri);
            }
            // SDK > 19 (Android 4.4)
            else
            {
                imageurl = RealPathUtil.getRealPathFromURI_API19(ImageUploadActivity.this, uri);
            }

            Log.e("path", "File Path: " + imageurl);
            // Get the file instance
//            File file = new File(path);
            Log.e("imgUrlResult","i"+imageurl);

//            Log.e("Check", "URI Path : " + uri.getPath());
//            Log.e("Check", "Real Path : " + path);


//            File file = new File(path.getPath());
//            RequestBody requestFile=RequestBody.create(MediaType.parse("multipart/form-data"), file);
//             body = try {
////                bitmap=MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(),path);
////
////               UploadImage();
////            } catch (IOException e) {
////                e.printStackTrace();
////            }MultipartBody.Part.createFormData("image", file.getName(), requestFile);

            Bitmap bitmap= null;
            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            binding.profileimg.setImageBitmap(bitmap);
//

        }
    }
}