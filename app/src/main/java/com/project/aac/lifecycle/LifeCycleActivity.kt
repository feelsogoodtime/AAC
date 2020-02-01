package com.project.aac.lifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.project.aac.R

class LifeCycleActivity : AppCompatActivity() {

    private var observer = MyObserve(lifecycle)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)

        lifecycle.addObserver(observer)
    }
}