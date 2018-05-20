package edu.gac.jmila.gustierides;

import java.util.UUID;

/**
 * Created by jessiemila on 5/18/18.
 */

public class Ride {

    private UUID mId;
    private String mEmail;
    private String mDestination;
    private String mLocation;
    private String mDate;

    public Ride() {this(UUID.randomUUID());}

    public Ride(UUID id) {
        mId = id;
    }

    public UUID getId() {return mId;}

    public String getEmail () {return mEmail;}

    public String getDestination () {return mDestination;}

    public String getLocation () {return mLocation;}

    public String getDate () {return mDate;}

    public void setEmail(String email) {
        mEmail = email;
    }

    public void setDestination(String destination) {
        mDestination = destination;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    public void setDate (String date) {
        mDate = date;
    }


}
