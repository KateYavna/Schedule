package com.example.schedule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DataBaseThread()


        Thread{val schedule =  App.instance.database.scheduleDao().all
            rvSchedule.adapter = ScheduleAdapter(this, schedule)
            rvSchedule.layoutManager = LinearLayoutManager(this)}.start()



    }


}