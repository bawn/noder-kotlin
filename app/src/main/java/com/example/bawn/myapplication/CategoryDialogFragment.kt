package com.example.bawn.myapplication
import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.category.*
import kotlinx.android.synthetic.main.create_topic_fragment.*


class CategoryDialogFragment: BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.category, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomSheetHeading.setOnClickListener {
            fragmentManager?.let {
                it.fragments.forEach { Log.i(it.toString(), "ttttttttttttttttt") }
                it.fragments.first { it is CreateFragment }.categoryInput.text = "4444"
            }
            this.dismiss()

        }

    }
}

