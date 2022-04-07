package com.axat.starbarn.activity.TakeVideo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.axat.starbarn.R;
import com.axat.starbarn.activity.VideoDetails.VideoDetailActivity;
import com.fxn.pix.Options;
import com.fxn.pix.Pix;
import com.fxn.utility.ImageQuality;
import com.fxn.utility.PermUtil;

import java.util.ArrayList;



public class PixxxxccActivity extends AppCompatActivity {
    ArrayList<String> returnValue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pixxxxcc);




        returnValue=new ArrayList<>();
        Options options = Options.init()
                .setRequestCode(100)
                .setCount(3)
                .setFrontfacing(false)
                .setPreSelectedUrls(returnValue)
                .setExcludeVideos(false)
                .setVideoDurationLimitinSeconds(30)
                .setScreenOrientation(Options.SCREEN_ORIENTATION_PORTRAIT)
                .setPath("/pix/images");

        Pix.start(PixxxxccActivity.this, options);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && requestCode == 100) {
            returnValue = data.getStringArrayListExtra(Pix.IMAGE_RESULTS);
            Log.e("returnValue","r"+returnValue.toString().replaceAll("(^\\[|\\]$)", ""));
            Intent intent=new Intent(PixxxxccActivity.this, VideoDetailActivity.class);
            intent.putExtra("path",returnValue.toString().replaceAll("(^\\[|\\]$)", ""));
            intent.putExtra("value",2);
            startActivity(intent);
        }

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PermUtil.REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Pix.start(PixxxxccActivity.this, Options.init().setRequestCode(100));
                } else {
                    Toast.makeText(PixxxxccActivity.this, "Approve permissions to open Pix ImagePicker", Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }
}