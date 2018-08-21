package com.example.ivanpillay.atlas;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AboutDialogFragment extends DialogFragment {

    public static final String TAG = "atlas.about";

    public AboutDialogFragment(){

    }

    public static AboutDialogFragment newInstance() {
        AboutDialogFragment f = new AboutDialogFragment();
        return f;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.about, null)).setNeutralButton("Ok",new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                AboutDialogFragment.this.dismiss();
            }
        });
        return builder.create();
    }
}
