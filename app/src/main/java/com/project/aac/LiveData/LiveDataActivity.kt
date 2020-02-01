package com.project.aac.LiveData

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.project.aac.R
import com.project.aac.lifecycle.MyObserve
import kotlinx.android.synthetic.main.activity_chrono_3.*

class LiveDataActivity : AppCompatActivity() {
    //static 변수 선언
    companion object {
        const val TAG = "LiveDataActivity"
    }
    //옵저버 선언 (MyObserve)
    private var observer = MyObserve(lifecycle)
    //LiveDataTimerViewModel 선언
    private var liveDataTimerViewModel: LiveDataTimerViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chrono_3)
        Log.d("MSKIM", "LiveDataActivity_onCreate") //1
        //ViewModelProviders에 ViewModel 탑재
        liveDataTimerViewModel = ViewModelProviders.of(this).get(LiveDataTimerViewModel::class.java)
        Log.d("MSKIM", "LiveDataActivity_onCreate2") //2
        //함수 호출
        subscibe()
        //lifecycle에 옵저버 탑재
        lifecycle.addObserver(observer)
    }

    private fun subscibe() {
        Log.d("MSKIM", "LiveDataActivity_subscibe") //4
        val elapsedTimeObserver = androidx.lifecycle.Observer<Long> { time ->
            timer_textview.text = time.toString()
            Log.d("MSKIM", "Updating timer") //7
        }

        //observe the ViewModel's elapsed time
        liveDataTimerViewModel?.getElapsedTime()?.observe(this, elapsedTimeObserver)
        Log.d("MSKIM", "LiveDataActivity_subscibe2") //5
    }
}