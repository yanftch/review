package com.yanftch.review.android.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.yanftch.review.R;
import com.yanftch.review.android.utils.ScreenUtils;
import com.yanftch.review.android.view.NetworkImageHolderView;

import java.util.ArrayList;
import java.util.List;

public class ConvenientbannerActivity extends AppCompatActivity {

    private ConvenientBanner mConverientBanner;
    private List<String> mList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convenientbanner);
        mConverientBanner = findViewById(R.id.convenientBanner);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

//        layoutParams.width = ScreenUtils.getScreenWidth(this) - ScreenUtils.dp2px(this, 80);
        layoutParams.rightMargin = ScreenUtils.dp2px(this, 40);

        mConverientBanner.setClipChildren(false);
        mConverientBanner.setClipToPadding(false);


        mConverientBanner.getViewPager().setLayoutParams(layoutParams);
        mConverientBanner.getViewPager().setClipChildren(false);
        mConverientBanner.getViewPager().setPageMargin(ScreenUtils.dp2px(this, 10));
        mConverientBanner.getViewPager().setOffscreenPageLimit(3);




        mList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1583296017343&di=83bb8de1ddeae7fa109fd27078b401f5&imgtype=0&src=http%3A%2F%2Fa3.att.hudong.com%2F68%2F61%2F300000839764127060614318218_950.jpg");
        mList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1583296017342&di=694ace980e43211a5863e826f0e09e6f&imgtype=0&src=http%3A%2F%2Fa0.att.hudong.com%2F78%2F52%2F01200000123847134434529793168.jpg");
        mList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1583296017342&di=65640c75a9311e222ce64ebdfe2aee29&imgtype=0&src=http%3A%2F%2Fi2.w.yun.hjfile.cn%2Fdoc%2F201303%2F54c809bf-1eb2-400b-827f-6f024d7d599b_01.jpg");

        //自定义你的Holder，实现更多复杂的界面，不一定是图片翻页，其他任何控件翻页亦可。
        mConverientBanner.setPages(
                new CBViewHolderCreator<NetworkImageHolderView>() {
                    @Override
                    public NetworkImageHolderView createHolder() {
                        return new NetworkImageHolderView();
                    }
                }, mList)
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                //设置指示器的方向
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
        //设置翻页的效果，不需要翻页效果可用不设
        //.setPageTransformer(Transformer.DefaultTransformer);    集成特效之后会有白屏现象，新版已经分离，如果要集成特效的例子可以看Demo的点击响应。
//convenientBanner.setManualPageable(false);//设置不能手动影响
    }
}
