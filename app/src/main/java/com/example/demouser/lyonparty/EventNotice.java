package com.example.demouser.lyonparty;

import android.view.View;
import android.content.ClipData;
import android.content.Context;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * EventNotice is the GUI representation of an event that will be on a list displayed on the app.
 * @author Jaemarie Solyst
 * @version 1/14/18
 */
public class EventNotice extends android.support.v7.widget.AppCompatTextView {
    //associated event
    private Event event;

    // dimensions of the event notice
    public static final int HEIGHT = 100;
    public static final int WIDTH = 500;
    public static final int TEXT_SIZE = 15;


    /**
     *
     * @param event event that the notice will hold and access information from
     */
    public EventNotice (Context context, Event event){
        //save event as global
        super(context);
        this.event = event;
        setText(event.getHost()
        + "\n" + "TIME: " +  event.getTime()
        + "\n" + "PLACE: " + event.getPlace());

        //setTextAlignment(TEXT_ALIGNMENT_CENTER);

        setHeight(HEIGHT);
        setWidth(WIDTH);
        setTextSize(TEXT_SIZE);
        setBackgroundColor(Color.rgb(255, 255, 200));
    }

    /**
     * pull info from event once it has been updated to display as text
     */
    public void updateInfo(){
        setText(event.getHost()
                + "\n" + "TIME: " +  event.getTime()
                + "\n" + "PLACE: " + event.getPlace());
    }
}
