package com.yanftch.review.android.fragment.new_home;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.yanftch.review.R;

public class ArcLayout extends FrameLayout {
    private Paint mPaint;
    private PaintFlagsDrawFilter mDrawFilter;
    private PorterDuffXfermode mXfermode;
    private Path mPath;

    private int mArcHeight;
    private int mArcDirection;
    private int mArcOrientation;
    private int mArcOffsetX, mArcOffsetY;
    private int mArcSrc;

    public ArcLayout(Context context) {
        this(context, null);
    }

    public ArcLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ArcLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        initTypeArray(context, attrs);

        mPaint = new Paint();
        mPath = new Path();
        //画布抗锯齿
        mDrawFilter = new PaintFlagsDrawFilter(
                0, Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG
        );

        //启用硬件加速，否则会出现一些异常（比如黑边，设计器和模拟器可能依旧会存在黑边）
        setLayerType(View.LAYER_TYPE_HARDWARE, mPaint);
        /* 0=in：过滤上层图像（弧形部分）。1=out：过滤可见部分（弧形部分、可见的控件部分），即保留被弧形遮住的部分 */
        mXfermode = new PorterDuffXfermode(
                mArcDirection == 0 ? PorterDuff.Mode.DST_OUT : PorterDuff.Mode.DST_ATOP
        );
    }

    private void initTypeArray(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ArcLayout);

        //弧形的高度
        mArcHeight = typedArray.getDimensionPixelSize(R.styleable.ArcLayout_arcHeight, 50);
        //偏移X轴
        mArcOffsetX = typedArray.getDimensionPixelSize(R.styleable.ArcLayout_arcOffsetX, 0);
        //偏移Y轴
        mArcOffsetY = typedArray.getDimensionPixelSize(R.styleable.ArcLayout_arcOffsetY, 0);
        //默认在顶部
        mArcDirection = typedArray.getInt(R.styleable.ArcLayout_arcDirection, 1);
        //默认向外
        mArcOrientation = typedArray.getInt(R.styleable.ArcLayout_arcOrientation, 1);
        //背景图
        mArcSrc = typedArray.getResourceId(R.styleable.ArcLayout_arcSrc, -1);
        typedArray.recycle();
    }


//    /**
//     * 该方法会出现锯齿
//     * @param canvas
//     */
//    @Override
//    protected void onDraw(Canvas canvas) {
//        Region.Op op = arcDirection == 0 ? Region.Op.DIFFERENCE : Region.Op.INTERSECT;
//        //绘制弧形路径
//        drawArcPath();
//        canvas.setDrawFilter( mDrawFilter );
//        canvas.clipPath(mPath, op);
//        super.onDraw(canvas);
//    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        //消除画布的抗锯齿
        canvas.setDrawFilter(mDrawFilter);

        //绘制背景资源
        drawBackgroundResources(canvas);
        super.dispatchDraw(canvas);
        //获取绘制弧形部分的图片
        Bitmap arcBmp = getDrawArcBitmp();
        //绘制时消除绘制的弧形画布 (或者注释掉看效果就明白了)
        mPaint.setXfermode(mXfermode);
        //绘制最终的结果
        canvas.drawBitmap(arcBmp, 0, 0, mPaint);
    }

    /**
     * 绘制背景资源
     *
     * @param canvas 画布
     */
    private void drawBackgroundResources(Canvas canvas) {
        if (mArcSrc != -1) {
            Bitmap bmpBG = BitmapFactory.decodeResource(getResources(), mArcSrc);
            RectF rectF = new RectF(0, 0, getWidth(), bmpBG.getHeight());
            canvas.drawBitmap(bmpBG, null, rectF, null);
        }
    }

    /**
     * 绘制弧形部分的图片。
     * 因为用的一个paint，所以需要在设置{@link Paint#setXfermode(Xfermode)}之前获取弧形图片
     */
    private Bitmap getDrawArcBitmp() {
        //建立一个空白图片，在里边绘制弧形路径
        Bitmap arcBmp = Bitmap.createBitmap(
                getWidth(), getHeight(), Bitmap.Config.ARGB_8888
        );

        //建立画布
        Canvas canvas = new Canvas(arcBmp);
        //消除画布的抗锯齿
        canvas.setDrawFilter(mDrawFilter);
        //绘制弧形路径
        drawArcPath();
        //启用抗锯齿
        mPaint.setAntiAlias(true);
        //绘制路径
        canvas.drawPath(mPath, mPaint);
        return arcBmp;
    }

    /**
     * 绘制弧形路径
     */
    private void drawArcPath() {
        float x1 = (getWidth() / 2F) + mArcOffsetX;
        mPath.lineTo(0, getDirectionHeight());
        mPath.quadTo(x1, getArcYHeight(), getWidth(), getDirectionHeight());
        mPath.lineTo(getWidth(), 0);
        mPath.close();
    }

    /**
     * 绘制弧形的高度
     *
     * @return 根据绘制位置返回绘制高度
     */
    private int getDirectionHeight() {
        boolean isIn = mArcOrientation == 0;
        int defHeight = mArcHeight + mArcOffsetY;
        switch (mArcDirection) {
            case 0: //顶部绘制弧形
                return isIn ? 0 : defHeight;
            case 1: //底部绘制弧形
                return isIn ? getHeight() : getHeight() - defHeight;
        }
        return 0;
    }

    /**
     * 弧形Y轴高度（贝塞尔曲线凸/凹起部分的Y轴）
     *
     * @return 根据绘制位置返回Y轴高度
     */
    private int getArcYHeight() {
        //决定朝内还是朝外
        int defHeight = (mArcOrientation == 1 ? -mArcHeight : mArcHeight * 2) + mArcOffsetY;
        switch (mArcDirection) {
            case 0: //顶部绘制弧形
                return defHeight;
            case 1: //底部绘制弧形
                return getHeight() - defHeight;
        }
        return 0;
    }
}
