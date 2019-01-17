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

import android.widget.CheckBox;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PostEvent extends AppCompatActivity {


    //private SearchEvent searchEvent = new SearchEvent();
    //private ToggleButton tbutton1 = findViewById(R.id.toggleButtonTAG1);
    public static List<String> tagsSelected; // will hold the tags selected by user at registration
   // public static List<Events> newEvents = new

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
    private Event createNewEvent() {


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
        Time time = new Time(12, 0, 0);


        //make the list of tags based on buttons they chose
        List<String> tags = retrieveInfo();
        //make the new event!
        Event newEvent = new Event(time, dateName, hostName, tags, eventName);


        MainActivity.tagsdemo1 = new ArrayList<>();    //lists for the hard coded events
        MainActivity.tagsdemo2 = new ArrayList<>();
        MainActivity.tagsdemo3 = new ArrayList<>();
        MainActivity.tagsdemo4 = new ArrayList<>();
        MainActivity.tagsdemo5 = new ArrayList<>();

        MainActivity.allEvents = new ArrayList<>();
        MainActivity.allEvents.add(newEvent);

        MainActivity.createTagHashMap();


        return newEvent;
    }

    /**
     * This method is called when the Post Event button is clicked at the top of the screen.
     *
     * @param view
     * @return
     */
    public boolean onDoneButton(View view) {
        return true;


    }

    public void onPostEvent(View view) {

        createNewEvent();

        //open the postEvent screen
        Intent intent = new Intent(this, SearchEvent.class);

        //takes a string name and value
        startActivity(intent);  //new UI
    }

    /**
     * This method should save which tags where clicked when the user clicks Post and add it
     * the hashmap containing all of the events (from the Main Activity). Then filterEvents from the
     * PostEvent class should be called to update the display.
     */
    public List<String> retrieveInfo() {

        tagsSelected = new ArrayList<>(); // a new list is created everytime the user clicks Done
        List<CheckBox> items = new ArrayList<CheckBox>();

        CheckBox foodCheckBox = (CheckBox) findViewById(R.id.checkBox1);
        items.add(foodCheckBox);

        CheckBox coffeeCheckBox = (CheckBox) findViewById(R.id.checkBox2);
        items.add(coffeeCheckBox);

        CheckBox drinksCheckBox = (CheckBox) findViewById(R.id.checkBox3);
        items.add(drinksCheckBox);

        CheckBox musicCheckBox = (CheckBox) findViewById(R.id.checkBox4);
        items.add(musicCheckBox);

        CheckBox lectureCheckBox = (CheckBox) findViewById(R.id.checkBox5);
        items.add(lectureCheckBox);

        CheckBox politicalCheckBox = (CheckBox) findViewById(R.id.checkBox6);
        items.add(politicalCheckBox);

        String text;

        for (CheckBox item : items) { // walk through all the tag check boxes
            text = item.getText().toString(); // retrieve their text data

            if (item.isChecked()) { // only if it is checked when the user submits
                tagsSelected.add(text); // add it to the selected tags array list
            }
        }

        Log.i("test", "tags selected: " + tagsSelected);

        return tagsSelected;
    }

}
