package com.yanftch.review.android.fragment.new_home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.fastjson.JSONObject
import com.yanftch.review.R
import com.yanftch.review.android.fragment.ZraMainProjectListAdapter
import com.yanftch.review.android.fragment.new_home.model.DataUtils
import com.yanftch.review.android.fragment.new_home.model.ZraRecommendzryEntity
import com.yanftch.review.android.utils.DensityUtil


class ZraMainProjectListFragment : Fragment() {

    private var mList: MutableList<ZraRecommendzryEntity.RecommendZRY> = mutableListOf()

    private var mFragmentActivity: FragmentActivity? = null

    private lateinit var mRv: RecyclerView
    private lateinit var mAdapter: ZraMainProjectListAdapter
    private lateinit var mVsEmpty: ViewStub

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFragmentActivity = activity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.zra_fragment_main_project_list, container, false)
        initView(view)
        initData()
        return view
    }

    private fun initData() {

    }

    private fun initView(view: View) {
        mVsEmpty = view.findViewById(R.id.vs_empty)

        mList =
            JSONObject.parseArray(DataUtils.json, ZraRecommendzryEntity.RecommendZRY::class.java)

        mRv = view.findViewById(R.id.rv_list)
        mRv.layoutManager =
            LinearLayoutManager(mFragmentActivity, LinearLayoutManager.VERTICAL, false)

        mAdapter = ZraMainProjectListAdapter(mFragmentActivity, mList)
        mRv.addItemDecoration(
            DividerRecyclerDecoration(
                mFragmentActivity,
                DensityUtil.dip2px(mFragmentActivity, 10f),
                false
            )
        )
        mRv.adapter = mAdapter

        mVsEmpty.visibility=View.VISIBLE
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ZraMainProjectListFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}