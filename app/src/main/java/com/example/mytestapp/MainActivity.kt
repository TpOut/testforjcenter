package com.example.mytestapp

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.androidlib.SysIntentUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun onPhoneCall(v: View) {
        if (!TextUtils.isEmpty(et_phone.text)) {
            SysIntentUtil.startPhoneCall(this, 15868106670.toInt())
        } else {

        }
    }
}
