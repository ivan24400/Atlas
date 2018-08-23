package com.example.ivanpillay.atlas;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class UserAccount extends Fragment {

    public static UserAccount newInstance() {
        UserAccount f = new UserAccount();
        return f;
    }

    public UserAccount(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.user_account, container, false);
    }

}
