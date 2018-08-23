package com.example.ivanpillay.atlas.model;


import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class CounterViewModel extends ViewModel {

    private MutableLiveData<Integer> count = new MutableLiveData<>();

    public int getCount(){return count.getValue();}

    public void setCount(int c){count.setValue(c);}

}