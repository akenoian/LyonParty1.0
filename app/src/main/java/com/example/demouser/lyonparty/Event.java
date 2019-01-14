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
     * Constructor to create an Event object. Do not pass in null for any of these objects.
     * @param time initial time of the event
     * @param place where the event will take place
     * @param host host of the event
     * @param tags what the tags are of the event
     * @param name what the event is called
     */
    public Event(Time time, String place, String host, String[] tags, String name){
        // save the params as global
        this.time = time;
        this.place = place;
        this.host = host;
        this.tags = tags;
        this.name = name;
    }

    /**
     * Change the name of the event
     * @param newName new name of the event
     */
    public void changeName(String newName){
        this.name = newName;
    }

    /**
     * Change the time of the event
     * @param newTime new time of the event
     */
    public void changeTime(Time newTime){
        this.time = newTime;
    }

    /**
     * Change the place of the event
     * @param newPlace new place of the event
     */
    public void changePlace(String newPlace){
        this.place = newPlace;
    }

    /**
     * Change the host of the event
     * @param newHost new name of the event
     */
    public void changeHost(String newHost){
        this.name = newHost;
    }

    /**
     * Remove a tag from the event
     * @param tagToRemove
     */
    public void removeTag(String tagToRemove){
        this.name = tagToRemove;
    }

    /**
     * Add a new tag to the event
     * @param newTag
     */
    public void addTag(String newTag){
        this.name = newTag;
    }

    /**
     * get the name of the event
     * @return event name
     */
    public String getName(){
        return name;
    }

    /**
     * get the time of the event
     * @return time of the event as a Time object
     */
    public Time getTime(){
        return time;
    }

    /**
     * get the place of the event
     * @return event place
     */
    public String getPlace(){
        return place;
    }

    /**
     * get the host of the event
     * @return event host
     */
    public String getHost(){
        return host;
    }

    /**
     * get the tags as a string array
     * @return tags of the event as a String array
     */
    public String[] getTags() {
        return tags;
    }
}
