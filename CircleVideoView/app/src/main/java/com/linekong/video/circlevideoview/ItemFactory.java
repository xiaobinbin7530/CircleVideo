package com.linekong.video.circlevideoview;

import android.app.Activity;

import com.squareup.picasso.Picasso;
import com.volokh.danylo.video_player_manager.manager.VideoPlayerManager;
import com.volokh.danylo.video_player_manager.meta.MetaData;

import java.io.IOException;

public class ItemFactory {


    public static BaseVideoItem createItemFromLocalFile(String title, String vidieoFilePath, String imageUrl, Activity activity, VideoPlayerManager<MetaData> videoPlayerManager) throws IOException {
        return new LocalVideoItem(title,vidieoFilePath ,videoPlayerManager, Picasso.with(activity), imageUrl);
    }
}
