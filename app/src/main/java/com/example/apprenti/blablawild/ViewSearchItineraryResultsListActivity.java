package com.example.apprenti.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_results_list);

        Intent intent = getIntent();

        String Depart = intent.getStringExtra("Depart");
        String Destination = intent.getStringExtra("Destination");

        setTitle(Depart + " " + getString(R.string.fleche) + " " + Destination);
    }
}
