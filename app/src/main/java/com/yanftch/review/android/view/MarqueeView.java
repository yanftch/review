package com.yanftch.review.android.view;

import android.content.Context;

import androidx.annotation.AnimRes;

import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.yanftch.review.R;

import java.util.ArrayList;
import java.util.List;

public class MarqueeView extends ViewFlipper {
    private static final String TAG = "debug_MarqueeView";

    private int mInterval = 3000;
    private boolean mHasSetAnimDuration = false;
    private int mAnimDuration = 1000;

    private int mGravity = Gravity.LEFT | Gravity.CENTER_VERTICAL;
    private static final int GRAVITY_LEFT = 0;
    private static final int GRAVITY_CENTER = 1;
    private static final int GRAVITY_RIGHT = 2;

    private boolean mHasSetDirection = false;
    private int mDirection = DIRECTION_BOTTOM_TO_TOP;
    private static final int DIRECTION_BOTTOM_TO_TOP = 0;
    private static final int DIRECTION_TOP_TO_BOTTOM = 1;
    private static final int DIRECTION_RIGHT_TO_LEFT = 2;
    private static final int DIRECTION_LEFT_TO_RIGHT = 3;

    @AnimRes
    private int mInAnimResId = R.anim.sojourn_station_anim_bottom_in;
    @AnimRes
    private int mOutAnimResId = R.anim.sojourn_station_anim_top_out;

    private int mPosition;
    private List<? extends CharSequence> mNotices = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    public interface OnCreateView {
        View getView(int position);
    }

    private OnCreateView oncreateView;

    public OnCreateView getOnCreateView() {
        return oncreateView;
    }

    public void setOnCreateView(OnCreateView oncreateView) {
        this.oncreateView = oncreateView;
    }

    public MarqueeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        int gravityType = GRAVITY_LEFT;
        switch (gravityType) {
            case GRAVITY_LEFT:
                mGravity = Gravity.LEFT | Gravity.CENTER_VERTICAL;
                break;
            case GRAVITY_CENTER:
                mGravity = Gravity.CENTER;
                break;
            case GRAVITY_RIGHT:
                mGravity = Gravity.RIGHT | Gravity.CENTER_VERTICAL;
                break;
        }
        if (mHasSetDirection) {
            switch (mDirection) {
                case DIRECTION_BOTTOM_TO_TOP:
                    mInAnimResId = R.anim.sojourn_station_anim_bottom_in;
                    mOutAnimResId = R.anim.sojourn_station_anim_top_out;
                    break;
                case DIRECTION_TOP_TO_BOTTOM:
                    mInAnimResId = R.anim.sojourn_station_anim_top_in;
                    mOutAnimResId = R.anim.sojourn_station_anim_bottom_out;
                    break;
            }
        } else {
            mInAnimResId = R.anim.sojourn_station_anim_bottom_in;
            mOutAnimResId = R.anim.sojourn_station_anim_top_out;
        }

        setFlipInterval(mInterval);
    }

    public void startWithList(List<? extends CharSequence> notices) {
        startWithList(notices, mInAnimResId, mOutAnimResId);
    }

    public void startWithList(List<? extends CharSequence> notices, @AnimRes int inAnimResId, @AnimRes int outAnimResID) {
        if (notices.isEmpty()) return;
        setNotices(notices);
        postStart(inAnimResId, outAnimResID);
    }

    private void postStart(final @AnimRes int inAnimResId, final @AnimRes int outAnimResID) {
        post(() -> start(inAnimResId, outAnimResID));
    }

    private boolean isAnimStart = false;

    private void start(final @AnimRes int inAnimResId, final @AnimRes int outAnimResID) {
//        Log.e(TAG, "start: mNotices.size = " + mNotices.size() + ", mPosition = " + mPosition);

        removeAllViews();
        clearAnimation();

        mPosition = 0;
        addView(createSubView(mNotices.get(mPosition)));

        if (mNotices.size() > 1) {
            setInAndOutAnimation(inAnimResId, outAnimResID);
            startFlipping();
        }

        if (getInAnimation() != null) {
            getInAnimation().setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    if (isAnimStart) {
                        animation.cancel();
                    }
                    isAnimStart = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
//                    Log.e(TAG, "onAnimationEnd 144 : mPosition = " + mPosition);
                    mPosition++;
                    if (mPosition >= mNotices.size()) {
                        mPosition = 0;
                    }
                    View view = createSubView(mNotices.get(mPosition));
                    int childCount = getChildCount();
//                    Log.e(TAG, "onAnimationEnd 149 : mPosition = " + mPosition  + ",  childCount = " + childCount + ", "+ mNotices.get(mPosition) + ",   " + view.getParent());
                    if (view.getParent() == null) {
                        addView(view);
                    }
                    isAnimStart = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }


    private View createSubView(CharSequence text) {

        if (oncreateView != null) {
            return oncreateView.getView(mPosition);
        }

        LinearLayout linearLayout = (LinearLayout) getChildAt((getDisplayedChild() + 1) % mNotices.size());
        if (linearLayout == null) {
            linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.sojourn_item_maqueen, this, false);
            linearLayout.setGravity(mGravity);
            TextView textView = linearLayout.findViewById(R.id.text);
            textView.setText(text == null ? "" : text);
        }
        linearLayout.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(getPosition(), text);
            }
        });
        linearLayout.setTag(mPosition);
        return linearLayout;
    }

    public int getPosition() {
        return (int) getCurrentView().getTag();
    }

    public List<? extends CharSequence> getNotices() {
        return mNotices;
    }

    public void setNotices(List<? extends CharSequence> notices) {
        this.mNotices = notices;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position, CharSequence text);
    }


    private void setInAndOutAnimation(@AnimRes int inAnimResId, @AnimRes int outAnimResID) {
        Animation inAnim = AnimationUtils.loadAnimation(getContext(), inAnimResId);
        if (mHasSetAnimDuration) inAnim.setDuration(mAnimDuration);
        setInAnimation(inAnim);

        Animation outAnim = AnimationUtils.loadAnimation(getContext(), outAnimResID);
        if (mHasSetAnimDuration) outAnim.setDuration(mAnimDuration);
        setOutAnimation(outAnim);
    }


}