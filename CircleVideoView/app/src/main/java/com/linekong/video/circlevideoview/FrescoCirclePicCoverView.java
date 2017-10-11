package com.linekong.video.circlevideoview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class FrescoCirclePicCoverView extends View {


    public FrescoCirclePicCoverView(Context context) {
        super(context);

        init();
    }

    public FrescoCirclePicCoverView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FrescoCirclePicCoverView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private Paint mPaint;
    private float Radius = 0;
    //    private int CoverColor = Color.parseColor("#c8e3f1");
      private int CoverColor = Color.parseColor("#ffffff");
//    private int CoverColor = Color.parseColor("#000000");

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(CoverColor);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int Vwidth = getWidth();
        int Vheight = getHeight();

        Radius = Math.max(Vwidth, Vheight) / 2;

        float Cx = Vwidth / 2;
        float Cy = Vheight / 2;

        Path path = new Path();

        path.moveTo(0, 0);
        path.lineTo(0, Vheight);
        path.lineTo(Vwidth, Vheight);
        path.lineTo(Vwidth, 0);
        path.lineTo(Vwidth / 2, 0);

        path.lineTo(Vwidth / 2, Vheight / 2 - Cy);
        path.addCircle(Cx, Cy, Radius, Path.Direction.CW);
        path.lineTo(Vwidth / 2, 0);

        canvas.drawPath(path, mPaint);

    }

}
