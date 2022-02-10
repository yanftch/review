package com.yanftch.review.android.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment

class TestFragment(var arg1: String? = "", var arg2: String? = "") : Fragment() {
    private var _list = mutableListOf<String>()
    private var list = mutableListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}