package com.screening.screeningtest.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.screening.screeningtest.R
import com.screening.screeningtest.ui.map.MapFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        toolbar.setNavigationOnClickListener {
            supportFragmentManager.popBackStackImmediate()
        }

        toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_media -> {
                    // Handle favorite icon press
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_container, MapFragment())
                        .addToBackStack(null)
                        .commit()
                    true
                }
                R.id.action_search -> {
                    // Handle search icon press
                    true
                }
                else -> false
            }
        }

        supportFragmentManager.beginTransaction()
            .add(R.id.frame_container, HomeFragment()).commit()
    }
}