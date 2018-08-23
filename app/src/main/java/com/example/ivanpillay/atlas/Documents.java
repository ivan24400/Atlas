package com.example.ivanpillay.atlas;

import com.example.ivanpillay.atlas.model.CounterViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class Documents extends Fragment {

    private TextView tv;
    private int count = 0;
    private Button btn;

    private CounterViewModel viewmodel;

    public Documents() {
        // Required empty public constructor
    }

    public static Documents newInstance() {
        Documents fragment = new Documents();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("Documents","on create");

        viewmodel = ViewModelProviders.of(getActivity()).get(CounterViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.documents, container, false);
        Log.e("Documents","on create view");
       return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e("Documents","on activity created");
        tv = getActivity().findViewById(R.id.doc_text);
        btn = getActivity().findViewById(R.id.doc_btn_add);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                viewmodel.setCount(viewmodel.getCount()+1);
                tv.setText(Integer.toString(viewmodel.getCount()));
            }
        });
    }

}
