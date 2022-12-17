package com.example.fetchapidata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder> {

    Context context;
    List<Item> recyclerList;

    public RecyclerAdapter(Context context, List<Item> recyclerList) {
        this.context = context;
        this.recyclerList = recyclerList;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.movie_card, parent, false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {

        Item item = recyclerList.get(position);
        holder.setImage(item.getImgUrl());

    }

    @Override
    public int getItemCount() {
        return recyclerList.size();
    }

    public class RecyclerHolder extends RecyclerView.ViewHolder {

        ShapeableImageView image;
        View view;

        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }

        public void setImage(String url) {
            image = view.findViewById(R.id.movie_card_image);
            Glide.with(context).load(url).into(image);
        }
    }
}
