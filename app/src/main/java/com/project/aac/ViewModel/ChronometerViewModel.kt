package com.project.aac.ViewModel

import androidx.lifecycle.ViewModel

class ChronometerViewModel : ViewModel() {
    private var startTime: Long = 0

    fun getStartTime(): Long = startTime

    fun setStartTime(startTime: Long) {
        this.startTime = startTime
    }
}