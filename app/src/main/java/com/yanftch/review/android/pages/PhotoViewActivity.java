package com.yanftch.review.android.pages;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.yanftch.review.R;
import com.yanftch.review.android.utils.DragCloseHelper;

/**
 * https://blog.csdn.net/u013700040/article/details/88665314
 * https://blog.csdn.net/longsh_/article/details/54839452
 * https://github.com/githubwing/DragPhotoView
 */
public class PhotoViewActivity extends AppCompatActivity {

    private ImageView mImageView;
    private String mImgUrl;

    private static final int DURATION = 250;
    //开始的坐标值
    private int startY;
    private int startX;
    //开始的宽高
    private int startWidth;
    private int startHeight;
    //X、Y的移动距离
    private int xDelta;
    private int yDelta;
    //X、Y的缩放比例
    private float mWidthScale;
    private float mHeightScale;
    //背景色
    private ColorDrawable colorDrawable;
    private ConstraintLayout mConstraintLayout;
    DragCloseHelper dragCloseHelper;

    public static void startActivity(Activity activity, String imgUrl, int x, int y, int width, int height) {
        Intent intent = new Intent(activity, PhotoViewActivity.class);
        intent.putExtra("url", imgUrl);
        intent.putExtra("x", x);
        intent.putExtra("y", y);
        intent.putExtra("width", width);
        intent.putExtra("height", height);
        activity.startActivity(intent);
        activity.overridePendingTransition(0, 0);
    }

    @SuppressLint("LongLogTag")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_photo_view);
        //设置背景色，后面需要为其设置渐变动画
        colorDrawable = new ColorDrawable(ContextCompat.getColor(this, R.color.black));


        mImageView = findViewById(R.id.iv_image);
        mConstraintLayout = findViewById(R.id.cl_container);
        mConstraintLayout.setBackgroundDrawable(colorDrawable);


        mImgUrl = getIntent().getStringExtra("url");
        startX = getIntent().getIntExtra("x", 0);
        startY = getIntent().getIntExtra("y", 0);
        startWidth = getIntent().getIntExtra("width", 0);
        startHeight = getIntent().getIntExtra("height", 0);
        Log.e("debug_PhotoViewActivity:", "onCreate==> " + "x = " + startX + ", y = " + startY + ", width = " + startWidth + ", height = " + startHeight);


        mImageView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                mImageView.getViewTreeObserver().removeOnPreDrawListener(this);
                //坐标的获取设置
                int[] screenLocation = new int[2];
                mImageView.getLocationOnScreen(screenLocation);
                xDelta = startX - screenLocation[0];
                yDelta = startY - screenLocation[1];

                // 计算缩放比例
                mWidthScale = (float) startWidth / mImageView.getWidth();
                mHeightScale = (float) startHeight / mImageView.getHeight();
                //开启缩放动画
                enterAnimation();
                return true;
            }
        });
        Glide.with(this).load(mImgUrl).into(mImageView);


         dragCloseHelper = new DragCloseHelper(this);
        dragCloseHelper.setDragCloseViews(mConstraintLayout, mImageView);
        dragCloseHelper.setDragCloseListener(new DragCloseHelper.DragCloseListener() {
            @Override
            public boolean intercept() {
                return false;
            }

            @Override
            public void dragStart() {

            }

            @Override
            public void dragging(float percent) {

            }

            @Override
            public void dragCancel() {

            }

            @Override
            public void dragClose(boolean isShareElementMode) {

            }
        });

    }

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        if (dragCloseHelper.handleEvent(ev)) {
//            return true;
//        }
//        return super.dispatchTouchEvent(ev);
//    }

    //进入动画
    public void enterAnimation() {
        //设置imageview动画的初始值
        mImageView.setPivotX(0);
        mImageView.setPivotY(0);
        mImageView.setScaleX(mWidthScale);
        mImageView.setScaleY(mHeightScale);
        mImageView.setTranslationX(xDelta);
        mImageView.setTranslationY(yDelta);
        //设置动画
        TimeInterpolator sDecelerator = new DecelerateInterpolator();
        //设置imageview缩放动画，以及缩放开始位置
        mImageView.animate().setDuration(DURATION).scaleX(1).scaleY(1).
                translationX(0).translationY(0).setInterpolator(sDecelerator);

        // 设置activity主布局背景颜色DURATION毫秒内透明度从透明到不透明
        ObjectAnimator bgAnim = ObjectAnimator.ofInt(colorDrawable, "alpha", 0, 255);
        bgAnim.setDuration(DURATION);
        bgAnim.start();
    }

    public void exitAnimation(final Runnable endAction) {

        TimeInterpolator sInterpolator = new AccelerateInterpolator();
        //设置imageview缩放动画，以及缩放结束位置
        mImageView.animate().setDuration(DURATION).scaleX(mWidthScale).scaleY(mHeightScale).
                translationX(xDelta).translationY(yDelta)
                .setInterpolator(sInterpolator).withEndAction(endAction);

        // 设置activity主布局背景颜色DURATION毫秒内透明度从不透明到透明
        ObjectAnimator bgAnim = ObjectAnimator.ofInt(colorDrawable, "alpha", 0);
        bgAnim.setDuration(DURATION);
        bgAnim.start();
    }


    @Override
    public void onBackPressed() {
        exitAnimation(new Runnable() {
            public void run() {
                finish();
                //取消activity动画
                overridePendingTransition(0, 0);
            }
        });
    }

    //    private void enterAnimation(final Runnable enterAction) {
//        //放大动画
//        curPhotoView.setPivotX(0);
//        curPhotoView.setPivotY(0);
//        curPhotoView.setScaleX(mWidthScale);
//        curPhotoView.setScaleY(mHeightScale);
//        curPhotoView.setTranslationX(xDelta);
//        curPhotoView.setTranslationY(yDelta);
//        TimeInterpolator sDecelerator = new DecelerateInterpolator();
//        curPhotoView.animate().setDuration(DURATION).scaleX(1).scaleY(1).
//                translationX(0).translationY(0).setInterpolator(sDecelerator).withEndAction(enterAction);
//        //设置背景渐变成你设置的颜色
//        ObjectAnimator bgAnim = ObjectAnimator.ofInt(colorDrawable, "alpha", 0, 255);
//        bgAnim.setDuration(DURATION);
//        bgAnim.start();
//    }
}
