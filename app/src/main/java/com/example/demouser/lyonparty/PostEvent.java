package com.example.demouser.lyonparty;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ToggleButton;

import java.sql.Time;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PostEvent extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_event);
        Button doneButton = findViewById(R.id.doneButton);

        createNewEvent();
        Log.i("test", "eventhost" + createNewEvent().getHost());
        Log.i("test", "eventtags" + createNewEvent().getTags());
        Log.i("test", "eventdate" + createNewEvent().getDate());
        Log.i("test", "eventname" + createNewEvent().getName());
        Log.i("test", "eventtime" + createNewEvent().getTime());


        //checks that all the fields have been filled by the time the user presses "done"
        //when done button is pressed, call createNewEvent method
        //insert the returned method to allEvents list, recall filter events
    }

    /**
     * All input text is saved into a new event object.
     * Event object is then saved into the hashmap depending on its tags.
     */
    private Event createNewEvent () {
        EditText eventNameInput = findViewById(R.id.editText1);
        EditText hostInput = findViewById(R.id.editText2);
        EditText dateInput = findViewById(R.id.editText3);
        EditText timeInput = findViewById(R.id.timeText);
        EditText infoInput = findViewById(R.id.editText5);

        //edit texts that expect string inputs
        String eventName = eventNameInput.getText().toString();
        Log.i("test", "event get name " + eventName);
        String hostName = hostInput.getText().toString();
        Log.i("test", "event get host " + hostName);
        String dateName = dateInput.getText().toString();
        Log.i("test", "event get date " + dateName);
        String infoName = infoInput.getText().toString();


        //convert time into a string, then an int, then parse that int into separate ints to put into Time object
        /*String timeName = timeInput.getText().toString();
        int timeParsed = Integer.parseInt(timeName);
        //stack to hold the digits
        List<Integer> stack = new ArrayList<Integer>();
        while (timeParsed > 0) {
            stack.add( timeParsed % 10 );
            timeParsed = timeParsed / 10;
        }
        //stack has all the separate digits
        //walk through and save them to 3 integers
        int t1=0;
        int t2=0;
        int t3=0;
        for (int i = 0; i<stack.size(); i++){
            if (i==0){
                t1 = stack.get(i);
            }
            if (i==1){
                t2 = stack.get(i);
            }
            if (i==2){
                t3 = stack.get(i);
            }
        }
        Time time = new Time(t1, t2, t3);*/
        Time time = new Time (12, 0, 0);


        //make the list of tags based on buttons they chose
        //TEMP
        List<String> tags = new ArrayList<>();
        tags.add(MainActivity.allTags.get(0));

        //make the new event!
        Event newEvent = new Event (time, dateName, hostName, tags, eventName);

        return newEvent;
    }

    /**
     * This method is called when the Post Event button is clicked at the top of the screen.
     * @param view
     * @return
     */
    public boolean onDoneButton(View view){
        return true;
    }

}
