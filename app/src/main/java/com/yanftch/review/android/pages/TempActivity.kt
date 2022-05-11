package com.yanftch.review.android.pages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.yanftch.review.R
import com.yanftch.review.android.view.MarqueeView
import org.jetbrains.anko.find
import org.jetbrains.anko.toast

class TempActivity : AppCompatActivity() {
    private lateinit var  mrView: MarqueeView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temp)
        
//        val list = mutableListOf<String>()
//        list.add("第一次，我们大家一起走")
//        list.add("第二次，我和小红一起走天津哦")
//        list.add("第三次，我和小明一起玩好不好好")
//        list.add("44444444444")
//        list.add("5555")
//        list.add("6666666")
//
//        mrView = find(R.id.marquee_view)
//        mrView.startWithList(list)
//        mrView.setOnItemClickListener(object : MarqueeView.OnItemClickListener{
//            override fun onItemClick(position: Int, text: CharSequence?) {
//                toast("position = $position, text = ${text}")
//            }
//        })

//        initControlView()
    }
//
//    private
//    /**
//    * 初始化操作栏所有widget
//    */
//    private fun initControlView() {
//
//    }
}