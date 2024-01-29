package com.yanftch.review.android.pages.vp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.fastjson.JSONObject
import com.yanftch.review.R
import com.yanftch.review.android.modules.HouseList

/**
 * User : yanftch
 * Date : 2023/2/27
 * Time : 14:37
 */
class Vp2BannerActivity : AppCompatActivity() {
    private lateinit var findZraMapPopView: FindZraMapPopView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vp2_banner)
        findZraMapPopView = findViewById(R.id.pop_zra_view)
        val data = getData()
        findZraMapPopView.updateData(data.rooms)
    }

    fun getData():HouseList {
        val obj = JSONObject.parseObject(DATA, HouseList::class.java)
        return obj
    }

    val DATA="""{
    "empty_tips": "",
    "title": "附近房源",
    "rooms": [
        {
            "card_type": "zra",
            "zra_aggs": {
                "project_info": {
                    "parameter": {
                        "page_source": "zraHomePage_search",
                        "projectId": "8a76b2dc8063dcf20180649e7fe70033",
                        "session_id": "1630094447121997824"
                    },
                    "focus_pic_list":[
                        "https://img.ziroom.com/minsu/g2m3/M00/83/55/ChAZE1-_EZmAPn66AACppq1pidc52.jpeg_Z_930_620.jpeg",
                        "https://img.ziroom.com/minsu/g2m3/M00/83/55/ChAZE1-_EZmAPn66AACppq1pidc52.jpeg_Z_930_620.jpeg",
                        "https://img.ziroom.com/minsu/g2m3/M00/83/55/ChAZE1-_EZmAPn66AACppq1pidc52.jpeg_Z_930_620.jpeg"
                    ],
                    "project_tags": [
                        {
                            "title": "人人享自如",
                            "icon":"https://img.ziroom.com/minsu/g2m3/M00/83/55/ChAZE1-_EZmAPn66AACppq1pidc52.jpeg_Z_930_620.jpeg"
                        },
                        {
                            "title": "大房子",
                            "icon":"https://img.ziroom.com/minsu/g2m3/M00/83/55/ChAZE1-_EZmAPn66AACppq1pidc52.jpeg_Z_930_620.jpeg",
                            "background": "#08000000",
                            "color": "#99000000"
                        },
                        {
                            "title": "小隔间",
                            "icon":"https://img.ziroom.com/minsu/g2m3/M00/83/55/ChAZE1-_EZmAPn66AACppq1pidc52.jpeg_Z_930_620.jpeg",
                            "background": "#08000000",
                            "color": "#99000000"
                        }
                    ],
                    "min_price":"1000",
                    "price_unit":"/月起",
                    "commute_icon":"https://webimg.ziroom.com/d704fb82-28ac-4eaf-9e2d-4d6ada7623e8.png",
                    "commute_info":"驾车大约120分钟到达",
                    "collection_num":300,
                    "background": "https://webimg.ziroom.com/d704fb82-28ac-4eaf-9e2d-4d6ada7623e8.png",
                    "project_id": "8a76b2dc8063dcf20180649e7fe70033",
                    "project_name": "配置物品测试",
                    "subway_station_info": "房源距将台站步行约26米",
                    "router_title": "进入自如寓",
                    "target": "ziroomCustomer://zrRentModule/newZraDetailspage"
                },
                "rooms": [
                    {
                        "house_type_sale_state": 2,
                        "template_type": 1,
                        "session_id": "1630094447121997824",
                        "page_source": "zraHomePage_search",
                        "inv_no": "834216",
                        "price_unit": "/月",
                        "zrrefer": "",
                        "name": "测试添加物品·南",
                        "type": 6,
                        "tags": [
                            {
                                "style": {
                                    "background": "#1AFF961E",
                                    "color": "#FFFF961E"
                                },
                                "hot": 1,
                                "title": "自如寓"
                            },
                            {
                                "title": "集中供暖"
                            }
                        ],
                        "zra_extra": {
                            "rooms_count": -1,
                            "zra_display_type": 1,
                            "house_type_id": "8a7695988068e0fd018069aa6519006b",
                            "house_type_name": "测试添加物品",
                            "project_id": "8a76b2dc8063dcf20180649e7fe70033",
                            "project_name": "配置物品测试",
                            "rent_unit_type": 2,
                            "reserve_num": -1,
                            "key_points": "整租1居 | 南",
                            "rent_unit": "整租1居"
                        },
                        "area": "25",
                        "has_video": 1,
                        "photo": "http://10.16.34.44:8000/minsu/group1/M00/23/D8/ChAiMGJo3yiABfLzAA2-6-Gywz0540.png_Z_930_620.png",
                        "price": 5599,
                        "subway_station_info": "房源距将台站步行约26米",
                        "location_id": 0,
                        "version_name": "10001011",
                        "zraExperimentId": "zrasearchstyle",
                        "zraGroupId": "projectstyle"
                    }
                ]
            },
            "zrrefer": "1630094447121997824|1|2|0|search_result|zraHomePage_search",
            "location_id": 2,
            "template_type": 2,
            "session_id": "1630094447121997824",
            "page_source": "zraHomePage_search"
        },
        {
            "zrrefer": "1630094447121997824|1|3|0|search_result|zraHomePage_search",
            "location_id": 3,
            "template_type": 2,
            "session_id": "1630094447121997824",
            "page_source": "zraHomePage_search",
            "card_type": "zra",
            "zra_aggs": {
                "rooms": [
                    {
                        "area": "45",
                        "name": "大开间A户型·北",
                        "price_unit": "/月起",
                        "zraGroupId": "projectstyle",
                        "template_type": 1,
                        "inv_no": "376641",
                        "subway_station_info": "房源距篱笆房站步行约1393米",
                        "type": 6,
                        "version_name": "10001011",
                        "zra_extra": {
                            "rent_unit": "整租1居",
                            "house_type_name": "望京自如寓·大开间A户型",
                            "key_points": "整租1居 | 北",
                            "project_name": "望京阳光自如寓-理房通测试项目",
                            "reserve_num": -1,
                            "rooms_count": -1,
                            "zra_display_type": 1,
                            "house_type_id": "ff80808148f9ac210148f9f17eb60026",
                            "project_id": "20",
                            "rent_unit_type": 2
                        },
                        "house_type_sale_state": 2,
                        "zrrefer": "",
                        "location_id": 0,
                        "tags": [
                            {
                                "title": "自如寓",
                                "style": {
                                    "background": "#1AFF961E",
                                    "color": "#FFFF961E"
                                },
                                "hot": 1
                            },
                            {
                                "title": "智能家居"
                            },
                            {
                                "title": "集中供暖"
                            }
                        ],
                        "zraExperimentId": "zrasearchstyle",
                        "session_id": "1630094447121997824",
                        "page_source": "zraHomePage_search",
                        "photo": "http://file.ziroom.com/g4m1/M00/04/C5/ChAFBlu7kKuAXBp_AAHlyDj1D3s136.JPG",
                        "price": 1
                    },
                    {
                        "page_source": "zraHomePage_search",
                        "name": "开间A户型·多朝向",
                        "zra_extra": {
                            "key_points": "整租1居 | 多种朝向",
                            "rooms_count": -1,
                            "zra_display_type": 1,
                            "rent_unit_type": 2,
                            "reserve_num": -1,
                            "house_type_id": "ff80808148e981940148e9b3bd420025",
                            "house_type_name": "望京自如寓·开间A户型",
                            "project_id": "20",
                            "project_name": "望京阳光自如寓-理房通测试项目",
                            "rent_unit": "整租1居"
                        },
                        "session_id": "1630094447121997824",
                        "inv_no": "961848",
                        "photo": "http://file.ziroom.com/g4m1/M00/04/C5/ChAFBlu7kKiAFK9MAAHcaJttrUQ145.jpg",
                        "price_unit": "/月起",
                        "tags": [
                            {
                                "style": {
                                    "background": "#1AFF961E",
                                    "color": "#FFFF961E"
                                },
                                "hot": 1,
                                "title": "自如寓"
                            },
                            {
                                "title": "集中供暖"
                            }
                        ],
                        "zraExperimentId": "zrasearchstyle",
                        "area": "28",
                        "price": 100,
                        "subway_station_info": "房源距篱笆房站步行约1393米",
                        "zraGroupId": "projectstyle",
                        "zrrefer": "",
                        "location_id": 0,
                        "template_type": 1,
                        "has_video": 1,
                        "type": 6,
                        "version_name": "10001011",
                        "house_type_sale_state": 2
                    },
                    {
                        "zrrefer": "",
                        "template_type": 1,
                        "photo": "http://file.ziroom.com/g4m1/M00/04/C4/ChAFB1u7kKuAJBaYAEsxcn-mgoU578.png",
                        "type": 6,
                        "zraGroupId": "projectstyle",
                        "area": "18",
                        "inv_no": "441052",
                        "tags": [
                            {
                                "style": {
                                    "color": "#FFFF961E",
                                    "background": "#1AFF961E"
                                },
                                "hot": 1,
                                "title": "自如寓"
                            },
                            {
                                "title": "集中供暖"
                            }
                        ],
                        "location_id": 0,
                        "subway_station_info": "房源距篱笆房站步行约1393米",
                        "zra_extra": {
                            "project_id": "20",
                            "rooms_count": -1,
                            "zra_display_type": 1,
                            "house_type_id": "ff80808148f9ac210148f9ef01710022",
                            "key_points": "2户合住 | 西",
                            "rent_unit": "2户合住",
                            "rent_unit_type": 3,
                            "reserve_num": -1,
                            "house_type_name": "EK-A",
                            "project_name": "望京阳光自如寓-理房通测试项目"
                        },
                        "version_name": "10001013",
                        "zraExperimentId": "zrasearchstyle",
                        "house_type_sale_state": 2,
                        "session_id": "1630094447121997824",
                        "page_source": "zraHomePage_search",
                        "name": "EK-A·西",
                        "price": 999,
                        "price_unit": "/月起"
                    },
                    {
                        "area": "18",
                        "subway_station_info": "房源距篱笆房站步行约1393米",
                        "location_id": 0,
                        "template_type": 1,
                        "session_id": "1630094447121997824",
                        "page_source": "zraHomePage_search",
                        "zraExperimentId": "zrasearchstyle",
                        "zraGroupId": "projectstyle",
                        "zrrefer": "",
                        "name": "开间D户型·多朝向",
                        "tags": [
                            {
                                "style": {
                                    "background": "#1AFF961E",
                                    "color": "#FFFF961E"
                                },
                                "hot": 1,
                                "title": "自如寓"
                            },
                            {
                                "title": "智能家居"
                            },
                            {
                                "title": "集中供暖"
                            }
                        ],
                        "type": 6,
                        "house_type_sale_state": 2,
                        "photo": "http://img.ziroom.com/minsu/g2m1/M00/AC/FD/ChAFB1xHxriAE1wfAAfBm9_Smh8397.jpg_Z_930_620.jpg",
                        "price_unit": "/月起",
                        "version_name": "10001013",
                        "zra_extra": {
                            "house_type_id": "ff80808148f9ac210148f9ebd7610020",
                            "project_id": "20",
                            "project_name": "望京阳光自如寓-理房通测试项目",
                            "zra_display_type": 1,
                            "house_type_name": "望京自如寓·开间D户型",
                            "key_points": "2户合住 | 多种朝向",
                            "rent_unit": "2户合住",
                            "rent_unit_type": 3,
                            "reserve_num": -1,
                            "rooms_count": -1
                        },
                        "inv_no": "140886",
                        "price": 2999
                    },
                    {
                        "zraExperimentId": "zrasearchstyle",
                        "subway_station_info": "房源距篱笆房站步行约1393米",
                        "price": 2999,
                        "zra_extra": {
                            "house_type_name": "望京自如寓·开间E户型",
                            "project_name": "望京阳光自如寓-理房通测试项目",
                            "rooms_count": -1,
                            "zra_display_type": 1,
                            "house_type_id": "ff80808148f9ac210148f9f06e900024",
                            "key_points": "2户合住 | 多种朝向",
                            "project_id": "20",
                            "rent_unit": "2户合住",
                            "rent_unit_type": 3,
                            "reserve_num": -1
                        },
                        "zraGroupId": "projectstyle",
                        "page_source": "zraHomePage_search",
                        "template_type": 1,
                        "inv_no": "419819",
                        "name": "开间E户型·多朝向",
                        "tags": [
                            {
                                "style": {
                                    "background": "#1AFF961E",
                                    "color": "#FFFF961E"
                                },
                                "hot": 1,
                                "title": "自如寓"
                            },
                            {
                                "title": "智能家居"
                            },
                            {
                                "title": "集中供暖"
                            }
                        ],
                        "version_name": "10001013",
                        "location_id": 0,
                        "session_id": "1630094447121997824",
                        "area": "18",
                        "photo": "http://file.ziroom.com/g4m1/M00/04/C4/ChAFB1u7kKuAEIjUAAGrhIVm0_k702.JPG",
                        "price_unit": "/月起",
                        "type": 6,
                        "house_type_sale_state": 2,
                        "zrrefer": ""
                    },
                    {
                        "page_source": "zraHomePage_search",
                        "inv_no": "133826",
                        "photo": "http://file.ziroom.com/g4m1/M00/04/C4/ChAFB1u7kKmAQIAAAAG1sIMTHe0303.jpg",
                        "version_name": "10001011",
                        "template_type": 1,
                        "area": "28",
                        "name": "开间C户型·多朝向",
                        "tags": [
                            {
                                "style": {
                                    "background": "#1AFF961E",
                                    "color": "#FFFF961E"
                                },
                                "hot": 1,
                                "title": "自如寓"
                            },
                            {
                                "title": "集中供暖"
                            }
                        ],
                        "type": 6,
                        "zra_extra": {
                            "rent_unit_type": 2,
                            "rooms_count": -1,
                            "zra_display_type": 1,
                            "house_type_name": "望京自如寓·开间C户型",
                            "rent_unit": "整租1居",
                            "project_id": "20",
                            "project_name": "望京阳光自如寓-理房通测试项目",
                            "reserve_num": -1,
                            "house_type_id": "ff80808148f9ac210148f9ea769f001e",
                            "key_points": "整租1居 | 多种朝向"
                        },
                        "house_type_sale_state": 2,
                        "session_id": "1630094447121997824",
                        "price": 5299,
                        "price_unit": "/月起",
                        "zraExperimentId": "zrasearchstyle",
                        "zraGroupId": "projectstyle",
                        "zrrefer": "",
                        "location_id": 0,
                        "subway_station_info": "房源距篱笆房站步行约1393米"
                    },
                    {
                        "location_id": 0,
                        "session_id": "1630094447121997824",
                        "page_source": "zraHomePage_search",
                        "name": "开间B户型·多朝向",
                        "price_unit": "/月起",
                        "house_type_sale_state": 2,
                        "zrrefer": "",
                        "template_type": 1,
                        "area": "28",
                        "inv_no": "926853",
                        "version_name": "10001011",
                        "zraExperimentId": "zrasearchstyle",
                        "zraGroupId": "projectstyle",
                        "photo": "http://file.ziroom.com/g4m1/M00/04/C4/ChAFB1u7kKiAHNtBAAHABkdMArk028.JPG",
                        "price": 6099,
                        "subway_station_info": "房源距篱笆房站步行约1393米",
                        "tags": [
                            {
                                "style": {
                                    "background": "#1AFF961E",
                                    "color": "#FFFF961E"
                                },
                                "hot": 1,
                                "title": "自如寓"
                            },
                            {
                                "title": "智能水电"
                            },
                            {
                                "title": "集中供暖"
                            }
                        ],
                        "type": 6,
                        "zra_extra": {
                            "house_type_id": "ff80808148eedb3e0148eeeb4223000d",
                            "project_id": "20",
                            "zra_display_type": 1,
                            "rent_unit_type": 2,
                            "reserve_num": -1,
                            "rooms_count": -1,
                            "house_type_name": "望京自如寓·开间B户型",
                            "key_points": "整租1居 | 多种朝向",
                            "project_name": "望京阳光自如寓-理房通测试项目",
                            "rent_unit": "整租1居"
                        }
                    },
                    {
                        "price": 8199,
                        "price_unit": "/月起",
                        "tags": [
                            {
                                "style": {
                                    "background": "#1AFF961E",
                                    "color": "#FFFF961E"
                                },
                                "hot": 1,
                                "title": "自如寓"
                            },
                            {
                                "title": "智能家居"
                            },
                            {
                                "title": "集中供暖"
                            }
                        ],
                        "zra_extra": {
                            "house_type_id": "ff80808148f9ac210148f9f2dad70028",
                            "house_type_name": "望京自如寓·大开间B户型",
                            "rent_unit": "整租1居",
                            "rent_unit_type": 2,
                            "reserve_num": -1,
                            "key_points": "整租1居 | 北",
                            "project_id": "20",
                            "project_name": "望京阳光自如寓-理房通测试项目",
                            "rooms_count": -1,
                            "zra_display_type": 1
                        },
                        "location_id": 0,
                        "template_type": 1,
                        "session_id": "1630094447121997824",
                        "inv_no": "687518",
                        "house_type_sale_state": 2,
                        "page_source": "zraHomePage_search",
                        "type": 6,
                        "version_name": "10001011",
                        "zraGroupId": "projectstyle",
                        "zrrefer": "",
                        "area": "42",
                        "name": "大开间B户型·北",
                        "photo": "http://file.ziroom.com/g4m1/M00/04/C4/ChAFB1u7kKuAKsHDAAHUcXzLHfo726.jpg",
                        "subway_station_info": "房源距篱笆房站步行约1393米",
                        "zraExperimentId": "zrasearchstyle"
                    }
                ],
                "project_info": {
                    "focus_pic_list":[
                        "https://img.ziroom.com/minsu/g2m3/M00/83/55/ChAZE1-_EZmAPn66AACppq1pidc52.jpeg_Z_930_620.jpeg"
                    ],
                    "project_id": "20",
                    "min_price":"2000",
                    "commute_icon":"https://webimg.ziroom.com/d704fb82-28ac-4eaf-9e2d-4d6ada7623e8.png",
                    "commute_info":"commute_infocommute_infocommute_info",
                    "collection_num":60000,
                    "min_original_price":"3000",
                    "price_unit":"/月起",
                    "project_name": "望京阳光自如寓-理房通测试项目",
                    "subway_station_info": "房源距篱笆房站步行约1393米",
                    "router_title": "进入自如寓",
                    "target": "ziroomCustomer://zrRentModule/newZraDetailspage",
                    "parameter": {
                        "page_source": "zraHomePage_search",
                        "projectId": "20",
                        "session_id": "1630094447121997824"
                    },
                    "project_tags": [
                        {
                            "title": "人人享自如",
                            "icon":"https://img.ziroom.com/minsu/g2m3/M00/83/55/ChAZE1-_EZmAPn66AACppq1pidc52.jpeg_Z_930_620.jpeg"
                        }
                    ],
                    "background": "https://webimg.ziroom.com/d704fb82-28ac-4eaf-9e2d-4d6ada7623e8.png"
                }
            }
        },
        {
            "zrrefer": "1630094447121997824|1|4|0|search_result|zraHomePage_search",
            "location_id": 4,
            "template_type": 2,
            "session_id": "1630094447121997824",
            "page_source": "zraHomePage_search",
            "card_type": "zra",
            "zra_aggs": {
                "project_info": {
                    "project_tags": [
                        {
                            "title": "品牌标签修改",
                            "background": "#F4E00E",
                            "color": "#3D86ED"
                        },
                        {
                            "background": "#FF3737",
                            "color": "#FFFFFF",
                            "title": "项目详情页改版优惠券"
                        },
                        {
                            "background": "#08000000",
                            "color": "#99000000",
                            "title": "特色标签1"
                        },
                        {
                            "color": "#99000000",
                            "title": "将府特色1",
                            "background": "#08000000"
                        },
                        {
                            "color": "#99000000",
                            "title": "虾米普通",
                            "background": "#08000000"
                        }
                    ],
                    "background": "https://webimg.ziroom.com/d704fb82-28ac-4eaf-9e2d-4d6ada7623e8.png",
                    "project_id": "16",
                    "project_name": "直营勿改将府全智能自如寓",
                    "subway_station_info": "房源距将台站步行约2146米",
                    "router_title": "进入将府",
                    "target": "ziroomCustomer://zrRentModule/newZraDetailspage",
                    "parameter": {
                        "projectId": "16",
                        "session_id": "1630094447121997824",
                        "page_source": "zraHomePage_search"
                    }
                },
                "rooms": [
                    {
                        "zrrefer": "",
                        "location_id": 0,
                        "version_name": "10001012",
                        "original_price_style": {
                            "color": "#66000000"
                        },
                        "zraExperimentId": "zrasearchstyle",
                        "page_source": "zraHomePage_search",
                        "has_3d": 1,
                        "price": 220,
                        "price_unit": "/月起",
                        "zra_extra": {
                            "key_points": "整租2居 | 多种朝向",
                            "project_name": "直营勿改将府全智能自如寓",
                            "feature_label": "环境优美",
                            "address": "问问",
                            "description": "副标题",
                            "house_type_id": "0000000048e4565b0148e459acd40002",
                            "reserve_num": -1,
                            "rooms_count": -1,
                            "labelmg": "https://webimg.ziroom.com/d8d99c27-0bda-4014-94c7-caa492ff95db.png",
                            "house_type_name": "开间A户型",
                            "rent_unit": "整租2居",
                            "rent_unit_type": 4,
                            "zra_display_type": 2,
                            "project_id": "16",
                            "introduction": "标题"
                        },
                        "house_type_sale_state": 2,
                        "template_type": 1,
                        "area": "10",
                        "name": "开间A户型·多朝向",
                        "type": 6,
                        "price_style": {
                            "color": "#FFFF3737"
                        },
                        "tags": [
                            {
                                "style": {
                                    "background": "#1AFF961E",
                                    "color": "#FFFF961E"
                                },
                                "hot": 1,
                                "title": "自如寓"
                            },
                            {
                                "title": "独立卫生间"
                            },
                            {
                                "title": "智能家居"
                            }
                        ],
                        "original_price": "¥5799/月起",
                        "zraGroupId": "projectstyle",
                        "session_id": "1630094447121997824",
                        "intro_list": [
                            {
                                "icon": "https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png",
                                "is_marked": 0,
                                "title": "xx6819元起"
                            }
                        ],
                        "inv_no": "455115",
                        "photo": "http://10.16.34.44:8000/minsu/group3/M00/1A/57/ChAiKmMIa_qATPYwACdRCepTdlE829.jpg_Z_930_620.jpg",
                        "subway_station_info": "房源距将台站步行约2146米"
                    },
                    {
                        "inv_no": "285596",
                        "price": 200,
                        "price_unit": "/月起",
                        "subway_station_info": "房源距将台站步行约2146米",
                        "type": 6,
                        "zraExperimentId": "zrasearchstyle",
                        "location_id": 0,
                        "area": "1",
                        "page_source": "zraHomePage_search",
                        "zraGroupId": "projectstyle",
                        "zra_extra": {
                            "rent_unit_type": 4,
                            "reserve_num": -1,
                            "labelmg": "https://webimg.ziroom.com/d8d99c27-0bda-4014-94c7-caa492ff95db.png",
                            "key_points": "2户合住 | 多种朝向",
                            "project_id": "16",
                            "description": "副标题",
                            "introduction": "标题",
                            "house_type_name": "大房间",
                            "project_name": "直营勿改将府全智能自如寓",
                            "zra_display_type": 2,
                            "address": "问问",
                            "house_type_id": "8a9093ad7010f23d017033072e5b0059",
                            "rent_unit": "2户合住",
                            "rooms_count": -1
                        },
                        "template_type": 1,
                        "version_name": "10001013",
                        "name": "大房间·多朝向",
                        "photo": "http://10.16.34.44:8000/minsu/group2/M00/23/71/ChAiLmKO43qAGkYPAAFMSdSotWM943.jpg_Z_930_620.jpg",
                        "tags": [
                            {
                                "title": "自如寓",
                                "style": {
                                    "background": "#1AFF961E",
                                    "color": "#FFFF961E"
                                },
                                "hot": 1
                            },
                            {
                                "title": "公共区域大"
                            }
                        ],
                        "house_type_sale_state": 2,
                        "zrrefer": "",
                        "session_id": "1630094447121997824"
                    },
                    {
                        "name": "开间B户型·多朝向",
                        "photo": "http://10.16.34.44:8000/minsu/group1/M00/23/F7/ChAiMGKNkGuAM_gpAASSA-W-zBs80.jpeg_Z_930_620.jpeg",
                        "price": 900,
                        "subway_station_info": "房源距将台站步行约2146米",
                        "zra_extra": {
                            "labelmg": "https://webimg.ziroom.com/d8d99c27-0bda-4014-94c7-caa492ff95db.png",
                            "house_type_id": "0000000048e846de0148e8492d4b0002",
                            "project_id": "16",
                            "description": "副标题",
                            "project_name": "直营勿改将府全智能自如寓",
                            "reserve_num": -1,
                            "rent_unit": "床位",
                            "rooms_count": -1,
                            "rent_unit_type": 4,
                            "zra_display_type": 2,
                            "address": "问问",
                            "introduction": "标题",
                            "house_type_name": "开间B户型",
                            "key_points": "床位 | 多种朝向"
                        },
                        "zrrefer": "",
                        "page_source": "zraHomePage_search",
                        "area": "4",
                        "original_price": "¥1111/月起",
                        "original_price_style": {
                            "color": "#66000000"
                        },
                        "template_type": 1,
                        "inv_no": "156392",
                        "version_name": "10001015",
                        "price_style": {
                            "color": "#FFFF3737"
                        },
                        "zraGroupId": "projectstyle",
                        "house_type_sale_state": 2,
                        "location_id": 0,
                        "session_id": "1630094447121997824",
                        "tags": [
                            {
                                "style": {
                                    "background": "#1AFF961E",
                                    "color": "#FFFF961E"
                                },
                                "hot": 1,
                                "title": "自如寓"
                            },
                            {
                                "title": "智能家居"
                            },
                            {
                                "title": "智能水电"
                            }
                        ],
                        "price_unit": "/月起",
                        "type": 6,
                        "zraExperimentId": "zrasearchstyle"
                    },
                    {
                        "zrrefer": "",
                        "location_id": 0,
                        "page_source": "zraHomePage_search",
                        "name": "房型88·多朝向",
                        "tags": [
                            {
                                "style": {
                                    "background": "#1AFF961E",
                                    "color": "#FFFF961E"
                                },
                                "hot": 1,
                                "title": "自如寓"
                            },
                            {
                                "title": "智能家居"
                            },
                            {
                                "title": "智能水电"
                            }
                        ],
                        "house_type_sale_state": 1,
                        "template_type": 1,
                        "session_id": "1630094447121997824",
                        "area": "11",
                        "inv_no": "643351",
                        "price_unit": "/月起",
                        "zraExperimentId": "zrasearchstyle",
                        "zraGroupId": "projectstyle",
                        "photo": "http://10.16.34.44:8000/minsu/group1/M00/19/F9/ChAiMF8egIuAUHIRAAjYyU5obD0503.png_Z_930_620.png",
                        "type": 6,
                        "zra_extra": {
                            "house_type_name": "房型88",
                            "reserve_num": -1,
                            "rooms_count": -1,
                            "labelmg": "https://webimg.ziroom.com/d8d99c27-0bda-4014-94c7-caa492ff95db.png",
                            "zra_display_type": 2,
                            "address": "问问",
                            "description": "副标题",
                            "house_type_id": "8a768c0c7370416401738f2ce1290095",
                            "project_id": "16",
                            "project_name": "直营勿改将府全智能自如寓",
                            "rent_unit": "整租3居",
                            "key_points": "整租3居 | 多种朝向",
                            "rent_unit_type": 4,
                            "introduction": "标题"
                        },
                        "subway_station_info": "房源距将台站步行约2146米",
                        "version_name": "10001016"
                    },
                    {
                        "area": "3",
                        "photo": "http://img.ziroom.com/minsu/g2m1/M00/FB/61/ChAFBlwQx9OAVrW0AAOWXYgBDYU946.jpg_Z_930_620.jpg",
                        "price_unit": "/月",
                        "tags": [
                            {
                                "style": {
                                    "color": "#FFFF961E",
                                    "background": "#1AFF961E"
                                },
                                "hot": 1,
                                "title": "自如寓"
                            },
                            {
                                "title": "公共区域大"
                            }
                        ],
                        "zraGroupId": "projectstyle",
                        "zrrefer": "",
                        "page_source": "zraHomePage_search",
                        "price": 1000,
                        "house_type_sale_state": 1,
                        "location_id": 0,
                        "session_id": "1630094447121997824",
                        "name": "套间B户型·其他",
                        "zra_extra": {
                            "address": "问问",
                            "rent_unit": "整租1居",
                            "reserve_num": -1,
                            "rooms_count": -1,
                            "feature_label": "消杀 | 虾米压图标签 | 虾米压图标签",
                            "labelmg": "https://webimg.ziroom.com/d8d99c27-0bda-4014-94c7-caa492ff95db.png",
                            "house_type_id": "8a90a3ab574465ac0157567f3f26031a",
                            "project_name": "直营勿改将府全智能自如寓",
                            "rent_unit_type": 4,
                            "zra_display_type": 2,
                            "house_type_name": "套间B户型",
                            "key_points": "整租1居 | 其他",
                            "project_id": "16",
                            "introduction": "标题",
                            "description": "副标题"
                        },
                        "zraExperimentId": "zrasearchstyle",
                        "template_type": 1,
                        "inv_no": "742988",
                        "version_name": "10001011",
                        "subway_station_info": "房源距将台站步行约2146米",
                        "type": 6
                    }
                ]
            }
        }
    ],
    "query_session_id": "1630094447121997824",
    "pass_through": "{}",
    "experiments": {},
    "re_call_type": ""
}"""

}