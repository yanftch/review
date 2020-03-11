package com.yanftch.review.android.pages

import android.os.Bundle
import android.util.Log
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
import org.jetbrains.anko.sdk15.listeners.onClick
import org.jetbrains.anko.textColorResource
import org.jetbrains.anko.verticalLayout

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var datas: ArrayList<ItemModel>
    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: LinearLayoutManager
    var glide: Glide? = null
    private lateinit var sparseArray: SparseArray<String>
    private var linearLayout: LinearLayout? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sparseArray = SparseArray()
        sparseArray.put(1, "s")


        datas = ArrayList()
        for (i in 0..20) {
            val model = ItemModel("name $i", false)
            datas.add(model)
        }

        layoutManager = LinearLayoutManager(this)


        setContentView(UI {
            verticalLayout {
                recyclerView = recyclerView {

                }
            }
        }.view)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter =
            MyAdapter(datas, object : ItemClick{
                override fun onItemClick(model: ItemModel) {
                }

            })
        recyclerView.scrollToPosition(20)

    }

    class MyAdapter(var datas: ArrayList<ItemModel>, var c: ItemClick) :
        RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

        lateinit var itemClick:ItemClick

        companion object{
            var mSelectedPosition: Int = -1
            var mList = mutableListOf<ItemModel>()
        }
        init {
            mList = datas
            itemClick = c
        }

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): MyViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, null, false)
            return MyViewHolder(view)
        }

        override fun getItemCount(): Int = datas.size

        override fun onBindViewHolder(
            holder: MyViewHolder,
            position: Int
        ) {
            holder.render(datas[position], position)
        }


        open class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var textView: TextView? = null

            init {
                textView = itemView.findViewById(R.id.text_view)
            }

            fun render(msg: ItemModel, position: Int) {
                textView?.text = msg.name
                if (msg.selected) {
                    textView?.textColorResource = R.color.colorAccent
                } else {
                    textView?.textColorResource = R.color.black_900
                }
                textView?.onClick {
                    Log.e("debug_", ": $msg,  position = $position")
                }
            }
        }
    }

    interface ItemClick{
        fun onItemClick(model:ItemModel)
    }

    data class ItemModel(
        var name: String,
        var selected: Boolean
    )
}
