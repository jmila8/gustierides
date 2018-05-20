package edu.gac.jmila.gustierides;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import java.util.List;

/**
 * Created by jessiemila on 5/18/18.
 */

public class rideListFragment extends Fragment {

    private RecyclerView mRideRecycleView;
    private RideAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle onSavedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ride_list, container, false);

        mRideRecycleView = (RecyclerView) view.findViewById(R.id.ride_recycler_view);
        mRideRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_ride_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.new_ride:
                Ride ride = new Ride();
                ridePosts.get(getActivity()).addRide(ride);
                Intent intent = RidePagerActivity.newIntent(getActivity(), ride.getId());
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateUI() {
        ridePosts ridePosts = edu.gac.jmila.gustierides.ridePosts.get(getActivity());
        List<Ride> rides = ridePosts.getRides();

        if (mAdapter == null) {
            mAdapter = new RideAdapter(rides);
            mRideRecycleView.setAdapter(mAdapter);
        } else {
            mAdapter.setRides(rides);
            mAdapter.notifyDataSetChanged();
        }
    }



    private class RideHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Ride mRide;

        private TextView mEmailTextView;
        private TextView mDateTextView;
        private TextView mDestinationTextView;
        private TextView mLocationTextView;

        public RideHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_ride, parent, false));
            itemView.setOnClickListener(this);

            mEmailTextView = (TextView) itemView.findViewById(R.id.ride_email);
            mDateTextView = (TextView) itemView.findViewById(R.id.ride_date);
            mDestinationTextView = (TextView) itemView.findViewById(R.id.ride_destination);
            mLocationTextView = (TextView) itemView.findViewById(R.id.ride_location);
        }

        public void bind(Ride ride) {
            mRide = ride;
            mEmailTextView.setText(mRide.getEmail());
            mDateTextView.setText(mRide.getDate());
            mDestinationTextView.setText(mRide.getDestination());
            mLocationTextView.setText(mRide.getLocation());
        }

        @Override
        public void onClick(View view) {
            Intent intent = RidePagerActivity.newIntent(getActivity(), mRide.getId());
            startActivity(intent);
        }

    }

    private class RideAdapter extends RecyclerView.Adapter<RideHolder> {

        private List<Ride> mRides;

        public RideAdapter(List<Ride> rides) {mRides = rides;}

        @Override
        public RideHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new RideHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(RideHolder holder, int position) {
            Ride ride = mRides.get(position);
            holder.bind(ride);
        }

        @Override
        public int getItemCount() {return mRides.size();}

        public void setRides(List<Ride> rides) {mRides = rides;}
    }

}
