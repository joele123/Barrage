package com.example.zhoule.barragedemo.view;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import com.example.zhoule.barragedemo.R;

import java.io.IOException;

/**
 * Created by zhoule on 2018/7/12.
 */

public class MediaPlayerView extends RelativeLayout {


    private MediaPlayer mediaPlayer;
    private VideoView videoView;

    public MediaPlayerView(Context context) {
        super(context);
    }

    public MediaPlayerView(Context context, AttributeSet attrs) {
        super(context, attrs);

        setView(context);
    }

    private void setView(Context context) {

        View view = LayoutInflater.from(context).inflate(R.layout.layout_media, null);
        videoView = view.findViewById(R.id.video);
        addView(view);

    }

    public void setUrl(Context context, int rID){

        videoView.setVideoURI(Uri.parse("android.resource://" + context.getPackageName() + "/" + rID));
        videoView.start();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {

                mp.start();
                mp.setLooping(true);

            }
        });
    }
}
