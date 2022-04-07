package com.axat.starbarn.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.axat.starbarn.R;
import com.axat.starbarn.activity.Challenge.Challenge_request_Activity;
import com.axat.starbarn.activity.HomeActivity;
import com.axat.starbarn.fragment.home.HomeFragment;
import com.axat.starbarn.model.VideoItem;
import com.axat.starbarn.service.OnSwipeTouchListener;

import java.util.List;

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.VideoViewHolder> {
    private List<VideoItem> mVideoItems;
    Context mContext;
    OnSwipeTouchListener onSwipeTouchListener;


    public VideosAdapter(List<VideoItem> videoItems) {
        mVideoItems = videoItems;


    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new VideoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_videos_container, parent, false));
//        View view = .inflate(R.layout.testclassfragment, container, false);
//        ImageView imageView = (ImageView) view.findViewById(R.id.my_image);
//        return view;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {

        holder.setVideoData(mVideoItems.get(position));

//        swipeTouchListener=new OnSwipeTouchListener(holder.playBtn.getContext(),holder.videoconst);



        holder.challengeimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(v.getContext(), "clicked",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(v.getContext(), Challenge_request_Activity.class);
                v.getContext().startActivity(intent);
            }
        });
        holder.shareimg.setOnClickListener(view -> {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "Here is the share content body";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            holder.shareimg.getContext().startActivity(Intent.createChooser(sharingIntent, "Share via"));
        });
        holder.saveimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.saveimg.setImageResource(R.drawable.save1);
            }
        });
        holder.videoconst.requestDisallowInterceptTouchEvent(true);

        holder.videoconst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(  holder.videoconst.getContext(), "TOP SWIPE", Toast.LENGTH_SHORT).show();
            }
        });

        holder.videoconst.setOnTouchListener(new OnSwipeTouchListener() {
            public boolean onSwipeTop() {
                Toast.makeText(holder.videoconst.getContext(), "top", Toast.LENGTH_SHORT).show();
                return true;
            }
            public boolean onSwipeRight() {
//                Toast.makeText(holder.videoconst.getContext(), "right", Toast.LENGTH_SHORT).show();
                View layout = LayoutInflater.from(holder.videoconst.getContext()).inflate(R.layout.toastdislike, null);

                Toast toast = new Toast(holder.videoconst.getContext());
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(layout);
                toast.show();
                return true;
            }
            public boolean onSwipeLeft() {
//                Toast.makeText(holder.videoconst.getContext(), "left", Toast.LENGTH_SHORT).show();
                View layout = LayoutInflater.from(holder.videoconst.getContext()).inflate(R.layout.toastlike, null);

                Toast toast = new Toast(holder.videoconst.getContext());
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(layout);
                toast.show();
                return true;
            }
            public boolean onSwipeBottom() {
                Toast.makeText(holder.videoconst.getContext(), "bottom", Toast.LENGTH_SHORT).show();
                return true;
            }
        });






//



//        holder.videoconst.setOnTouchListener(new OnSwipeTouchListener(holder.videoconst.getContext(),holder.videoconst) {
////            public void onSwipeTop() {
////                Toast.makeText(holder.videoconst.getContext(), "top", Toast.LENGTH_SHORT).show();
////            }
////
////            public void onSwipeRight() {
////
////                View layout = LayoutInflater.from(holder.videoconst.getContext()).inflate(R.layout.toastdislike, null);
////
////                Toast toast = new Toast(holder.videoconst.getContext());
////                toast.setGravity(Gravity.CENTER, 0, 0);
////                toast.setDuration(Toast.LENGTH_SHORT);
////                toast.setView(layout);
////            }
////                toast.show();
////
////            public void onSwipeLeft() {
////
////                View layout = LayoutInflater.from(holder.videoconst.getContext()).inflate(R.layout.toastlike, null);
////
////                Toast toast = new Toast(holder.videoconst.getContext());
////                toast.setGravity(Gravity.CENTER, 0, 0);
////                toast.setDuration(Toast.LENGTH_SHORT);
////                toast.setView(layout);
////                toast.show();
////            }
////
////            public void onSwipeBottom() {
////
////                Toast.makeText(holder.videoconst.getContext(), "bottom", Toast.LENGTH_SHORT).show();
////            }
//
//        });





    }

    @Override
    public int getItemCount() {
        return mVideoItems.size();
    }

    static class VideoViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout videoconst;
        ImageView animateimagedisliked, animateimageliked, shareimg;
        VideoView mVideoView;
        TextView txtTitle, txtDesc;
        ProgressBar mProgressBar;
        ImageView challengeimg;
        ImageView saveimg;
        ImageView playBtn;
        HomeActivity.SwipeListener swipeListener;
        public float x1, x2, y1, y2;
        GestureDetector gestureDetector;
        OnSwipeTouchListener onSwipeTouchListener1;


        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            shareimg = itemView.findViewById(R.id.shareimg);
            animateimagedisliked = itemView.findViewById(R.id.animateimagedisliked);
            animateimageliked = itemView.findViewById(R.id.animateimageliked);
            videoconst = itemView.findViewById(R.id.videoconst);
            mVideoView = itemView.findViewById(R.id.videoView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtDesc = itemView.findViewById(R.id.txtDesc);
            mProgressBar = itemView.findViewById(R.id.progressBar);
            challengeimg = itemView.findViewById(R.id.challengeimg);
            saveimg = itemView.findViewById(R.id.saveimg);
            playBtn = itemView.findViewById(R.id.playBtn);

            videoconst.setLongClickable(true);
            videoconst.setClickable(true);











//            onSwipeTouchListener = new OnSwipeTouchListener(playBtn.getContext(),itemView.findViewById(R.id.videoconst));

//            swipeListener=new HomeActivity().SwipeListener(videoconst);

        }



        void setVideoData(VideoItem videoItem){
            txtTitle.setText(videoItem.videoTitle);
            txtDesc.setText(videoItem.videoDesc);
            mVideoView.setVideoPath(videoItem.videoURL);
            mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mProgressBar.setVisibility(View.GONE);
                    mp.start();
//                    swipeListener=new HomeFragment.SwipeListener(videoconst);




//                    float videoRatio = mp.getVideoWidth() / (float)mp.getVideoHeight();
//                    float screenRatio = mVideoView.getWidth() / (float)mVideoView.getHeight();
//                    float scale  = videoRatio / screenRatio;
//                    if (scale >= 1f){
//                        mVideoView.setScaleX(scale);
//                    }else {
//                        mVideoView.setScaleY(1f / scale);
//                    }
                }
            });
            mVideoView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {

//                    swipeListener=new HomeFragment.SwipeListener(videoconst);
//                    onSwipeTouchListener1=new OnSwipeTouchListener(mVideoView.getContext());
                    playBtn.setVisibility(View.VISIBLE);
                    mVideoView.pause();


//



                    return false;
                }
            });

//            videoconst.setOnTouchListener(new OnSwipeTouchListener(videoconst.getContext()));


            playBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mVideoView.isPlaying()){
                        mVideoView.pause();
                        playBtn.setVisibility(View.VISIBLE);
                    }else {
                        mVideoView.start();
                        playBtn.setVisibility(View.INVISIBLE);
                    }

                }
            });

            mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.start();
                }
            });




        }


    }
}