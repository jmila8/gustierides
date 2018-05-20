package edu.gac.jmila.gustierides;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.UUID;

/**
 * Created by jessiemila on 5/18/18.
 */

public class RideFragment extends Fragment {

    private static final String ARG_RIDE_ID = "ride_id";

    private Ride mRide;
    private EditText mEmail;
    private EditText mDate;
    private EditText mDestination;
    private EditText mLocation;

    public static RideFragment newInstance(UUID rideId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_RIDE_ID, rideId);

        RideFragment fragment = new RideFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        UUID rideId = (UUID) getArguments().getSerializable(ARG_RIDE_ID);
        mRide = ridePosts.get(getActivity()).getRide(rideId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.ride_post_fragment_activity, container, false);

        mEmail = (EditText) v.findViewById(R.id.ride_email);
        mEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mRide.setEmail(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mDate = (EditText) v.findViewById(R.id.ride_date);
        mDate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mRide.setDate(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mLocation = (EditText) v.findViewById(R.id.ride_location);
        mLocation.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mRide.setLocation(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mDestination = (EditText) v.findViewById(R.id.ride_destination);
        mDestination.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mRide.setDestination(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return v;
    }

    @Override
    public void onPause() {
        super.onPause();

        ridePosts.get(getActivity())
                .updateRide(mRide);
    }



}
