/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Time;

/**
 *
 * @author ADMIN
 */
public class DTO_Khac {
   Time CheckIn,CheckOut;
   int moc1,moc2,moc3,moc4,phuthu1,phuthu2,phuthu3,phuthu4;

    public Time getCheckIn() {
        return CheckIn;
    }

    public void setCheckIn(Time CheckIn) {
        this.CheckIn = CheckIn;
    }

    public Time getCheckOut() {
        return CheckOut;
    }

    public void setCheckOut(Time CheckOut) {
        this.CheckOut = CheckOut;
    }

    public int getMoc1() {
        return moc1;
    }

    public void setMoc1(int moc1) {
        this.moc1 = moc1;
    }

    public int getMoc2() {
        return moc2;
    }

    public void setMoc2(int moc2) {
        this.moc2 = moc2;
    }

    public int getMoc3() {
        return moc3;
    }

    public void setMoc3(int moc3) {
        this.moc3 = moc3;
    }

    public int getMoc4() {
        return moc4;
    }

    public void setMoc4(int moc4) {
        this.moc4 = moc4;
    }

    public int getPhuthu1() {
        return phuthu1;
    }

    public void setPhuthu1(int phuthu1) {
        this.phuthu1 = phuthu1;
    }

    public int getPhuthu2() {
        return phuthu2;
    }

    public void setPhuthu2(int phuthu2) {
        this.phuthu2 = phuthu2;
    }

    public int getPhuthu3() {
        return phuthu3;
    }

    public void setPhuthu3(int phuthu3) {
        this.phuthu3 = phuthu3;
    }

    public int getPhuthu4() {
        return phuthu4;
    }

    public void setPhuthu4(int phuthu4) {
        this.phuthu4 = phuthu4;
    }
   
}
