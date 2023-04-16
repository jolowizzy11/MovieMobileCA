package com.example.moviemobile;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private final String name;
    private final String image;
    private final String certification;
    private final String description;
    private final String[] starring;
    private final int seatsRemaining;
    private final int runningTime;

    public Movie(String name, String image, String certification, String description, String[] starring, int seatsRemaining, int runningTime) {
        this.name = name;
        this.image = image;
        this.certification = certification;
        this.description = description;
        this.starring = starring;
        this.seatsRemaining = seatsRemaining;
        this.runningTime = runningTime;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getCertification() {
        return certification;
    }

    public String getDescription() {
        return description;
    }

    public String[] getStarring() {
        return starring;
    }

    public int getSeatsRemaining() {
        return seatsRemaining;
    }

    public int getRunningTime() {

        return runningTime;
    }

    protected Movie(Parcel in) {
        name = in.readString();
        image = in.readString();
        certification = in.readString();
        description = in.readString();
        starring = in.createStringArray();
        seatsRemaining = in.readInt();
        runningTime = in.readInt();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(image);
        dest.writeString(certification);
        dest.writeString(description);
        dest.writeStringArray(starring);
        dest.writeInt(seatsRemaining);
        dest.writeInt(runningTime);
    }
}
