package com.example.ivanpillay.atlas;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class UserHomeFragment extends Fragment {

    private TextView welcome;

    public UserHomeFragment() {
        // Required empty public constructor
    }

    public static UserHomeFragment newInstance() {
        UserHomeFragment f = new UserHomeFragment();
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.user_content, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        welcome = getActivity().findViewById(R.id.u_tv_welcome);
        welcome.setText(getResources().getString(R.string.u_welcome,"ivan"));

    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
