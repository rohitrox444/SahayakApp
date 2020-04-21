package com.example.sahanacorona;

import com.google.type.LatLng;

public class MarkPeopleData {

    private String MarkPeopleData_area_dsc;

    private  String MarkPeopleData_area_mark;

    private  String MarkPeopleData_no_of_people;

    private LatLng MarkPeopleData_lat_lng;

    public MarkPeopleData() {
    }

    public MarkPeopleData(String markPeopleData_area_dsc, String markPeopleData_area_mark, String markPeopleData_no_of_people, LatLng markPeopleData_lat_lng) {
        MarkPeopleData_area_dsc = markPeopleData_area_dsc;
        MarkPeopleData_area_mark = markPeopleData_area_mark;
        MarkPeopleData_no_of_people = markPeopleData_no_of_people;
        MarkPeopleData_lat_lng = markPeopleData_lat_lng;
    }

    public String getMarkPeopleData_area_dsc() {
        return MarkPeopleData_area_dsc;
    }

    public String getMarkPeopleData_area_mark() {
        return MarkPeopleData_area_mark;
    }

    public String getMarkPeopleData_no_of_people() {
        return MarkPeopleData_no_of_people;
    }

    public LatLng getMarkPeopleData_lat_lng() {
        return MarkPeopleData_lat_lng;
    }
}
