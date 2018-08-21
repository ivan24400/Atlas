package com.example.ivanpillay.atlas;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ivanpillay.atlas.model.Student;

import java.util.ArrayList;

public class StudentListActivity extends ListActivity {

    public static final String STUDENT_ID = "com.example.ip.atlas.sid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View emptyView = layoutInflater.inflate(R.layout.student_list_empty, null);
        ((ViewGroup) getListView().getParent()).addView(emptyView);
        getListView().setEmptyView(emptyView);

        StudentListAdapter adapter = new StudentListAdapter(this,getStudentData());
        setListAdapter(adapter);
    }

    public ArrayList<Student> getStudentData() {
        ArrayList<Student> studentData = new ArrayList<Student>();
        studentData.add(new Student(1,"Black sheep","2",""));
        studentData.add(new Student(2,"green parrot","3",""));
        studentData.add(new Student(3,"brown eagle","4",""));
        return studentData;
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Student student = (Student)l.getItemAtPosition(position);
        Intent intent = new Intent(StudentListActivity.this,StudentProfileActivity.class);
        intent.putExtra(STUDENT_ID,student.getId());
        startActivity(intent);
    }

    public class StudentListAdapter extends ArrayAdapter<Student> {

        private final Context context;
        private final ArrayList<Student> listItems;

        public StudentListAdapter(Context context, ArrayList<Student> list){
            super(context,R.layout.student_list_item,list);
            this.context = context;
            this.listItems = list;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            View row = convertView;

            if(row == null){
                LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.student_list_item,parent,false);
            }

            Student student = listItems.get(position);
            ImageView img = row.findViewById(R.id.st_li_img);
            TextView name = row.findViewById(R.id.st_li_name);
            TextView roll = row.findViewById(R.id.st_li_roll);

            Log.e("StudentsListAdapter",student.toString()+"\n"+name+"\n"+roll);

            name.setText(student.getName());
            img.setImageResource(R.mipmap.ic_student_profile);
            roll.setText("ID: "+student.getRoll());

            return row;
        }

    }

}
