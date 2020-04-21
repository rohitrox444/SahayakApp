package com.example.sahanacorona;

public class Profiledata {

    String name,address,uuid;
    String phone_no, user_type, nearby_landmark, password;



    public Profiledata() {
    }

    public Profiledata(String name, String address, String uuid, String phone_no, String user_type, String nearby_landmark, String password) {
        this.name = name;
        this.address = address;
        this.uuid = uuid;
        this.phone_no = phone_no;
        this.user_type = user_type;
        this.nearby_landmark = nearby_landmark;
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getNearby_landmark() {
        return nearby_landmark;
    }

    public void setNearby_landmark(String nearby_landmark) {
        this.nearby_landmark = nearby_landmark;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
