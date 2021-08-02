package com.example.schedule;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Schedule.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ScheduleDao scheduleDao();
}
