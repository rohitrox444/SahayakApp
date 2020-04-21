package com.example.sahanacorona;

import com.google.type.LatLng;

public class PackageData {

    String packaging,address;
    LatLng latLng;

    public PackageData() {
    }

    public PackageData(String packaging, String address, LatLng latLng) {
        this.packaging = packaging;
        this.address = address;
        this.latLng = latLng;
    }

    public String getPackaging() {
        return packaging;
    }

    public String getAddress() {
        return address;
    }

    public LatLng getLatLng() {
        return latLng;
    }


}
