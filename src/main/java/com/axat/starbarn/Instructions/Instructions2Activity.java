package com.axat.starbarn.Instructions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.axat.starbarn.R;
import com.axat.starbarn.activity.HomeActivity;
import com.axat.starbarn.databinding.ActivityInstructions2Binding;

public class Instructions2Activity extends AppCompatActivity {
    ActivityInstructions2Binding binding;
    SwipeListener swipeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(Instructions2Activity.this,R.layout.activity_instructions2);

        binding.rightarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Instructions2Activity.this, HomeActivity.class));
            }
        });
//        setContentView(R.layout.activity_instructions2);

//        swipeListener= new SwipeListener(binding.instruLayout);
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
                                    Intent intent=new Intent(Instructions2Activity.this,InstructionsActivity1.class);
                                    startActivity(intent);

                                } else {
                                    Log.e("swiped", "Left");
                                    Intent intent=new Intent(Instructions2Activity.this,HomeActivity.class);
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
                    } catch (Exception exception) {
                        Log.e("swiped","s"+exception.getMessage());
                        exception.printStackTrace();
                        Toast.makeText(Instructions2Activity.this, "msg"+exception.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                    return false;


                }
            };
            gestureDetector = new GestureDetector(Instructions2Activity.this,listener);
            view.setOnTouchListener(this);


        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return gestureDetector.onTouchEvent(event);
        }
    }
}