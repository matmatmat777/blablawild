package com.example.apprenti.blablawild;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import static android.R.attr.data;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {


    private SearchRequestModel resultat;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_results_list);
        SearchRequestModel resultat;


        intent = getIntent();
        resultat = intent.getParcelableExtra(SearchItineraryActivity.EXTRA_REQUEST);

        Toast.makeText(this, resultat.getmDateDepart(), Toast.LENGTH_SHORT).show();
        this.setTitle(resultat.getmDepart() + ">>" + resultat.getmArrivee());



    }
}
