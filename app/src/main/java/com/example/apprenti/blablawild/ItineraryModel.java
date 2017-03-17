package com.example.apprenti.blablawild;

/**
 * Created by apprenti on 16/03/17.
 */

public class ItineraryModel {

    public  int userID;
    public String driverLastName;
    public String driverFirstName;
    public String depart;
    public String destination;
    public int prix;
    public String date;

    private ItineraryModel(){

    }
    public ItineraryModel(int mUserID, String mDriverLastName, String mDriverFirstName, String mDepart, String mDestination, int mPrix, String  mDate){

        this.userID =0;
        this.driverLastName = "Flic";
        this.driverFirstName = "Flac";
        this.depart = mDepart;
        this.destination = mDestination;
        this.prix = mPrix;
        this.date = mDate;

    }

    public int getUserID() {
        return userID;
    }

    public String getDriverLastName() {
        return driverLastName;
    }

    public String getDriverFirstName() {
        return driverFirstName;
    }

    public String getDepart() {
        return depart;
    }

    public String getDestination() {
        return destination;
    }

    public int getPrix() {
        return prix;
    }

    public String getDate() {
        return date;
    }


}
