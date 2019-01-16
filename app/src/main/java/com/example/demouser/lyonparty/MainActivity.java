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
import android.widget.Toast;

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
    public List<String> selectedTags; // will hold the tags selected by user at registration
    public List<String> allTags = new ArrayList<>(); // holds all the tags provided to the user upon registration

    // hashmap that maps the tags to an array list of their coresponding events (one event can be listed under multiple tags)
    public Map<String, List<Event>> taggedEvents = new HashMap<>();

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

        createEvent();   //fill each list of the events bc they're hard coded for now

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

        tagsdemo5.add(allTags.get(4));

        Event eventdemo1 = new Event(time, "Event place1", "event host1", tagsdemo1, "event name1" );
        Event eventdemo2 = new Event(time, "Event place2", "event host2", tagsdemo2, "event name2" );
        Event eventdemo3 = new Event(time, "Event place3", "event host3", tagsdemo3, "event name3" );
        Event eventdemo4 = new Event(time, "Event place4", "event host4", tagsdemo4, "event name4" );
        Event eventdemo5 = new Event(time, "Event place5", "event host5", tagsdemo5, "event name5" );
        

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

        String name = edTextName.getText().toString();

        userInfo.put("name", name); // put the name in the hashmap containing user info

        Log.i(TAG, "Inputted name: " + name);

        return name;

    }

    public String getEmail() {

        EditText edTextEmail = (EditText) findViewById(R.id.editTextEmail);

        edTextEmail.setInputType(InputType.TYPE_CLASS_TEXT);

        String email = edTextEmail.getText().toString();

        userInfo.put("Email", email); // put the email in the hashmap containing user info

        Log.i(TAG, "Inputted email: " + email);

        return email;

    }

    public String getClassYear() {

        radioGroup = (RadioGroup) findViewById(R.id.radioGroupClassYear);

        // get selected radio button from radioGroup
        int selectedYear = radioGroup.getCheckedRadioButtonId();
        // find the radiobutton by returned id
        radioButton = (RadioButton) findViewById(selectedYear);

        String year = radioButton.getText().toString();

        userInfo.put("Class Year", year); // put the year in the hashmap containing user info

        Log.i(TAG, "Inputted class year: " + year);

        return year;

    }

    public List<String> getCheckedTags() {

        selectedTags = new ArrayList<>();
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
        Log.i(TAG, "check selected tags: " + selectedTags);
        return selectedTags;
    }

    /**
     * Build the hash map that maps tags to a list of events.
     */
    public void createTagHashMap() {

        for (int i = 0; i < allTags.size(); i++) {
            taggedEvents.put(allTags.get(i), new ArrayList<Event>());
        }

    }

}
