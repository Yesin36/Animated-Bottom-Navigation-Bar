package com.example.animatebottomnavigationbar

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.animatebottomnavigationbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    //    val custom_bottom_nav = com.example.animatebottomnavigationbar.custom_bottom_nav()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set default fragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frame, BlankFragment())
                .commit()
        }

        // Set up the bottom bar tab selection listener
        binding.bottomBar.onTabSelected = { tab ->
            when (tab.id) {
                R.id.tab_home -> replaceFragment(BlankFragment())
                R.id.tab_alarm -> replaceFragment(BlankFragment2())
                R.id.tab_bread -> replaceFragment(BlankFragment3())
                R.id.tab_cart -> replaceFragment(BlankFragment4())
            }
        }
    }

    private fun replaceFragment(fragment: androidx.fragment.app.Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    }
