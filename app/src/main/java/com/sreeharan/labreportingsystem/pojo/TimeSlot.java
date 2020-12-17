package com.sreeharan.labreportingsystem.pojo;

public class TimeSlot {
    private int mSlot;

    public TimeSlot(int slot){
        mSlot = slot;
    }

    public int getSlot() {
        return mSlot;
    }
    public static String convertTimeToString(int timeSlot){
        switch (timeSlot){
            case 0:
                return "9.30 - 10.30";
            case 1:
                return "10.30 - 11.30";
            case 2:
                return "11.30 - 12.30";
            case 3:
                return "1.30 - 2.30";
            case 4:
                return "2.30 - 3.30";
            case 5:
                return "3.30 - 4.30";
            default:
                return "Lab Closed";
        }

    }
}
