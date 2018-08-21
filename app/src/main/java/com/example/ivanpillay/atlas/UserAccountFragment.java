package com.example.ivanpillay.atlas;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class UserAccountFragment extends Fragment {

    public static UserAccountFragment newInstance() {
        UserAccountFragment f = new UserAccountFragment();
        return f;
    }

    public UserAccountFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.user_account, container, false);
    }

}
