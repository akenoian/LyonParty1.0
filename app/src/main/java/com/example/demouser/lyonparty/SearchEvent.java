package com.example.demouser.lyonparty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Toast;

import java.sql.Array;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SearchEvent extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    private MyRecyclerViewAdapter adapter;
    private LinearLayoutManager layoutManager;
    private Event exampleEv1;
    private Event exampleEv2;
    private Event exampleEv3;
    public List<String> selectedTags = MainActivity.selectedTags;
    Set<EventNotice> noticesSet;
    List<EventNotice> notices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_event);


        filterEvents();


        // instantiate layout manager
        layoutManager = new LinearLayoutManager(this);

        // Create example events
        createExampleEvents();

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.eventListView);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MyRecyclerViewAdapter(this, notices);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        // create division for events
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);


    }


    @Override
    public void onItemClick(View view, int position) {
        //add an intent to open another activity that's just an xml of the event information
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();

        EventNotice clickedNotice = adapter.getItem(position);
        Event clickedEvent = clickedNotice.getEvent();

        //EventPage page = new EventPage(this, clickedEvent);
        Intent openEventPageIntent = new Intent(this, EventPage.class);

        // for demo on Fri
        openEventPageIntent.putExtra("event", clickedEvent);

        startActivity(openEventPageIntent);


    }

    /**
     * BELOW HERE IS HARDCODED EVENT INFORMATION FOR DEMONSTRATION PURPOSES
     */
    public void createExampleEvents(){
        // example times
        /**
        Time time1 = new Time(01,1,00);
        Time time2 = new Time(03, 49, 00);
        Time time3 = new Time(10, 30, 00);

        // example tags
        ArrayList<String> tags1 = new ArrayList<>();
        ArrayList<String> tags2 = new ArrayList<>();
        ArrayList<String> tags3 = new ArrayList<>();


        tags1.add("free food");
        tags1. add("wild part");

        // Example 1: Mary's Party
        exampleEv1 = new Event(time1, "Rockies 304", "Mary Lyon", tags1, "Mary's Wild Graduation" );
        EventNotice notice1 = new EventNotice(this, exampleEv1);


        // Populate the recycler view with demo example events
        ArrayList<EventNotice> notices = new ArrayList<>();
        notices.add(notice1);
        */

        /**
        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.eventListView);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MyRecyclerViewAdapter(this, notices);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        // create division for events
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
         */

    }

    @Override
    protected void onResume() {
        super.onResume();

        filterEvents();

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        noticesSet = new HashSet<>();
        notices = new ArrayList<>();

    }

    public void filterEvents() {

        noticesSet = new HashSet<>();
        notices = new ArrayList<>();

        List<Event> userEvents = new ArrayList<>();

        for (int i = 0; i < selectedTags.size(); i++) {
            List<Event> events = MainActivity.taggedEvents.get(selectedTags.get(i));
            for (int j = 0; j < events.size(); j++) {
                if (!userEvents.contains(events.get(j))) {
                    userEvents.add(events.get(j));
                }
            }
        }

        for (int j = 0; j < userEvents.size(); j++) {
            //EventNotice demo = new EventNotice(this, events.get(j));
            noticesSet.add(new EventNotice(this, userEvents.get(j)));
            //Log.i("test", "set: " + noticesSet.get);
            //Log.i("test", "event added: " + demo.getEvent());


        }


        Iterator<EventNotice> it = noticesSet.iterator();
        while (it.hasNext()) {
            notices.add(it.next());

        }


    }

}
