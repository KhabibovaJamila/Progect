package com.example.mysmartlab.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mysmartlab.DataClass.ImageAnalyzes;
import com.example.mysmartlab.R;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.CourseHolder>{

    Context context;
    List<ImageAnalyzes> courses;

    public ImageAdapter(Context context, List<ImageAnalyzes> courses) {
        this.context = context;
        this.courses = courses;
    }


    @NonNull
    @Override
    public ImageAdapter.CourseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v ;
        LayoutInflater inflater = LayoutInflater.from(context);
        v = inflater.inflate(R.layout.image_item,parent,false) ;
        return new CourseHolder (v) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.CourseHolder holder, int position) {
        holder.text2.setText(courses.get(position).getDescription());
        holder.text3.setText(courses.get(position).getPrice());



        Glide.with( context)
                .load(courses.get(position).getImage())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public static final  class CourseHolder extends RecyclerView.ViewHolder {
        TextView text,text2,text3;
        ImageView image ;
        public CourseHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.textView5) ;
            text2 = itemView.findViewById(R.id.textView11) ;
            text3 = itemView.findViewById(R.id.textView12) ;
            image = itemView.findViewById(R.id.imageView6) ;
        }
    }
}
