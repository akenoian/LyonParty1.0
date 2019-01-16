package com.example.demouser.lyonparty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Toast;

import java.sql.Array;
import java.sql.Time;
import java.util.ArrayList;

public class SearchEvent extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener{

    MyRecyclerViewAdapter adapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_event);

        Time time = new Time(1,1,1);
        ArrayList<String> tags = new ArrayList<>();
        tags.add("free food");

        Event event = new Event(time, "Event place", "event host", tags, "event name" );
        EventNotice demo = new EventNotice(this, event);
        // data to populate the RecyclerView with
        ArrayList<EventNotice> notices = new ArrayList<>();
        notices.add(demo);

        // instantiate layout manager
        layoutManager = new LinearLayoutManager(this);

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


    }
}
