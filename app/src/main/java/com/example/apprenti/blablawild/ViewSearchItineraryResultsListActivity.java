package com.example.apprenti.blablawild;

import android.content.Context;
import android.content.Intent;
import android.net.ParseException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static android.R.attr.data;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {


    private SearchRequestModel resultat;
    private Intent intent;
    private ListView mListViewResults;
    private ListAdapter mResultsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_results_list);
        SearchRequestModel resultat;

        mListViewResults = (ListView) findViewById(R.id.List);
        ArrayList<TripResultModel> results = new ArrayList<>();


        intent = getIntent();
        resultat = intent.getParcelableExtra(SearchItineraryActivity.EXTRA_REQUEST);

        Toast.makeText(this, resultat.getmDateDepart(), Toast.LENGTH_SHORT).show();
        this.setTitle(resultat.getmDepart() + ">>" + resultat.getmArrivee());


                results.add(new TripResultModel("Bruce", "21/02/2017-15:30", 15));
                results.add(new TripResultModel("Clark", "21/02/2017-16:00", 20));
                results.add(new TripResultModel("Bary", "21/02/2017-16:30", 16));
                results.add(new TripResultModel("Lex", "21/02/2017-17:00", 40));


        mResultsAdapter = new TripResultAdapter(this, results);
            mListViewResults.setAdapter(mResultsAdapter);


        }


    }



