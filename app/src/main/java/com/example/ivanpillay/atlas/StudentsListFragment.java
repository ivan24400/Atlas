package com.example.ivanpillay.atlas;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ivanpillay.atlas.model.Student;
import com.example.ivanpillay.atlas.model.StudentsData;
import com.example.ivanpillay.atlas.network.RetrofitStudentsData;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentsListFragment extends Fragment {

    public static final String STUDENT_ID = "com.example.ip.atlas.sid";
    private MyRecyclerView recyclerView;
    private ProgressBar progressBar;


    public StudentsListFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.students_list, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = getActivity().findViewById(R.id.s_recycler_view);
        progressBar = getActivity().findViewById(R.id.progressBar_cyclic);
        progressBar.setVisibility(View.VISIBLE);

        StudentsData data = RetrofitStudentsData.getRetrofitInstance().create(StudentsData.class);
        Call<List<Student>> call = data.getData();
        call.enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                progressBar.setVisibility(View.INVISIBLE);
                Log.e("retrofit", response.body().toString());
                generateStudentsDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(getContext(),"Unable to load data !",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateStudentsDataList(List<Student> list){
        StudentsListAdapter adapter = new StudentsListAdapter(getActivity(), recyclerView, list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setEmptyView(getActivity().findViewById(R.id.st_empty_view));
    }

    public List<Student> getStudentsData() {
        ArrayList<Student> studentData = new ArrayList<Student>();
        studentData.add(new Student(1,"Black sheep","2",""));
        studentData.add(new Student(2,"green parrot","3",""));
        studentData.add(new Student(3,"brown eagle","4",""));
        return studentData;
    }
}
