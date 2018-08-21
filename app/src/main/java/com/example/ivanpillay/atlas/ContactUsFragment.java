package com.example.ivanpillay.atlas;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ContactUsFragment extends Fragment {

    public ContactUsFragment(){

    }

    public static ContactUsFragment newInstance() {
        ContactUsFragment f = new ContactUsFragment();
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.contact_us, container, false);
    }

}
