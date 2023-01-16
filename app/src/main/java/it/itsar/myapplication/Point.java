package it.itsar.myapplication;

import com.google.android.gms.maps.model.LatLng;

public class Point {

    private LatLng coordinate;
    private String name;

    public Point(Double latitude, Double longitude, String name) {
        this.coordinate = new LatLng(latitude,longitude);
        this.name = name;
    }

    public LatLng getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(LatLng coordinate) {
        this.coordinate = coordinate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }
}