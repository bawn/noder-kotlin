package com.example.bawn.myapplication

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    private val bottomListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                viewPager.setCurrentItem(0,false)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
//                viewPager.setCurrentItem(1,false)

                Navigation.findNavController(this.view!!).navigate(R.id.action_mainFragment_to_createFragment)
//                Navigation.findNavController(this.activity)
                return@OnNavigationItemSelectedListener false
            }
            R.id.navigation_notifications -> {
                viewPager.setCurrentItem(2, false)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onResume() {
        super.onResume()

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigation.setOnNavigationItemSelectedListener(bottomListener)
//        viewPager.adapter = PagerAdapter(activity!!.supportFragmentManager)
        viewPager.adapter = PagerAdapter(childFragmentManager)

    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        navigation.setOnNavigationItemSelectedListener(bottomListener)
//        viewPager.adapter = PagerAdapter(supportFragmentManager)
//
//    }
}