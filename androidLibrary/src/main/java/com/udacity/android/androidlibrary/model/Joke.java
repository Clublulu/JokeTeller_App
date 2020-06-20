package com.udacity.android.androidlibrary.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Joke implements Parcelable {

    public String jokeType;
    public String joke;
    public String setup;
    public String delivery;
    public int jokeId;

    public Joke(String jokeType, String joke, String setup, String delivery, int jokeId) {
        this.jokeType = jokeType;
        this.joke = joke;
        this.setup = setup;
        this.delivery = delivery;
        this.jokeId = jokeId;
    }

    protected Joke(Parcel in) {
        jokeType = in.readString();
        joke = in.readString();
        setup = in.readString();
        delivery = in.readString();
        jokeId = in.readInt();
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
        dest.writeString(jokeType);
        dest.writeString(joke);
        dest.writeString(setup);
        dest.writeString(delivery);
        dest.writeInt(jokeId);
    }
}