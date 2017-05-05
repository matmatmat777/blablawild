package com.example.apprenti.blablawild;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static com.example.apprenti.blablawild.R.id.editTextDate;

public class SearchItineraryActivity extends AppCompatActivity {

    EditText editText;
    EditText editText2;
    EditText editTextDate;
    Button button2;
    Context context;
    Toast toast;
    Intent Resultat;
    int toastDuration;
    Calendar mCalendar;
    DatePickerDialog.OnDateSetListener date;
    public final static String EXTRA_REQUEST = "resultat";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);

        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editTextDate = (EditText) findViewById(R.id.editTextDate);
        button2 = (Button) findViewById(R.id.button2);
        context = getApplicationContext();
        toast = Toast.makeText(context, getString(R.string.toast), toastDuration);
        toastDuration = Toast.LENGTH_SHORT;
        mCalendar = Calendar.getInstance();

        date = new DatePickerDialog.OnDateSetListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                mCalendar.set(Calendar.YEAR, year);
                mCalendar.set(Calendar.MONTH, month);
                mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();

            }
        };
        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(SearchItineraryActivity.this, date,
                        mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });






        Resultat = new Intent(this, ViewSearchItineraryResultsListActivity.class);

        button2.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (editText.length() != 0 && editText2.length() != 0) {

                    String mDepart = editText.getText().toString();
                    String mArrivee = editText2.getText().toString();
                    String mDateDepart = editTextDate.getText().toString();

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

        });
    }
    private void updateLabel() {

        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        editTextDate.setText(sdf.format(mCalendar.getTime()));
    }
}





