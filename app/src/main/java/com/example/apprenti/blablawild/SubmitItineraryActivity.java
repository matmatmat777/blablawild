package com.example.apprenti.blablawild;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.apprenti.blablawild.SearchItineraryActivity.EXTRA_REQUEST;



public class SubmitItineraryActivity extends AppCompatActivity {

    EditText editTextDepart;
    EditText editTextDestination;
    EditText editTextPrix;
    EditText editTextDate;
    EditText editTextHeure;
    Button buttonPublier;
    ItineraryModel mItineraryModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_itinerary);

        editTextDepart = (EditText)findViewById(R.id.editTextDepart);
        editTextDestination = (EditText)findViewById(R.id.editTextDestination);
        editTextPrix = (EditText)findViewById(R.id.editTextPrix);
        editTextDate = (EditText)findViewById(R.id.editTextDate);
        editTextHeure = (EditText)findViewById(R.id.editTextHeure);
        buttonPublier = (Button)findViewById(R.id.buttonPublier);

        buttonPublier.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                //if (editTextDepart.length() != 0 && editTextDestination.length() != 0 && editTextHeure.length() !=0 && editTextPrix.length() != 0 && editTextDate.length() != 0) {
                    String mLastName ="Flic";
                    String mFirstName ="Flac";
                    int mId = 0;
                    String mDepart = editTextDepart.getText().toString();
                    String mDestination = editTextDestination.getText().toString();
                    int mPrix = Integer.parseInt(editTextPrix.getText().toString());
                    String mDate = editTextDate.getText().toString();
                    String mHeure = editTextHeure.getText().toString();


                final FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference ref = database.getReference("itineraries");


                mItineraryModel = new ItineraryModel(mId, mLastName, mFirstName, mDepart, mDestination, mPrix,mDate);
                ref.push().setValue(mItineraryModel);
                finish();
               /* } else {


                    Context context = getApplicationContext();
                    CharSequence text = getString(R.string.toast);
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context,text,duration);
                    toast.show();
                }*/
            }

        });





    }
}
