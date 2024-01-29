package com.yanftch.review.android.pages

import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import com.yanftch.review.R
import com.yanftch.review.android.view.DiySwitchView
import org.jetbrains.anko.toast

class DiyMainActivity : AppCompatActivity() {
    private lateinit var sw_view: Switch
    private lateinit var diy_switch_view: DiySwitchView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diy_main)
        sw_view = findViewById(R.id.sw_view)
        sw_view.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
                if (p1) {
                    toast("选中了")
                } else {
                    toast("取消了")
                }
                diy_switch_view.updateSelected(p1)
            }
        })

        diy_switch_view = findViewById(R.id.diy_switch_view)
        diy_switch_view.updateSelected(false)
        diy_switch_view.setOnChangeListener(object : DiySwitchView.OnChangeListener {
            override fun onChange(selectedRight: Boolean) {
                toast("选中右边了吗？$selectedRight")

            }
        })
    }


}