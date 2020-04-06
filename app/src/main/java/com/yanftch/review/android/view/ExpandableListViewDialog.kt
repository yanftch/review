package com.yanftch.review.android.view

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.*
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.yanftch.review.R
import com.yanftch.review.android.modules.Item
import com.yanftch.review.android.utils.getFilterDatas
import org.jetbrains.anko.find
import org.jetbrains.anko.support.v4.longToast
import org.jetbrains.anko.support.v4.toast

/**
 *
 * User : yanftch
 * Date : 2019-08-23
 * Time : 10:48
 * Desc :
 */
class ExpandableListViewDialog(
    tag: String?,
    dialogClickListener: DialogClickListener
) : DialogFragment() {

    private lateinit var eListView: ExpandableListView
    private lateinit var adapter: ExpandAdapter
    private lateinit var groups: ArrayList<String>
    private lateinit var items: HashMap<String, List<com.yanftch.review.android.modules.Item>>
    private lateinit var mDialog: Dialog
    private var onKeyListener: OnKeyListener? = null
    private var eventListener: DialogClickListener? = null

    init {
        eventListener = dialogClickListener
    }

    override fun show(manager: FragmentManager, tag: String?) {
        super.show(manager, tag)
    }


    interface OnKeyListener {
        fun onkeyDown(keyCode: Int, event: KeyEvent): Boolean
    }

    interface DialogClickListener {
        fun rightEvent(obj: Any)
    }

    @SuppressLint("InflateParams")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view = activity?.layoutInflater?.inflate(R.layout.activity_expandable_list_view, null, false)

        mDialog = Dialog(context, R.style.dialog_background_dimEnabled)
        dialogSettings()

        mDialog.setContentView(view)//添加view
        // 必须在 setContentView 之后调用
        mDialog.window.setBackgroundDrawable(ColorDrawable(0x00000000))
        var window = mDialog.window
        window.setGravity(Gravity.RIGHT)
        var lp = window.attributes
        var defaultDisplay = window.windowManager.defaultDisplay
        val w = (defaultDisplay.width * 0.8).toInt()

        mDialog.window.setLayout(w, WindowManager.LayoutParams.MATCH_PARENT)
        handleData()
        initViews(view)
        mDialog.setOnKeyListener { dialog, keyCode, event ->
            onKeyListener?.onkeyDown(keyCode, event) ?: false
        }
        return mDialog

    }

    private fun handleData() {
        items = HashMap()
        items.putAll(getFilterDatas())
        groups = ArrayList(items.keys)

    }

    @SuppressLint("LongLogTag")
    private fun initViews(view: View?) {

        view?.find<Button>(R.id.btn_show_dlg)?.visibility = View.GONE
        if (view != null) {
            eListView = view.find(R.id.expand_listview)
        }
        view?.find<TextView>(R.id.tv_reset)?.setOnClickListener {
            onReset()
        }
        view?.find<Button>(R.id.btn_ancho)?.setOnClickListener {
            onDone()
        }
        adapter = ExpandAdapter(groups, items, context)
        eListView.setAdapter(adapter)
        // 默认展开
        for (i in 0 until adapter.groupCount) {
            eListView.expandGroup(i)
        }

        eListView.viewTreeObserver.addOnGlobalLayoutListener {
            eListView.setIndicatorBounds(
                eListView.right - 180,
                eListView.width
            )
        }

        eListView.setOnChildClickListener { _, _, groupPosition, childPosition, id ->

            if (groupPosition == 1) {
                items.get(groups.get(groupPosition))?.get(childPosition)?.isSingleChecked =
                    items.get(groups.get(groupPosition))?.get(childPosition)?.isSingleChecked != true

            } else {
                // 单选
                @Suppress("UNUSED_VARIABLE")
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

    private fun onReset() {
        items.keys.forEach {
            var list = items.get(it) ?: emptyList()

            for (item in list) {
                item.isSingleChecked = false
            }
            list.get(0).isSingleChecked = true
        }
        adapter.notifyDataSetChanged()

    }
    @SuppressLint("LongLogTag")
   private fun onDone() {
        toast("submit")
        val sb = StringBuilder()

        items.keys.forEach {
            //            Log.e("debug_ExpandableListViewActivity", "btnDone: $it")
            var list = items.get(it) ?: emptyList()

            for (item in list) {
                Log.e("debug_ExpandableListViewActivity", "btnDone: ${item.itemName}     ${item.isSingleChecked}     ")
                if (item.isSingleChecked) {
                    sb.append(item.itemName).append("*")
                }
            }

        }
        eventListener?.rightEvent(sb)

    }

    private fun dialogSettings() {
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

        val dialogWindow = mDialog.window
//        dialogWindow!!.setWindowAnimations(R.style.dialogWindowAnim) //设置窗口弹出动画
        dialogWindow.setGravity(Gravity.RIGHT)
        val m = dialogWindow.windowManager
        val d = m.defaultDisplay // 获取屏幕宽、高用
        val p = dialogWindow.attributes // 获取对话框当前的参数值
        p.height = d.height
        p.width = (d.width * 0.8).toInt()
        dialogWindow.attributes = p
        mDialog.setCanceledOnTouchOutside(false)//外部禁止点击
    }

    override fun onPause() {
        super.onPause()
        if (mDialog != null) {
            mDialog.dismiss()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (eListView != null) {
        }
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
        val viewHolder: ViewHolderGroup
        var convertView = convertView

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.expand_lv_item_group, parent, false)
            viewHolder = ViewHolderGroup()
            viewHolder.tvGroupName = convertView.find(R.id.tv_group_name)
            viewHolder.divider = convertView.find(R.id.view_divider)
            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ViewHolderGroup
        }
        viewHolder.tvGroupName?.text = groups[groupPosition]

        viewHolder.divider?.visibility = if (isExpanded) View.GONE else View.VISIBLE
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
        val itemHolder: ViewHolderItem
        var convertView = convertView

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.expand_lv_item_child, parent, false)
            itemHolder = ViewHolderItem()
            itemHolder.tvItemName = convertView.findViewById(R.id.tv_item_name) as TextView
            itemHolder.icIndicator = convertView.findViewById(R.id.iv_check) as ImageView
            itemHolder.view_divider = convertView.findViewById(R.id.view_divider) as View
            convertView.tag = itemHolder
        } else {
            itemHolder = convertView.tag as ViewHolderItem
        }
        itemHolder.tvItemName?.text = items.get(groups.get(groupPosition))?.get(childPosition)?.itemName
        itemHolder.icIndicator?.visibility =
            if (items.get(groups.get(groupPosition))?.get(childPosition)?.isSingleChecked == true) View.VISIBLE else View.INVISIBLE

        itemHolder.view_divider?.visibility = if (isLastChild) View.VISIBLE else View.GONE

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