package edu.gac.jmila.gustierides;

import android.support.v4.app.Fragment;
/**
 * Created by jessiemila on 5/18/18.
 */

public class rideListActivity extends ridePostActivity {

    @Override
    protected Fragment createFragment() {return new rideListFragment();}
}
