package com.example.poiuytrewq;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.sip.SipSession;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    private String[] locations;
    private String[] times;
    private int[] imageIds;
    private Listener listener;

    public static interface Listener{
        public void onClick(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        public ViewHolder(@NonNull CardView itemView) {
            super(itemView);
            cardView = itemView;
        }
    }

    public EventAdapter(String[] locations, String[] times, int[] imageIds){
        this.locations = locations;
        this.times = times;
        this.imageIds = imageIds;
    }

    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_event,parent,false);
        return new ViewHolder(cv);
    }

    public void setListener(Listener listener){
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        CardView cardView = holder.cardView;
        ImageView cardImageHolder = (ImageView) cardView.findViewById(R.id.card_image_holder);
        Drawable drawable = cardView.getResources().getDrawable(imageIds[position]);
        cardImageHolder.setImageDrawable(drawable);
        TextView cardLocationHolder = (TextView) cardView.findViewById(R.id.card_location_holder);
        cardLocationHolder.setText(locations[position]);
        TextView cardTimeHolder = (TextView) cardView.findViewById(R.id.card_time_holder);
        cardTimeHolder.setText(times[position]);
        cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if( listener != null){
                    listener.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return locations.length;
    }
}
