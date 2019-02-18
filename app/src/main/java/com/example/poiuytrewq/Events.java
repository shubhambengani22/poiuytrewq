package com.example.poiuytrewq;

public class Events {
    private String location;
    private String time;
    private int imageResourceId;

    public static final Events[] events = {
            new Events("JP Nagar","1 hr ago",R.drawable.image01),
            new Events("Jayanager","50 min ago",R.drawable.image02),
            new Events("VV Pura","16 min ago",R.drawable.image03)
    };

    public Events(String location, String time, int imageResourceId) {
        this.location = location;
        this.time = time;
        this.imageResourceId = imageResourceId;
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
}
