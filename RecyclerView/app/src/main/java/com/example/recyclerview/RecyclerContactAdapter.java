package com.example.recyclerview;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// To make this class like adapter we have to extend it
public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {

    private final Context context;
    private final ArrayList<ContactModel> arrContacts;

    public RecyclerContactAdapter(Context context, ArrayList<ContactModel> arrContacts) {
        this.arrContacts = arrContacts;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // generate the layout from view
        View v = LayoutInflater.from(this.context).inflate(R.layout.contact_row, parent, false);
        return new ViewHolder(v);
    }

    // to set the data on view
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgContact.setImageResource(arrContacts.get(position).img);
        holder.txtContactName.setText(arrContacts.get(position).contactName);
        holder.txtContactNumber.setText(arrContacts.get(position).contactNumber);

        setAnimation(holder.itemView, position);

        holder.llrow.setOnClickListener(view -> {

            Dialog dialog = new Dialog(context);
            dialog.setContentView(R.layout.add_update_layout);

            EditText edtContactName = dialog.findViewById(R.id.edtContactName);
            EditText edtContactNumber = dialog.findViewById(R.id.edtContactNumber);
            Button btnSubmit = dialog.findViewById(R.id.submit_button);
            btnSubmit.setText("Update");

            edtContactName.setText(arrContacts.get(position).contactName);
            edtContactNumber.setText(arrContacts.get(position).contactNumber);

            btnSubmit.setOnClickListener(view1 -> {
                String contactName = "";
                String contactNumber = "";

                if (!edtContactName.getText().toString().equals("") && !edtContactNumber.getText().toString().equals("")) {
                    contactName = edtContactName.getText().toString();
                    contactNumber = edtContactNumber.getText().toString();

                    arrContacts.set(position, new ContactModel(R.drawable.a, contactName, contactNumber));
                    notifyItemChanged(position);
                    dialog.dismiss();
                } else {
                    Toast.makeText(context, "Please enter valid details", Toast.LENGTH_LONG).show();
                }

            });

            dialog.show();
        });

        holder.llrow.setOnLongClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(context)
                    .setTitle("Delete Contact")
                    .setMessage("You want to delete?")
                    .setIcon(R.drawable.ic_launcher_background)
                    .setPositiveButton("yes", (dialogInterface, i) -> {
                        arrContacts.remove(position);
                        notifyItemRemoved(position);
                    }).setNegativeButton("no", (dialogInterface, i) -> {

                    });

            builder.show();
            return true;
        });
    }

    // which is last element to find out when to stop scrolling.
    @Override
    public int getItemCount() {
        return arrContacts.size();
    }

    // to make this class viewHolder we have to extend it
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtContactName, txtContactNumber;
        ImageView imgContact;
        LinearLayout llrow;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgContact = itemView.findViewById(R.id.imgContact);
            txtContactName = itemView.findViewById(R.id.contactName);
            txtContactNumber = itemView.findViewById(R.id.contactNumber);
            llrow = itemView.findViewById(R.id.llrow);
        }
    }

    private void setAnimation(View view, int position) {
        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        view.startAnimation(animation);
    }
}
