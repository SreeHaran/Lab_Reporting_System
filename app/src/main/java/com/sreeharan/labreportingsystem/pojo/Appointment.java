package com.sreeharan.labreportingsystem.pojo;

public class Appointment {
    private boolean mSugarTest, mBloodTest, mUrineTest;

    public void setBloodTest(boolean mBloodTest) {
        this.mBloodTest = mBloodTest;
    }

    public void setSugarTest(boolean mSugarTest) {
        this.mSugarTest = mSugarTest;
    }

    public void setUrineTest(boolean mUrineTest) {
        this.mUrineTest = mUrineTest;
    }

    public boolean isBloodTest() {
        return mBloodTest;
    }

    public boolean isSugarTest() {
        return mSugarTest;
    }

    public boolean isUrineTest() {
        return mUrineTest;
    }
}
