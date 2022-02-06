package com.axat.starbarn.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
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
import com.axat.starbarn.model.VideoItem;
import com.axat.starbarn.service.OnSwipeTouchListener;

import java.util.List;

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.VideoViewHolder> {
    private List<VideoItem> mVideoItems;
    Context mContext;

    public VideosAdapter(List<VideoItem> videoItems, Context context) {
        mVideoItems = videoItems;
        mContext=context;

    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_videos_container, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.setVideoData(mVideoItems.get(position),mContext);


        holder.shareimg.setOnClickListener(view -> {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "Here is the share content body";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            holder.shareimg.getContext().startActivity(Intent.createChooser(sharingIntent, "Share via"));
        });

        holder.videoconst.setOnTouchListener(new OnSwipeTouchListener(holder.videoconst.getContext()) {
            public void onSwipeTop() {
                Toast.makeText(holder.videoconst.getContext(), "top", Toast.LENGTH_SHORT).show();
            }

            public void onSwipeRight() {

                View layout = LayoutInflater.from(holder.videoconst.getContext()).inflate(R.layout.toastdislike, null);

                Toast toast = new Toast(holder.videoconst.getContext());
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(layout);
                toast.show();
            }

            public void onSwipeLeft() {

                View layout = LayoutInflater.from(holder.videoconst.getContext()).inflate(R.layout.toastlike, null);

                Toast toast = new Toast(holder.videoconst.getContext());
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(layout);
                toast.show();
            }

            public void onSwipeBottom() {

                Toast.makeText(holder.videoconst.getContext(), "bottom", Toast.LENGTH_SHORT).show();
            }

        });


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
        }


        void setVideoData(VideoItem videoItem,Context context) {
            txtTitle.setText(videoItem.videoTitle);
            txtDesc.setText(videoItem.videoDesc);
            try {
                //Attach a media controller to video view
//                MediaController mediaController = new MediaController(context);
//                mVideoView.setMediaController(mediaController);
//                mediaController.setAnchorView(mVideoView);

                //add your video URL
                Uri  uri = Uri.parse(videoItem.videoURL);


                mVideoView.setVideoURI(uri);
                mVideoView.requestFocus();
                mVideoView.start();

            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }

//            mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//                public void onPrepared(MediaPlayer mp) {
//
//                }
//            });
            Log.e("videopath",videoItem.videoURL);
//            mVideoView.setVideoPath(videoItem.videoURL);
//            mVideoView.start();
            mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mProgressBar.setVisibility(View.GONE);
                    mVideoView.start();
                    mp.start();

                    float videoRatio = mp.getVideoWidth() / (float) mp.getVideoHeight();
                    float screenRatio = mVideoView.getWidth() / (float) mVideoView.getHeight();
                    float scale = videoRatio / screenRatio;
                    if (scale >= 1f) {
                        mVideoView.setScaleX(scale);
                    } else {
                        mVideoView.setScaleY(1f / scale);
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
