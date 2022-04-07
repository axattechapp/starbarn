package com.axat.starbarn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.axat.starbarn.Instructions.Instructions2Activity;
import com.axat.starbarn.Instructions.InstructionsActivity1;
import com.axat.starbarn.R;
import com.axat.starbarn.ToastDislikeActivity;
import com.axat.starbarn.ToastLikeActivity;
import com.axat.starbarn.databinding.ActivityHomeBinding;
import com.axat.starbarn.service.OnSwipeTouchListener;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;


public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding binding;
     SwipeListener swipeListener;
//    OnSwipeTouchListener onSwipeTouchListener;

    private NavController navController;

    private NavHostFragment navHostFragment;
    public float x1, x2, y1, y2;
//    InstructionsActivity1.SwipeListener swipeListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);





        setupBottomNavigation();

//        swipeListener1=new SwipeListener(binding.mainContainer);
        Menu navView = binding.mainNavigation.getMenu();
        navView.findItem(R.id.navigation_upload).setIcon(R.drawable.upload);
        //Add custom tab menu
        BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) binding.mainNavigation.getChildAt(0);

        View view = bottomNavigationMenuView.getChildAt(2);

        BottomNavigationItemView itemView = (BottomNavigationItemView) view;

        View viewCustom = LayoutInflater.from(this).inflate(R.layout.uploadvideocustom, bottomNavigationMenuView, false);
        itemView.addView(viewCustom);


//        swipeListener=new SwipeListener(binding.mainContainer);

//        binding.scroll.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SwipeListener= new SwipeListener(binding.scroll);
//
//            }
//        });

//        swipeListener=new SwipeListener(binding.mainContainer);



//        onSwipeTouchListener = new OnSwipeTouchListener(HomeActivity.this, findViewById(R.id.main));

//        binding.mainContainer.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch (event.getAction()) {
//
//                    case MotionEvent.ACTION_DOWN:
//                        x1 = event.getX();
//                        y1 = event.getY();
////                t1 = System.currentTimeMillis();
//                        return true;
//                    case MotionEvent.ACTION_UP:
//                        x2 = event.getX();
//                        y2 = event.getY();
////                t2 = System.currentTimeMillis();
//
//                        if (x1 > x2) {
//                            Toast.makeText(v.getContext(), "Left swipe", Toast.LENGTH_SHORT).show();
//                        } else if (x2 > x1) {
//                            Toast.makeText(v.getContext(), "Right swipe", Toast.LENGTH_SHORT).show();
//                        }
//
//
//                        return true;
//                }
//                return false;
//            }
//        });


    }
    public class SwipeListener implements View.OnTouchListener {

        GestureDetector gestureDetector;



        public SwipeListener(View view) {
            int threshold = 100;
            int velocity_threshold = 100;

            GestureDetector.SimpleOnGestureListener listener = new GestureDetector.SimpleOnGestureListener() {
                /*@Override
                public boolean onDown(MotionEvent e) {
                    return true;
                }*/

                @Override
                public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {


                    try {
                        float xDiff = e2.getX() - e1.getX();
                        float yDiff = e2.getY() - e1.getY();
                        if (Math.abs(xDiff) > Math.abs(yDiff)) {
                            if (Math.abs(xDiff) > threshold && Math.abs(velocityX) > velocity_threshold) {
                                if (xDiff > 0) {
                                    Log.e("swiped", "right");
//                                    Intent intent=new Intent(InstructionsActivity1.this, CategoriesActivity.class);
//                                    startActivity(intent);

                                } else {
                                    Log.e("swiped", "Left");
//                                    Intent intent=new Intent(InstructionsActivity1.this,Instructions2Activity.class);
//                                    startActivity(intent);
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
                        Toast.makeText(HomeActivity.this, "msg"+exception.getMessage(), Toast.LENGTH_SHORT).show();   Toast.makeText(HomeActivity.this, "msg"+exception.getMessage(), Toast.LENGTH_SHORT).show();

                    }


                    return false;



                }
            };
            gestureDetector = new GestureDetector(HomeActivity.this,listener);
            view.setOnTouchListener(this);


        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return gestureDetector.onTouchEvent(event);
        }
    }


    private void setupBottomNavigation() {

        navHostFragment = (NavHostFragment)
                getSupportFragmentManager()
                        .findFragmentById(R.id.main_container);

        if (navHostFragment != null) {

            navController = navHostFragment.getNavController();

            NavigationUI.setupWithNavController(binding.mainNavigation, navController);


        }

    }

//    public boolean onTouchEvent(MotionEvent touchevent)
//    {
//        Log.d("onTouch", "onTouch " + touchevent);
//        switch (touchevent.getAction())
//        {
//            // when user first touches the screen we get x and y coordinate
//            case MotionEvent.ACTION_DOWN:
//            {
//                x1 = touchevent.getX();
//                y1 = touchevent.getY();
//                break;
//            }
//            case MotionEvent.ACTION_UP:
//            {
//                x2 = touchevent.getX();
//                y2 = touchevent.getY();
//
//                //if left to right sweep event on screen
//                if (x1 < x2)
//                {
//                    Toast.makeText(this, "Left to Right Swap Performed", Toast.LENGTH_LONG).show();
//                }
//
//                // if right to left sweep event on screen
//                if (x1 > x2)
//                {
//                    Toast.makeText(this, "Right to Left Swap Performed", Toast.LENGTH_LONG).show();
//                }
//
//                // if UP to Down sweep event on screen
//
//                break;
//            }
//        }
//        return false;
//    }
//







}