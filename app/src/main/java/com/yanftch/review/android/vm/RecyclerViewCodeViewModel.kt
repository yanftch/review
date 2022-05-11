package com.yanftch.review.android.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alibaba.fastjson.JSONObject
import com.yanftch.review.android.modules.BaseProBean
import com.yanftch.review.android.modules.ProjectBean

class RecyclerViewCodeViewModel : ViewModel() {
    private val TAG = "debug_RecyclerViewCodeViewModel"

    private val _listData = MutableLiveData<MutableList<ProjectBean>>()
    val listData: LiveData<MutableList<ProjectBean>> = _listData


    fun getData() {
        val data = JSONObject.parseObject(S, BaseProBean::class.java)
        Log.e(TAG, "getData: " + data.rows.size)
        _listData.value = data.rows
    }

    val S = """{
    "rows": [
        {
            "houseTypeShowName": "整租1居",
            "signStatus": 1,
            "discountLabels": [
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "立减¥3000"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "邀好友有礼"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "毕业生0押金"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "企悦会"
                }
            ],
            "specialMaxPrice": 0.0,
            "houseTypeName": "将府自如寓·一居韵节",
            "houseTypePic": "https://img.ziroom.com/minsu/g2m3/M00/B9/17/ChAZVGBnGXSAGHWAAAO_Z_D1AVQ549.jpg_Z_930_620.jpg",
            "rentScore": 16.5,
            "canSpecialCount": 0,
            "subwayStationInfo": "小区距将台站步行约2146米",
            "houseTypeStatusNames": [
                "可预订",
                "可签约"
            ],
            "houseTypeId": "2c92a2aa788881d101788b9e9a1e0330",
            "price_unit": "/月起",
            "hasVr": 0,
            "unit": "¥",
            "isLive": 0,
            "signMinMonth": 0,
            "minPrice": 6299.0,
            "projectId": "16",
            "minArea": 28.5
        },
        {
            "prePrice": "6249",
            "houseTypeShowName": "整租1居",
            "signStatus": 1,
            "discountLabels": [
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "立减¥3000"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "邀好友有礼"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "毕业生0押金"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "企悦会"
                }
            ],
            "specialMaxPrice": 0.0,
            "houseTypeName": "将府自如寓·一居竹青",
            "houseTypePic": "https://img.ziroom.com/minsu/g2m3/M00/B9/19/ChAZVGBnGjqAHT-HAAQVm0Y0iAk751.jpg_Z_930_620.jpg",
            "rentScore": 16.49,
            "canSpecialCount": 0,
            "subwayStationInfo": "小区距将台站步行约2146米",
            "houseTypeStatusNames": [
                "可预订",
                "可签约"
            ],
            "houseTypeId": "2c92a2aa788881d101788b9e9a210332",
            "price_unit": "/月起",
            "hasVr": 1,
            "unit": "¥",
            "isLive": 0,
            "signMinMonth": 0,
            "minPrice": 5999.0,
            "projectId": "16",
            "minArea": 28.5
        },
        {
            "houseTypeShowName": "整租1居",
            "signStatus": 1,
            "discountLabels": [
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "立减¥3000"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "邀好友有礼"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "毕业生0押金"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "企悦会"
                }
            ],
            "specialMaxPrice": 0.0,
            "houseTypeName": "将府自如寓·一居若草",
            "houseTypePic": "https://img.ziroom.com/minsu/g2m3/M00/B8/D8/ChAZE2BnGxyAbjOyAAO9VDVC9wY952.jpg_Z_930_620.jpg",
            "rentScore": 16.48,
            "canSpecialCount": 0,
            "subwayStationInfo": "小区距将台站步行约2146米",
            "houseTypeStatusNames": [
                "可签约"
            ],
            "houseTypeId": "2c92a2aa788881d101788b9e9a17032e",
            "price_unit": "/月起",
            "hasVr": 1,
            "unit": "¥",
            "isLive": 0,
            "signMinMonth": 0,
            "minPrice": 5699.0,
            "projectId": "16",
            "minArea": 28.5
        },
        {
            "houseTypeShowName": "整租1居",
            "signStatus": 1,
            "discountLabels": [
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "立减¥1500"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "立减¥1500"
                }
            ],
            "specialMaxPrice": 0.0,
            "houseTypeName": "纪家庙自如寓·一居苍崎",
            "houseTypePic": "https://img.ziroom.com/minsu/g2m4/M00/C6/CB/ChAZ2GGu1V6ARMl1AAxlpxJ3iWY961.jpg_Z_930_620.jpg",
            "rentScore": 16.46,
            "canSpecialCount": 0,
            "subwayStationInfo": "小区距纪家庙站步行约526米",
            "houseTypeStatusNames": [
                "可预订",
                "可签约"
            ],
            "houseTypeId": "2c9291ab79113689017944eaa4f3494c",
            "price_unit": "/月起",
            "hasVr": 0,
            "unit": "¥",
            "isLive": 0,
            "signMinMonth": 0,
            "minPrice": 3890.0,
            "projectId": "2c9291ab79113689017944e8c6454946",
            "minArea": 16.0
        },
        {
            "houseTypeShowName": "整租1居",
            "signStatus": 1,
            "discountLabels": [
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "立减¥2000"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "邀好友有礼"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "毕业生0押金"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "企悦会"
                }
            ],
            "specialMaxPrice": 0.0,
            "houseTypeName": "Meeta自如寓·萌宠星球独卫",
            "houseTypePic": "https://img.ziroom.com/minsu/g2m3/M00/C0/4C/ChAZVF9UKOaAHlqeAASTOlWop9c537.jpg_Z_930_620.jpg",
            "rentScore": 15.33,
            "canSpecialCount": 0,
            "subwayStationInfo": "小区距丰台科技园站步行约449米",
            "houseTypeStatusNames": [
                "可预订",
                "可签约"
            ],
            "houseTypeId": "8a9099cb62dbb9100162dd4d5786007b",
            "price_unit": "/月",
            "hasVr": 0,
            "unit": "¥",
            "activityLabels": [
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "生活节特惠"
                }
            ],
            "isLive": 1,
            "signMinMonth": 0,
            "minPrice": 3499.0,
            "projectId": "8a9099cb611da272016140e3165e042a",
            "minArea": 8.0
        },
        {
            "houseTypeShowName": "床位",
            "signStatus": 1,
            "discountLabels": [
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "立减¥1000"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "邀好友有礼"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "毕业生0押金"
                }
            ],
            "specialMaxPrice": 0.0,
            "houseTypeName": "城市之光丽泽店·女生独卫6人间",
            "houseTypePic": "https://img.ziroom.com/minsu/g2m4/M00/4E/4B/ChAZ2GFFRIaAMcDBACQtIlaauvU649.jpg_Z_930_620.jpg",
            "rentScore": 15.28,
            "canSpecialCount": 0,
            "subwayStationInfo": "小区距七里庄站步行约590米",
            "houseTypeStatusNames": [
                "可预订",
                "可签约"
            ],
            "houseTypeId": "2c92aab47be3b344017bf692451217b4",
            "price_unit": "/月起",
            "hasVr": 0,
            "unit": "¥",
            "activityLabels": [
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "生活节特惠"
                }
            ],
            "isLive": 0,
            "signMinMonth": 0,
            "minPrice": 1599.0,
            "projectId": "8a90a3ab61fa03be0161faaef7d4004a",
            "minArea": 21.0
        },
        {
            "prePrice": "45000",
            "houseTypeShowName": "整租1居",
            "signStatus": 1,
            "discountLabels": [
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "免服务费"
                }
            ],
            "specialMaxPrice": 0.0,
            "houseTypeName": "FunHub自如寓·Fun享尊爵心奢房",
            "houseTypePic": "https://img.ziroom.com/minsu/g2m3/M00/87/B8/ChAZVGDupD-ADXlZAARoeKTrAP8123.jpg_Z_930_620.jpg",
            "rentScore": 6.24,
            "canSpecialCount": 0,
            "subwayStationInfo": "小区距建国门站步行约437米",
            "houseTypeStatusNames": [
                "可签约"
            ],
            "houseTypeId": "2c928edb7a799e41017a9d44520646a5",
            "price_unit": "/月",
            "hasVr": 0,
            "unit": "¥",
            "isLive": 0,
            "signMinMonth": 0,
            "minPrice": 29952.0,
            "projectId": "2c928edb7a799e41017a9d4106a9468c",
            "minArea": 100.0
        },
        {
            "houseTypeShowName": "床位",
            "signStatus": 1,
            "discountLabels": [
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "立减¥1000"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "邀好友有礼"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "毕业生0押金"
                }
            ],
            "specialMaxPrice": 0.0,
            "houseTypeName": "城市之光丽泽店·男生独卫6人间",
            "houseTypePic": "https://img.ziroom.com/minsu/g2m4/M00/4E/4C/ChAZYWFFRHiAbRGhAB762tbPnZM730.jpg_Z_930_620.jpg",
            "rentScore": 6.16,
            "canSpecialCount": 0,
            "subwayStationInfo": "小区距七里庄站步行约590米",
            "houseTypeStatusNames": [
                "可预订",
                "可签约"
            ],
            "houseTypeId": "2c92aab47be3b344017bf692451017b2",
            "price_unit": "/月起",
            "hasVr": 0,
            "unit": "¥",
            "isLive": 0,
            "signMinMonth": 0,
            "minPrice": 1599.0,
            "projectId": "8a90a3ab61fa03be0161faaef7d4004a",
            "minArea": 21.0
        },
        {
            "prePrice": "5400",
            "houseTypeShowName": "整租1居",
            "signStatus": 1,
            "discountLabels": [
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "立减¥2000"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "毕业生0押金"
                }
            ],
            "specialMaxPrice": 0.0,
            "houseTypeName": "角门自如寓·一居简物",
            "houseTypePic": "https://img.ziroom.com/minsu/g2m3/M00/85/33/ChAZVF-_ffCAU9rcAAcARbNFdtg155.jpg_Z_930_620.jpg",
            "rentScore": 6.15,
            "canSpecialCount": 0,
            "subwayStationInfo": "小区距角门东站步行约632米",
            "houseTypeStatusNames": [
                "可预订",
                "可签约"
            ],
            "houseTypeId": "8af5c12f5ebdd3d0015ec26751cb1084",
            "price_unit": "/月起",
            "hasVr": 1,
            "unit": "¥",
            "isLive": 0,
            "signMinMonth": 0,
            "minPrice": 4700.0,
            "projectId": "8af5c12f5eb941db015ebcc235cd0b6d",
            "minArea": 27.0
        },
        {
            "houseTypeShowName": "整租1居",
            "signStatus": 1,
            "discountLabels": [
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "立减¥2000"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "邀好友有礼"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "毕业生0押金"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "企悦会"
                }
            ],
            "specialMaxPrice": 0.0,
            "houseTypeName": "Meeta自如寓·趣玩星球独卫",
            "houseTypePic": "https://img.ziroom.com/minsu/g2m4/M00/11/EE/ChAZYWEV7raAGEMmAAewK94s5a8197.jpg_Z_930_620.jpg",
            "rentScore": 6.14,
            "canSpecialCount": 0,
            "subwayStationInfo": "小区距丰台科技园站步行约449米",
            "houseTypeStatusNames": [
                "可预订",
                "可签约"
            ],
            "houseTypeId": "8a90a3ab611da410016140e4aeeb039e",
            "price_unit": "/月起",
            "hasVr": 1,
            "unit": "¥",
            "activityLabels": [
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "生活节特惠"
                }
            ],
            "isLive": 1,
            "signMinMonth": 0,
            "minPrice": 2599.0,
            "projectId": "8a9099cb611da272016140e3165e042a",
            "minArea": 8.0
        },
        {
            "houseTypeShowName": "2户合租",
            "signStatus": 1,
            "discountLabels": [
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "立减¥1500"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "邀好友有礼"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "毕业生0押金"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "企悦会"
                }
            ],
            "specialMaxPrice": 0.0,
            "houseTypeName": "城市之光丽泽店·一居博学",
            "houseTypePic": "https://img.ziroom.com/minsu/g2m3/M00/B1/B4/ChAZVF9N1CeAaGf9AASP28f_2Z8429.jpg_Z_930_620.jpg",
            "rentScore": 6.13,
            "canSpecialCount": 0,
            "subwayStationInfo": "小区距七里庄站步行约590米",
            "houseTypeStatusNames": [
                "可预订",
                "可签约"
            ],
            "houseTypeId": "8a90a3ab61fa03be0161faccf322004b",
            "price_unit": "/月起",
            "hasVr": 0,
            "unit": "¥",
            "activityLabels": [
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "生活节特惠"
                }
            ],
            "isLive": 0,
            "signMinMonth": 0,
            "minPrice": 2599.0,
            "projectId": "8a90a3ab61fa03be0161faaef7d4004a",
            "minArea": 7.0
        },
        {
            "prePrice": "5199",
            "houseTypeShowName": "整租1居",
            "signStatus": 1,
            "discountLabels": [
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "立减¥2000"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "邀好友有礼"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "毕业生0押金"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "企悦会"
                }
            ],
            "specialMaxPrice": 0.0,
            "houseTypeName": "欢乐谷自如寓·套间都市",
            "houseTypePic": "https://img.ziroom.com/minsu/g2m2/M00/0D/63/CtgFCF0thKGAdnMwAAWWFueEQhU332.jpg_Z_930_620.jpg",
            "rentScore": 6.12,
            "canSpecialCount": 0,
            "subwayStationInfo": "小区距垡头站步行约224米",
            "houseTypeStatusNames": [
                "可签约"
            ],
            "houseTypeId": "ff80808148fe297d014908d02e960061",
            "price_unit": "/月",
            "hasVr": 0,
            "unit": "¥",
            "isLive": 0,
            "signMinMonth": 0,
            "minPrice": 4599.0,
            "projectId": "19",
            "minArea": 52.0
        },
        {
            "prePrice": "4199",
            "houseTypeShowName": "整租1居",
            "signStatus": 1,
            "discountLabels": [
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "立减¥2000"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "邀好友有礼"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "毕业生0押金"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "企悦会"
                }
            ],
            "specialMaxPrice": 0.0,
            "houseTypeName": "欢乐谷自如寓·一居至纯",
            "houseTypePic": "https://img.ziroom.com/minsu/g2m3/M00/B7/0D/ChAZE19QS9yALG5bAAYxS6GS43w773.jpg_Z_930_620.jpg",
            "rentScore": 6.09,
            "canSpecialCount": 0,
            "subwayStationInfo": "小区距垡头站步行约224米",
            "houseTypeStatusNames": [
                "可预订",
                "可签约"
            ],
            "houseTypeId": "ff80808148e981940148e9b1045c001f",
            "price_unit": "/月起",
            "hasVr": 0,
            "unit": "¥",
            "activityLabels": [
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "生活节特惠"
                }
            ],
            "isLive": 0,
            "signMinMonth": 0,
            "minPrice": 3599.0,
            "projectId": "19",
            "minArea": 13.0
        },
        {
            "prePrice": "39000",
            "houseTypeShowName": "整租1居",
            "signStatus": 1,
            "discountLabels": [
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "免服务费"
                }
            ],
            "specialMaxPrice": 0.0,
            "houseTypeName": "FunHub自如寓·Fun空身心豪华套房",
            "houseTypePic": "https://img.ziroom.com/minsu/g2m3/M00/87/75/ChAZE2Duo-GAPnHIAASi1GoJgT8596.jpg_Z_930_620.jpg",
            "rentScore": 6.09,
            "canSpecialCount": 0,
            "subwayStationInfo": "小区距建国门站步行约437米",
            "houseTypeStatusNames": [
                "可签约"
            ],
            "houseTypeId": "2c928edb7a799e41017a9d44520246a3",
            "price_unit": "/月",
            "hasVr": 0,
            "unit": "¥",
            "isLive": 0,
            "signMinMonth": 0,
            "minPrice": 25152.0,
            "projectId": "2c928edb7a799e41017a9d4106a9468c",
            "minArea": 80.0
        },
        {
            "houseTypeShowName": "床位",
            "signStatus": 1,
            "discountLabels": [
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "立减¥1000"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "邀好友有礼"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "毕业生0押金"
                }
            ],
            "specialMaxPrice": 0.0,
            "houseTypeName": "城市之光丽泽店·女生6人间",
            "houseTypePic": "https://img.ziroom.com/minsu/g2m4/M00/4E/4C/ChAZ2GFFRKOAFLD3ACEFNgcivx0031.jpg_Z_930_620.jpg",
            "rentScore": 6.0,
            "canSpecialCount": 0,
            "subwayStationInfo": "小区距七里庄站步行约590米",
            "houseTypeStatusNames": [
                "可预订",
                "可签约"
            ],
            "houseTypeId": "2c92aab47be3b344017bf692451417b6",
            "price_unit": "/月起",
            "hasVr": 0,
            "unit": "¥",
            "activityLabels": [
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "生活节特惠"
                }
            ],
            "isLive": 0,
            "signMinMonth": 0,
            "minPrice": 1649.0,
            "projectId": "8a90a3ab61fa03be0161faaef7d4004a",
            "minArea": 21.0
        },
        {
            "houseTypeShowName": "整租1居",
            "signStatus": 1,
            "discountLabels": [
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "立减¥2500"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "邀好友有礼"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "毕业生0押金"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "企悦会"
                }
            ],
            "specialMaxPrice": 0.0,
            "houseTypeName": "欢乐谷自如寓·loft曙光",
            "houseTypePic": "https://img.ziroom.com/minsu/g2m3/M00/FD/FE/ChAZE2AJK9GAA8vvAAQ9jsvmi-o108.jpg_Z_930_620.jpg",
            "rentScore": 5.82,
            "canSpecialCount": 0,
            "subwayStationInfo": "小区距垡头站步行约224米",
            "houseTypeStatusNames": [
                "可预订",
                "可签约"
            ],
            "houseTypeId": "ff80808148fe297d014907af0bf70022",
            "price_unit": "/月起",
            "hasVr": 0,
            "unit": "¥",
            "activityLabels": [
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "生活节特惠"
                }
            ],
            "isLive": 0,
            "signMinMonth": 0,
            "minPrice": 5299.0,
            "projectId": "19",
            "minArea": 37.5
        },
        {
            "prePrice": "5700",
            "houseTypeShowName": "整租1居",
            "signStatus": 1,
            "discountLabels": [
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "立减¥2000"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "毕业生0押金"
                }
            ],
            "specialMaxPrice": 0.0,
            "houseTypeName": "角门自如寓·一居简纯",
            "houseTypePic": "https://img.ziroom.com/minsu/g2m3/M00/84/F1/ChAZE1-_feWAUSZLAAcq-cAPdLw135.jpg_Z_930_620.jpg",
            "rentScore": 5.79,
            "canSpecialCount": 0,
            "subwayStationInfo": "小区距角门东站步行约632米",
            "houseTypeStatusNames": [
                "可预订",
                "可签约"
            ],
            "houseTypeId": "8af5c12f5ebdd3d0015ec26827961085",
            "price_unit": "/月起",
            "hasVr": 1,
            "unit": "¥",
            "isLive": 0,
            "signMinMonth": 0,
            "minPrice": 5200.0,
            "projectId": "8af5c12f5eb941db015ebcc235cd0b6d",
            "minArea": 32.0
        },
        {
            "houseTypeShowName": "2户合租",
            "signStatus": 1,
            "discountLabels": [
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "立减¥2000"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "邀好友有礼"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "毕业生0押金"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "企悦会"
                }
            ],
            "specialMaxPrice": 0.0,
            "houseTypeName": "Meeta自如寓·单身星球两户一卫",
            "houseTypePic": "https://img.ziroom.com/minsu/g2m3/M00/BC/1C/ChAZVF9R99mAE6sTAAPAcGcUdzc395.jpg_Z_930_620.jpg",
            "rentScore": 5.77,
            "canSpecialCount": 0,
            "subwayStationInfo": "小区距丰台科技园站步行约449米",
            "houseTypeStatusNames": [
                "可预订",
                "可签约"
            ],
            "houseTypeId": "8a90a3ab621e6ca3016227b8d1d000a0",
            "price_unit": "/月起",
            "hasVr": 1,
            "unit": "¥",
            "isLive": 1,
            "signMinMonth": 0,
            "minPrice": 2399.0,
            "projectId": "8a9099cb611da272016140e3165e042a",
            "minArea": 7.0
        },
        {
            "prePrice": "26000",
            "houseTypeShowName": "整租1居",
            "signStatus": 1,
            "discountLabels": [
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "免服务费"
                }
            ],
            "specialMaxPrice": 0.0,
            "houseTypeName": "FunHub自如寓·Fun肆生活标准房",
            "houseTypePic": "https://img.ziroom.com/minsu/g2m3/M00/87/8D/ChAZE2DurZ6AUpNTAASKbQZyY3s653.jpg_Z_930_620.jpg",
            "rentScore": 5.71,
            "canSpecialCount": 0,
            "subwayStationInfo": "小区距建国门站步行约437米",
            "houseTypeStatusNames": [
                "可签约"
            ],
            "houseTypeId": "2c928edb7a799e41017a9d4451fc469f",
            "price_unit": "/月起",
            "hasVr": 0,
            "unit": "¥",
            "isLive": 0,
            "signMinMonth": 0,
            "minPrice": 16512.0,
            "projectId": "2c928edb7a799e41017a9d4106a9468c",
            "minArea": 52.0
        },
        {
            "houseTypeShowName": "整租1居",
            "signStatus": 1,
            "discountLabels": [
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "立减¥2000"
                },
                {
                    "highLight": 1,
                    "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                    "title": "毕业生0押金"
                }
            ],
            "specialMaxPrice": 0.0,
            "houseTypeName": "角门自如寓·一居简趣",
            "houseTypePic": "https://img.ziroom.com/minsu/g2m3/M00/85/32/ChAZVF-_fXiANrRNAAh9TzftF8c904.jpg_Z_930_620.jpg",
            "rentScore": 5.71,
            "canSpecialCount": 0,
            "subwayStationInfo": "小区距角门东站步行约632米",
            "houseTypeStatusNames": [
                "可签约"
            ],
            "houseTypeId": "8af5c12f5ebdd3d0015ec2691c881089",
            "price_unit": "/月",
            "hasVr": 0,
            "unit": "¥",
            "isLive": 0,
            "signMinMonth": 0,
            "minPrice": 4200.0,
            "projectId": "8af5c12f5eb941db015ebcc235cd0b6d",
            "minArea": 19.0
        }
    ]
}"""


}