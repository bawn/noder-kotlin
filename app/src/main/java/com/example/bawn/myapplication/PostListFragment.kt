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


class PostListFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        return inflater.inflate(R.layout.post_list, container, false)
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

        RestAPI().getTopics()
                .subscribeOn(rx.schedulers.Schedulers.io())
                .map { it.data }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                    this.listView.adapter = PostAdapter(context!!, it) { item ->
                        Navigation.findNavController(listView).navigate(R.id.action_mainFragment_to_settingFragment)
                    }
                })


//        RestAPI().getTopics()
//                .subscribeOn(rx.schedulers.Schedulers.io())
//                .map { it.data }
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(object : Subscriber<List<Topic>>() {
//                    override fun onNext(t: List<Topic>?) {
//                        Log.i("test", "dsfsdfsf   " + t.toString())
//                    }
//
//                    override fun onCompleted() {
//                    }
//
//                    override fun onError(e: Throwable?) {
//                        Log.i("test", e.toString())
//                    }
//
//                })


    }
}
