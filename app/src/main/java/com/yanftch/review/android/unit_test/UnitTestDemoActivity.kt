package com.yanftch.review.android.unit_test

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.yanftch.review.R
import kotlinx.android.synthetic.main.activity_unit_test_demo.*
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk15.listeners.onClick
import org.jetbrains.anko.toast
import kotlin.random.Random

/**
 * Author : yanftch
 * Date   : 2020-01-29
 * Time   : 12:32
 * Desc   : 练习单元测试
 */
class UnitTestDemoActivity : AppCompatActivity(), UnitTestContract.View {
    private lateinit var mPresenter: UnitTestContract.Presenter

    private lateinit var btnClick: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unit_test_demo)
        mPresenter = UnitTestPresenter(this)
        click()
        btnClick = find(R.id.btn_listener)
        btnClick.setOnClickListener{
            val clickListener = TestClickListener()
            clickListener.onClick(null)
        }

    }

    override fun onResume() {
        super.onResume()
        mPresenter.onStart()
    }

    private fun click() {
        btn_login.onClick {
            val name = et_name.text.toString()
            if (TextUtils.isEmpty(name)) {
                toast("请输入用户名")
                return@onClick
            }

            mPresenter.login(name, "$name-${Random(10).nextInt()}")
//            Runnable {
//                Thread.sleep(6000)
//                toast("123")
//            }.run()
        }
    }

    override fun onLoginSucceed(message: Any) {
        Log.e("debug_UnitTestDemoActivity", "onLoginSucceed: message=======>$message")
        toast(message.toString())
    }

    override fun onLoginError(errorMsg: Any) {
        Log.e("debug_UnitTestDemoActivity", "onLoginError: message=======>$errorMsg")
        toast(errorMsg.toString())
    }

    override fun setPresenter(presenter: UnitTestContract.Presenter) {
        mPresenter = presenter
    }
}

class TestClickListener: View.OnClickListener {
    override fun onClick(v: View?) {
        Log.e("debug_TestClickListener", "onClick: TestClickListener 引入形式66666666")
    }

}