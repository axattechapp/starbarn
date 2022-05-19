package com.axat.starbarn.fragment.home;

import static android.content.Context.MODE_PRIVATE;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.provider.SyncStateContract;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.axat.starbarn.Instructions.Instructions2Activity;
import com.axat.starbarn.Instructions.InstructionsActivity1;
import com.axat.starbarn.R;
import com.axat.starbarn.activity.CategoriesActivity;
import com.axat.starbarn.activity.HomeActivity;
import com.axat.starbarn.adapter.VideosAdapter;
import com.axat.starbarn.databinding.HomeFragmentBinding;
import com.axat.starbarn.model.CategoryModel;
import com.axat.starbarn.model.HomeVideoResponse;
import com.axat.starbarn.model.VideoItem;
import com.axat.starbarn.service.Api;
import com.axat.starbarn.service.OnSwipeTouchListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment  {

    private HomeViewModel mViewModel;
    HomeFragmentBinding binding;
//    HomeActivity.SwipeListener swipeListener;
//    InstructionsActivity1.SwipeListener listener;
    SwipeListener swipeListener;
    public float x1, x2, y1, y2;
    ViewPager2 viewPager;
    int SCROLLING_RIGHT = 0;
    int SCROLLING_LEFT = 1;
    int SCROLLING_UNDETERMINED = 2;
    float tempPositionOffset = 0;
    Api api;
    LayoutInflater inflater;


    int currentScrollDirection = 2;


    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        inflater.getContext().setTheme(R.style.FullScreen);
        binding = DataBindingUtil.inflate(inflater,R.layout.home_fragment,container,false);
//        View v = inflater.inflate(R.layout.home_fragment, container, false);
//       try {
//           binding.homelayout.setOnTouchListener(new OnSwipeTouchListener(getActivity()) {
//               public void onSwipeTop() {
//                   Toast.makeText(getActivity(), "TOP SWIPE", Toast.LENGTH_SHORT).show();
//               }
//
//               public void onSwipeRight() {
//                   Toast.makeText(getActivity(), "RIGHT SWIPE", Toast.LENGTH_SHORT).show();
//                   //go back to landing page
//                   // Intent intent = new Intent (getApplicationContext(), MainScreen.class);
//                   // startActivity (intent);
//               }
//
//
//               public void onSwipeLeft() {
//                   Toast.makeText(getActivity(), "LEFT SWIPE", Toast.LENGTH_SHORT).show();
//               }
//
//               public void onSwipeBottom() {
//                   Toast.makeText(getActivity(), "BOTTOM SWIPE", Toast.LENGTH_SHORT).show();
//               }
//           });
//
//       }catch (Exception e) {
//           Log.e("err0r", "e" + e.getMessage());
//       }




//        final GestureDetector gesture = new GestureDetector(getActivity(),
//                new GestureDetector.SimpleOnGestureListener() {
//
//                    @Override
//                    public boolean onDown(MotionEvent e) {
//                        return true;
//                    }
//
//                    @Override
//                    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
//                                           float velocityY) {
//                        Log.e("onFling", "onFling has been called!");
//                        final int SWIPE_MIN_DISTANCE = 120;
//                        final int SWIPE_MAX_OFF_PATH = 250;
//                        final int SWIPE_THRESHOLD_VELOCITY = 200;
//                        try {
//                            if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
//                                return false;
//                            if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE
//                                    && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
//                                Log.e("Right to Left", "Right to Left");
//                            } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
//                                    && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
//                                Log.i("Left to Right", "Left to Right");
//                            }
//                        } catch (Exception e) {
//                            // nothing
//                            Log.e("catch","c"+e.getMessage());
//                        }
//                        return super.onFling(e1, e2, velocityX, velocityY);
//                    }
//                });
//
//        v.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return gesture.onTouchEvent(event);
//            }
//        });



//        viewPager=v.findViewById(R.id.viewPagerVideos);
//        viewPager.setLayoutManager(new LinearLayoutManager(v.getContext()));



//        SwipeListener= new HomeActivity.SwipeListener(binding.mainContainer);
//        swipeListener=new SwipeListener(binding.homelayout);


//        return binding.getRoot();

        loadAllVideo();

        return binding.getRoot();
    }






    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);



//        swipeListener=new HomeActivity.SwipeListener(binding.homelayout);
//        listener=new InstructionsActivity1.SwipeListener(binding.homelayout);


//   viewPager.setOnTouchListener(new View.OnTouchListener() {
//       @Override
//       public boolean onTouch(View v, MotionEvent event) {
//           return false;
//       }
//   });


//
//        binding.homelayout.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent touchevent) {
//                Log.d("onTouch", "onTouch " + touchevent);
//                switch (touchevent.getAction())
//                {
//                    // when user first touches the screen we get x and y coordinate
//                    case MotionEvent.ACTION_DOWN:
//                    {
//                        x1 = touchevent.getX();
//                        y1 = touchevent.getY();
//                        return true;
//                    }
//                    case MotionEvent.ACTION_UP:
//                    {
//                        x2 = touchevent.getX();
//                        y2 = touchevent.getY();
//
//                        //if left to right sweep event on screen
//                        if (x1 < x2)
//                        {
//                            Toast.makeText(v.getContext(), "Left to Right Swap Performed", Toast.LENGTH_LONG).show();
//                        }
//
//                        // if right to left sweep event on screen
//                        if (x1 > x2)
//                        {
//                            Toast.makeText(v.getContext(), "Right to Left Swap Performed", Toast.LENGTH_LONG).show();
//                        }
//
//                        // if UP to Down sweep event on screen
//
//                        return true;
//                    }
//                }
//                return false;
//
//            }
//        });
    }



//    @Override
//    public void onPageScrolled(int i, float v, int i1) {
//        if (i == 0) {
//            if (tempPositionOffset < v) {
//                Log.d("eric", "scrolling left ...");
//            } else {
//                Log.d("eric", "scrolling right ...");
//            }
//
//            tempPositionOffset = v;
//
//            Log.d("eric", "position " + i + "; " + " positionOffset " + v + "; " + " positionOffsetPixels " + i1 + ";");
//        }
//
//    }
//
//
//
//
//
//    @Override
//    public void onPageSelected(int i) {
//
//
//
//    }
//
//    @Override
//    public void onPageScrollStateChanged(int i) {
//
//
//    }


    public static class SwipeListener implements View.OnTouchListener {

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
//                                    Intent intent=new Intent(Instructions2Activity.this,InstructionsActivity1.class);
//                                    startActivity(intent);
                                    View layout = LayoutInflater.from(view.getContext()).inflate(R.layout.toastlike, null);
                                    Toast toast = new Toast(view.getContext());
                                    toast.setGravity(Gravity.CENTER, 0, 0);
                                    toast.setDuration(Toast.LENGTH_SHORT);
                                    toast.setView(layout);
                                    toast.show();

                                } else {
                                    Log.e("swiped", "Left");
//                                    Intent intent=new Intent(Instructions2Activity.this,HomeActivity.class);
//                                    startActivity(intent);

                                    View layout = LayoutInflater.from(view.getContext()).inflate(R.layout.toastlike, null);
                                    Toast toast = new Toast(view.getContext());
                                    toast.setGravity(Gravity.CENTER, 0, 0);
                                    toast.setDuration(Toast.LENGTH_SHORT);
                                    toast.setView(layout);
                                    toast.show();

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
//                        Toast.makeText(Instructions2Activity.this, "msg"+exception.getMessage(), Toast.LENGTH_SHORT).show();

                    }

                    return false;

                }

            };
            gestureDetector = new GestureDetector(view.getContext(),listener);
            view.setOnTouchListener(this);


        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (gestureDetector.onTouchEvent(event)) {
                return true;
            } else {
                return false;
            }
        }

//        public static void showToast(){
//            View layout = LayoutInflater.from().inflate(R.layout.row_payment_gateway_item, null);
//            Toast toast = new Toast(HomeActivity.this);
//            toast.setGravity(Gravity.CENTER, 0, 0);
//            toast.setDuration(Toast.LENGTH_SHORT);
//            toast.setView(layout);
//            toast.show();
//        }
    }

    public void loadAllVideo(){
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
        inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        SharedPreferences sharedPreferences=getContext().getSharedPreferences("goat",MODE_PRIVATE);
        String token1=sharedPreferences.getString("token","");
        Log.e("token1","token1"+token1);
        Call<HomeVideoResponse> call = api.HomeAllVideo("Bearer "+token1);
        call.enqueue(new Callback<HomeVideoResponse>() {
            @Override
            public void onResponse(Call<HomeVideoResponse> call, Response<HomeVideoResponse> response) {
                if (response.code() == 200) {
                    List<VideoItem> videoItems = new ArrayList<>();



                    binding.viewPagerVideos.requestDisallowInterceptTouchEvent(true);
//        swipeListener=new SwipeListener(binding.homelayout);

                    HomeVideoResponse model= response.body();

                    Log.e("size",""+model.getData().size());
                   for(int i=0;i<model.getData().size();i++) {
                       VideoItem item = new VideoItem();
                       item.videoURL = model.getData().get(i).getMedia_url();
                       item.videoTitle = model.getData().get(i).getTitle();
                       item.videoDesc = model.getData().get(i).getDescription();
                       item.id = model.getData().get(i).getPost_id();
                       videoItems.add(item);
                   }





                    binding.viewPagerVideos.setAdapter(new VideosAdapter(videoItems,token1));

                } else
                    Toast.makeText(getContext(), "error" + response.message(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<HomeVideoResponse> call, Throwable t) {
                Toast.makeText(getContext(), "fail" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}