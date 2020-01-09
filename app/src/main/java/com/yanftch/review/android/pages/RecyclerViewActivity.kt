package com.yanftch.review.android.pages

import android.os.Bundle
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yanftch.review.R
import org.jetbrains.anko.UI
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.verticalLayout

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var datas: ArrayList<String>
    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: LinearLayoutManager
    var glide: Glide? = null
    private lateinit var newDatas: ArrayList<String>
    private lateinit var sparseArray: SparseArray<String>
    private var linearLayout: LinearLayout? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sparseArray = SparseArray()
        sparseArray.put(1, "s")


        datas = ArrayList()
        for (i in 0..100) {
            datas.add("item $i")
        }
        newDatas = ArrayList()
        newDatas.add("newItem1")
        newDatas.add("newItem2")
        newDatas.add("newItem3")

        datas.addAll(2, newDatas)


        layoutManager = LinearLayoutManager(this)


        setContentView(UI {
            verticalLayout {
                recyclerView = recyclerView {

                }
            }
        }.view)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter =
            com.yanftch.review.android.pages.RecyclerViewActivity.MyAdapter(datas)
        recyclerView.scrollToPosition(20)

    }

    private class MyAdapter(val datas: ArrayList<String>) :
        RecyclerView.Adapter<com.yanftch.review.android.pages.RecyclerViewActivity.MyAdapter.MyViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): com.yanftch.review.android.pages.RecyclerViewActivity.MyAdapter.MyViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, null, false)
            return com.yanftch.review.android.pages.RecyclerViewActivity.MyAdapter.MyViewHolder(view)
        }

        override fun getItemCount(): Int = datas.size

        override fun onBindViewHolder(holder: com.yanftch.review.android.pages.RecyclerViewActivity.MyAdapter.MyViewHolder, position: Int) {
            holder.render("${datas[position]}: position=$position")
        }


        class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var textView: TextView? = null

            init {
                textView = itemView.findViewById(R.id.text_view)
            }

            fun render(msg: String) {
                textView?.text = msg
            }
        }
    }
}
