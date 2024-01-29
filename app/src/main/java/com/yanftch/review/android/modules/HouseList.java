package com.yanftch.review.android.modules;


import java.io.Serializable;
import java.util.List;

/**
 * Created by huangjin.
 * Date: 2018-05-23 下午3:24
 * Description:
 */

public class HouseList {

    public final static String SCENE_LIST = "1";
    public final static String SCENE_MAP = "2";

    private List<HouseListItem> rooms;
    private Commute commute;
    public int getTitle_display() {
        return title_display;
    }

    public void setTitle_display(int title_display) {
        this.title_display = title_display;
    }

    private int title_display;
    private String title;
    private String empty_tips; //空结果副标题
    private List<SugCity> sug_city;
    private List<SugResblock> sug_resblock;
    private HouseListZraProject project_info;
    private String pass_through;
    private String intention_inv_no;
    //新增推荐列表
    private List<SugRecResblock> rec_resblock;
    /**
     * //搜索召回类型
     * const SearchReCallTypeMix = "mix_search"         //多路召回
     * const SearchReCallTypeIdR = "id_search_r"        //小区召回
     * const SearchReCallTypeIdd = "id_search_d"        //城区召回
     * const SearchReCallTypeIdb = "id_search_b"        //商圈召回
     * const SearchReCallTypeIdSL = "id_search_sl"      //地铁线召回
     * const SearchReCallTypeIdSS = "id_search_ss"      //地铁站召回
     * const SearchReCallTypePoi = "poi_search"         //POI召回
     * const SearchReCallTypeTag = "tag_search"         //TAG召回
     * const SearchReCallTypeGeo = "geo_search"         //用户定位召回
     * const SearchReCallTypeKeyword = "keyword_search" //全文检索召回
     */
    private String re_call_type;
    private List<String> unhiding_filters;

    private String query_session_id_record;

    //二级首页添加
    private String text; //召回说明
    private String empty_title; //空结果主标题
    private String browse_mode; //强制选择的浏览模式
    private DefaultFilter default_filter; //默认引导词

    //20230209 应看尽看二期 新增出参
    private HeadBanner head_banner;

    public HeadBanner getHead_banner() {
        return head_banner;
    }

    public void setHead_banner(HeadBanner head_banner) {
        this.head_banner = head_banner;
    }

    public List<String> getUnhiding_filters() {
        return unhiding_filters;
    }

    public void setUnhiding_filters(List<String> unhiding_filters) {
        this.unhiding_filters = unhiding_filters;
    }

    public String getIntention_inv_no() {
        return intention_inv_no;
    }

    public void setIntention_inv_no(String intention_inv_no) {
        this.intention_inv_no = intention_inv_no;
    }

    public String getPass_through() {
        return pass_through;
    }

    public void setPass_through(String pass_through) {
        this.pass_through = pass_through;
    }

    public String getEmpty_tips() {
        return empty_tips;
    }

    public void setEmpty_tips(String empty_tips) {
        this.empty_tips = empty_tips;
    }

    public List<SugCity> getSug_city() {
        return sug_city;
    }

    public void setSug_city(List<SugCity> sug_city) {
        this.sug_city = sug_city;
    }

    public List<SugResblock> getSug_resblock() {
        return sug_resblock;
    }

    public void setSug_resblock(List<SugResblock> sug_resblock) {
        this.sug_resblock = sug_resblock;
    }

    private String query_session_id;
    private String hited_query_index;
    private String scid;
    private String page_source;

    public String getScid() {
        return scid;
    }

    public void setScid(String scid) {
        this.scid = scid;
    }

    public String getPage_source() {
        return page_source;
    }

    public void setPage_source(String page_source) {
        this.page_source = page_source;
    }

    public String getHited_query_index() {
        return hited_query_index;
    }

    public void setHited_query_index(String hited_query_index) {
        this.hited_query_index = hited_query_index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Commute getCommute() {
        return commute;
    }

    public void setCommute(Commute commute) {
        this.commute = commute;
    }


    public List<HouseListItem> getRooms() {
        return rooms;
    }

    public void setRooms(List<HouseListItem> rooms) {
        this.rooms = rooms;
    }

    public String getQuery_session_id() {
        return query_session_id;
    }

    public void setQuery_session_id(String query_session_id) {
        this.query_session_id = query_session_id;
    }

    public HouseListZraProject getProject_info() {
        return project_info;
    }

    public void setProject_info(HouseListZraProject project_info) {
        this.project_info = project_info;
    }

    public List<SugRecResblock> getRec_resblock() {
        return rec_resblock;
    }

    public void setRec_resblock(List<SugRecResblock> rec_resblock) {
        this.rec_resblock = rec_resblock;
    }

    public String getRe_call_type() {
        return re_call_type;
    }

    public void setRe_call_type(String re_call_type) {
        this.re_call_type = re_call_type;
    }

    public String getQuery_session_id_record() {
        return query_session_id_record;
    }

    public void setQuery_session_id_record(String query_session_id_record) {
        this.query_session_id_record = query_session_id_record;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getEmpty_title() {
        return empty_title;
    }

    public void setEmpty_title(String empty_title) {
        this.empty_title = empty_title;
    }

    public String getBrowse_mode() {
        return browse_mode;
    }

    public void setBrowse_mode(String browse_mode) {
        this.browse_mode = browse_mode;
    }

    public DefaultFilter getDefault_filter() {
        return default_filter;
    }

    public void setDefault_filter(DefaultFilter default_filter) {
        this.default_filter = default_filter;
    }

    public boolean isNewRecommend() {
        return "id_search_r".equals(getRe_call_type());
    }

    public static class DefaultFilter {
        private String company; //公司名称
        private float lng; //公司所在经度
        private float lat; //公司所在维度
        private String transport; //通勤方式
        private String price; //价格范围
        private int minute; //通勤时间

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public float getLng() {
            return lng;
        }

        public void setLng(float lng) {
            this.lng = lng;
        }

        public float getLat() {
            return lat;
        }

        public void setLat(float lat) {
            this.lat = lat;
        }

        public String getTransport() {
            return transport;
        }

        public void setTransport(String transport) {
            this.transport = transport;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public int getMinute() {
            return minute;
        }

        public void setMinute(int minute) {
            this.minute = minute;
        }
    }

    public static class SugRecResblock implements IRentListCard{
        private TopImgInfo top_image_info;
        private String title;
        private String resblock_id;
        private String intro;
        private String cover;
        private HouseListItem.CardRouter detail_router;
        private HouseListItem.CardBaseInfo base_info;
        private HouseListItem.CardTraffic traffic;
        private HouseListItem.CardAround around;
        private List<TabsInfo> tabs;
        private String icon;

        public TopImgInfo getTop_image_info() {
            return top_image_info;
        }

        public void setTop_image_info(TopImgInfo top_image_info) {
            this.top_image_info = top_image_info;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getResblock_id() {
            return resblock_id;
        }

        public void setResblock_id(String resblock_id) {
            this.resblock_id = resblock_id;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public HouseListItem.CardRouter getDetail_router() {
            return detail_router;
        }

        public void setDetail_router(HouseListItem.CardRouter detail_router) {
            this.detail_router = detail_router;
        }

        public HouseListItem.CardBaseInfo getBase_info() {
            return base_info;
        }

        public void setBase_info(HouseListItem.CardBaseInfo base_info) {
            this.base_info = base_info;
        }

        public HouseListItem.CardTraffic getTraffic() {
            return traffic;
        }

        public void setTraffic(HouseListItem.CardTraffic traffic) {
            this.traffic = traffic;
        }

        public HouseListItem.CardAround getAround() {
            return around;
        }

        public void setAround(HouseListItem.CardAround around) {
            this.around = around;
        }

        public List<TabsInfo> getTabs() {
            return tabs;
        }

        public void setTabs(List<TabsInfo> tabs) {
            this.tabs = tabs;
        }

        @Override
        public int getTemplate_type() {
            return TYPE_RECOMMEND_COMMUNITY;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }

    public static class TopImgInfo {
        private String bg_image;
        private String left_top_image;
        private String right_bg_image;
        private String title;
        private String title_color;

        public String getBg_image() {
            return bg_image;
        }

        public void setBg_image(String bg_image) {
            this.bg_image = bg_image;
        }

        public String getLeft_top_image() {
            return left_top_image;
        }

        public void setLeft_top_image(String left_top_image) {
            this.left_top_image = left_top_image;
        }

        public String getRight_bg_image() {
            return right_bg_image;
        }

        public void setRight_bg_image(String right_bg_image) {
            this.right_bg_image = right_bg_image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle_color() {
            return title_color;
        }

        public void setTitle_color(String title_color) {
            this.title_color = title_color;
        }
    }

    public static class TabsInfo implements Serializable {
        private int is_selected;
        private String title;
        private String tip;
        private int total_count;
        private ButtonInfo bottom_button;
        private List<HouseListItem> rooms;

        public int getIs_selected() {
            return is_selected;
        }

        public void setIs_selected(int is_selected) {
            this.is_selected = is_selected;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTip() {
            return tip;
        }

        public void setTip(String tip) {
            this.tip = tip;
        }

        public int getTotal_count() {
            return total_count;
        }

        public void setTotal_count(int total_count) {
            this.total_count = total_count;
        }

        public ButtonInfo getBottom_button() {
            return bottom_button;
        }

        public void setBottom_button(ButtonInfo bottom_button) {
            this.bottom_button = bottom_button;
        }

        public List<HouseListItem> getRooms() {
            return rooms;
        }

        public void setRooms(List<HouseListItem> rooms) {
            this.rooms = rooms;
        }
    }

    public static class ButtonInfo implements Serializable{
        private String title;
        private HouseListItem.Router router;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public HouseListItem.Router getRouter() {
            return router;
        }

        public void setRouter(HouseListItem.Router router) {
            this.router = router;
        }
    }

    public static class Commute implements IRentListCard{
        private String name;
        private String type;
        private String type_name;
        private String time;
        private String mode;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getType_name() {
            return type_name;
        }

        public void setType_name(String type_name) {
            this.type_name = type_name;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getMode() {
            return mode;
        }

        public void setMode(String mode) {
            this.mode = mode;
        }

        @Override
        public int getTemplate_type() {
            return IRentListCard.TYPE_COMMUTE;
        }
    }

    public static class SugCity implements IRentListCard{
        private String city_code;
        private String city_name;
        private String img;
        private String sug_text;
        private int house_num;
        private String keyword;

        public String getCity_code() {
            return city_code;
        }

        public void setCity_code(String city_code) {
            this.city_code = city_code;
        }

        public String getCity_name() {
            return city_name;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getSug_text() {
            return sug_text;
        }

        public void setSug_text(String sug_text) {
            this.sug_text = sug_text;
        }

        public int getHouse_num() {
            return house_num;
        }

        public void setHouse_num(int house_num) {
            this.house_num = house_num;
        }

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        @Override
        public int getTemplate_type() {
            return IRentListCard.TYPE_OTHER_CITY;
        }
    }

    public static class  SugResblock{
        private String resblock_id;
        private int house_num;
        private int min_price;
        private int distance;
        private String resblock_name;
        private String district_info;
        private String tags;
        private String price_unit;
        private String subway_station_info;
        private String keyword;
        private String resblock_img;

        public String getResblock_img() {
            return resblock_img;
        }

        public void setResblock_img(String resblock_img) {
            this.resblock_img = resblock_img;
        }

        public String getResblock_id() {
            return resblock_id;
        }

        public void setResblock_id(String resblock_id) {
            this.resblock_id = resblock_id;
        }

        public int getHouse_num() {
            return house_num;
        }

        public void setHouse_num(int house_num) {
            this.house_num = house_num;
        }

        public int getMin_price() {
            return min_price;
        }

        public void setMin_price(int min_price) {
            this.min_price = min_price;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public String getResblock_name() {
            return resblock_name;
        }

        public void setResblock_name(String resblock_name) {
            this.resblock_name = resblock_name;
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

        public String getPrice_unit() {
            return price_unit;
        }

        public void setPrice_unit(String price_unit) {
            this.price_unit = price_unit;
        }

        public String getSubway_station_info() {
            return subway_station_info;
        }

        public void setSubway_station_info(String subway_station_info) {
            this.subway_station_info = subway_station_info;
        }

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }
    }

    public static class HeadBanner implements Serializable {
        private String background_image;
        private String title;
        private String title_icon;
        private List<Desc> descs;
        private Button button;

        public String getBackground_image() {
            return background_image;
        }

        public void setBackground_image(String background_image) {
            this.background_image = background_image;
        }

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

        public List<Desc> getDescs() {
            return descs;
        }

        public void setDescs(List<Desc> descs) {
            this.descs = descs;
        }

        public Button getButton() {
            return button;
        }

        public void setButton(Button button) {
            this.button = button;
        }
    }

    public static class Desc implements Serializable {
        private String icon;
        private String text;
        private HouseListItem.Router router;

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public HouseListItem.Router getRouter() {
            return router;
        }

        public void setRouter(HouseListItem.Router router) {
            this.router = router;
        }
    }

    public static class Button implements Serializable {
        private String title;
        private HouseListItem.Router router;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public HouseListItem.Router getRouter() {
            return router;
        }

        public void setRouter(HouseListItem.Router router) {
            this.router = router;
        }
    }
}
