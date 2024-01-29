package com.yanftch.review.android.pages.two_tab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yanftch.review.R

class TwoTabActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val array = com.alibaba.fastjson.JSONArray.parseArray(T, Media::class.java)

        setContentView(R.layout.activity_two_tab)
    }

    val T = """[
  {
    "hx_photo": {
      "photo": "https://img.ziroom.com/pic/house_images/g2m2/M00/71/31/CtgFCVycQZuAF0nIAAKrhK3Fr3c723.jpg_C_800_600_Q100.webp"
    },
    "name": "户型图",
    "interaction_type": 5
  },
  {
    "name": "全景视频",
    "interaction_type": 4,
    "video": {
      "cover": "https://vr.ziroom.com/temphousevr/1654768350734/7906604/realsee_edit/media_files/3e624da8d41c84d19a2ee6ab199ca050.jpg_C_600_800_Q80.jpg",
      "animated_cover": "https://amsimg.ziroom.com/14f20a73-3f74-4956-953c-ce4adf8877d2.webp",
      "url": "http://hot.t.ziroom.com/2022/panoVideo/?source=frontend&inv_no=778842958",
      "video_type": 2,
      "router": {
        "target": "ziroomCustomer://zrRentModule/jumpUniversePage",
        "parameter": {
          "autoCallBack": 0,
          "inv_no": "777181930",
          "id": "62152916",
          "house_id": "60338493"
        }
      },
      "type": "H5"
    },
    "is_selected": 1
  },
  {
    "name": "VR",
    "interaction_type": 2,
    "vr": {
      "source": 1,
      "router": {
        "target": "ziroomCustomer://zrRentModule/toRushiVr",
        "parameter": {
          "url": "https://realsee.com/ziroom/bW0Pr35emWW356gj/dpalejxJOKqbfXhjhxcj4QqtnJAPg9VQ/",
          "invNo": "777181930",
          "versionName": "整租4.0高配版",
          "needLogin": 0
        }
      },
      "cover": "https://vrlab-image4.ljcdn.com/release/auto3dhd/b08b27f1d25d45308b10df150df51797/screenshot/1539759462_6/pc0_UJiIHz2ph.jpg?imageMogr2/quality/70/thumbnail/1024x"
    }
  },
  {
    "name": "相册",
    "interaction_type": 3,
    "album": [
      {
        "photos": [
          {
            "photo": "https://img.ziroom.com/pic/house_images/g2m2/M00/77/A0/CtgFCFydyfuATgzrABW4LXfq93E409.jpg_C_800_600_Q100.webp"
          },
          {
            "photo": "https://img.ziroom.com/pic/house_images/g2m2/M00/77/A0/CtgFCFydyfyAHpMsABhg2f1i3Oc604.jpg_C_800_600_Q100.webp"
          },
          {
            "photo": "https://img.ziroom.com/pic/house_images/g2m2/M00/77/A0/CtgFCFydyf2AVtymABTXqr2ZU5A691.jpg_C_800_600_Q100.webp"
          },
          {
            "photo": "https://img.ziroom.com/pic/house_images/g2m2/M00/77/A0/CtgFCFydyfuAfbBSABU4218vaBM617.jpg_C_800_600_Q100.webp"
          }
        ],
        "name": "起居室",
        "album_type": 0
      },
      {
        "name": "主卧",
        "album_type": 0,
        "photos": [
          {
            "photo": "https://img.ziroom.com/pic/house_images/g2m2/M00/77/9E/CtgFCVydyf-AQFdFABcstsmMqvs132.jpg_C_800_600_Q100.webp"
          },
          {
            "photo": "https://img.ziroom.com/pic/house_images/g2m2/M00/77/A0/CtgFCFydyfeAbHJBABS20hgykYQ296.jpg_C_800_600_Q100.webp"
          },
          {
            "photo": "https://img.ziroom.com/pic/house_images/g2m2/M00/77/A0/CtgFCFydyfiAcCMhABTa6DGjmQU407.jpg_C_800_600_Q100.webp"
          }
        ]
      },
      {
        "name": "次卧",
        "album_type": 0,
        "photos": [
          {
            "photo": "https://img.ziroom.com/pic/house_images/g2m2/M00/77/A0/CtgFCFydyfqAZZTWAA504KAS_jc940.jpg_C_800_600_Q100.webp"
          },
          {
            "photo": "https://img.ziroom.com/pic/house_images/g2m2/M00/77/A0/CtgFCFydyfqACz1FABMbc5EGKr4844.jpg_C_800_600_Q100.webp"
          }
        ]
      },
      {
        "name": "厨房",
        "album_type": 0,
        "photos": [
          {
            "photo": "https://img.ziroom.com/pic/house_images/g2m2/M00/77/A0/CtgFCFydyf6APEaAABdTlUIWju8067.jpg_C_800_600_Q100.webp"
          },
          {
            "photo": "https://img.ziroom.com/pic/house_images/g2m2/M00/77/A0/CtgFCFydyf2ASbuFABf7AaVHG7A743.jpg_C_800_600_Q100.webp"
          },
          {
            "photo": "https://img.ziroom.com/pic/house_images/g2m2/M00/77/A0/CtgFCFydyf6ALuVsABUhZtW6YHI978.jpg_C_800_600_Q100.webp"
          }
        ]
      },
      {
        "album_type": 0,
        "photos": [
          {
            "photo": "https://img.ziroom.com/pic/house_images/g2m2/M00/77/9E/CtgFCVydygaAOe82ABooHnujPfE224.jpg_C_800_600_Q100.webp"
          }
        ],
        "name": "餐厅"
      },
      {
        "name": "卫生间",
        "album_type": 0,
        "photos": [
          {
            "photo": "https://img.ziroom.com/pic/house_images/g2m2/M00/77/A0/CtgFCFydyf-Aa9qgABy87nLWJs8948.jpg_C_800_600_Q100.webp"
          }
        ]
      },
      {
        "album_type": 1,
        "photos": [
          {
            "name": "楼体外观",
            "photo": "https://amsimg.ziroom.com/2e7007de-987b-4ccb-ac34-7c2d55f4e4a2.jpg?imageMogr2/thumbnail/800x600"
          },
          {
            "name": "楼体外观",
            "photo": "https://amsimg.ziroom.com/f4427873-6911-47c8-9834-63a77220754e.jpg?imageMogr2/thumbnail/800x600"
          },
          {
            "name": "景观",
            "photo": "https://amsimg.ziroom.com/d45ac346-1029-48a2-b2e1-8b62c92f16ec.jpg?imageMogr2/thumbnail/800x600"
          },
          {
            "name": "景观",
            "photo": "https://amsimg.ziroom.com/d33d5cc0-f4c4-4f02-9c94-4af56255d64d.jpg?imageMogr2/thumbnail/800x600"
          },
          {
            "name": "活动场所",
            "photo": "https://amsimg.ziroom.com/a8a27d1e-b321-400f-a677-8d0d94c9b018.jpg?imageMogr2/thumbnail/800x600"
          }
        ],
        "name": "小区"
      }
    ]
  }
]"""
}