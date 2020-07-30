package com.yanftch.review.android.pages.douyin;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bumptech.glide.Glide;
import com.pili.pldroid.player.PLOnBufferingUpdateListener;
import com.pili.pldroid.player.PLOnInfoListener;
import com.pili.pldroid.player.widget.PLVideoTextureView;
import com.yanftch.review.R;
import com.yanftch.review.android.modules.RowsBean;

public class PageFragment extends Fragment {

    private RowsBean mRowsBean;
    private int mCurrentPosition = -1;

    private TextView mTvDebugInfo;
    private Activity mActivity;
    private ImageView mImageView;
    private PLVideoTextureView mPLVideoTextureView;
    // 轮播
    private ConvenientBanner mConvenientBanner;


    public static PageFragment newInstance(int position, RowsBean bean) {
        PageFragment fragment = new PageFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("rowsBean", bean);
        bundle.putInt("position", position);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
        if (getArguments() != null) {
            mRowsBean = (RowsBean) getArguments().getSerializable("rowsBean");
            mCurrentPosition = getArguments().getInt("position");
        }
        Log.e("debug_PageFragment:", "onCreate==> " + "mCurrentPosition = " + mCurrentPosition + ", mRowsBean = " + mRowsBean);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_play_evaluation_list, container, false);
        initView(view);
//        Log.e("debug_PageFragment:", "onCreateView==> " + "mCurrentPosition = " + mCurrentPosition);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        Log.e("debug_PageFragment:", "onViewCreated==> " + "mCurrentPosition = " + mCurrentPosition);
        render();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("debug_PageFragment:", "onResume==> " + "mCurrentPosition = " + mCurrentPosition);
        mPLVideoTextureView.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("debug_PageFragment:", "onPause==> " + "mCurrentPosition = " + mCurrentPosition);
        mPLVideoTextureView.pause();

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("debug_PageFragment:", "onStop==> " + "mCurrentPosition = " + mCurrentPosition);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("debug_PageFragment:", "onDestroyView==> " + "mCurrentPosition = " + mCurrentPosition);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("debug_PageFragment:", "onDestroy==> " + "mCurrentPosition = " + mCurrentPosition);
    }


    @SuppressLint("SetTextI18n")
    private void render() {
        if (mRowsBean == null) return;

        String videoUrl = mRowsBean.getVideoUrl();
        if (!TextUtils.isEmpty(videoUrl)) {
            mPLVideoTextureView.setVideoPath(videoUrl);
        }
        mPLVideoTextureView.setLooping(true);


        if (mRowsBean.getPicList() != null && !mRowsBean.getPicList().isEmpty()) {
            RowsBean.PicBean picBean = mRowsBean.getPicList().get(0);
            String video = mRowsBean.isVideo() ? "视频" : "图片";
            mTvDebugInfo.setText(video + ", " + mCurrentPosition + ", " + picBean.getPicUrl());
            Glide.with(mActivity).load(picBean.getPicUrl()).into(mImageView);
        }
        //自定义你的Holder，实现更多复杂的界面，不一定是图片翻页，其他任何控件翻页亦可。
        mConvenientBanner.setPages(
                new CBViewHolderCreator<DetailPlayPicHolder>() {
                    @Override
                    public DetailPlayPicHolder createHolder() {
                        return new DetailPlayPicHolder();
                    }
                }, mRowsBean.getPicList())
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                //设置指示器的方向
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
        //设置翻页的效果，不需要翻页效果可用不设
        //.setPageTransformer(Transformer.DefaultTransformer);    集成特效之后会有白屏现象，新版已经分离，如果要集成特效的例子可以看Demo的点击响应。
//convenientBanner.setManualPageable(false);//设置不能手动影响

        // 图片，视频切换显示
        if (mRowsBean.isVideo()) {
            mPLVideoTextureView.setVisibility(View.VISIBLE);
            mConvenientBanner.setVisibility(View.GONE);
        } else {
            mPLVideoTextureView.setVisibility(View.GONE);
            mConvenientBanner.setVisibility(View.VISIBLE);
        }

    }

    private void initView(View view) {
        mTvDebugInfo = view.findViewById(R.id.tv_debug_info);
        mImageView = view.findViewById(R.id.iv_image);
        mPLVideoTextureView = view.findViewById(R.id.pl_video_view);
        mConvenientBanner = view.findViewById(R.id.cb_viewpager);

        mPLVideoTextureView.setOnInfoListener(new PLOnInfoListener() {
            @Override
            public void onInfo(int what, int extra) {
                Log.e("debug_PageFragment:", "onInfo==> " + "what = " + what + ", extra = " + extra);
            }
        });
        mPLVideoTextureView.setOnBufferingUpdateListener(new PLOnBufferingUpdateListener() {
            @Override
            public void onBufferingUpdate(int percent) {
                Log.e("debug_PageFragment:", "onBufferingUpdate==> " + "percent = " + percent);
            }
        });
    }
}
