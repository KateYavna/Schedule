package com.example.schedule;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Schedule {
    @PrimaryKey
    @NonNull
    public String task;
    public String description;
    public String time;
    public Boolean importance;

    public Schedule(String task, String description, String time, Boolean importance) {
        this.task = task;
        this.description = description;
        this.time = time;
        this.importance = importance;
    }

    public String getTask() {
        return task;
    }

    public String getDescription() {
        return description;
    }

    public String getTime() {
        return time;
    }

    public Boolean getImportance() {
        return importance;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setImportance(Boolean importance) {
        this.importance = importance;
    }
}
