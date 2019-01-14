package com.example.demouser.lyonparty;

import java.sql.Time;

/**
 * This class holds all of the data for an event. It has no GUI components, but rather other
 * GUI components know about their associated events, and can access information from this
 * primary data object.
 */
public class Event {

    // event information that can be changed or accessed later
    private String place;
    private String host;
    private String name;
    private String[] tags;
    private Time time;

    /**
     * Constructor to create an Event object
     * @param time initial time of the event
     * @param place where the event will take place
     * @param host host of the event
     * @param tags what the tags are of the event
     * @param name what the event is called
     */
    public Event(Time time, String place, String host, String[] tags, String name){
        // save the params as global
        time = this.time;
        place = this.place;
        host = this.host;
        tags = this.tags;
        name = this.name;
    }



}
