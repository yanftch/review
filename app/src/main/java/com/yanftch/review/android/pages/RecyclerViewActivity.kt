package com.yanftch.review.android.pages

import android.animation.Animator
import android.animation.ObjectAnimator
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
import org.jetbrains.anko.sdk15.listeners.onClick
import org.jetbrains.anko.textColorResource

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var datas: ArrayList<ItemModel>
    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: LinearLayoutManager
    var glide: Glide? = null
    private lateinit var sparseArray: SparseArray<String>
    private var linearLayout: LinearLayout? = null

    companion object {
        var mTvQuestion: TextView? = null
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sparseArray = SparseArray()
        sparseArray.put(1, "s")


        datas = ArrayList()
        for (i in 0..1000) {
            val model = ItemModel("name $i", false)
            datas.add(model)
        }

        layoutManager = LinearLayoutManager(this)

        setContentView(R.layout.rv_test)
        recyclerView = findViewById(R.id.recyclerView)
        mTvQuestion = findViewById(R.id.tv_question)

//        setContentView(UI {
//            relativeLayout {
//                recyclerView = recyclerView {
//
//                }
//                textView {
//                    text = "我是红包"
//                    backgroundColor = R.color.orange_100
//                    padding = 20
//                }
//            }
//        }.view)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter =
            MyAdapter(datas, object : ItemClick {
                override fun onItemClick(model: ItemModel) {
                }

            })

        // 滑动监听
        recyclerView.addOnScrollListener(OnScroll())
        val objectAnimatorOut: ObjectAnimator =
            ObjectAnimator.ofFloat(mTvQuestion, "translationX", 0f, 200f)
                .setDuration(1000)
        var needTry = false
        mTvQuestion?.setOnClickListener {
            Log.e("debug_", ": mTvQuestion 飞出去,  ")

            if (objectAnimatorOut.isRunning) {
                Log.e("debug_", ": mTvQuestion 飞出去,  running  ")


            } else {
                Log.e("debug_", ": mTvQuestion 飞出去, start  ")

                objectAnimatorOut.start()
            }
        }


    }

    class OnScroll : RecyclerView.OnScrollListener() {
        var needTryLocal = true

        var objectAnimatorOut: ObjectAnimator =
            ObjectAnimator.ofFloat(mTvQuestion, "translationX", 0f, 200f)
                .setDuration(1000)

        var objectAnimatorIn: ObjectAnimator =
            ObjectAnimator.ofFloat(mTvQuestion, "translationX", 200f, 0f)
                .setDuration(1000)

        init {
            objectAnimatorOut.addListener(object : Animator.AnimatorListener {
                override fun onAnimationRepeat(animation: Animator?) {
                }

                override fun onAnimationEnd(animation: Animator?) {
                    // 动画结束，也就是滑动出去以后，禁用重复属性
                    needTryLocal = false
                }

                override fun onAnimationCancel(animation: Animator?) {
                }

                override fun onAnimationStart(animation: Animator?) {
                }
            })
            objectAnimatorIn.addListener(object : Animator.AnimatorListener{
                override fun onAnimationRepeat(animation: Animator?) {
                }

                override fun onAnimationEnd(animation: Animator?) {
                    needTryLocal = true
                }

                override fun onAnimationCancel(animation: Animator?) {
                }

                override fun onAnimationStart(animation: Animator?) {
                }
            })
        }

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//            Log.e("debug_", ": dy = $dy")
        }

        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            val b = recyclerView.canScrollVertically(-1) // 返回false，表示已经在顶部了
            val isAtTop = !b
            Log.e("debug_", "onScrollStateChanged: newState $newState,   b = $b")

            if (newState == 1 || newState == 2) {
                // 滚出去
                if (objectAnimatorOut.isRunning) {
                    return
                } else {
                    if (needTryLocal) {
                        objectAnimatorOut.start()
                    }
                }

            } else if (newState == 0) {
                // 滚回来
                if (objectAnimatorIn.isRunning) {
                    return
                } else {
                    objectAnimatorIn.start()
                }
            }

        }
    }

    class MyAdapter(var datas: ArrayList<ItemModel>, var c: ItemClick) :
        RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

        lateinit var itemClick: ItemClick

        companion object {
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

    interface ItemClick {
        fun onItemClick(model: ItemModel)
    }

    data class ItemModel(
        var name: String,
        var selected: Boolean
    )
}
