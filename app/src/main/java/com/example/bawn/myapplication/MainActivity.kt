package com.example.bawn.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_me.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        navigation.setOnNavigationItemSelectedListener(bottomListener)
//        viewPager.adapter = PagerAdapter(supportFragmentManager)

    }

    override fun onSupportNavigateUp(): Boolean {
        return my_nav_host_fragment.findNavController().navigateUp() || super.onSupportNavigateUp()
    }
}
