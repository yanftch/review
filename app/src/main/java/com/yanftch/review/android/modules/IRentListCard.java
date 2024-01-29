package com.yanftch.review.android.modules;

/**
 * 抽象的列表卡片template_type
 * 这些模板template_type没有在后台定义，因此，维护在这里。房源卡片，在houseListItem中存在。
 * 维护的template_type避免和HouseListItem中的重复
 */
public interface IRentListCard {
    /**
     * 请求失败卡片。出现该卡片时，不展示其他卡片
     */
    int TYPE_ERROR = 1001;

    /**
     * 搜索无结果卡片。List接口无房源时，展示该卡片
     */
    int TYPE_EMPTY = 1002;

    /**
     * 其他城市卡片
     */
    int TYPE_OTHER_CITY = 1003;

    /**
     *   sug附近小区卡片
     */
    int TYPE_SUG_RESBLOCK = 1004;

    /**
     * 咨询卡片
     */
    int TYPE_HOUSE_OPTIONS = 1005;

    /**
     * 小区卡片。搜索小区的sug或keywords时匹配的结果
     */
    int TYPE_RESBLOCK = 1006;

    /**
     * 通勤卡片
     */
    int TYPE_COMMUTE = 1007;

    /**
     * 推荐标题卡片。展示推荐时，才会添加
     */
    int TYPE_RECOMMEND_TITLE = 1008;

    /**
     * 小区搜索结果页-推荐小区列表卡片
     */
    int TYPE_RECOMMEND_COMMUNITY = 1009;

    /**
     * 小区搜索结果页-推荐小区列表无数据提示
     */
    int TYPE_RECOMMEND_BOTTOM = 1010;

    int getTemplate_type();
}
