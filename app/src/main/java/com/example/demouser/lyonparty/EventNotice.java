package com.example.demouser.lyonparty;

/**
 *
 * @author Jaemarie Solyst
 * @version 1/14/18
 */
public class EventNotice {
    //associated event
    private Event event;

    /**
     *
     * @param event event that the notice will hold and access information from
     */
    public EventNotice (Event event){
        //save event as global
        this.event = event;
    }

    /**
     * pull info from event once it has been updated
     */
    public void updateInfo(){

    }
}
