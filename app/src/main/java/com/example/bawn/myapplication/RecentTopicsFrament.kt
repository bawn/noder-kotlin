package com.example.bawn.myapplication


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.bawn.noder_kotlin.RestAPI
import kotlinx.android.synthetic.main.post_list.*
import rx.android.schedulers.AndroidSchedulers


class RecentTopicsFrament: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        return inflater.inflate(R.layout.recent_topics_list, container, false)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("${view}", "view.findViewById(R.id.textview)")

    }

    override fun onResume() {
        super.onResume()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        listView.layoutManager = LinearLayoutManager(context)

        RestAPI().getRecentTopics()
                .subscribeOn(rx.schedulers.Schedulers.io())
                .map { it.data }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    // 获取传值
                    val isRecentTopics = arguments?.getBoolean("isRecentTopics") ?: false
                    val value = if (isRecentTopics) {it.recent_topics} else {it.recent_replies}
                    this.listView.adapter = RecentTopicsAdapter(context!!, value) { item ->
                        Navigation.findNavController(listView).navigate(R.id.action_mainFragment_to_settingFragment)
                    }
                })
    }
}
