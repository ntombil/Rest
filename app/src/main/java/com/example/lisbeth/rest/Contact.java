package com.example.lisbeth.rest;

/**
 * Created by LISBETH on 2017/10/02.
 */

public class Contact {
    private String Name ;
    private String Surname;
    private String cellNo;
    private  String Date;
    private  String Time;
    private  String deceasedName;

    public String getName() {
        return Name;
    }
    public Contact() {
        Name = Name;
        Surname = Surname;
        this.cellNo = cellNo;
        Date = Date;
        Time = Time;
        this.deceasedName = deceasedName;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getCellNo() {
        return cellNo;
    }

    public void setCellNo(String cellNo) {
        this.cellNo = cellNo;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getDeceasedName() {
        return deceasedName;
    }

    public void setDeceasedName(String deceasedName) {
        this.deceasedName = deceasedName;
    }


}
