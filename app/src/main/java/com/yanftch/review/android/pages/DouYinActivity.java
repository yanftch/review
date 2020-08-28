package com.yanftch.review.android.pages;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.yanftch.review.R;
import com.yanftch.review.android.adapter.DetailPlayEvaluationAdapter;
import com.yanftch.review.android.modules.RowsBean;

import java.util.ArrayList;
import java.util.List;

public class DouYinActivity extends AppCompatActivity {
    private RecyclerView mRvEvaluation;
    private PagerSnapHelper mSnapHelper;
    private LinearLayoutManager mLayoutManager;
    private List<RowsBean> mModelList = new ArrayList<>();
    private int mCurrentPosition = 0;
    private DetailPlayEvaluationAdapter mAdapter;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        overridePendingTransition(0, R.anim.anim_scale_out);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dou_yin);
//        mRvEvaluation = findViewById(R.id.rv_evaluation);
//
////        mModelList.add(new RowsBean("https://bnbimg.ziroom.com/5d058142-4f3a-4bc4-a460-fd4ba7439149.mp4", "http://10.16.34.42:8080/group3/M00/12/23/ChAiKl8b1X2ANuXHAAATnUR6F2o944.jpg"));
////        mModelList.add(new RowsBean("https://bnbimg.ziroom.com/5d058142-4f3a-4bc4-a460-fd4ba7439149.mp4", "http://10.16.34.42:8080/group3/M00/12/23/ChAiKl8b1XmAb-A4AAATnUR6F2o853.jpg"));
////        mModelList.add(new RowsBean("https://bnbimg.ziroom.com/5d058142-4f3a-4bc4-a460-fd4ba7439149.mp4", "http://10.16.34.42:8080/group3/M00/12/23/ChAiKl8b1XSAcaVPAAATnUR6F2o078.jpg"));
////        mModelList.add(new RowsBean("https://bnbimg.ziroom.com/5d058142-4f3a-4bc4-a460-fd4ba7439149.mp4", "http://10.16.34.42:8080/group3/M00/12/23/ChAiKl8b1XGAKLh4AAATnUR6F2o940.jpg"));
////        mModelList.add(new RowsBean("https://bnbimg.ziroom.com/56e26a96-8fd6-4beb-b9f4-ebe6018e9a90.mp4", "http://10.16.34.42:8080/group3/M00/12/23/ChAiKl8b1b-AQNNuAAATnUR6F2o459.jpg"));
////        mModelList.add(new RowsBean("https://bnbimg.ziroom.com/e7a2df03-ae3a-46be-9bf6-3e91fb0f77b9.mp4", "http://10.16.34.42:8080/group3/M00/12/23/ChAiKl8b2PeASXjVAAATnUR6F2o168.jpg"));
////        mModelList.add(new RowsBean("https://bnbimg.ziroom.com/b4c93d96-d111-4792-bfc9-00ae84ac19b3.mp4", "http://10.16.34.42:8080/group3/M00/12/23/ChAiKl8b2HmAFSVaAAATnUR6F2o267.jpg"));
////        mModelList.add(new RowsBean("https://bnbimg.ziroom.com/31ef183b-dd6f-42b8-88c6-a554da19090a.MOV", "http://10.16.34.42:8080/group3/M00/12/23/ChAiKl8b1weAFYvuAAAfFDSQkvk601.jpg"));
////        mModelList.add(new RowsBean("https://bnbimg.ziroom.com/56e26a96-8fd6-4beb-b9f4-ebe6018e9a90.mp4", "http://10.16.34.42:8080/group3/M00/12/23/ChAiKl8b1cKAWkZyAAATnUR6F2o616.jpg"));
//        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/4F/2C/ChAZE15zWkKAGtskAAKm6gTHWQg22.jpeg"));
//        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/41/FA/ChAZE15wgWuAAykeAAS4Zf6EVwM267.jpg"));
//        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/4F/2C/ChAZE15zWlOAO47XAAJyq_wUMF087.jpeg"));
//        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/4F/6F/ChAZVF5zWkqAA7m-AALaK4_0lfM67.jpeg"));
//        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/34/7D/ChAZE18adEmAUUJAAAGp074u0dY793.jpg"));
//        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/33/F1/ChAZE18aVomASOjsAAS9m2TmgLY107.jpg"));
//        mModelList.add(new RowsBean("https://image.ziroom.com/g2m1/M00/FA/35/ChAFB1wQx8aAQUY_AAMj7USWDbQ229.jpg"));
//        mModelList.add(new RowsBean("https://image.ziroom.com/g2m2/M00/A2/02/CtgFCVzmXn-AUK5qAALVCBqjl9o121.jpg"));
//        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/7C/B5/ChAZE17eFICAY981AAV69NWOJ1o836.jpg"));
//        mModelList.add(new RowsBean("https://image.ziroom.com/g2m2/M00/0A/1E/CtgFCV0tKO6ACYckAARczRwD_Sk849.jpg"));
//        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/7C/E8/ChAZVF7eEU-AaU8DAAWQ51DMpLU649.jpg"));
//        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/4F/6E/ChAZVF5zWiSAMZv6AAKQ6xfIwS867.jpeg"));
//        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/7C/9F/ChAZVF7eA16AePLTAAcqyxMnuHw818.jpg"));
//        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/49/54/ChAZE15yHyKALt2AAAG_BMTh-2A843.jpg"));
//        mModelList.add(new RowsBean("https://image.ziroom.com/g2m2/M00/0D/63/CtgFCF0thKGAdnMwAAWWFueEQhU332.jpg"));
//        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/42/3D/ChAZVF5wgX6ACLJlAAN8Cu3qPpw470.jpg"));
//        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/49/97/ChAZVF5yHxOAHuAuAAGdEn4xrS0274.jpg"));
//        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/49/97/ChAZVF5yHviAa52rAAFwSZBR-jk567.jpg"));
//        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/40/F7/ChAZVF8fsJaATBKeACsxgUDmIT4076.jpg"));
//        mModelList.add(new RowsBean("https://image.ziroom.com/g2m2/M00/A2/05/CtgFCFzmXn6AYSPxAANI1lBa4AQ948.jpg"));
//        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/7C/E0/ChAZVF7eD5qAV_u9AAar9srkXLo312.jpg"));
//        mModelList.add(new RowsBean("https://image.ziroom.com/g2m2/M00/2A/34/CtgFCF0CNuyALX92AALb54X2soE955.jpg"));
//        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/7C/F0/ChAZVF7eEuuABZUMAAG3D3bpDus856.jpg"));
//        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/10/96/ChAZE162If2AQ4eUAAKAWD_w8Uo492.jpg"));
//        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/10/95/ChAZE162IemAIphzAAG6R6fnrWI996.jpg"));
//        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/10/D8/ChAZVF62IfaATY5cAAJG5DKHww4612.jpg"));
//        mModelList.add(new RowsBean("https://image.ziroom.com/g2m2/M00/29/F8/CtgFCV0CL7qAG9VVAAVHHZ0T-Jo162.jpg"));
//        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/3D/19/ChAZE18eN66Ac2X3AAbQrDZq9Dw178.jpg"));
//        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/3D/23/ChAZE18eO0-Aa7PPAAYDjkcAiS0226.jpg"));
//        mSnapHelper = new PagerSnapHelper();
//        mSnapHelper.attachToRecyclerView(mRvEvaluation);
//
//        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        mRvEvaluation.setLayoutManager(mLayoutManager);
//        mAdapter = new DetailPlayEvaluationAdapter(this, mModelList);
//
//        mRvEvaluation.setAdapter(mAdapter);
//
//        mRvEvaluation.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
//                switch (newState) {
//                    case RecyclerView.SCROLL_STATE_IDLE:
//                        //停止滚动
//                        View view = mSnapHelper.findSnapView(mLayoutManager);
//                        if (view == null) {
//                            return;
//                        }
//                        //当前固定后的item position
//                        int position = recyclerView.getChildAdapterPosition(view);
////                        LogUtil.e("debug_DetailPlayEvaluationActivity:", "onScrollStateChanged==> " + "position = " + position + ", mCurrentPosition = " + mCurrentPosition);
//
//                        if (position != mCurrentPosition) {
//
//                            View viewByPosition = mLayoutManager.findViewByPosition(mCurrentPosition);
////                            LogUtil.e("debug_DetailPlayEvaluationActivity:", "onScrollStateChanged==> " + "viewByPosition = "  + viewByPosition);
//                            //这只当前item的数据
//                            RowsBean model = mModelList.get(position);
//                            RecyclerView.ViewHolder viewHolder = recyclerView.getChildViewHolder(view);
//                        }
//                        mCurrentPosition = position;
//                        break;
//                    case RecyclerView.SCROLL_STATE_DRAGGING:
//                        //拖动
//                        break;
//                    case RecyclerView.SCROLL_STATE_SETTLING:
//                        //惯性滑动
//                        break;
//                    default:
//                        break;
//                }
//
//                //
//                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
//                if (!(layoutManager instanceof LinearLayoutManager)) {
//                    return;
//                }
//                int lastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
//                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
//                    if (layoutManager.getChildCount() > 0 && lastVisibleItemPosition >= layoutManager.getItemCount() - 2) {
//                    }
//                }
//            }
//        });


    }

}
