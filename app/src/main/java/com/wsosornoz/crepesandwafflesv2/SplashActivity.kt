package com.wsosornoz.crepesandwafflesv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Window
import java.util.*
import java.util.TimerTask
import java.util.Timer


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({ startActivity(Intent(this@SplashActivity, LoginActivity::class.java)) }, 2000)
    }
}