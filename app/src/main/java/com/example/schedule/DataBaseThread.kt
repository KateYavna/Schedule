package com.example.schedule



class DataBaseThread :Runnable{

    init {
        Thread(this).start()
    }
    override fun run() {

        val db = App.instance.database
        val scheduleDao = db.scheduleDao()
       // val schedule = Schedule ("  ","","",false)
       // scheduleDao.insert(schedule)



    }
}