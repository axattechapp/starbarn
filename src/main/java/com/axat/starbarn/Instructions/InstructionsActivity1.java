package com.axat.starbarn.Instructions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.axat.starbarn.R;
import com.axat.starbarn.activity.CategoriesActivity;
import com.axat.starbarn.activity.HomeActivity;
import com.axat.starbarn.databinding.ActivityInstructions1Binding;

public class InstructionsActivity1 extends AppCompatActivity {
    ActivityInstructions1Binding binding;
//    HomeActivity.SwipeListener swipeListener;
    SwipeListener swipeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_instructions1);
//        setContentView(R.layout.activity_instructions1);

//      swipeListener=new HomeActivity.SwipeListener(binding.instruLayout);
        binding.skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InstructionsActivity1.this,Instructions2Activity.class));
            }
        });
        binding.rightarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InstructionsActivity1.this,Instructions2Activity.class));
            }
        });
        binding.leftarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onBackPressed();
            }
        });
//        swipeListener=new SwipeListener(binding.scroll2);

    }
    public class SwipeListener implements View.OnTouchListener {

        GestureDetector gestureDetector;



        public SwipeListener(View view) {
            int threshold = 100;
            int velocity_threshold = 100;

            GestureDetector.SimpleOnGestureListener listener = new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onDown(MotionEvent e) {
                    return true;
                }

                @Override
                public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {


                       try {
                           float xDiff = e2.getX() - e1.getX();
                           float yDiff = e2.getY() - e1.getY();
                           if (Math.abs(xDiff) > Math.abs(yDiff)) {
                               if (Math.abs(xDiff) > threshold && Math.abs(velocityX) > velocity_threshold) {
                                   if (xDiff > 0) {
                                       Log.e("swiped", "right");
                                       Intent intent=new Intent(InstructionsActivity1.this, CategoriesActivity.class);
                                       startActivity(intent);

                                   } else {
                                       Log.e("swiped", "Left");
                                       Intent intent=new Intent(InstructionsActivity1.this,Instructions2Activity.class);
                                       startActivity(intent);
                                   }
                                   return true;
                               }

                           } else {
                               if (Math.abs(yDiff) > threshold && Math.abs(velocityY) > velocity_threshold) {
                                   if (yDiff > 0) {
                                       Log.e("swiped", "Down");
                                   } else {
                                       Log.e("swiped", "Up");
                                   }
                                   return true;
                               }
                           }
                       }catch (Exception exception) {
                           Log.e("swiped","s"+exception.getMessage());
                           exception.printStackTrace();
                           Toast.makeText(InstructionsActivity1.this, "msg"+exception.getMessage(), Toast.LENGTH_SHORT).show();   Toast.makeText(InstructionsActivity1.this, "msg"+exception.getMessage(), Toast.LENGTH_SHORT).show();

                       }


                    return false;



                }
            };
            gestureDetector = new GestureDetector(InstructionsActivity1.this,listener);
            view.setOnTouchListener(this);


        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return gestureDetector.onTouchEvent(event);
        }
    }
    

}