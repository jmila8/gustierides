package edu.gac.jmila.gustierides;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;

import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

import database.RideDbSchema;
import database.databaseHelper;
import database.RideCursorWrapper;


/**
 * Created by jessiemila on 4/27/18.
 */

public class ridePosts {

    private Context mContext;
    private SQLiteDatabase mDatabase;
    private static ridePosts sRidePosts;

    public static ridePosts get(Context context) {
        if (sRidePosts == null) {
            sRidePosts = new ridePosts(context);
        }

        return sRidePosts;
    }

    private ridePosts (Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new databaseHelper(mContext).getWritableDatabase();
    }

    public void addRide(Ride r) {
        ContentValues values = getContentValues(r);

        mDatabase.insert(RideDbSchema.RideTable.NAME, null, values);
    }

    public List<Ride> getRides() {
        List<Ride> rides = new ArrayList<>();
        RideCursorWrapper cursor = queryRides(null, null);
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                rides.add(cursor.getRide());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return rides;
    }

    public Ride getRide(UUID id) {
        RideCursorWrapper cursor = queryRides(RideDbSchema.RideTable.Cols.UUID +
        " = ?", new String[] {id.toString()}
        );

        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getRide();
        }finally {
            cursor.close();
        }
    }

    public void updateRide(Ride ride) {
        String uuidString = ride.getId().toString();
        ContentValues values = getContentValues(ride);

        mDatabase.update(RideDbSchema.RideTable.NAME, values, RideDbSchema.RideTable.Cols.UUID +
        " = ?", new String[] {uuidString});
    }

    private RideCursorWrapper queryRides(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                RideDbSchema.RideTable.NAME,
                null, // Columns - null selects all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null  // orderBy
        );
        return new RideCursorWrapper(cursor);
    }

    private static ContentValues getContentValues(Ride ride) {
        ContentValues values = new ContentValues();
        values.put(RideDbSchema.RideTable.Cols.UUID, ride.getId().toString());
        values.put(RideDbSchema.RideTable.Cols.EMAIL, ride.getEmail());
        values.put(RideDbSchema.RideTable.Cols.DESTINATION, ride.getDestination());
        values.put(RideDbSchema.RideTable.Cols.LOCATION, ride.getLocation());
        values.put(RideDbSchema.RideTable.Cols.DATE, ride.getDate());

        return values;

    }


}
