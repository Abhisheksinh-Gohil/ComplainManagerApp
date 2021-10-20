package com.example.complainmanagerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.complain>{

    String data[][];

    public RecyclerViewAdapter(String[][] data) {
        this.data = data;
    }

    @NonNull
    @Override
    public complain onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.complain_card_view,parent,false);
        return new complain(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.complain holder, int position) {
        holder.personName.setText(data[position][0]);
        holder.dateOfComplain.setText(data[position][1]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class complain extends RecyclerView.ViewHolder{

        TextView personName, dateOfComplain;

        public complain(@NonNull View itemView) {
            super(itemView);
            personName = itemView.findViewById(R.id.personName);
            dateOfComplain = itemView.findViewById(R.id.dateOfComplain);
        }
    }

}
