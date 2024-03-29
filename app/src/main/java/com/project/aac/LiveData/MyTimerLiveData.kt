package com.project.aac.LiveData

import android.os.SystemClock
import android.util.Log
import androidx.lifecycle.LiveData
import java.util.*

class MyTimerLiveData : LiveData<Long>() {
    companion object {
        private const val ONE_SECOND = 1000.toLong()
        const val TAG = "MyTimerLiveData"
    }

    private val initialTime: Long = SystemClock.elapsedRealtime()
    private var timer: Timer? = null

    override fun onActive() {
        super.onActive()
        Log.d(TAG, "onActive")
        timer = Timer()
        timer?.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                val newValue = (SystemClock.elapsedRealtime() - initialTime) / 100
                postValue(newValue)
                Log.d(TAG, "updating real time")
            }
        }, ONE_SECOND, ONE_SECOND)
    }
    override fun onInactive() {
        Log.d(TAG, "onInactive")
        timer?.cancel()
    }
}