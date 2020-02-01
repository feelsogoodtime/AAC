package com.project.aac.LiveData

import android.os.SystemClock
import androidx.lifecycle.ViewModel

class LiveDataTimerViewModel : ViewModel() {

    companion object {
        //1초
        private const val ONE_SECOND = 1000.toLong()
        //태그
        const val TAG = "LiveDataTimerViewModel"
    }

    //초기화 시간 -> 부팅된후 흐른 시간.
    private val initialTime: Long = SystemClock.elapsedRealtime()
    //LiveData 의 시간
    private val elapsedTime = MyTimerLiveData()

    //LiveData에서 시간을 가져오는 함수
    fun getElapsedTime() = elapsedTime
}