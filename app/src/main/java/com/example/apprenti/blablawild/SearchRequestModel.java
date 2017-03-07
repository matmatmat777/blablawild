package com.example.apprenti.blablawild;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by apprenti on 06/03/17.
 */

public class SearchRequestModel implements Parcelable {

    private String mDepart;
    private String mArrivee;
    private String mDateDepart;


    public SearchRequestModel(String mDepart, String mArrivee, String mDateDepart) {
        this.mDepart = mDepart;
        this.mArrivee = mArrivee;
        this.mDateDepart = mDateDepart;
    }

    protected SearchRequestModel(Parcel in) {

        mArrivee = in.readString();
        mDepart = in.readString();
        mDateDepart = in.readString();
    }

    public static final Creator<SearchRequestModel> CREATOR = new Creator<SearchRequestModel>() {
        @Override
        public SearchRequestModel createFromParcel(Parcel in) {
            return new SearchRequestModel(in);
        }

        @Override
        public SearchRequestModel[] newArray(int size) {
            return new SearchRequestModel[size];
        }
    };


    public String getmDepart() {
        return mDepart;
    }

    public String getmArrivee() {
        return mArrivee;
    }

    public String getmDateDepart() {
        return mDateDepart;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mDepart);
        dest.writeString(mArrivee);
        dest.writeString(mDateDepart);

    }

}