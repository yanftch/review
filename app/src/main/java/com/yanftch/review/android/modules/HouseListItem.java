package com.yanftch.review.android.modules;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangjin.
 * Date: 2018-05-23 下午3:24
 * Description:
 */

public class HouseListItem implements Serializable , IRentListCard {

    public final static int TEMPLATE_TYPE_HOUSE = 1;
    public final static int TEMPLATE_TYPE_HOUSE_B = 15;
    public final static int TEMPLATE_TYPE_ZRA = 2; // 自如寓卡片
    public final static int TEMPLATE_TYPE_ZRA_MAP = 3;
    public final static int TEMPLATE_TYPE_ZSTATION = 6;
    public final static int TEMPLATE_TYPE_CARDS_SEARCH_KEYS = 4;
    public final static int TEMPLATE_TYPE_CARDS_SUG_RESBLOCK = 5;
    public final static int TEMPLATE_TYPE_BANNER = 7;
    public final static int TEMPLATE_TYPE_FIND_RESBLOCK = 8;
    public final static int TEMPLATE_TYPE_KEEPER_A = 9;
    public final static int TEMPLATE_TYPE_KEEPER_B = 10;
    public final static int TEMPLATE_TYPE_IM_A = 11;
    public final static int TEMPLATE_TYPE_IM_B = 12;
    public final static int TEMPLATE_TYPE_CARDS_SEARCH_KEYS_XIAXUAN = 13;
    //200616列表页穿插卡片-banne
    public final static int TEMPLATE_TYPE_BANNER_EXTRA = 14;
    public final static int TEMPLATE_TYPE_RESBLOCK_KEEPER = 16;
    // 通勤设置
    public final static int TEMPLATE_TYPE_COMPANY_SETTINGS = 17;
    // 豪宅大卡片
    public final static int TEMPLATE_TYPE_LUXURY_BIG_CARD = 18;
    public final static int TEMPLATE_TYPE_KOL_STANDARD_CARD = 19;
    public final static int TEMPLATE_TYPE_KOL_CONTENT_CARD = 20;

    //房源分级待释放的标题
    public final static int TEMPLATE_TYPE_FENJI_TITLE = 21;
    public final static int TEMPLATE_TYPE_TONGQIN_RECOMMEND = 22;
    //换租宝卡片
    public final static int TEMPLATE_TYPE_REPLACE = 23;
    //小区搜索结果页卡片
    public final static int TEMPLATE_TYPE_COMMUNITY_SEARCH = 24;
    //小区卡片
    public final static int TEMPLATE_TYPE_COMMUNITY = 25;
    //文本
    public final static int TEMPLATE_TYPE_TEXT = 26;

    public final static int SHOW_STATUS_UNSHELVE = 2;
    public final static String STOCK_STATUS_HAVE_RENT = "202";
    /**
     * 看注释：
     * 本来是打算给真阁豪宅项目大卡片和真阁房型维度卡片添加两种 TEMPLATE_TYPE 的，但是由于后端原因，无法添加，所以只能通过【TEMPLATE_TYPE_ZRA】之下添加新的字段来做区分
     */
//    public final static int TEMPLATE_TYPE_MANSION = 10; // 豪宅插入卡片
//    public final static int TEMPLATE_TYPE_ZHENGE = 11; // RV item  真阁项目特殊处理UI

    private String id;  //BJZRXXXX房间编号
    private String house_id;  //房子id
    private String code;
    private String house_code; //房间id
    private String status;
    private int turn; // 是否转租
    private int type;  // 房间类型：1=合租/ 3·4 = 整租
    private String type_text;  // 合租整租文字描述
    private String type_color;
    private String name; //房间标题
    private String house_type_sale_state;   // 1 满房 2 可签约 3 可预订 4 待售
    private int price;  //价格
    private String area;  // 面积
    private String subway_station_info;  // 到地体站xx米
    private String price_unit; //单位
    private int bedroom; //居室数
    private int parlor;  //厅数
    private String resblock_id; //小区id
    private String resblock_name; //小区名
    private double lng; //纬度
    private double lat; //经度
    private String face; //朝向
    private String photo; //房间图片
    private String photo_min; //小尺寸图片
    private String photo_webp; //房间图片
    private String photo_min_webp; //小尺寸图片
    private String floor_total;  //所在楼层总数
    private String floor; //房间所在楼层
    private List<JSONObject> intro_list; // 房源介绍列表
    private int sale_status;   //房源销售状态  1：可立即签约2：可预订3：转租4：待释放
    private int show_status;//2:下架
    private String stock_status;//202:已出租
    private int hide_price ;//1:已出租
    private int share_rent_type;

    private List<ReplaceCardBean.ReplaceCardItemBean> card_list;
    private ReplaceCardBean.ReplaceCardBtnBean button;

    // 本地记录：用来记录当前对象是搜索的，还是推荐的， 参考：RentHouseListContract.View.TYPE_NORMAL
    private int dataType = -1;


    /**
     * 状态-可签约
     * // 1 满房 2 可签约 3 可预订 4 待售
     */
    public boolean saleStateSign() {
        return "2".equals(house_type_sale_state);
    }
    /**
     * 状态-可预订
     */
    public boolean saleStateOrder() {
        return "3".equals(house_type_sale_state);
    }
    /**
     * 状态-满房
     */
    public boolean saleStateFull() {
        return "1".equals(house_type_sale_state);
    }
    /**
     * 状态-待售
     */
    public boolean saleStatePreOpen() {
        return "4".equals(house_type_sale_state);
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public String getHouse_type_sale_state() {
        return house_type_sale_state;
    }

    public void setHouse_type_sale_state(String house_type_sale_state) {
        this.house_type_sale_state = house_type_sale_state;
    }

    public List<ReplaceCardBean.ReplaceCardItemBean> getCard_list() {
        return card_list;
    }

    public void setCard_list(List<ReplaceCardBean.ReplaceCardItemBean> card_list) {
        this.card_list = card_list;
    }

    public ReplaceCardBean.ReplaceCardBtnBean getButton() {
        return button;
    }

    public void setButton(ReplaceCardBean.ReplaceCardBtnBean button) {
        this.button = button;
    }

    public int getShare_rent_type() {
        return share_rent_type;
    }

    public void setShare_rent_type(int share_rent_type) {
        this.share_rent_type = share_rent_type;
    }

    public int getShare_rent_tag() {
        return share_rent_tag;
    }

    public void setShare_rent_tag(int share_rent_tag) {
        this.share_rent_tag = share_rent_tag;
    }

    public int getShare_rent_count() {
        return share_rent_count;
    }

    public void setShare_rent_count(int share_rent_count) {
        this.share_rent_count = share_rent_count;
    }

    private int share_rent_tag;
    private int share_rent_count;
    /**
     * 房源推荐理由
     */
    private String intro;
    /**
     * 特殊类型标签
     */
    private String style_tag;

    private String inv_no;

    private String source;

    private String first_photo_style;
    private int has_matrix;//样板间预览标识 0 无 1 有 ,version:3+

    private String zrrefer;

    //	1-单个房源，2-自如寓项目聚合，3-地图找房自如寓，4-相关搜索关键词，5-附近/热门小区
    private int template_type;

    private ZraAgg zra_aggs;

    private ZinnAgg zinn_aggs;
    private ResblockInfo resblock_info;

    private String experimentId;
    private String groupId;


    //相关搜索（template_type=4）
    private List<String> search_keys;
    //周边小区搜索结果（template_type=5）
    private List<SugResblock> sug_resblock;

    //细选
    private List<RentConditionItem> related_filter;

    private String structure;


    private Style price_style;
    private String original_price;
    private Style original_price_style;

    /**
     * 通勤引导卡片字段
     */
// 已经存在   private String title;
    private String subtitle;
    private String picture;


    private String intention_inv_no; //意向房源编号(拼租主/次 租中拼的inv_no)

    private String share_label; //标签 可拼主卧

    private ShareTip share_tip;

    private int parent_price; // 整租价格

    private String price_intro; //价格说明 如：（主卧）

    private String parent_price_unit; //整租价格单位

    private String price_prefix; //最高可减至

    private String text;

    public String getShare_label() {
        return share_label;
    }

    public void setShare_label(String share_label) {
        this.share_label = share_label;
    }

    public ShareTip getShare_tip() {
        return share_tip;
    }

    public void setShare_tip(ShareTip share_tip) {
        this.share_tip = share_tip;
    }

    public String getIntention_inv_no() {
        return intention_inv_no;
    }

    public void setIntention_inv_no(String intention_inv_no) {
        this.intention_inv_no = intention_inv_no;
    }

    public int getParent_price() {
        return parent_price;
    }

    public void setParent_price(int parent_price) {
        this.parent_price = parent_price;
    }

    public String getPrice_intro() {
        return price_intro;
    }

    public void setPrice_intro(String price_intro) {
        this.price_intro = price_intro;
    }

    public String getParent_price_unit() {
        return parent_price_unit;
    }

    public void setParent_price_unit(String parent_price_unit) {
        this.parent_price_unit = parent_price_unit;
    }

    public String getPrice_prefix() {
        return price_prefix;
    }

    public void setPrice_prefix(String price_prefix) {
        this.price_prefix = price_prefix;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private String cover; //小区图片
    private CardRouter detail_router;
    private CardBaseInfo base_info;
    private CardTraffic traffic;
    private CardAround around;
    private HouseList.TopImgInfo top_image_info;
    private List<HouseList.TabsInfo> tabs;
    private String icon;

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public CardRouter getDetail_router() {
        return detail_router;
    }

    public void setDetail_router(CardRouter detail_router) {
        this.detail_router = detail_router;
    }

    public CardBaseInfo getBase_info() {
        return base_info;
    }

    public void setBase_info(CardBaseInfo base_info) {
        this.base_info = base_info;
    }

    public CardTraffic getTraffic() {
        return traffic;
    }

    public void setTraffic(CardTraffic traffic) {
        this.traffic = traffic;
    }

    public CardAround getAround() {
        return around;
    }

    public void setAround(CardAround around) {
        this.around = around;
    }

    private OpenHouseBean open_house;

    public OpenHouseBean getOpen_house() {
        return open_house;
    }

    public void setOpen_house(OpenHouseBean open_house) {
        this.open_house = open_house;
    }

    public HouseList.TopImgInfo getTop_image_info() {
        return top_image_info;
    }

    public void setTop_image_info(HouseList.TopImgInfo top_image_info) {
        this.top_image_info = top_image_info;
    }

    public List<HouseList.TabsInfo> getTabs() {
        return tabs;
    }

    public void setTabs(List<HouseList.TabsInfo> tabs) {
        this.tabs = tabs;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public static class OpenHouseBean implements Serializable{
        private String open_house_logo; //图标
        private String black_ground_img; //标签切图
        private String black_ground_triangle; //三角图标
        private String text; //标签文案
        private Router router;

        public String getOpen_house_logo() {
            return open_house_logo;
        }

        public void setOpen_house_logo(String open_house_logo) {
            this.open_house_logo = open_house_logo;
        }

        public String getBlack_ground_img() {
            return black_ground_img;
        }

        public void setBlack_ground_img(String black_ground_img) {
            this.black_ground_img = black_ground_img;
        }

        public String getBlack_ground_triangle() {
            return black_ground_triangle;
        }

        public void setBlack_ground_triangle(String black_ground_triangle) {
            this.black_ground_triangle = black_ground_triangle;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Router getRouter() {
            return router;
        }

        public void setRouter(Router router) {
            this.router = router;
        }
    }

    /**
     * 卡片-跳转详情路由
     */
    public static class CardRouter {
        private String title;
        private String parameter;
        private String target;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getParameter() {
            return parameter;
        }

        public void setParameter(String parameter) {
            this.parameter = parameter;
        }

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }
    }

    /**
     * 卡片-小区攻略
     */
    public static class CardBaseInfo {
        private String title;
        private String intro;
        private Router router;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public Router getRouter() {
            return router;
        }

        public void setRouter(Router router) {
            this.router = router;
        }
    }

    public static class Router implements Serializable{
        private String parameter;
        private String target;

        public String getParameter() {
            return parameter;
        }

        public void setParameter(String parameter) {
            this.parameter = parameter;
        }

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }
    }

    /**
     * 卡片-地铁信息（与周边信息互斥）
     */
    public static class CardTraffic {
        private String img;
        private String background;
        private String color;
        private String name;
        private Router router;
        private DistanceInfo distance_info;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Router getRouter() {
            return router;
        }

        public void setRouter(Router router) {
            this.router = router;
        }

        public DistanceInfo getDistance_info() {
            return distance_info;
        }

        public void setDistance_info(DistanceInfo distance_info) {
            this.distance_info = distance_info;
        }
    }

    /**
     * 卡片-地铁距离信息
     */
    public static class DistanceInfo {
        private String title;
        private String distance;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }
    }

    /**
     * 卡片-周边信息（与地铁信息互斥）
     */
    public static class CardAround {
        private String img;
        private String title;
        private String intro;
        private Router router;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public Router getRouter() {
            return router;
        }

        public void setRouter(Router router) {
            this.router = router;
        }
    }

    public static class ShareTip implements Serializable{
        private String title;
        private String icon;
        private String color;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }


    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getStock_status() {
        return stock_status;
    }

    public void setStock_status(String stock_status) {
        this.stock_status = stock_status;
    }

    public Style getPrice_style() {
        return price_style;
    }

    public void setPrice_style(Style price_style) {
        this.price_style = price_style;
    }

    public String getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(String original_price) {
        this.original_price = original_price;
    }

    public Style getOriginal_price_style() {
        return original_price_style;
    }

    public void setOriginal_price_style(Style original_price_style) {
        this.original_price_style = original_price_style;
    }

    public int getHide_price() {
        return hide_price;
    }

    public void setHide_price(int hide_price) {
        this.hide_price = hide_price;
    }

    public int getShow_status() {
        return show_status;
    }

    public void setShow_status(int show_status) {
        this.show_status = show_status;
    }

    private ResblockKeeperAggs resblock_keeper_aggs;

    public ResblockKeeperAggs getResblock_keeper_aggs() {
        return resblock_keeper_aggs;
    }

    public void setResblock_keeper_aggs(ResblockKeeperAggs resblock_keeper_aggs) {
        this.resblock_keeper_aggs = resblock_keeper_aggs;
    }


    private String title;
    private String parameter;
    private String target;

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    private String version_name;

    public String getVersion_name() {
        return version_name;
    }

    public void setVersion_name(String version_name) {
        this.version_name = version_name;
    }

    /**
     * 小区管家卡片
     */
    private KeeperAggs keeper_aggs;

    /**
     * 云销卡片
     */
    private ImAggs im_aggs;

    public ImAggs getIm_aggs() {
        return im_aggs;
    }

    public void setIm_aggs(ImAggs im_aggs) {
        this.im_aggs = im_aggs;
    }

    public KeeperAggs getKeeper_aggs() {
        return keeper_aggs;
    }

    public void setKeeper_aggs(KeeperAggs keeper_aggs) {
        this.keeper_aggs = keeper_aggs;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    /**
     * 卡片类型标识
     * relatedSearch-相关搜索，
     * companyHot-公司周边热租小区，
     * resblockHot-热门小区，
     * resblockNear1-附近小区场景1，
     * resblockNear2-附近小区场景2
     */
    private String card_type;

    //卡片类型名称 相关搜索
    private String card_name;
    private String page_source;

    private Banner banner_extra;

    private List<String> type_text_style;
    private String variantName;
    private Integer location_id;

    private String card_experiment_id;
    private String card_group_id;
    private String pic_experiment_id;
    private String pic_group_id;

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getStyle_tag() {
        return style_tag;
    }

    public void setStyle_tag(String style_tag) {
        this.style_tag = style_tag;
    }

    private MaskLayer mask_layer;
    //商圈
    private String bizcircle_name;

    public String getBizcircle_name() {
        return bizcircle_name;
    }

    public void setBizcircle_name(String bizcircle_name) {
        this.bizcircle_name = bizcircle_name;
    }

    public MaskLayer getMask_layer() {
        return mask_layer;
    }

    public void setMask_layer(MaskLayer mask_layer) {
        this.mask_layer = mask_layer;
    }


    public String getCard_experiment_id() {
        return card_experiment_id;
    }

    public void setCard_experiment_id(String card_experiment_id) {
        this.card_experiment_id = card_experiment_id;
    }

    public String getCard_group_id() {
        return card_group_id;
    }

    public void setCard_group_id(String card_group_id) {
        this.card_group_id = card_group_id;
    }

    public String getPic_experiment_id() {
        return pic_experiment_id;
    }

    public void setPic_experiment_id(String pic_experiment_id) {
        this.pic_experiment_id = pic_experiment_id;
    }

    public String getPic_group_id() {
        return pic_group_id;
    }

    public void setPic_group_id(String pic_group_id) {
        this.pic_group_id = pic_group_id;
    }

    public Integer getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Integer location_id) {
        this.location_id = location_id;
    }

    public ResblockInfo getResblock_info() {
        return resblock_info;
    }

    public void setResblock_info(ResblockInfo resblock_info) {
        this.resblock_info = resblock_info;
    }

    public String getVariantName() {
        return variantName;
    }

    public void setVariantName(String variantName) {
        this.variantName = variantName;
    }

    public String getPage_source() {
        return page_source;
    }

    public void setPage_source(String page_source) {
        this.page_source = page_source;
    }

    public Banner getBanner_extra() {
        return banner_extra;
    }

    public void setBanner_extra(Banner banner_extra) {
        this.banner_extra = banner_extra;
    }

    public List<String> getType_text_style() {
        return type_text_style;
    }

    public void setType_text_style(List<String> type_text_style) {
        this.type_text_style = type_text_style;
    }

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    public String getCard_name() {
        return card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }

    public List<SugResblock> getSug_resblock() {
        return sug_resblock;
    }

    public void setSug_resblock(List<SugResblock> sug_resblock) {
        this.sug_resblock = sug_resblock;
    }

    public List<String> getSearch_keys() {
        return search_keys;
    }

    public List<RentConditionItem> getRelated_filter() {
        return related_filter;
    }

    public void setRelated_filter(List<RentConditionItem> related_filter) {
        this.related_filter = related_filter;
    }

    public void setSearch_keys(List<String> search_keys) {
        this.search_keys = search_keys;
    }

    public String getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(String experimentId) {
        this.experimentId = experimentId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public int getTemplate_type() {
        return template_type;
    }

    public void setTemplate_type(int template_type) {
        this.template_type = template_type;
    }

    public ZraAgg getZra_aggs() {
        return zra_aggs;
    }

    public void setZra_aggs(ZraAgg zra_aggs) {
        this.zra_aggs = zra_aggs;
    }

    public ZinnAgg getZinn_aggs() {
        return zinn_aggs;
    }

    public void setZinn_aggs(ZinnAgg zinn_aggs) {
        this.zinn_aggs = zinn_aggs;
    }

    public String getZrrefer() {
        return zrrefer;
    }

    public void setZrrefer(String zrrefer) {
        this.zrrefer = zrrefer;
    }

    public int getHas_matrix() {
        return has_matrix;
    }

    public void setHas_matrix(int has_matrix) {
        this.has_matrix = has_matrix;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getInv_no() {
        return inv_no;
    }

    public void setInv_no(String inv_no) {
        this.inv_no = inv_no;
    }

    // 通勤时间描述
    private String commute_info; // 例如：步行3分钟到达北京市电机总厂

    public List<JSONObject> getIntro_list() {
        return intro_list;
    }

    public void setIntro_list(List<JSONObject> intro_list) {
        this.intro_list = intro_list;
    }

    public int getSale_status() {
        return sale_status;
    }

    public void setSale_status(int sale_status) {
        this.sale_status = sale_status;
    }
//    private int is_recommend;  //是否推荐--Adapter中判断View类型用
//    private int is_End;  //是否结尾--Adapter中判断View类型用


    public String getCommute_info() {
        return commute_info;
    }

    public void setCommute_info(String commute_info) {
        this.commute_info = commute_info;
    }

    private List<Tag> tags;

    private ZraExtra zra_extra;
    private String zraExperimentId;
    private String zraGroupId;

    private int has_video;
    private int has_3d;
    private int air_qualified;

    private int has_immersive_video;
    private List<Icon> photo_icons;
    private List<Tag> tags_row2;

    public List<Icon> getPhoto_icons() {
        return photo_icons;
    }

    public void setPhoto_icons(List<Icon> photo_icons) {
        this.photo_icons = photo_icons;
    }

    public List<Tag> getTags_row2() {
        return tags_row2;
    }

    public void setTags_row2(List<Tag> tags_row2) {
        this.tags_row2 = tags_row2;
    }

    public static class Icon implements Serializable{
        private String url;
        private int type;// 1-common 2-svga

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }

    public int getHas_immersive_video() {
        return has_immersive_video;
    }

    public void setHas_immersive_video(int has_immersive_video) {
        this.has_immersive_video = has_immersive_video;
    }

    public String getZraExperimentId() {
        return zraExperimentId;
    }

    public void setZraExperimentId(String zraExperimentId) {
        this.zraExperimentId = zraExperimentId;
    }

    public String getZraGroupId() {
        return zraGroupId;
    }

    public void setZraGroupId(String zraGroupId) {
        this.zraGroupId = zraGroupId;
    }

    public int getHas_3d() {
        return has_3d;
    }

    public void setHas_3d(int has_3d) {
        this.has_3d = has_3d;
    }

    //预计退租时间
    private String will_unrent_date;


    // 限时优惠图片
    private String sale_img;


    public static class Tag implements Serializable {
        private String title;

        private Integer hot;

        private String bg_img;

        private Style style;

        private Tag tail_tag;

        public Style getStyle() {
            return style;
        }

        public void setStyle(Style style) {
            this.style = style;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Integer getHot() {
            return hot;
        }

        public void setHot(Integer hot) {
            this.hot = hot;
        }

        public String getBg_img() {
            return bg_img;
        }

        public void setBg_img(String bg_img) {
            this.bg_img = bg_img;
        }

        public Tag getTail_tag() {
            return tail_tag;
        }

        public void setTail_tag(Tag tail_tag) {
            this.tail_tag = tail_tag;
        }
    }

    public static class Style implements Serializable {
        private String color;
        private String background;

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }
    }

    public static class ZraExtra implements Serializable {
        //         "project_id": "sdfasdfasdf",
//                 "project_name": "Meeta",
//                 "house_type_id": "房型",
//                 "rent_unit"： "出租单位"
        private int rooms_count = -1;

        private String project_id;
        private String project_name;
        private String house_type_id;
        private String rent_unit;
        private String house_type_name;

        // 可预订数量
        private int reserve_num = -1;

        private String key_points;


        private int can_rent_count;
        private int can_order_count;
        // 是否满房(0:否 1:是)
        private int full_status;
        private String feature_label;
        private String address;
        private String introduction;
        private String labelmg;
        private String description;

        private int zra_display_type; // 1:自如寓 2:真阁样式

        public boolean isZhenGeStyle() {
            return zra_display_type == 2;
        }

        public String getFeature_label() {
            return feature_label;
        }

        public void setFeature_label(String feature_label) {
            this.feature_label = feature_label;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getIntroduction() {
            return introduction;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
        }

        public String getLabelmg() {
            return labelmg;
        }

        public void setLabelmg(String labelmg) {
            this.labelmg = labelmg;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getZra_display_type() {
            return zra_display_type;
        }

        public void setZra_display_type(int zra_display_type) {
            this.zra_display_type = zra_display_type;
        }

        public int getCan_rent_count() {
            return can_rent_count;
        }

        public void setCan_rent_count(int can_rent_count) {
            this.can_rent_count = can_rent_count;
        }

        public int getCan_order_count() {
            return can_order_count;
        }

        public void setCan_order_count(int can_order_count) {
            this.can_order_count = can_order_count;
        }

        public int getFull_status() {
            return full_status;
        }

        public void setFull_status(int full_status) {
            this.full_status = full_status;
        }

        public String getKey_points() {
            return key_points;
        }

        public void setKey_points(String key_points) {
            this.key_points = key_points;
        }

        public String getProject_id() {
            return project_id;
        }

        public void setProject_id(String project_id) {
            this.project_id = project_id;
        }

        public String getProject_name() {
            return project_name;
        }

        public void setProject_name(String project_name) {
            this.project_name = project_name;
        }

        public String getHouse_type_id() {
            return house_type_id;
        }

        public void setHouse_type_id(String house_type_id) {
            this.house_type_id = house_type_id;
        }

        public String getRent_unit() {
            return rent_unit;
        }

        public void setRent_unit(String rent_unit) {
            this.rent_unit = rent_unit;
        }

        public String getHouse_type_name() {
            return house_type_name;
        }

        public void setHouse_type_name(String house_type_name) {
            this.house_type_name = house_type_name;
        }

        public int getRooms_count() {
            return rooms_count;
        }

        public void setRooms_count(int rooms_count) {
            this.rooms_count = rooms_count;
        }

        public int getReserve_num() {
            return reserve_num;
        }

        public void setReserve_num(int reserve_num) {
            this.reserve_num = reserve_num;
        }
    }

    public int getAir_qualified() {
        return air_qualified;
    }

    public void setAir_qualified(int air_qualified) {
        this.air_qualified = air_qualified;
    }

    public ZraExtra getZra_extra() {
        return zra_extra;
    }

    public void setZra_extra(ZraExtra zra_extra) {
        this.zra_extra = zra_extra;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHouse_id() {
        return house_id;
    }

    public void setHouse_id(String house_id) {
        this.house_id = house_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getHouse_code() {
        return house_code;
    }

    public void setHouse_code(String house_code) {
        this.house_code = house_code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getType_text() {
        return type_text;
    }

    public void setType_text(String type_text) {
        this.type_text = type_text;
    }

    public String getType_color() {
        return type_color;
    }

    public void setType_color(String type_color) {
        this.type_color = type_color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSubway_station_info() {
        return subway_station_info;
    }

    public void setSubway_station_info(String subway_station_info) {
        this.subway_station_info = subway_station_info;
    }

    public String getPrice_unit() {
        return price_unit;
    }

    public void setPrice_unit(String price_unit) {
        this.price_unit = price_unit;
    }

    public int getBedroom() {
        return bedroom;
    }

    public void setBedroom(int bedroom) {
        this.bedroom = bedroom;
    }

    public int getParlor() {
        return parlor;
    }

    public void setParlor(int parlor) {
        this.parlor = parlor;
    }

    public String getResblock_id() {
        return resblock_id;
    }

    public void setResblock_id(String resblock_id) {
        this.resblock_id = resblock_id;
    }

    public String getResblock_name() {
        return resblock_name;
    }

    public void setResblock_name(String resblock_name) {
        this.resblock_name = resblock_name;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhoto_min() {
        return photo_min;
    }

    public void setPhoto_min(String photo_min) {
        this.photo_min = photo_min;
    }

    public String getPhoto_webp() {
        return photo_webp;
    }

    public void setPhoto_webp(String photo_webp) {
        this.photo_webp = photo_webp;
    }

    public String getPhoto_min_webp() {
        return photo_min_webp;
    }

    public void setPhoto_min_webp(String photo_min_webp) {
        this.photo_min_webp = photo_min_webp;
    }

    public String getFloor_total() {
        return floor_total;
    }

    public void setFloor_total(String floor_total) {
        this.floor_total = floor_total;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getWill_unrent_date() {
        return will_unrent_date;
    }

    public void setWill_unrent_date(String will_unrent_date) {
        this.will_unrent_date = will_unrent_date;
    }

    public int getHas_video() {
        return has_video;
    }

    public void setHas_video(int has_video) {
        this.has_video = has_video;
    }

    public String getSale_img() {
        return sale_img;
    }

    public void setSale_img(String sale_img) {
        this.sale_img = sale_img;
    }

    public String getFirst_photo_style() {
        return first_photo_style;
    }

    public void setFirst_photo_style(String first_photo_style) {
        this.first_photo_style = first_photo_style;
    }

    public static class ZraTagStyle implements Serializable {
        // 直播中
        public static final String ICON_ZBZ = "ZBZ";
        private String title;
        private String icon;
        private String color;
        private String background;

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }
    }

    public static class ZraBannerBean implements Serializable {
        private String img;
        private String target;
        private String parameter;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }

        public String getParameter() {
            return parameter;
        }

        public void setParameter(String parameter) {
            this.parameter = parameter;
        }
    }

    public static class ZraPorjectInfo implements Serializable {

        private ZraBannerBean banner;
        private List<String> focus_pic_list;
        private String background;
        private List<ZraTagStyle> project_tags;
        private int isCollected; // 1 已收藏  0 未收藏
        private long total;

        private String min_price;
        private String min_original_price;
        private String price_unit;
        private String collection_num;
        private String project_id;
        private String project_name;
        private List<String> tags;
        private String subway_station_info;
        private String commute_info;
        private String commute_icon;
        private String discount_info;
        private Float score;
        private String score_text;
        //0开始 1 直播中
        public static final int LIVE_PRE = 1;
        public static final int LIVE_LOADING = 2;
        private int live_status;
        private String live_title;
        private String live_time;
        // 1:自如寓 2:真阁样式
        private int zra_display_type; // 真阁新增
        //项目地址
        private String project_address; // 真阁新增
        private ProjectCmsInfo project_cms_info; // 真阁新增


        private String target;
        private String parameter;
        private String router_title;

        public static final int ZRA_DISPLAY_TYPE_ZHENGE = 2;

        public List<String> getFocus_pic_list() {
            return focus_pic_list;
        }

        public void setFocus_pic_list(List<String> focus_pic_list) {
            this.focus_pic_list = focus_pic_list;
        }

        public String getMin_price() {
            return min_price;
        }

        public void setMin_price(String min_price) {
            this.min_price = min_price;
        }

        public String getMin_original_price() {
            return min_original_price;
        }

        public void setMin_original_price(String min_original_price) {
            this.min_original_price = min_original_price;
        }

        public String getPrice_unit() {
            return price_unit;
        }

        public void setPrice_unit(String price_unit) {
            this.price_unit = price_unit;
        }

        public String getCollection_num() {
            return collection_num;
        }

        public void setCollection_num(String collection_num) {
            this.collection_num = collection_num;
        }

        public boolean isZhenGe() {
            return zra_display_type == ZRA_DISPLAY_TYPE_ZHENGE;
        }

        public String getProject_address() {
            return project_address;
        }

        // 已经被收藏
        public boolean inCollectList() {
            return 1 == isCollected;
        }

        public int getIsCollected() {
            return isCollected;
        }

        public void setIsCollected(int isCollected) {
            this.isCollected = isCollected;
        }

        public long getTotal() {
            return total;
        }

        public void setTotal(long total) {
            this.total = total;
        }

        public String getBackground() {
            return background;
        }

        public List<ZraTagStyle> getProject_tags() {
            return project_tags;
        }

        public void setProject_tags(List<ZraTagStyle> project_tags) {
            this.project_tags = project_tags;
        }

        public void setBackground(String background) {
            this.background = background;
        }

        public ZraBannerBean getBanner() {
            return banner;
        }

        public void setBanner(ZraBannerBean banner) {
            this.banner = banner;
        }

        public void setProject_address(String project_address) {
            this.project_address = project_address;
        }

        public ProjectCmsInfo getProject_cms_info() {
            return project_cms_info;
        }

        public void setProject_cms_info(ProjectCmsInfo project_cms_info) {
            this.project_cms_info = project_cms_info;
        }

        public int getZra_display_type() {
            return zra_display_type;
        }

        public void setZra_display_type(int zra_display_type) {
            this.zra_display_type = zra_display_type;
        }

        public int getLive_status() {
            return live_status;
        }

        public void setLive_status(int live_status) {
            this.live_status = live_status;
        }

        public String getLive_title() {
            return live_title;
        }

        public void setLive_title(String live_title) {
            this.live_title = live_title;
        }

        public String getLive_time() {
            return live_time;
        }

        public void setLive_time(String live_time) {
            this.live_time = live_time;
        }

        public String getProject_id() {
            return project_id;
        }

        public void setProject_id(String project_id) {
            this.project_id = project_id;
        }

        public String getProject_name() {
            return project_name;
        }

        public void setProject_name(String project_name) {
            this.project_name = project_name;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        public String getCommute_info() {
            return commute_info;
        }

        public void setCommute_info(String commute_info) {
            this.commute_info = commute_info;
        }

        public String getCommute_icon() {
            return commute_icon;
        }

        public void setCommute_icon(String commute_icon) {
            this.commute_icon = commute_icon;
        }

        public String getSubway_station_info() {
            return subway_station_info;
        }

        public void setSubway_station_info(String subway_station_info) {
            this.subway_station_info = subway_station_info;
        }

        public String getDiscount_info() {
            return discount_info;
        }

        public void setDiscount_info(String discount_info) {
            this.discount_info = discount_info;
        }

        public Float getScore() {
            return score;
        }

        public void setScore(Float score) {
            this.score = score;
        }

        public String getScore_text() {
            return score_text;
        }

        public void setScore_text(String score_text) {
            this.score_text = score_text;
        }

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }

        public String getParameter() {
            return parameter;
        }

        public void setParameter(String parameter) {
            this.parameter = parameter;
        }

        public String getRouter_title() {
            return router_title;
        }

        public void setRouter_title(String router_title) {
            this.router_title = router_title;
        }
    }

    public static class ProjectCmsInfo implements Serializable {
        private String label; // 图片地址
        private String title;
        private String description;
        private String target;
        private String parameter;


        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }

        public String getParameter() {
            return parameter;
        }

        public void setParameter(String parameter) {
            this.parameter = parameter;
        }
    }

    public static class ZinnPorjectInfo implements Serializable {

        private String project_id;
        private String project_name;
        private List<String> tags;
        private String subway_station_info;
        private String discount_info;
        private Float score;
        private String score_text;
        private String project_master_pic;
        private String fitness_room_pic;
        private String public_area_pic;
        private String min_price;
        private String price_unit;

        public String getProject_id() {
            return project_id;
        }

        public void setProject_id(String project_id) {
            this.project_id = project_id;
        }

        public String getProject_name() {
            return project_name;
        }

        public void setProject_name(String project_name) {
            this.project_name = project_name;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        public String getSubway_station_info() {
            return subway_station_info;
        }

        public void setSubway_station_info(String subway_station_info) {
            this.subway_station_info = subway_station_info;
        }

        public String getDiscount_info() {
            return discount_info;
        }

        public void setDiscount_info(String discount_info) {
            this.discount_info = discount_info;
        }

        public Float getScore() {
            return score;
        }

        public void setScore(Float score) {
            this.score = score;
        }

        public String getScore_text() {
            return score_text;
        }

        public void setScore_text(String score_text) {
            this.score_text = score_text;
        }

        public String getProject_master_pic() {
            return project_master_pic;
        }

        public void setProject_master_pic(String project_master_pic) {
            this.project_master_pic = project_master_pic;
        }

        public String getFitness_room_pic() {
            return fitness_room_pic;
        }

        public void setFitness_room_pic(String fitness_room_pic) {
            this.fitness_room_pic = fitness_room_pic;
        }

        public String getPublic_area_pic() {
            return public_area_pic;
        }

        public void setPublic_area_pic(String public_area_pic) {
            this.public_area_pic = public_area_pic;
        }

        public String getMin_price() {
            return min_price;
        }

        public void setMin_price(String min_price) {
            this.min_price = min_price;
        }

        public String getPrice_unit() {
            return price_unit;
        }

        public void setPrice_unit(String price_unit) {
            this.price_unit = price_unit;
        }
    }

    public static class ZraAgg implements Serializable {

        private ZraPorjectInfo project_info;
        private List<HouseListItem> rooms;

        public ZraPorjectInfo getProject_info() {
            return project_info;
        }

        public void setProject_info(ZraPorjectInfo project_info) {
            this.project_info = project_info;
        }

        public List<HouseListItem> getRooms() {
            return rooms;
        }

        public void setRooms(List<HouseListItem> rooms) {
            this.rooms = rooms;
        }
    }

    public static class ZinnAgg implements Serializable {

        private ZinnPorjectInfo project_info;
        private List<HouseListItem> rooms;

        public ZinnPorjectInfo getProject_info() {
            return project_info;
        }

        public void setProject_info(ZinnPorjectInfo project_info) {
            this.project_info = project_info;
        }

        public List<HouseListItem> getRooms() {
            return rooms;
        }

        public void setRooms(List<HouseListItem> rooms) {
            this.rooms = rooms;
        }
    }

    public static class SugResblock implements Serializable {

        //小区ID 1111027380046
        private String resblock_id;
        //小区名称 卡布其诺
        private String resblock_name;
        //小区图片 http://ziroom.com/pic
        private String resblock_img;
        //房源数量 18
        private int house_num;
        //商圈信息 朝阳-酒仙桥
        private String district_info;
        //小区标签 封闭式小区 | 智慧广场
        private String tags;
        //起价 3000
        private int min_price;
        //价格单位 月
        private String price_unit;
        //价格单位描述
        private String price_unit_info;
        //地铁信息 小区距将台站步行约1200米
        private String subway_station_info;
        //距离搜索小区的距离 1333
        private int distance;
        //搜索词 将台
        private String keyword;
        //租住热度 租住热度100%
        private String tips_hotspot;
        //通勤信息 距离西二旗2.2公里，骑行10分钟
        private String tips_commute;
        //top标签 top1
        private String tag_top;

        private DistanceDesc distance_desc;

        public DistanceDesc getDistance_desc() {
            return distance_desc;
        }

        public void setDistance_desc(DistanceDesc distance_desc) {
            this.distance_desc = distance_desc;
        }

        public String getResblock_id() {
            return resblock_id;
        }

        public void setResblock_id(String resblock_id) {
            this.resblock_id = resblock_id;
        }

        public String getResblock_name() {
            return resblock_name;
        }

        public void setResblock_name(String resblock_name) {
            this.resblock_name = resblock_name;
        }

        public String getResblock_img() {
            return resblock_img;
        }

        public void setResblock_img(String resblock_img) {
            this.resblock_img = resblock_img;
        }

        public int getHouse_num() {
            return house_num;
        }

        public void setHouse_num(int house_num) {
            this.house_num = house_num;
        }

        public String getDistrict_info() {
            return district_info;
        }

        public void setDistrict_info(String district_info) {
            this.district_info = district_info;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public int getMin_price() {
            return min_price;
        }

        public void setMin_price(int min_price) {
            this.min_price = min_price;
        }

        public String getPrice_unit() {
            return price_unit;
        }

        public void setPrice_unit(String price_unit) {
            this.price_unit = price_unit;
        }

        public String getPrice_unit_info() {
            return price_unit_info;
        }

        public void setPrice_unit_info(String price_unit_info) {
            this.price_unit_info = price_unit_info;
        }

        public String getSubway_station_info() {
            return subway_station_info;
        }

        public void setSubway_station_info(String subway_station_info) {
            this.subway_station_info = subway_station_info;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public String getTips_hotspot() {
            return tips_hotspot;
        }

        public void setTips_hotspot(String tips_hotspot) {
            this.tips_hotspot = tips_hotspot;
        }

        public String getTips_commute() {
            return tips_commute;
        }

        public void setTips_commute(String tips_commute) {
            this.tips_commute = tips_commute;
        }

        public String getTag_top() {
            return tag_top;
        }

        public void setTag_top(String tag_top) {
            this.tag_top = tag_top;
        }

        public static class DistanceDesc implements Serializable {
            private String text;
            private List<String> highlight;

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public List<String> getHighlight() {
                return highlight;
            }

            public void setHighlight(List<String> highlight) {
                this.highlight = highlight;
            }
        }
    }

    public static class Banner implements Serializable {

        private String img;
        private String title;
        private String target;
        private JSONObject parameter;
        private String tag;
        private String sub_title;
        private String description;

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getSub_title() {
            return sub_title;
        }

        public void setSub_title(String sub_title) {
            this.sub_title = sub_title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }

        public JSONObject getParameter() {
            return parameter;
        }

        public void setParameter(JSONObject parameter) {
            this.parameter = parameter;
        }
    }


    public static class ResblockInfo implements Serializable{
        private ResblockDetail resblock_detail;
        private ArrayList<HouseListItem> rooms;

        public ResblockDetail getResblock_detail() {
            return resblock_detail;
        }

        public void setResblock_detail(ResblockDetail resblock_detail) {
            this.resblock_detail = resblock_detail;
        }

        public ArrayList<HouseListItem> getRooms() {
            return rooms;
        }

        public void setRooms(ArrayList<HouseListItem> rooms) {
            this.rooms = rooms;
        }
    }

    public static class ResblockDetail implements Serializable{
        private String resblock_id;
        private String resblock_name;
        private float score;
        private String product;
        private String avg_price;
        private String score_text;
        private String commute_info;
        private String subway_station_info;
        private List<Tag> tags;
        private int total;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public String getResblock_id() {
            return resblock_id;
        }

        public void setResblock_id(String resblock_id) {
            this.resblock_id = resblock_id;
        }

        public String getResblock_name() {
            return resblock_name;
        }

        public void setResblock_name(String resblock_name) {
            this.resblock_name = resblock_name;
        }

        public float getScore() {
            return score;
        }

        public void setScore(float score) {
            this.score = score;
        }

        public String getProduct() {
            return product;
        }

        public void setProduct(String product) {
            this.product = product;
        }

        public String getAvg_price() {
            return avg_price;
        }

        public void setAvg_price(String avg_price) {
            this.avg_price = avg_price;
        }

        public String getScore_text() {
            return score_text;
        }

        public void setScore_text(String score_text) {
            this.score_text = score_text;
        }

        public String getCommute_info() {
            return commute_info;
        }

        public void setCommute_info(String commute_info) {
            this.commute_info = commute_info;
        }

        public List<Tag> getTags() {
            return tags;
        }

        public void setTags(List<Tag> tags) {
            this.tags = tags;
        }

        public String getSubway_station_info() {
            return subway_station_info;
        }

        public void setSubway_station_info(String subway_station_info) {
            this.subway_station_info = subway_station_info;
        }
    }

    public static class KeeperAggs implements Serializable {
        /**
         * 标题
         */
        private String title;
        /**
         * 标题icon，图片链接
         */
        private String title_icon;
        /**
         * 管家头像，图片链接
         */
        private String avatar;
        /**
         * 管家名字
         */
        private String name;
        /**
         * 文案列表，每一个文案是一个object
         */
        private List<Content> content;
        /**
         * 问题列表，每一个问题是一个object
         */
        /**
         * 按钮
         */
        /**
         * 调起400或是im 1-400，2-im
         */
        private int contact_type;
        public final static int CALL_400 = 1;
        public final static int IM = 2;
        /**
         * 400号
         */
        private String number_400;
        /**
         * 管家ID号
         */
        private String keeper_id;
        /**
         * 问候语
         * 您好，我想咨询一下{小区名称}小区的房源
         */
        private String greetings;
        /**
         * ab实验ID
         * RoomListKeeperCard
         */
        private String experiment_id;
        /**
         * ab分组名
         * housekeeper——样式1
         * question——样式2
         * default——现有版本样式，无卡片
         */
        private String group_id;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle_icon() {
            return title_icon;
        }

        public void setTitle_icon(String title_icon) {
            this.title_icon = title_icon;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Content> getContent() {
            return content;
        }

        public void setContent(List<Content> content) {
            this.content = content;
        }


        public int getContact_type() {
            return contact_type;
        }

        public void setContact_type(int contact_type) {
            this.contact_type = contact_type;
        }

        public String getNumber_400() {
            return number_400;
        }

        public void setNumber_400(String number_400) {
            this.number_400 = number_400;
        }

        public String getKeeper_id() {
            return keeper_id;
        }

        public void setKeeper_id(String keeper_id) {
            this.keeper_id = keeper_id;
        }

        public String getGreetings() {
            return greetings;
        }

        public void setGreetings(String greetings) {
            this.greetings = greetings;
        }

        public String getExperiment_id() {
            return experiment_id;
        }

        public void setExperiment_id(String experiment_id) {
            this.experiment_id = experiment_id;
        }

        public String getGroup_id() {
            return group_id;
        }

        public void setGroup_id(String group_id) {
            this.group_id = group_id;
        }
    }

    public static class Content implements Serializable {
        private String text;
        private String highlight;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getHighlight() {
            return highlight;
        }

        public void setHighlight(String highlight) {
            this.highlight = highlight;
        }
    }

    public static class ImAggs implements Serializable {
        /**
         * 标题
         */
        private String title;
        /**
         * 标题icon，图片链接
         */
        private String title_icon;
        /**
         * 管家头像，图片链接
         */
        private String avatar;
        /**
         * 问候语
         * 您好，我想咨询一下{小区名称}小区的房源
         */
        private String greetings;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle_icon() {
            return title_icon;
        }

        public void setTitle_icon(String title_icon) {
            this.title_icon = title_icon;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }


        public String getGreetings() {
            return greetings;
        }

        public void setGreetings(String greetings) {
            this.greetings = greetings;
        }
    }

    public static class MaskLayer implements Serializable {
        /**
         * 文字色值
         * #B2FF3737
         */
        private String color;
        /**
         * 背景色值
         */
        private String background;
        /**
         * 文案
         */
        private String text;

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }


    public static class ResblockKeeperAggs implements Serializable {



        private String avatar;
        private String name;
        private Content content;
        private String phone;
        private int has_IM;
        private String code;
        private String IM_init_text;
        private String experiment_id;
        private String group_id;

        public String getIM_init_text() {
            return IM_init_text;
        }

        public void setIM_init_text(String IM_init_text) {
            this.IM_init_text = IM_init_text;
        }

        public String getExperiment_id() {
            return experiment_id;
        }

        public void setExperiment_id(String experiment_id) {
            this.experiment_id = experiment_id;
        }

        public String getGroup_id() {
            return group_id;
        }

        public void setGroup_id(String group_id) {
            this.group_id = group_id;
        }


        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Content getContent() {
            return content;
        }

        public void setContent(Content content) {
            this.content = content;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getHas_IM() {
            return has_IM;
        }

        public void setHas_IM(int has_IM) {
            this.has_IM = has_IM;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }



    private String session_id;
    private String session_id_record;

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getSession_id_record() {
        return session_id_record;
    }

    public void setSession_id_record(String session_id_record) {
        this.session_id_record = session_id_record;
    }
}
