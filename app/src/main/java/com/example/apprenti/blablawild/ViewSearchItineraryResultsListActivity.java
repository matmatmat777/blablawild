package com.example.apprenti.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {


    private SearchRequestModel resultat;
    private Intent intent;
    private ListView mListViewResults;
    private ListAdapter mResultsAdapter;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_results_list);





        intent = getIntent();
        resultat = intent.getParcelableExtra(SearchItineraryActivity.EXTRA_REQUEST);

        this.setTitle(resultat.getmDepart()+ " " + resultat.getmArrivee());

        mListViewResults = (ListView) findViewById(R.id.List);
        mDatabase = FirebaseDatabase.getInstance().getReference("itineraries");
        TripResultAdapter mTripResultAdapter = new TripResultAdapter(mDatabase, this, R.layout.trip_item);
        mListViewResults.setAdapter(mTripResultAdapter);



    }


}



