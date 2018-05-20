package database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

import database.RideDbSchema.RideTable;

/**
 * Created by jessiemila on 5/18/18.
 */

public class databaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "profile.db";

    public  databaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + RideTable.NAME + "(" +
        RideTable.Cols.EMAIL + ", " +
        RideTable.Cols.DESTINATION + ", " +
        RideTable.Cols.LOCATION + ", " +
        RideTable.Cols.DATE + ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
