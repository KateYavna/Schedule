package com.example.schedule;



import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface ScheduleDao {

    @Query("SELECT * FROM Schedule")
    List<Schedule> getAll();

    @Query("SELECT * FROM Schedule WHERE task = :task")
    Schedule getByTask(String task);

    @Insert
    void insert (Schedule schedule);

    @Update
    void update (Schedule schedule);

    @Delete
    void delete (Schedule schedule);
}
