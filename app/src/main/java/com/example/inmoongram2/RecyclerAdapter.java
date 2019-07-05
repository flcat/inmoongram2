package com.example.inmoongram2;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<Contact> contacts;
    private Context context;

    public RecyclerAdapter (List<Contact> contacts,Context context) {

        this.contacts = contacts;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.userName.setText(contacts.get(position).getUserName());
        holder.Contents.setText(contacts.get(position).getContents());
        Glide.with(context).load(contacts.get(position).getmUri()).into(holder.contentImage);

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView userName,Contents;
        ImageView contentImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = (TextView)itemView.findViewById(R.id.username_item);
            Contents = (TextView)itemView.findViewById(R.id.contents_item);
            contentImage = (ImageView)itemView.findViewById(R.id.content_photo_item);
        }
    }
}
