package com.yanftch.review.android.pages.douyin;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.gson.Gson;
import com.yanftch.review.R;
import com.yanftch.review.android.modules.RowsBean;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("LongLogTag")
public class Page2DouYinActivity extends AppCompatActivity {

    private ViewPager2 mViewPager2;
    private List<RowsBean> mModelList = new ArrayList<>();
    private Page2DouYinAdapter mPage2DouYinAdapter;
    private int mCurrentPage = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2_dou_yin);
        initView();
    }

    private void initView() {
        mViewPager2 = findViewById(R.id.view_pager2);
//        addData();
        addLocalData(TestData.JSON_0);
        mPage2DouYinAdapter = new Page2DouYinAdapter(this, mModelList);
        mViewPager2.setAdapter(mPage2DouYinAdapter);
        mViewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);


        mViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                // TODO:yanfeng 2020-07-30 模拟分页
                Log.e("debug_Page2DouYinActivity:", "onPageSelected==> " + "position = " + position);
                if (position == mModelList.size() - 1) {
                    Log.e("debug_Page2DouYinActivity:", "onPageSelected==> " + "mCurrentPage前 = " + mCurrentPage);
                    mCurrentPage++;
                    Log.e("debug_Page2DouYinActivity:", "onPageSelected==> " + "mCurrentPage后 = " + mCurrentPage);
                    if (mCurrentPage == 1) {
                        addLocalData(TestData.JSON_1);
                    } else if (mCurrentPage == 2) {
                        addLocalData(TestData.JSON_2);
                    } else if (mCurrentPage == 3) {
                        addLocalData(TestData.JSON_3);
                    } else if (mCurrentPage == 4) {
                        addLocalData(TestData.JSON_4);
                    } else if (mCurrentPage == 5) {
                        addLocalData(TestData.JSON_5);
                    } else if (mCurrentPage == 6) {
                        addLocalData(TestData.JSON_6);
                    }
                    mPage2DouYinAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    private void addLocalData(String json) {
        Gson gson = new Gson();
        OutModel outModel = gson.fromJson(json, OutModel.class);
        OutModel.InnerModel data = outModel.getData();
        List<RowsBean> rows = data.getRows();
        Log.e("debug_Page2DouYinActivity:", "addLocalData==> " + "rows.size = " + rows.size());
        mModelList.addAll(rows);
    }

    private void detData() {
        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/4F/2C/ChAZE15zWkKAGtskAAKm6gTHWQg22.jpeg"));
        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/41/FA/ChAZE15wgWuAAykeAAS4Zf6EVwM267.jpg"));
        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/4F/2C/ChAZE15zWlOAO47XAAJyq_wUMF087.jpeg"));
        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/4F/6F/ChAZVF5zWkqAA7m-AALaK4_0lfM67.jpeg"));
        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/34/7D/ChAZE18adEmAUUJAAAGp074u0dY793.jpg"));
        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/33/F1/ChAZE18aVomASOjsAAS9m2TmgLY107.jpg"));
        mModelList.add(new RowsBean("https://image.ziroom.com/g2m1/M00/FA/35/ChAFB1wQx8aAQUY_AAMj7USWDbQ229.jpg"));
        mModelList.add(new RowsBean("https://image.ziroom.com/g2m2/M00/A2/02/CtgFCVzmXn-AUK5qAALVCBqjl9o121.jpg"));
        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/7C/B5/ChAZE17eFICAY981AAV69NWOJ1o836.jpg"));
        mModelList.add(new RowsBean("https://image.ziroom.com/g2m2/M00/0A/1E/CtgFCV0tKO6ACYckAARczRwD_Sk849.jpg"));
        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/7C/E8/ChAZVF7eEU-AaU8DAAWQ51DMpLU649.jpg"));
        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/4F/6E/ChAZVF5zWiSAMZv6AAKQ6xfIwS867.jpeg"));
        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/7C/9F/ChAZVF7eA16AePLTAAcqyxMnuHw818.jpg"));
        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/49/54/ChAZE15yHyKALt2AAAG_BMTh-2A843.jpg"));
        mModelList.add(new RowsBean("https://image.ziroom.com/g2m2/M00/0D/63/CtgFCF0thKGAdnMwAAWWFueEQhU332.jpg"));
        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/42/3D/ChAZVF5wgX6ACLJlAAN8Cu3qPpw470.jpg"));
        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/49/97/ChAZVF5yHxOAHuAuAAGdEn4xrS0274.jpg"));
        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/49/97/ChAZVF5yHviAa52rAAFwSZBR-jk567.jpg"));
        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/40/F7/ChAZVF8fsJaATBKeACsxgUDmIT4076.jpg"));
        mModelList.add(new RowsBean("https://image.ziroom.com/g2m2/M00/A2/05/CtgFCFzmXn6AYSPxAANI1lBa4AQ948.jpg"));
        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/7C/E0/ChAZVF7eD5qAV_u9AAar9srkXLo312.jpg"));
        mModelList.add(new RowsBean("https://image.ziroom.com/g2m2/M00/2A/34/CtgFCF0CNuyALX92AALb54X2soE955.jpg"));
        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/7C/F0/ChAZVF7eEuuABZUMAAG3D3bpDus856.jpg"));
        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/10/96/ChAZE162If2AQ4eUAAKAWD_w8Uo492.jpg"));
        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/10/95/ChAZE162IemAIphzAAG6R6fnrWI996.jpg"));
        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/10/D8/ChAZVF62IfaATY5cAAJG5DKHww4612.jpg"));
        mModelList.add(new RowsBean("https://image.ziroom.com/g2m2/M00/29/F8/CtgFCV0CL7qAG9VVAAVHHZ0T-Jo162.jpg"));
        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/3D/19/ChAZE18eN66Ac2X3AAbQrDZq9Dw178.jpg"));
        mModelList.add(new RowsBean("https://image.ziroom.com/g2m3/M00/3D/23/ChAZE18eO0-Aa7PPAAYDjkcAiS0226.jpg"));
//        mModelList.add(new RowsBean("content1", , ));
//        mModelList.add(new RowsBean("content1", , ));
//        mModelList.add(new RowsBean("content1", , ));
//        mModelList.add(new RowsBean("content1", , ));
//        mModelList.add(new RowsBean("content1", , ));
//        mModelList.add(new RowsBean("content1", , ));
//        mModelList.add(new RowsBean("content1", , ));
//        mModelList.add(new RowsBean("content1", , ));
//        mModelList.add(new RowsBean("content1", , ));
//        mModelList.add(new RowsBean("content1", , ));
//        mModelList.add(new RowsBean("content1", , ));
//        mModelList.add(new RowsBean("content1", , ));
    }
}
