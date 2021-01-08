package com.yanftch.review.android.fragment.new_home;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;

import com.bigkoo.convenientbanner.holder.Holder;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.yanftch.review.android.fragment.new_home.model.ZraEntryBean;

import org.jetbrains.annotations.NotNull;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 首页-banner-ViewHolder
 */
public class ZraMainBannerViewHolder implements Holder<ZraEntryBean> {
    private SimpleDraweeView mSimpleDraweeView;
    private SVGAImageView mSVGAAnnouncement;


    @Override
    public View createView(Context context) {
        FrameLayout fl = new FrameLayout(context);
        mSimpleDraweeView = new SimpleDraweeView(context);
        mSVGAAnnouncement = new SVGAImageView(context);
        mSimpleDraweeView.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
        fl.addView(mSimpleDraweeView);
        fl.addView(mSVGAAnnouncement);
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) mSimpleDraweeView.getLayoutParams();
        return fl;
    }

    @Override
    public void UpdateUI(Context context, int position, ZraEntryBean data) {
        if (data == null) return;
        boolean retVal = false;

        if (data != null) {
            retVal = !TextUtils.isEmpty(data.getImg()) && data.getImg().contains(".svga");
        }

        // TODO:yanfeng 2021/1/8 替换通用加载方法
        mSimpleDraweeView.setImageURI(data.getImg());

        if (retVal) {
            mSVGAAnnouncement.setVisibility(View.VISIBLE);
            mSimpleDraweeView.setVisibility(View.GONE);
            SVGAParser parser = new SVGAParser(context);
            try {
                parser.parse(new URL(data.getImg()), new SVGAParser.ParseCompletion() {
                    @Override
                    public void onComplete(@NotNull SVGAVideoEntity svgaVideoEntity) {
                        SVGADrawable drawable = new SVGADrawable(svgaVideoEntity);
                        mSVGAAnnouncement.setImageDrawable(drawable);
                        mSVGAAnnouncement.startAnimation();
                    }

                    @Override
                    public void onError() {

                    }
                });
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else {
            mSVGAAnnouncement.setVisibility(View.GONE);
            mSimpleDraweeView.setVisibility(View.VISIBLE);
            // TODO:yanfeng 2021/1/8 替换加载方法
            mSimpleDraweeView.setImageURI(data.getImg());
        }
    }
}
