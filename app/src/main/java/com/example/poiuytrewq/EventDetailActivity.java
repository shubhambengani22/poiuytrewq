package com.example.poiuytrewq;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class EventDetailActivity extends AppCompatActivity {

    public static final String EXTRA_EVENTNO = "eventNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int eventNo = (Integer) getIntent().getExtras().get(EXTRA_EVENTNO);
        String eventLocation = Events.events[eventNo].getLocation();
        String eventTime = Events.events[eventNo].getTime();
        int eventImage = Events.events[eventNo].getImageResourceId();

        TextView tvLocation = (TextView) findViewById(R.id.event_detail_location);
        TextView tvTime = (TextView) findViewById(R.id.event_detail_time);
        ImageView ivImage = (ImageView) findViewById(R.id.event_detail_image);

        tvLocation.setText(eventLocation);
        tvTime.setText(eventTime);
        ivImage.setImageDrawable(getResources().getDrawable(eventImage));
    }
}
