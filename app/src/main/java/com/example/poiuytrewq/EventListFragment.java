package com.example.poiuytrewq;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

public class EventListFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    String[] eventLocation;
    String[] eventTime;
    int[] eventImages;
    EventAdapter adapter;

    private OnFragmentInteractionListener mListener;

    public EventListFragment() {
        // Required empty public constructor
    }

    public static EventListFragment newInstance(String param1, String param2) {
        EventListFragment fragment = new EventListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

//        RecyclerView eventRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_event_list, container, false);
//
//        Toast.makeText(getContext(),"Fragment Loaded!",Toast.LENGTH_LONG).show();
//
//        //TODO: Populate the Data from Events Class
//        int length = Events.events.length;
//        eventLocation = new String[length];
//        for(int i=0; i<length; i++)
//            eventLocation[i] = Events.events[i].getLocation();
//        eventTime = new String[length];
//        for(int i=0; i<length; i++)
//            eventTime[i] = Events.events[i].getTime();
//        eventImages = new int[length];
//        for(int i=0; i<length; i++)
//            eventImages[i] = Events.events[i].getImageResourceId();
//        adapter = new EventAdapter(eventLocation, eventTime, eventImages);

//        EventAdapter adapter = new EventAdapter(eventLocation, eventTime, eventImages);
//        eventRecycler.setAdapter(adapter);
//        RecyclerView.Adapter adapter1  = eventRecycler.getAdapter();
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        eventRecycler.setLayoutManager(layoutManager);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView eventRecycler  = (RecyclerView) inflater.inflate(R.layout.fragment_event_list, container, false);

        //TODO: Populate the Data from Events Class
        int length = Events.events.length;
        String[] eventLocation = new String[length];
        for(int i=0; i<length; i++)
            eventLocation[i] = Events.events[i].getLocation();
        String[] eventTime = new String[length];
        for(int i=0; i<length; i++)
            eventTime[i] = Events.events[i].getTime();
        int[] eventImages = new int[length];
        for(int i=0; i<length; i++)
            eventImages[i] = Events.events[i].getImageResourceId();

        EventAdapter adapter = new EventAdapter(eventLocation, eventTime, eventImages);
        eventRecycler.setAdapter(adapter);
        RecyclerView.Adapter adapter1  = eventRecycler.getAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        eventRecycler.setLayoutManager(layoutManager);
        eventRecycler.setAdapter(adapter);

        adapter.setListener(new EventAdapter.Listener(){
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), EventDetailActivity.class);
                intent.putExtra(EventDetailActivity.EXTRA_EVENTNO, position);
                getActivity().startActivity(intent);
            }
        });
        return eventRecycler;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
