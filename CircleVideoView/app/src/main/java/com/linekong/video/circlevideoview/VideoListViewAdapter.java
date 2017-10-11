package com.linekong.video.circlevideoview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.volokh.danylo.video_player_manager.manager.VideoPlayerManager;

import java.util.List;

public class VideoListViewAdapter extends BaseAdapter {

    private final VideoPlayerManager mVideoPlayerManager;
    private final List<BaseVideoItem> mList;
    private final Context mContext;

    public VideoListViewAdapter(VideoPlayerManager videoPlayerManager, Context context, List<BaseVideoItem> list){
        mVideoPlayerManager = videoPlayerManager;
        mContext = context;
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        BaseVideoItem videoItem = mList.get(position);

        View resultView;
        if(convertView == null){

            resultView = videoItem.createView(parent, mContext.getResources().getDisplayMetrics().widthPixels);
        } else {
            resultView = convertView;
        }

        videoItem.update(position, (VideoViewHolder) resultView.getTag(), mVideoPlayerManager);
        /**--------------开始初始化TextView控件的点击事件--------------*/
        VideoViewHolder videoViewHolder = (VideoViewHolder) resultView.getTag();
        videoViewHolder.mTvWifiLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapterListener.loadWifiVideo(position);
            }
        });
        videoViewHolder.mTvWifiLoad.setVisibility(View.INVISIBLE);
        /**--------------初始化TextView控件的点击事件完成--------------*/
        return resultView;
    }

    public interface AdapterListener{

        public void loadWifiVideo(int position);

    }
    private AdapterListener adapterListener = null ;

    public void setAdapterListener(AdapterListener mVideoAdapterListener) {
        this.adapterListener = mVideoAdapterListener;
    }

}
