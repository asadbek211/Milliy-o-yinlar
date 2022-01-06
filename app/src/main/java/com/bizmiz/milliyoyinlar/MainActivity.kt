package com.bizmiz.milliyoyinlar

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bizmiz.milliyoyinlar.utils.LocaleManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
    }
    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(LocaleManager.setLocale(newBase))
    }
}