package com.yanftch.review.android.fragment.new_home;

import com.yanftch.review.android.fragment.new_home.model.ZraEntryBean;

import java.util.List;

public interface ZraMainFragmentContract {

    interface Top {
        interface View extends BaseView<Presenter> {
            /**
             * 渲染banner
             */
            void renderBanner();

            /**
             * 渲染金刚位入口
             */
            void renderEntry(List<ZraEntryBean> list);

            /**
             * 渲染特价房模块
             */
            void renderSpecialHouseInfo();

            /**
             * 渲染瓷片营销区域
             */
            void renderMarketing();

            /**
             * 渲染多媒体找房模块
             */
            void renderMediaInfo();

            /**
             * 渲染瀑布流标题栏
             */
            void renderRecTitle();
        }

        interface Presenter extends BasePresenter<Top.View> {
            /**
             * 获取上半部分基本数据
             */
            void getHeaderData();

            /**
             * 获取营销卡片的数据(为了支持后续单独刷新)
             */
            void getCouponInfo();
        }
    }

    interface Bottom {
        interface View extends BaseView<Top.Presenter> {

        }

        interface Presenter extends BasePresenter<Bottom.View> {
            /**
             * 获取瀑布流数据
             */
            void getRecData();

            /**
             * 获取项目列表+快筛列表数据
             */
            void getProjectListData();

        }
    }
}
