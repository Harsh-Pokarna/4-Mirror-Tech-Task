package com.example.a4mirrortechtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_home_widget.*

class MainActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment()
    private val shoppingFragment = ShoppingFragment()
    private val monitorFragment = MonitorFragment()
    private val learnFragment = LearnFragment()
    private val settingsFragment = SettingsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        setNavBar()
        setCurrentFragment(homeFragment)
        setListeners()
    }

    private fun setNavBar() {
        val mbottomNavigationMenuView = bottomNavigationView.getChildAt(0) as BottomNavigationMenuView
        val bottomNavigationItemView = mbottomNavigationMenuView.getChildAt(1) as BottomNavigationItemView
        val notificationBadge = LayoutInflater.from(this).inflate(R.layout.custom_badge_layout, bottomNavigationItemView, false)
        bottomNavigationItemView.addView(notificationBadge)
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
    }

    private fun setListeners() {
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.home -> setCurrentFragment(homeFragment)
                R.id.shop -> setCurrentFragment(shoppingFragment)
                R.id.monitor -> setCurrentFragment(monitorFragment)
                R.id.learn -> setCurrentFragment(learnFragment)
                R.id.settings -> setCurrentFragment(settingsFragment)
                else -> {}
            }
            true
        }
    }
}