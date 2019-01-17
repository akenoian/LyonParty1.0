package com.example.demouser.lyonparty;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

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
        setContentView(R.layout.activity_event_page);

        // Save passed in event information from the prior activity's event
        event = (Event) getIntent().getParcelableExtra("event");
        if (event != null) {
            this.event = event;
        }

        // Update GUIs to display information from the specific event object parced
        displayEventInfo();
    }

    /**
     * Displays the updated information from the event
     * //@param event
     */
    public void displayEventInfo (){

        // Get all views on the EventPage xml (GUI view) and instanitate as variables
        TextView nameView = findViewById(R.id.eventNameText);
        TextView timeView = findViewById(R.id.timeText);
        TextView placeView = findViewById(R.id.placeText);
        TextView tagView = findViewById(R.id.tagsText);
        TextView hostView = findViewById(R.id.hostText);

        // update the GUI components with the event information
        nameView.setText(event.getName());
        timeView.setText((event.getTime()).toString());
        placeView.setText(event.getDate());
        hostView.setText(event.getHost());
        //tagView.setText(event.getTags());


    }
}
