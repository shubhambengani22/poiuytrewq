package com.example.poiuytrewq;

public class Events {
    private String title;
    private String location;
    private String time;
    private int imageResourceId;
    private String latLon;

    public static final Events[] events = {
            new Events("SOS","JP Nagar", "1 hr ago", R.drawable.image01,"12.903261, 77.582728"),
            new Events("Theft","Jayanager", "50 min ago", R.drawable.image02,"12.929630, 77.589103 "),
            new Events("Robbery","VV Pura", "16 min ago", R.drawable.image03,"12.951555, 77.574988")
    };

    public Events(String title, String location, String time, int imageResourceId, String latLon) {
        this.title = title;
        this.location = location;
        this.time = time;
        this.imageResourceId = imageResourceId;
        this.latLon = latLon;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public String getTime() {
        return time;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getLatLon() {
        return latLon;
    }
}