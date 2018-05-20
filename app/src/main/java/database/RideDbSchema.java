package database;

/**
 * Created by jessiemila on 5/18/18.
 */

public class RideDbSchema {
    public static final class RideTable {
        public static final String NAME = "rides";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String EMAIL = "email";
            public static final String DESTINATION = "destination";
            public static final String LOCATION = "location";
            public static final String DATE = "date";
        }
    }

}
