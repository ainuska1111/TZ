package com.ainuska1111.mytz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ainuska1111.tz.ui.home.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNav = findViewById(R.id.main_bottom_nav)
        setupBottomNav()
    }

    private fun setupBottomNav() {
        val homeFragment = HomeFragment()
        //todo create others later
        supportFragmentManager.beginTransaction()
                .add(R.id.main_container, homeFragment)
                .commit()
        bottomNav.setOnNavigationItemSelectedListener {
            val newFragment = when(it.itemId) {
                R.id.fragment_home -> homeFragment
                R.id.fragment_search-> homeFragment //todo change later
                else -> homeFragment //todo change later
            }
            supportFragmentManager.beginTransaction()
                    .replace(R.id.main_container, newFragment)
                    .commit()
            true
        }
    }
}