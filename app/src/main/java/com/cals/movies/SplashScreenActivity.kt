package com.cals.movies

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity


@Suppress("DEPRECATION")
class SplashScreenActivity : AppCompatActivity() {

    private lateinit var  handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        handler = Handler()
        handler.postDelayed({
            val intent = Intent(
                this@SplashScreenActivity,
                MainActivity::class.java
            )
            startActivity(intent)
            finish()
        }, 3000)
    }
}