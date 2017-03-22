package com.example.apprenti.blablawild;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.firebase.database.Query;

import static java.lang.String.valueOf;

/**

 @author greg
 @since 6/21/13 *
 This class is an example of how to use FirebaseListAdapter. It uses the <code>ItineraryModel</code> class to encapsulate the

 data for each individual chat message


 */
// nom de ma class qui hérite de la firelistadapter <no
public class TripResultAdapter extends FirebaseListAdapter<ItineraryModel> {

    // The mUsername for this client. We use this to indicate which messages originated from this user
    private String mUsername;
    private TextView TextViewDepartureTime;
    private TextView TextViewFirstName;
    private TextView TextViewPrice;

    public TripResultAdapter(Query ref, Activity activity, int layout) {
        super(ref, ItineraryModel.class, layout, activity);
        this.mUsername = mUsername;

    }

    @Override
    protected void populateView(View view, ItineraryModel model) {

        TextViewDepartureTime = (TextView)view.findViewById(R.id.textViewDateDepart);
        TextViewFirstName = (TextView)view.findViewById(R.id.TextViewNom);
        TextViewPrice = (TextView)view.findViewById(R.id.textViewPrice);

        String firstName = model.getDriverFirstName();
        String depart=model.getDepart();
        TextViewDepartureTime.setText(depart);
        TextViewFirstName.setText(firstName);
        TextViewPrice.setText(Integer.toString(model.getPrix()));

    }
}

