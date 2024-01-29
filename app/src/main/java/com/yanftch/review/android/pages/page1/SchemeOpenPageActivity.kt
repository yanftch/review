package com.yanftch.review.android.pages.page1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.yanftch.review.R

class SchemeOpenPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nsv_and_vp_fragment_rv)
        findViewById<View>(R.id.btn1).setOnClickListener {
            try {
                val url = "ziroomcustomer://www.ziroom.com/housedetail?invNo=773994122"
                val uri = Uri.parse(url)
                val intent = Intent(Intent.ACTION_VIEW, uri)
//                intent.putExtra("invNo", 773994122)
                intent.flags = Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT
                startActivity(intent)
            } catch (e: Exception) {
                Log.e("debug_TestDialog:", "initView==>" + "e===>" + e)
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<View>(R.id.btn2).setOnClickListener {
            try {
                val intent = packageManager.getLaunchIntentForPackage("com.ziroom.ziroomcustomer")
                if (intent != null) {
                    intent.setClassName(
                        "com.ziroom.ziroomcustomer",
                        "com.ziroom.find.detail.RentHouseDetailActivity"
                    )
                    intent.putExtra("invNo", 773994122)
                    intent.flags =
                        Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED or Intent.FLAG_ACTIVITY_CLEAR_TOP
                    startActivity(intent)
                }
            } catch (e: Exception) {
                Log.e("debug_TestDialog:", "initView==>" + "e===>" + e)
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<View>(R.id.btn3).setOnClickListener {
            try {

                val url = "ziroom://ziroom.app/openApp?p=userouter=true&function=ziroomCustomer://zrRentModule/rentDetailspage&parameter={invNo=763569144}"
                val uri = Uri.parse(url)
                val intent = Intent(Intent.ACTION_VIEW, uri)
//                intent.putExtra("invNo", 773994122)
                intent.flags = Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT
                startActivity(intent)
            } catch (e: Exception) {
                Log.e("debug_TestDialog:", "initView==>" + "e===>" + e)
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }
}