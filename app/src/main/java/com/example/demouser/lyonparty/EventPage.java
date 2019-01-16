package com.example.demouser.lyonparty;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * The EventPage is opened as an intent, which shows information about the event.
 * @author Jaemarie Solyst
 * @version 1/15/19
 */
public class EventPage extends AppCompatActivity {

    private Event event;

    /**
     * Event page displays information about an event
     * //@param event Event for the EventPage to display
     */
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_post_event);
    }
}
