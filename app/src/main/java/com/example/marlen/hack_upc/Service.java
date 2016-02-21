package com.example.marlen.hack_upc;

/**
 * Created by Jou on 20/2/2016.
 */
public class Service {
    private String name;
    private String type;
    private String city;
    private int MaxDist;
    private int TelNum;

    public Service() {
        super();
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public String getCity() {
        return city;
    }
    public int getMaxDist() {
        return MaxDist;
    }
    public Integer getTelNum() {
        return TelNum;
    }


    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setMaxDist(int MaxDist) {
        this.MaxDist = MaxDist;
    }
    public void setTelNum(int TelNum) {
        this.TelNum = TelNum;
    }
}
