package com.example.aditishevale999.simpleretr;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    List<Contact> mContact;

    public RecyclerAdapter(List<Contact> mContact) {
        this.mContact = mContact;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_item, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Contact contact= mContact.get(i);
        myViewHolder.txt.setText(contact.getEmail());
        myViewHolder.txt2.setText(contact.getUsername());

    }

    @Override
    public int getItemCount() {
        return mContact.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView txt,txt2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txt=itemView.findViewById(R.id.textView);
            txt2=itemView.findViewById(R.id.textView2);
        }
    }
}
