package com.yanftch.review.android.pages

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.yanftch.review.R
import com.yanftch.review.android.modules.Item
import com.yanftch.review.android.utils.getFilterDatas
import com.yanftch.review.android.view.ExpandableListViewDialog
import kotlinx.android.synthetic.main.activity_expandable_list_view.*
import org.jetbrains.anko.find
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast


/**
 * 二级列表
 */

class ExpandableListViewActivity : AppCompatActivity() {

    private lateinit var eListView: ExpandableListView
    private lateinit var adapter: com.yanftch.review.android.pages.ExpandAdapter
    private lateinit var groups: ArrayList<String>
    private lateinit var items: HashMap<String, List<com.yanftch.review.android.modules.Item>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expandable_list_view)
        handleData()
        initViews()
        btn_ancho.setOnClickListener {
            onDone()
        }
        btn_show_dlg.setOnClickListener {
            btnShow()
        }
    }

    fun btnShow() {
//        var dlg = ExpandableListViewDialog()
        val dlg = ExpandableListViewDialog("a", object : ExpandableListViewDialog.DialogClickListener {
            @SuppressLint("LongLogTag")
            override fun rightEvent(obj: Any) {
                Log.e("debug_ExpandableListViewActivity", "rightEvent: 啥？$obj")
            }
        })
        dlg.show(supportFragmentManager, "")
    }

    fun onDone() {
        toast("submit")
        items.keys.forEach {
            //            Log.e("debug_ExpandableListViewActivity", "btnDone: $it")
            var list = items.get(it) ?: emptyList()

            for (item in list) {
                Log.e("debug_ExpandableListViewActivity", "btnDone: ${item.itemName}     ${item.isSingleChecked}     ")
            }

        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        // 设置箭头指示器的位置
        eListView.setIndicatorBounds(eListView.right - 120, eListView.width)
    }

    @SuppressLint("LongLogTag")
    private fun initViews() {
        eListView = find(R.id.expand_listview)
        adapter = com.yanftch.review.android.pages.ExpandAdapter(groups, items, this)
        eListView.setAdapter(adapter)
        // 默认展开
        for (i in 0 until adapter.groupCount) {
            eListView.expandGroup(i)
        }

        eListView.setOnChildClickListener { _, _, groupPosition, childPosition, id ->

            if (groupPosition == 1) {
                items.get(groups.get(groupPosition))?.get(childPosition)?.isSingleChecked =
                    items.get(groups.get(groupPosition))?.get(childPosition)?.isSingleChecked != true

            } else {
                // 单选
                val size = items.get(groups.get(groupPosition))?.size ?: 0
                val tempItems = items.get(groups.get(groupPosition)) ?: emptyList()
                for (item in tempItems) {
                    item.isSingleChecked = false
                }
                items.get(groups.get(groupPosition))?.get(childPosition)?.isSingleChecked = true
            }
            adapter.notifyDataSetChanged()
            longToast(
                "you click: group=${groups[groupPosition]}      child=${items.get(groups.get(groupPosition))?.get(
                    childPosition
                )}      id=$id"
            )
            Log.e(
                "debug_ExpandableListViewActivity",
                "initViews: you click: group=${groups[groupPosition]}      child=${items.get(groups.get(groupPosition))?.get(
                    childPosition
                )}      id=$id"
            )
            true
        }
    }

    private fun handleData() {
        items = HashMap()
        items.putAll(getFilterDatas())
        groups = ArrayList(items.keys)

    }
}

class ExpandAdapter(
    private var groups: ArrayList<String>,
    var items: HashMap<String, List<com.yanftch.review.android.modules.Item>>,
    var context: Context?
) :
    BaseExpandableListAdapter() {

    override fun getGroup(groupPosition: Int) = groups[groupPosition]

    override fun getGroupCount() = groups.size

    override fun getGroupId(groupPosition: Int) = groupPosition.toLong()

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View? {
        val viewHolder: com.yanftch.review.android.pages.ExpandAdapter.ViewHolderGroup
        var convertView = convertView

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.expand_lv_item_group, parent, false)
            viewHolder = com.yanftch.review.android.pages.ExpandAdapter.ViewHolderGroup()
            viewHolder.tvGroupName = convertView.find(R.id.tv_group_name)
            viewHolder.divider = convertView.find(R.id.view_divider)
            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as com.yanftch.review.android.pages.ExpandAdapter.ViewHolderGroup
        }
        viewHolder.tvGroupName?.text = groups[groupPosition]
        if (!isExpanded) {
            viewHolder.divider?.visibility = View.GONE
        } else {
            viewHolder.divider?.visibility = View.GONE
        }
        return convertView
    }

    override fun getChild(groupPosition: Int, childPosition: Int) =
        items.get(groups.get(groupPosition))?.get(childPosition)

    override fun getChildrenCount(groupPosition: Int): Int = items.get(groups.get(groupPosition))?.size ?: 0

    override fun getChildId(groupPosition: Int, childPosition: Int) = childPosition.toLong()

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View? {
        val itemHolder: com.yanftch.review.android.pages.ExpandAdapter.ViewHolderItem
        var convertView = convertView

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.expand_lv_item_child, parent, false)
            itemHolder = com.yanftch.review.android.pages.ExpandAdapter.ViewHolderItem()
            itemHolder.tvItemName = convertView.findViewById(R.id.tv_item_name) as TextView
            itemHolder.icIndicator = convertView.findViewById(R.id.iv_check) as ImageView
            itemHolder.view_divider = convertView.findViewById(R.id.view_divider) as View
            convertView.tag = itemHolder
        } else {
            itemHolder = convertView.tag as com.yanftch.review.android.pages.ExpandAdapter.ViewHolderItem
        }
        itemHolder.tvItemName?.text = items.get(groups.get(groupPosition))?.get(childPosition)?.itemName
        itemHolder.icIndicator?.visibility =
            if (items.get(groups.get(groupPosition))?.get(childPosition)?.isSingleChecked == true) View.VISIBLE else View.INVISIBLE
        if (isLastChild) {
            itemHolder.view_divider?.visibility = View.GONE
        } else {
            itemHolder.view_divider?.visibility = View.GONE
        }
        return convertView
    }


    override fun hasStableIds(): Boolean = false

    override fun isChildSelectable(groupPosition: Int, childPosition: Int) = true

    private class ViewHolderGroup {
        var tvGroupName: TextView? = null
        var divider: View? = null

    }

    private class ViewHolderItem {
        // 文案
        var tvItemName: TextView? = null
        // icon
        var icIndicator: ImageView? = null
        var view_divider: View? = null

    }

}