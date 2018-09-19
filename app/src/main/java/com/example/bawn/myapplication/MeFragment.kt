package com.example.bawn.myapplication

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_me.*

class MeFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_me, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        textview.text = "putao"
//        textview.text = "suit"
//        scan.setOnClickListener {
//
//        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        scan.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_settingFragment)
        }

        recentTopics.setOnClickListener {
            val args = Bundle()
            args.putBoolean("isRecentTopics", true)
            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_recentTopicsFrament, args, null)
        }

        recentReplies.setOnClickListener {
            val args = Bundle()
            args.putBoolean("isRecentTopics", false)
            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_recentTopicsFrament, args, null)
        }

        setting.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_settingFragment)
        }

        collection.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_collectionTopicsFrament)
        }
    }
}