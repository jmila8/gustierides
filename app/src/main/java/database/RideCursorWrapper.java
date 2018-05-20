package database;

import android.database.CursorWrapper;
import android.database.Cursor;
import java.util.UUID;

import edu.gac.jmila.gustierides.Ride;

/**
 * Created by jessiemila on 5/18/18.
 */

public class RideCursorWrapper extends CursorWrapper{

    public RideCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Ride getRide() {
        String uuidString = getString(getColumnIndex(RideDbSchema.RideTable.Cols.UUID));
        String email = getString(getColumnIndex(RideDbSchema.RideTable.Cols.EMAIL));
        String date = getString(getColumnIndex(RideDbSchema.RideTable.Cols.DATE));
        String destination = getString(getColumnIndex(RideDbSchema.RideTable.Cols.DESTINATION));
        String location = getString(getColumnIndex(RideDbSchema.RideTable.Cols.LOCATION));

        Ride ride = new Ride(UUID.fromString(uuidString));
        ride.setEmail(email);
        ride.setDate(date);
        ride.setDestination(destination);
        ride.setLocation(location);

        return ride;
    }

}
