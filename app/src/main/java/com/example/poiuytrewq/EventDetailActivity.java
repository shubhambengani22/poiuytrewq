package com.example.poiuytrewq;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class EventDetailActivity extends AppCompatActivity {

    public static final String EXTRA_EVENTNO = "eventNo";
    public static String latLon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int eventNo = (Integer) getIntent().getExtras().get(EXTRA_EVENTNO);
        String eventTitle = Events.events[eventNo].getTitle();
        String eventLocation = Events.events[eventNo].getLocation();
        String eventTime = Events.events[eventNo].getTime();
        int eventImage = Events.events[eventNo].getImageResourceId();
        latLon = Events.events[eventNo].getLatLon();

        TextView tvTitle = (TextView) findViewById(R.id.event_detail_title);
        TextView tvLocation = (TextView) findViewById(R.id.event_detail_location);
        TextView tvTime = (TextView) findViewById(R.id.event_detail_time);
        ImageView ivImage = (ImageView) findViewById(R.id.event_detail_image);

        tvTitle.setText(eventTitle);
        tvTitle.setAllCaps(true);
        tvTitle.setTextSize(tvTitle.getTextSize()*2);
        tvLocation.setText(eventLocation);
        tvTime.setText(eventTime);
        ivImage.setImageDrawable(getResources().getDrawable(eventImage));
    }

    public void onClickMapBtn(View view){
        Uri gmmIntentUri = Uri.parse("geo:0,0?q="+latLon+"(Event)");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }
}
