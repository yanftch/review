package com.yanftch.review

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yanftch.review.android.activity.EventActivity
import com.yanftch.review.android.activity.EventCase1Activity
import com.yanftch.review.android.activity.TextSwitcherActivity
import com.yanftch.review.bean.MenuItems

class MainActivity : AppCompatActivity() {
    val TAG = "debug_MainActivity"
    private lateinit var recyclerView: RecyclerView
    private lateinit var datas: ArrayList<MenuItems>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        generateDatas()

        val lm = LinearLayoutManager(this)
        recyclerView = findViewById(R.id.rv)
        recyclerView.adapter = RvAdapter()
        recyclerView.layoutManager = lm
    }

    private fun generateDatas() {
        datas = ArrayList()
        datas.apply {
            add(
                MenuItems(
                    name = "事件分发", highlight = true, clazz = EventActivity::class.java
                )
            )
            add(
                MenuItems(
                    name = "事件分发-案例", highlight = false, clazz = EventCase1Activity::class.java
                )
            )
            add(
                MenuItems(
                    name = "TextSwitcher实现自动垂直滚动", clazz = TextSwitcherActivity::class.java
                )
            )
            add(
                MenuItems(
                    name = "VP2+transform的Banner",
                )
            )
        }

    }

    inner class RvAdapter() : RecyclerView.Adapter<RvAdapter.RvViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
            val view = layoutInflater.inflate(R.layout.rv_item, parent, false)
            return RvViewHolder(view)
        }

        override fun getItemCount() = datas.size

        override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
            holder.render(datas[position])
        }

        inner class RvViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private lateinit var title: TextView

            fun render(item: MenuItems) {
                title = itemView.findViewById(R.id.text_view)
                if (item.highlight) {
                    title.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.color_c1_50))
                } else {
                    title.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.white))
                }
                title.text = item.name
                title.setOnClickListener {
                    if (item.clazz != null) {
                        startActivity(Intent(this@MainActivity, item.clazz))
                    }
                }
            }
        }
    }
}