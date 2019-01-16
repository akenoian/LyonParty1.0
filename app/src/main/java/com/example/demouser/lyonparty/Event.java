package com.example.demouser.lyonparty;

import android.os.Parcel;
import android.os.Parcelable;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * This class holds all of the data for an event. It has no GUI components, but rather other
 * GUI components know about their associated events, and can access information from this
 * primary data object.
 * @author Jaemarie Solyst
 * @version 1/14/19
 */
public class Event implements Parcelable {

    // event information that can be changed or accessed later
    private String place;
    private String host;
    private String name;
    private List<String> tags;
    private Time time;

    /**
     * Constructor to create an Event object. Do not pass in null for any of these objects.
     * @param time initial time of the event
     * @param place where the event will take place
     * @param host host of the event
     * @param tags what the tags are of the event
     * @param name what the event is called
     */
    public Event(Time time, String place, String host, List<String> tags, String name){
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
        tags.remove(tagToRemove);
    }

    /**
     * Add a new tag to the event
     * @param newTag
     */
    public void addTag(String newTag){
        tags.add(newTag);
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
    public List<String> getTags() {
        return tags;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * BELOW HERE MAKES THE EVENT CLASS PARCEABLE
     */

    /**
     * Store event data to a parcel object. More information here:
     * https://en.proft.me/2017/02/28/pass-object-between-activities-android-parcelable/
     * @param dest
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(place);
        dest.writeString(host);
        dest.writeString(name);
        dest.writeStringList(tags);
        dest.writeString(time.toString());
    }

    /**
     * Retrieving Movie data from Parcel object
     * This constructor is invoked by the method createFromParcel(Parcel source) of
     * the object CREATOR
     **/
    private Event(Parcel in){
        // get global vars of an event
        this.place = in.readString();
        this.host = in.readString();
        this.name = in.readString();
        this.tags = in.createStringArrayList();

        // Get the time as a string first
        String timeString = in.readString();
        //convert String to time
        this.time = java.sql.Time.valueOf(timeString);
    }

    /**
     * ???
     * https://en.proft.me/2017/02/28/pass-object-between-activities-android-parcelable/
     */
    public static final Parcelable.Creator<Event> CREATOR = new Parcelable.Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel source) {
            return new Event(source);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };
}
