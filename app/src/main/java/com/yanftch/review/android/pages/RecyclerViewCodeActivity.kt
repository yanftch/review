package com.yanftch.review.android.pages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import com.yanftch.review.R
import com.yanftch.review.android.modules.ProjectBean
import com.yanftch.review.android.vm.RecyclerViewCodeViewModel
import org.jetbrains.anko.find

class RecyclerViewCodeActivity : AppCompatActivity() {
    private val TAG = "debug_RecyclerViewCodeActivity"
    private lateinit var rv: RecyclerView
    private var list = mutableListOf<ProjectBean>()
    private lateinit var adapter: MyAdapter
    private lateinit var layoutManager: LinearLayoutManager

    val viewModel by lazy {
        ViewModelProviders.of(this).get(RecyclerViewCodeViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_code)
        initView()
        viewModel.getData()
        initVm()

        find<TextView>(R.id.tv_btn).setOnClickListener {
                val layoutManager = rv.layoutManager as LinearLayoutManager
            val findFirstCompletelyVisibleItemPosition =
                layoutManager.findFirstCompletelyVisibleItemPosition()
            val findFirstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

            Log.e(TAG, "onCreate: " + "findFirstCompletelyVisibleItemPosition = $findFirstCompletelyVisibleItemPosition" + "\r\n"
            + ", findFirstVisibleItemPosition = $findFirstVisibleItemPosition"
            )

        }
    }

    private fun initVm() {
        viewModel.listData.observe(this, Observer {
            Log.e(TAG, "initVm: " + it.size)
            adapter.setData(it)
        })
    }

    private fun initView() {
        rv = findViewById(R.id.rv_list)
        adapter = MyAdapter()
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv.adapter = adapter
    }

    inner class MyAdapter : RecyclerView.Adapter<MyViewHolder>() {
        fun setData(l: MutableList<ProjectBean>?) {
            l?.let {
                list.clear()
                list.addAll(it)
                notifyDataSetChanged()
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            return MyViewHolder(
                layoutInflater.inflate(
                    R.layout.layout_item_project_info,
                    parent,
                    false
                )
            )
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.render(list[position], position)
        }

        override fun getItemCount() = list.size
    }

    inner class MyViewHolder(iView: View) : RecyclerView.ViewHolder(iView) {

        private var pvImage: SimpleDraweeView = iView.findViewById(R.id.pv_image)
        private var tvPosition: TextView = iView.findViewById(R.id.tv_debug_info)
        private var tvSubTitle: TextView = iView.findViewById(R.id.tv_sub_title)

        fun render(bean: ProjectBean, position: Int) {
            Log.e(TAG, "render: position = $position, " + bean.houseTypeName)
            pvImage.setImageURI(bean.houseTypePic)
            tvPosition.text = "$position"

            tvSubTitle.text = bean.subwayStationInfo + " = " + bean.subwayStationInfo

        }
    }
}