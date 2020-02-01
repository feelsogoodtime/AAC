package com.project.aac.ViewModel

import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.project.aac.R
import com.project.aac.lifecycle.MyObserve
import kotlinx.android.synthetic.main.activity_chrono_2.*

class ViewModelActivity : AppCompatActivity() {
    companion object {
        const val TAG = "ViewModelActivity"
    }

    private var observer = MyObserve(lifecycle)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chrono_2)

        //The ViewModelStore provides a new ViewModel or one previously created.
        val chronometerViewModel = ViewModelProviders.of(this).get(ChronometerViewModel::class.java)

        if (chronometerViewModel.getStartTime() <= 0) {
            //If the start date is not defined, it's a new ViewModel so set it.
            val startTime = SystemClock.elapsedRealtime()
            chronometerViewModel.setStartTime(startTime)
            chronometer.base = startTime
            Log.d(TAG, "Use new create time")
        } else {
            chronometer.base = chronometerViewModel.getStartTime()
            Log.d(TAG, "Use saved time")
        }

        lifecycle.addObserver(observer)
        chronometer.start()
    }
}