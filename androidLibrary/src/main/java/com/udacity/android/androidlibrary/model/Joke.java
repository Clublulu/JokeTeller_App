package com.udacity.android.androidlibrary.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Joke implements Parcelable {

    public String setupLine;
    public String punchLine;

    public Joke(String setupLine, String punchLine) {
        this.setupLine = setupLine;
        this.punchLine = punchLine;
    }

    protected Joke(Parcel in) {
        setupLine = in.readString();
        punchLine = in.readString();
    }

    public static final Creator<Joke> CREATOR = new Creator<Joke>() {
        @Override
        public Joke createFromParcel(Parcel in) {
            return new Joke(in);
        }

        @Override
        public Joke[] newArray(int size) {
            return new Joke[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(setupLine);
        dest.writeString(punchLine);
    }
}