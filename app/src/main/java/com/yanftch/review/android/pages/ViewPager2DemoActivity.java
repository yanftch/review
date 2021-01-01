package com.yanftch.review.android.pages;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.yanftch.review.R;
import com.yanftch.review.android.view.ZrlEvaluationMiniView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.google.android.material.tabs.TabLayout.MODE_SCROLLABLE;

public class ViewPager2DemoActivity extends AppCompatActivity {
    private static final String TAG = "debug_ViewPager2DemoActivity";

    private FragmentActivity mFragmentActivity;
    private ViewPager2 mViewPager2;
    private TabLayout mTabLayout;
    private Vp2Adapter mAdapter;
    private List<VpBean> mVpBeans;

    private List<VpBean> mVpBeanList = new ArrayList<>();
    private ZrlEvaluationMiniView mZrlEvaluationMiniView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager2);
        mZrlEvaluationMiniView = findViewById(R.id.zrl_eval_view);

        mFragmentActivity = this;
        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager2 = findViewById(R.id.view_pager2);
        mVpBeans = new ArrayList<>();
        mTabLayout.removeAllTabs();
        mTabLayout.setTabMode(MODE_SCROLLABLE);

        for (int i = 0; i < 10; i++) {
            VpBean bean = new VpBean();
            bean.setTitle("title " + i);
            if (i == 0) {
                bean.setDistance(200);
            } else if (i == 1) {
                bean.setDistance(600);
            } else if (i == 2) {
                bean.setDistance(3);
            } else if (i == 3) {
                bean.setDistance(120);
            } else if (i == 4) {
                bean.setDistance(300);
            } else if (i == 5) {
                bean.setDistance(220);
            } else if (i == 6) {
                bean.setDistance(320);
            } else if (i == 7) {
                bean.setDistance(20);
            } else if (i == 8) {
                bean.setDistance(10);
            } else {
                bean.setDistance(50);
            }
            mVpBeanList.add(bean);
        }

        Log.e(TAG, "onCreate: 排序前------");
        for (VpBean bean: mVpBeanList) {
            Log.e(TAG, "onCreate: 前：" + bean.toString());
        }
        Log.e(TAG, "onCreate: 开始排序。。。。。。。。");
        Collections.sort(mVpBeanList, new Comparator<VpBean>() {
            @Override
            public int compare(VpBean o1, VpBean o2) {
                return o1.getDistance() - o2.getDistance();
            }
        });
        Log.e(TAG, "onCreate: 排序后------");
        for (VpBean bean: mVpBeanList) {
            Log.e(TAG, "onCreate: 后：" + bean.toString());
        }


        for (int i = 0; i < 10; i++) {
            mVpBeans.add(new VpBean("title " + i, "content " + i));
        }

        mAdapter = new Vp2Adapter(mFragmentActivity, mVpBeans);

        mViewPager2.setAdapter(mAdapter);
        mViewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        new TabLayoutMediator(mTabLayout, mViewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                TextView textView = new TextView(mFragmentActivity);
                textView.setText(mVpBeans.get(position).getTitle());
                tab.setCustomView(textView);
            }
        }).attach();


        mZrlEvaluationMiniView.setData("5.0");

    }


    class Vp2Adapter extends FragmentStateAdapter {
        private List<VpBean> mList = new ArrayList<>();

        public Vp2Adapter(@NonNull FragmentActivity fragmentActivity, List<VpBean> list) {
            super(fragmentActivity);
            mList = list;
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return VpFragment.newInstance(position, mList.get(position));
        }

        @Override
        public int getItemCount() {
            return mList == null ? 0 : mList.size();
        }
    }

    public static class VpFragment extends Fragment {
        private VpBean mVpBean;
        private int mCurrentPosition;

        private TextView mTvTitle;
        private TextView mTvContent;

        public static VpFragment newInstance(int position, VpBean bean) {
            VpFragment fragment = new VpFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("bean", bean);
            bundle.putInt("p", position);
            ;
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (getArguments() != null) {
                mVpBean = (VpBean) getArguments().getSerializable("bean");
                mCurrentPosition = getArguments().getInt("p");
            }
        }

        @Override
        public void onResume() {
            super.onResume();
            Log.e(TAG, "onResume:  mCurrentPosition = " + mCurrentPosition);
        }

        @Override
        public void onPause() {
            super.onPause();
            Log.e(TAG, "onPause:  mCurrentPosition = " + mCurrentPosition);
        }


        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.item_vp2_item_view, container, false);
            initView(view);
            return view;
        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            render();
        }

        private void initView(View view) {
            mTvTitle = view.findViewById(R.id.tv_title);
            mTvContent = view.findViewById(R.id.tv_content);
        }

        private void render() {
            if (mVpBean == null) return;
            mTvTitle.setText(mVpBean.getTitle());

            if (mCurrentPosition % 2 == 0) {
                mTvContent.setVisibility(View.VISIBLE);
            } else {
                mTvContent.setVisibility(View.GONE);
            }
            mTvContent.setText(mCurrentPosition + " P");
        }
    }

    class VpBean implements Serializable {
        public VpBean() {
        }

        @Override
        public String toString() {
            return "VpBean{" +
                    "distance=" + distance +
                    ", title='" + title + '\'' +
                    ", content='" + content + '\'' +
                    '}';
        }

        public VpBean(String title, String content) {
            this.title = title;
            this.content = content;
        }

        private int distance;

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        private String title;
        private String content;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
