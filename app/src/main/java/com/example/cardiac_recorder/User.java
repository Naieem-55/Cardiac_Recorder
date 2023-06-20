package com.example.cardiac_recorder;

import android.widget.Button;

public class User {
    String Systolic , Diastolic, HeartRate , Date, Comment, Time ;
    //Button editButton , deleteButton;

    /**
     * Constructor ,called when object is defined.
     * @param systolic
     * @param diastolic
     * @param heartRate
     * @param date
     * @param comment
     * @param time
     */
    public User(String systolic,String diastolic,String heartRate,String date,String comment,String time)
    {
        Systolic = systolic;
        Diastolic = diastolic;
        HeartRate = heartRate;
        Date = date;
        Comment = comment;
        Time = time;
    }
    public User() {
    }

    public String getComment() {
        return Comment;
    }

    public String getTime() {
        return Time;
    }

    public void setSystolic(String systolic) {
        Systolic = systolic;
    }

    public void setDiastolic(String diastolic) {
        Diastolic = diastolic;
    }

    public void setHeartRate(String heartRate) {
        HeartRate = heartRate;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getSystolic() {
        return Systolic;
    }

    public String getDiastolic() {
        return Diastolic;
    }

    public String getHeartRate() {
        return HeartRate;
    }

    public String getDate() {
        return Date;
    }
}
