package com.edupointbd.amirul.birthdayoffriends;

/**
 * Created by amirul on 19-Apr-17.
 */

public class DataTem {


    private  int id;
    private String name;
    private String day;

    public DataTem(String name, String day) {
        this.name = name;
        this.day = day;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDay() {
        return day;
    }


}
