package com.screening.screeningtest.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.screening.screeningtest.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.frame_container, HomeFragment()).commit()
    }
}