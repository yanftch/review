package com.yanftch.review.android.pages.two_tab;

import java.io.Serializable;
import java.util.List;

/**
 * Author:bianle
 * Time:2022/4/28
 * Description: 全景看房头部media 数据
 */

public class Media implements Serializable {
    /**
     * name
     */
    private String name;
    /**
     * interaction_type
     */
    private int interaction_type;
    /**
     * video
     */
    private Video video;
    /**
     * vr
     */
    private Vr vr;
    /**
     * album
     */
    private List<Album> album;//数据整合之前，接收接口数据

    /**
     * hx_photo
     */
    private HxPhoto hx_photo;

    private Album album_after;//数据整合之后，albumList中的数据展开到上一层时，用此接收
    private int scrollPosition;//点击类型tab 对应滚动到的position
    private int isChecked;//选中,手动点击
    private int is_selected;//选中,接口给的默认


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInteraction_type() {
        return interaction_type;
    }

    public void setInteraction_type(int interaction_type) {
        this.interaction_type = interaction_type;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Vr getVr() {
        return vr;
    }

    public void setVr(Vr vr) {
        this.vr = vr;
    }


    public HxPhoto getHx_photo() {
        return hx_photo;
    }

    public void setHx_photo(HxPhoto hx_photo) {
        this.hx_photo = hx_photo;
    }

    public Album getAlbum_after() {
        return album_after;
    }

    public void setAlbum_after(Album album_after) {
        this.album_after = album_after;
    }

    public List<Album> getAlbum() {
        return album;
    }

    public void setAlbum(List<Album> album) {
        this.album = album;
    }

    public int getScrollPosition() {
        return scrollPosition;
    }

    public void setScrollPosition(int scrollPosition) {
        this.scrollPosition = scrollPosition;
    }

    public int getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(int isChecked) {
        this.isChecked = isChecked;
    }

    public int getIs_selected() {
        return is_selected;
    }

    public void setIs_selected(int is_selected) {
        this.is_selected = is_selected;
    }


    public static class Video implements Serializable {
        private HouseMedia houseMedia;

        private RouterVideo router;
        /**
         * corver
         */
        private String cover;

        private String animated_cover;

        public String getAnimated_cover() {
            return animated_cover;
        }

        public void setAnimated_cover(String animated_cover) {
            this.animated_cover = animated_cover;
        }

        /**
         * url
         */
        private String url;

        private String title;//h5类型的视频需求，联调时提醒接口加
        /**
         * width
         */
        private int width;
        /**
         * height
         */
        private int height;
        /**
         * video_type
         */
        private int video_type;
        /**
         * type
         */
        private String type;

        public boolean isVerticalVideo() {
            return height > width;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getVideo_type() {
            return video_type;
        }

        public void setVideo_type(int video_type) {
            this.video_type = video_type;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public HouseMedia getHouseMedia() {
            return houseMedia;
        }

        public void setHouseMedia(HouseMedia houseMedia) {
            this.houseMedia = houseMedia;
        }

        public RouterVideo getRouter() {
            return router;
        }

        public void setRouter(RouterVideo router) {
            this.router = router;
        }
    }

    public static class Vr implements Serializable {
        /**
         * corver
         */
        private String cover;
        /**
         * source
         */
        private int source;
        /**
         * router
         */

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public int getSource() {
            return source;
        }

        public void setSource(int source) {
            this.source = source;
        }

    }

    public static class HxPhoto implements Serializable {
        /**
         * photo
         */
        private String photo;
        private int photo_type;

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public int getPhoto_type() {
            return photo_type;
        }

        public void setPhoto_type(int photo_type) {
            this.photo_type = photo_type;
        }
    }

    public static class Album implements Serializable {
        /**
         * name
         */
        private String name;

        private int has_anchor;//接口给的选中状态
        /**
         * photos
         */
        private List<Photo> photos;

        private int index;//该数据的数组下标(起居室在相册中的位置)
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Photo> getPhotos() {
            return photos;
        }

        public void setPhotos(List<Photo> photos) {
            this.photos = photos;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getHas_anchor() {
            return has_anchor;
        }

        public void setHas_anchor(int has_anchor) {
            this.has_anchor = has_anchor;
        }
    }

    public static class Photo implements Serializable{
        private String photo;
        private int photo_type; //0普通图片 1缺省图片
        private int ablumIndex;//所有ablum中的photo平铺成一层之后，对应的index位置(用于跳转跳转图集页的index)
        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public int getAblumIndex() {
            return ablumIndex;
        }

        public void setAblumIndex(int ablumIndex) {
            this.ablumIndex = ablumIndex;
        }

        public int getPhoto_type() {
            return photo_type;
        }

        public void setPhoto_type(int photo_type) {
            this.photo_type = photo_type;
        }
    }
    public static class RouterVideo implements Serializable{
        private String target;
        private String parameter;

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
}
