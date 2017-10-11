package com.linekong.video.circlevideoview;

import android.view.View;

import com.squareup.picasso.Picasso;
import com.volokh.danylo.video_player_manager.Config;
import com.volokh.danylo.video_player_manager.manager.VideoPlayerManager;
import com.volokh.danylo.video_player_manager.meta.MetaData;
import com.volokh.danylo.video_player_manager.ui.VideoPlayerView;
import com.volokh.danylo.video_player_manager.utils.Logger;

public class LocalVideoItem extends BaseVideoItem{

    private static final String TAG = LocalVideoItem.class.getSimpleName();
    private static final boolean SHOW_LOGS = Config.SHOW_LOGS;

    private String mVideoFilePath;
    private String mTitle;

    private final Picasso mImageLoader;
    private final String mImageResource;

    public LocalVideoItem(String title, String vidieoFilePath, VideoPlayerManager<MetaData> videoPlayerManager, Picasso imageLoader, String imageUrl) {
        super(videoPlayerManager);
        mTitle = title;
        mVideoFilePath = vidieoFilePath;
        mImageLoader = imageLoader;
        mImageResource = imageUrl;
    }

    @Override
    public void update(int position, final VideoViewHolder viewHolder, VideoPlayerManager videoPlayerManager) {
        if(SHOW_LOGS) Logger.v(TAG, "update, position " + position);

        viewHolder.mTitle.setText(mTitle);
        viewHolder.mCover.setVisibility(View.VISIBLE);
        mImageLoader.load("file://"+mImageResource).into(viewHolder.mCover);
    }


    @Override
    public void playNewVideo(MetaData currentItemMetaData, VideoPlayerView player, VideoPlayerManager<MetaData> videoPlayerManager) {
        videoPlayerManager.playNewVideo(currentItemMetaData, player, mVideoFilePath);
    }

    @Override
    public void stopPlayback(VideoPlayerManager videoPlayerManager) {
        videoPlayerManager.stopAnyPlayback();
    }

    @Override
    public String toString() {
        return getClass() + ", mTitle[" + mTitle + "]";
    }
}
