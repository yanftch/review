package com.yanftch.review.android.modules;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangjin on 2018/3/10.
 */

public class RentConditionItem implements Parcelable, Comparable {

    private String title;
    private String value;
    private String key;
    private boolean check;
    private int hot;
    private List<RentConditionItem> children;

    private String bg_img;
    private String icon;

    private int is_single;

    private RentConditionItem parent;

    private int template_type; //类型:0普通(根据style中icon判断是存文本样式还是图文) 1图文模式，用于产品风格,3选中模式

    private Style style;

    private StylePro style_pro;

    private Picture picture;
    private int is_default; //1-选中 0-未选中

    public StylePro getStyle_pro() {
        return style_pro;
    }

    public void setStyle_pro(StylePro style_pro) {
        this.style_pro = style_pro;
    }

    public RentConditionItem getParent() {
        return parent;
    }

    public int getTemplate_type() {
        return template_type;
    }

    public void setTemplate_type(int template_type) {
        this.template_type = template_type;
    }

    public void setParent(RentConditionItem parent) {
        this.parent = parent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public List<RentConditionItem> getChildren() {
        return children;
    }

    public void setChildren(List<RentConditionItem> children) {
        this.children = children;
    }


    public String getBg_img() {
        return bg_img;
    }

    public void setBg_img(String bg_img) {
        this.bg_img = bg_img;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getIs_single() {
        return is_single;
    }

    public void setIs_single(int is_single) {
        this.is_single = is_single;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public boolean isSingle() {
        return is_single == 1;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public int getIs_default() {
        return is_default;
    }

    public void setIs_default(int is_default) {
        this.is_default = is_default;
    }

    @Override
    public String toString() {
        return "RentConditionItem{" +
                "title='" + title + '\'' +
                ", value='" + value + '\'' +
                ", check=" + check +
                ", hot=" + hot +
                ", bg_img=" + bg_img +
                ", hot=" + hot +
                ", icon=" + icon +
                '}';
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        boolean resultKey = false;
        boolean resultValue = false;
        if (obj instanceof RentConditionItem) {
            RentConditionItem rentConditionItem = (RentConditionItem) obj;

            if (this.key == null && rentConditionItem.getKey() == null) {
                resultKey = true;
            } else {
                if (this.key == null) {
                    resultKey = false;
                } else {
                    resultKey = this.key.equals(rentConditionItem.getKey());
                }
            }


            if (this.value == null && rentConditionItem.getValue() == null) {
                resultValue = true;
            } else {
                if (this.value == null) {
                    resultValue = false;
                } else {
                    resultValue = this.value.equals(rentConditionItem.getValue());
                }
            }
        }
        return resultKey && resultValue;

    }


    public RentConditionItem() {
    }

    @Override
    public RentConditionItem clone() {

        RentConditionItem copyItem = new RentConditionItem();

        copyItem.setTitle(this.title);
        copyItem.setValue(this.value);
        copyItem.setCheck(this.check);
        copyItem.setHot(this.hot);
        copyItem.setIcon(this.icon);
        copyItem.setBg_img(this.bg_img);
        copyItem.setKey(this.key);
        copyItem.setIs_single(this.is_single);
        List<RentConditionItem> copyChildren = new ArrayList<>();
        copyItem.setChildren(copyChildren);
        if (this.children == null || this.children.size() < 1) {
            return copyItem;
        }
        for (RentConditionItem childItem : this.children) {
            copyChildren.add(childItem.clone());
        }
        copyItem.setStyle(this.style);
        copyItem.setPicture(this.picture);
        copyItem.setIs_default(this.is_default);
        return copyItem;
    }

    @Override
    public int compareTo(@NonNull Object o) {
        RentConditionItem rentConditionItem = (RentConditionItem) o;
        if (this.value == null && rentConditionItem.getValue() == null) {
            return 0;
        } else {
            if (this.value == null) {
                return -1;
            } else {
                return this.value.compareTo(rentConditionItem.getValue());
            }
        }
    }

    public static class StylePro {
        private String img; //配置实拍图
        private String color; //标题颜色
        private String sub_title; //副标题
        private String tag_img; //新品标签

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getSub_title() {
            return sub_title;
        }

        public void setSub_title(String sub_title) {
            this.sub_title = sub_title;
        }

        public String getTag_img() {
            return tag_img;
        }

        public void setTag_img(String tag_img) {
            this.tag_img = tag_img;
        }
    }


    public static class Style implements Parcelable {

        private String background;
        private String color;
        private String checked_background;
        private String checked_color;
        private String icon;
        private String checked_icon;

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getChecked_icon() {
            return checked_icon;
        }

        public void setChecked_icon(String checked_icon) {
            this.checked_icon = checked_icon;
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

        public String getChecked_background() {
            return checked_background;
        }

        public void setChecked_background(String checked_background) {
            this.checked_background = checked_background;
        }

        public String getChecked_color() {
            return checked_color;
        }

        public void setChecked_color(String checked_color) {
            this.checked_color = checked_color;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.background);
            dest.writeString(this.color);
            dest.writeString(this.checked_background);
            dest.writeString(this.checked_color);
        }

        public Style() {
        }

        protected Style(Parcel in) {
            this.background = in.readString();
            this.color = in.readString();
            this.checked_background = in.readString();
            this.checked_color = in.readString();
        }

        public static final Creator<Style> CREATOR = new Creator<Style>() {
            @Override
            public Style createFromParcel(Parcel source) {
                return new Style(source);
            }

            @Override
            public Style[] newArray(int size) {
                return new Style[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.value);
        dest.writeString(this.key);
        dest.writeByte(this.check ? (byte) 1 : (byte) 0);
        dest.writeInt(this.hot);
        dest.writeTypedList(this.children);
        dest.writeString(this.bg_img);
        dest.writeString(this.icon);
        dest.writeInt(this.is_single);
        dest.writeParcelable(this.parent, flags);
        dest.writeParcelable(this.style, flags);
    }

    protected RentConditionItem(Parcel in) {
        this.title = in.readString();
        this.value = in.readString();
        this.key = in.readString();
        this.check = in.readByte() != 0;
        this.hot = in.readInt();
        this.children = in.createTypedArrayList(RentConditionItem.CREATOR);
        this.bg_img = in.readString();
        this.icon = in.readString();
        this.is_single = in.readInt();
        this.parent = in.readParcelable(RentConditionItem.class.getClassLoader());
        this.style = in.readParcelable(Style.class.getClassLoader());
    }

    public static final Creator<RentConditionItem> CREATOR = new Creator<RentConditionItem>() {
        @Override
        public RentConditionItem createFromParcel(Parcel source) {
            return new RentConditionItem(source);
        }

        @Override
        public RentConditionItem[] newArray(int size) {
            return new RentConditionItem[size];
        }
    };

    public static class Picture implements Parcelable {
        private String unchecked; //未选中图片
        private String checked; //选中图片
        private float scale; //宽高比

        public Picture() {}

        public String getUnchecked() {
            return unchecked;
        }

        public void setUnchecked(String unchecked) {
            this.unchecked = unchecked;
        }

        public String getChecked() {
            return checked;
        }

        public void setChecked(String checked) {
            this.checked = checked;
        }

        public float getScale() {
            return scale;
        }

        public void setScale(float scale) {
            this.scale = scale;
        }

        protected Picture(Parcel in) {
            unchecked = in.readString();
            checked = in.readString();
            scale = in.readFloat();
        }

        public static final Creator<Picture> CREATOR = new Creator<Picture>() {
            @Override
            public Picture createFromParcel(Parcel in) {
                return new Picture(in);
            }

            @Override
            public Picture[] newArray(int size) {
                return new Picture[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(unchecked);
            dest.writeString(checked);
            dest.writeFloat(scale);
        }
    }
}
