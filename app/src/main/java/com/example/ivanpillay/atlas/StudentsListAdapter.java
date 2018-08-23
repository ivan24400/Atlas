package com.example.ivanpillay.atlas;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ivanpillay.atlas.model.Student;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class StudentsListAdapter extends RecyclerView.Adapter<StudentsListAdapter.ViewHolder> {

    private List<Student> listItems;
    private Context context;
    private MyRecyclerView recyclerView;

    public StudentsListAdapter(Context context, MyRecyclerView rview, List<Student> list){
        this.context = context;
        this.listItems = list;
        this.recyclerView = rview;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.student_list_item,viewGroup,false);
        v.setOnClickListener(new OnItemClickListener(context));
        return (new ViewHolder(v));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.name.setText(listItems.get(i).getName());
        viewHolder.roll.setText("Roll No: "+listItems.get(i).getRoll());
        viewHolder.img.setImageResource(R.mipmap.ic_student_profile);

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(listItems.get(i).getPicUrl())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(viewHolder.img);
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public void insert(int position, Student student){
        listItems.add(position,student);
        notifyItemChanged(position);
    }

    public void  insert(Student student){
        listItems.add(student);
        notifyDataSetChanged();
    }

    public void remove(Student student){
        int position = listItems.indexOf(student);
        listItems.remove(position);
        notifyItemChanged(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView name,roll;
        public ImageView img;
        public CardView mainView;

        public ViewHolder(View v) {
            super(v);
            mainView = v.findViewById(R.id.st_li_view);
            name = v.findViewById(R.id.st_li_name);
            roll = v.findViewById(R.id.st_li_roll);
            img = v.findViewById(R.id.st_li_img);
        }
    }

    /**
     * On click listener for each list item
     */
    class OnItemClickListener implements View.OnClickListener{

        Context context;

        public OnItemClickListener(Context c){
            context = c;
        }

        @Override
        public void onClick(View v) {
            if(recyclerView != null) {
                int itemPosition = recyclerView.getChildLayoutPosition(v);
                Student item = listItems.get(itemPosition);
                Intent intent = new Intent(context, StudentProfile.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(StudentsList.STUDENT_ID, item.getId());
                context.startActivity(intent);
            }else{
                Log.e("StudentsListAdpater","recycler view is empty");
            }
        }
    }
}
