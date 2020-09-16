package com.yanftch.review.android.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yanftch.review.R
import java.util.*

class CoordinatorLayoutActivity : AppCompatActivity() {
    private lateinit var mRecyclerView: RecyclerView
    private val mStrings = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coordinator_layout)
        mRecyclerView = findViewById(R.id.rv_list)

        for (i in 0..49) {
            mStrings.add("item$i")
        }
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.adapter = MyAdapter(
            mStrings
        ) // 先设置高度，后设置数据源

    }


    internal class MyAdapter(private val mList: ArrayList<String>) :
        RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): MyViewHolder {
            return MyViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.rv_item, null, false)
            )
        }

        override fun onBindViewHolder(
            holder: MyViewHolder,
            position: Int
        ) {
            holder.render(mList[position])
        }

        override fun getItemCount(): Int {
            return mList.size
        }

        internal inner class MyViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView) {
            private val mTitle: TextView = itemView.findViewById(R.id.text_view)
            fun render(o: String?) {
                mTitle.text = o
            }

        }

    }
}
