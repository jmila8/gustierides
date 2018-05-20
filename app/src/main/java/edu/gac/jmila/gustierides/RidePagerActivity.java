package edu.gac.jmila.gustierides;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.UUID;

/**
 * Created by jessiemila on 5/18/18.
 */

public class RidePagerActivity  extends  AppCompatActivity {

    private static final String EXTRA_RIDE_ID = "edu.gac.jmila.gustierides.ride_id";

    private ViewPager mViewPager;
    private List<Ride> mRides;

    public static Intent newIntent(Context packageContext, UUID rideId) {
        Intent intent = new Intent(packageContext, RidePagerActivity.class);
        intent.putExtra(EXTRA_RIDE_ID, rideId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_pager);

        UUID crimeId = (UUID) getIntent()
                .getSerializableExtra(EXTRA_RIDE_ID);

        mViewPager = (ViewPager) findViewById(R.id.ride_view_pager);

        mRides = ridePosts.get(this).getRides();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {

            @Override
            public Fragment getItem(int position) {
                Ride ride = mRides.get(position);
                return RideFragment.newInstance(ride.getId());
            }

            @Override
            public int getCount() {
                return mRides.size();
            }
        });

        for (int i = 0; i < mRides.size(); i++) {
            if (mRides.get(i).getId().equals(crimeId)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }


}
