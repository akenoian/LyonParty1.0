package com.example.demouser.lyonparty;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PostEvent extends AppCompatActivity {

    //private SearchEvent searchEvent = new SearchEvent();
    //private ToggleButton tbutton1 = findViewById(R.id.toggleButtonTAG1);
    public static List<String> tagsSelected; // will hold the tags selected by user at registration

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_event);



    }

    /**
     * This method is called when the Post button is clicked after the user has entered their event info.
     * The event info should be saved and the new event should also be displayed when the Post Events screen pops up again.
     *
     * @param view
     * @return
     */
//    public void onPost(View view) {
//
//        retrieveInfo();
//
//        //open the postEvent screen
//        Intent intent = new Intent(this, SearchEvent.class);
//
//        //takes a string name and value
//        startActivity(intent);  //new UI
//
//        //return true;
//    }
//
    public void onPostEvent(View view) {

        retrieveInfo();

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
    public void retrieveInfo() {

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

        //MainActivity.allEvents.add(new Event());

    }

}
