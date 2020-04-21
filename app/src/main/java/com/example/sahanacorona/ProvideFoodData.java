package com.example.sahanacorona;

import com.google.type.LatLng;

public class ProvideFoodData {
    String title, address, description,itemtype,given_address,report_person_UUID, gps_loc_URL, report_date;
    LatLng latLng;

    public ProvideFoodData() {
    }

    public String getItemtype() {
        return itemtype;
    }

    public String getReport_date() {
        return report_date;
    }

    public ProvideFoodData(String title, String address, String description, LatLng latLng, String foodtype, String given_address,
                           String report_person_UUID, String gps_loc_URL, String report_date
    ) {
        this.address = address;
        this.description = description;
        this.latLng = latLng;
        this.itemtype = foodtype;
        this.title = title;
        this.report_person_UUID = report_person_UUID;
        this.given_address = given_address;
        this.gps_loc_URL = gps_loc_URL;
        this.report_date = report_date;
    }

    public String getAddress() {
        return address;
    }

    public String getTitle() {
        return title;
    }

    public String getGiven_address() {
        return given_address;
    }

    public String getReport_person_UUID() {
        return report_person_UUID;
    }

    public String getGps_loc_URL() {
        return gps_loc_URL;
    }

    public String getDescription() {
        return description;
    }

    public LatLng getLatLng() {
        return latLng;
    }
}
