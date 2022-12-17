package com.example.practical52;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OSModelAdapter extends RecyclerView.Adapter<OSModelAdapter.ViewHolder> {

    private final Context context;
    private final ArrayList<OSModel> osList;

    public OSModelAdapter(Context context, ArrayList<OSModel> osList) {
        this.context = context;
        this.osList = osList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //generate the layout form view
        View v = LayoutInflater.from(this.context).inflate(R.layout.os_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.os_name.setText(osList.get(position).osName);
        holder.os_description.setText(osList.get(position).osDescription);
        holder.os_image.setImageResource(osList.get(position).image_id);

//        setAnimation(holder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return osList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView os_description, os_name;
        ImageView os_image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            os_name = itemView.findViewById(R.id.os_name);
            os_description = itemView.findViewById(R.id.os_description);
            os_image = itemView.findViewById(R.id.os_image);
        }

    }

    private void setAnimation(View view, int position) {
        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        view.startAnimation(animation);
    }
}
