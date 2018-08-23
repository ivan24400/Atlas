package com.example.ivanpillay.atlas;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;

public class AboutDialog extends DialogFragment {

    public static final String TAG = "atlas.about";

    public AboutDialog(){

    }

    public static AboutDialog newInstance() {
        AboutDialog f = new AboutDialog();
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
                AboutDialog.this.dismiss();
            }
        });
        return builder.create();
    }
}
