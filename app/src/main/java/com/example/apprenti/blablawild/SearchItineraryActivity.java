package com.example.apprenti.blablawild;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.widget.ContentFrameLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchItineraryActivity extends AppCompatActivity {

    EditText editText;
    EditText editText2;
    EditText editText3;
    Button button2;
    Context context;
    Toast toast;
    Intent Resultat;
    int toastDuration;
    public final static String EXTRA_REQUEST = "resultat";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);

        editText =(EditText)findViewById(R.id.editText);
        editText2 =(EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);
        button2 = (Button) findViewById(R.id.button2);
        context = getApplicationContext();
        toast = Toast.makeText(context, getString(R.string.toast), toastDuration);
        toastDuration = Toast.LENGTH_SHORT;

        Resultat = new Intent(this, ViewSearchItineraryResultsListActivity.class);

        button2.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (editText.length() != 0 && editText2.length() != 0) {

                    String mDepart = editText.getText().toString();
                    String mArrivee = editText2.getText().toString();
                    String mDateDepart = editText3.getText().toString();

                    SearchRequestModel resultat = new SearchRequestModel (mDepart, mArrivee, mDateDepart);

                    Resultat.putExtra(EXTRA_REQUEST, resultat);
                    startActivity(Resultat);

                } else {


                    Context context = getApplicationContext();
                    CharSequence text = getString(R.string.toast);
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context,text,duration);
                    toast.show();
                }
            }

        });}}



