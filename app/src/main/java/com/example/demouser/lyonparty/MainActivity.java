package com.example.demouser.lyonparty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "LyonPartyApp";
    private Map<String, String> userInfo = new HashMap<>(); // holds the name, email, and class year of the user
    private RadioGroup radioGroup; // group of buttons that provide choices for class year
    private RadioButton radioButton;
    public static List<String> selectedTags; // will hold the tags selected by user at registration
    public static List<String> allTags = new ArrayList<>(); // holds all the tags provided to the user upon registration

    // hashmap that maps the tags to an array list of their coresponding events (one event can be listed under multiple tags)
    public static Map<String, List<Event>> taggedEvents = new HashMap<>();
    public static List<Event> allEvents = new ArrayList<>();

    Time time = new Time(1,1,1);

    ArrayList<String> tagsdemo1 = new ArrayList<>();    //lists for the hard coded events
    ArrayList<String> tagsdemo2 = new ArrayList<>();
    ArrayList<String> tagsdemo3 = new ArrayList<>();
    ArrayList<String> tagsdemo4 = new ArrayList<>();
    ArrayList<String> tagsdemo5 = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * hard code events for testing purposes
     * fill their tags array lists with tags
     */
    private void createEvent() {



        for (int i=0;i<allTags.size();i++) {    //only list with all tags
            tagsdemo1.add(allTags.get(i));      //should be in every event notice list
        }

        tagsdemo2.add(allTags.get(1));
        tagsdemo2.add(allTags.get(0));

        tagsdemo3.add(allTags.get(2));
        tagsdemo3.add(allTags.get(4));

        tagsdemo4.add(allTags.get(3));

        tagsdemo5.add(allTags.get(5));

        Event eventdemo1 = new Event(time, "5/10/19", "Mary Lyon", tagsdemo1, "Mary's Graduation Party" );
        allEvents.add(eventdemo1);
        Event eventdemo2 = new Event(time, "2/3/19", "Political Society", tagsdemo2, "Upcoming Elections Discussion" );
        allEvents.add(eventdemo2);
        Event eventdemo3 = new Event(time, "4/3/19", "Jenny Graham", tagsdemo3, "Thrift my room!" );
        allEvents.add(eventdemo3);
        Event eventdemo4 = new Event(time, "2/15/19", "Nicki Minaj", tagsdemo4, "Lunch with Nicki Minaj" );
        allEvents.add(eventdemo4);
        Event eventdemo5 = new Event(time, "3/4/19", "Holyoke Hikers", tagsdemo5, "Hiking Outing" );
        allEvents.add(eventdemo5);

    }

    /**
     * This method is called when the Done button is clicked.
     * @param view
     * @return
     */
    public boolean onDone(View view) {

        // retrieve the information that the user has submitted
        getNameText();

        getEmail();

        getClassYear();

        getCheckedTags();

        //open the postEvent screen
        Intent intent = new Intent(this, SearchEvent.class);
        
        //takes a string name and value
        startActivity(intent);  //new UI

        return true;
    }

    public String getNameText() {

        EditText edTextName = (EditText) findViewById(R.id.editTextName);

        edTextName.setInputType(InputType.TYPE_CLASS_TEXT);

        String name = "";

        if (edTextName != null) { // make sure info was added before retreiving anything

            name = edTextName.getText().toString();

            userInfo.put("Name", name); // put the name in the hashmap containing user info

            Log.i(TAG, "Inputted name: " + name);
        }

        return name;

    }

    public String getEmail() {

        EditText edTextEmail = (EditText) findViewById(R.id.timeText);

        edTextEmail.setInputType(InputType.TYPE_CLASS_TEXT);

        String email = "";

        if (edTextEmail != null) { // make sure info was added before retreiving anything

            email = edTextEmail.getText().toString();

            userInfo.put("Email", email); // put the email in the hashmap containing user info

            Log.i(TAG, "Inputted email: " + email);
        }

        return email;

    }

    public String getClassYear() {

        radioGroup = (RadioGroup) findViewById(R.id.radioGroupClassYear);

        // get selected radio button from radioGroup
        int selectedYear = radioGroup.getCheckedRadioButtonId();

        String year = "";


        // find the radiobutton by returned id
        radioButton = (RadioButton) findViewById(selectedYear);

        if (radioButton != null) { // make sure a button was selected before retreiving any information

            year = radioButton.getText().toString();

            userInfo.put("Class Year", year); // put the year in the hashmap containing user info

            Log.i(TAG, "Inputted class year: " + year);
        }

        return year;

    }

    public List<String> getCheckedTags() {

        selectedTags = new ArrayList<>(); // a new list is created everytime the user clicks Done
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
            allTags.add(text); // add it to the allTags array list
            if (item.isChecked()) { // only if it is checked when the user submits
                selectedTags.add(text); // add it to the selected tags array list
            }
        }

        createTagHashMap(); //make the hashmap

        return selectedTags;
    }

    /**
     * Build the hash map that maps tags to a list of events.
     */
    public static void createTagHashMap() {
        //createEvent();   //fill each list of the events bc they're hard coded for now
        //puts the keys in (tags)
        for (int i = 0; i < allTags.size(); i++) {
            taggedEvents.put(allTags.get(i), new ArrayList<Event>());
        }
        //walk through all the possible events
        for (int i = 0; i<allEvents.size(); i++){
            List<String> eventTags = allEvents.get(i).getTags();    //make a local list to hold event tags
            for (int j = 0; j<eventTags.size(); j++) {   //walk through them
                taggedEvents.get(eventTags.get(j)).add(allEvents.get(i));  //add event to hashmap at value that matches key/tag
            }
            Log.i("test", "hashmap: " + taggedEvents.get("free food").toString());
        }

        for (Map.Entry<String, List<Event>> entry : taggedEvents.entrySet()) {
            //Log.i("test", "key: " + entry.getKey() + "values: " + entry.getValue());
        }

    }

}
