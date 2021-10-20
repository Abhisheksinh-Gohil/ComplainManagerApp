package com.example.complainmanagerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ComplainList extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain_list);

        recyclerView = findViewById(R.id.complainList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseDatabase fireBaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference dbRef = fireBaseDatabase.getReference();


        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Information info = snapshot.getValue(Information.class);
                String name = info.name;
                Toast.makeText(getApplicationContext(), "DONEEEE", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ComplainList.this, "Error while fetching data!", Toast.LENGTH_SHORT).show();
            }
        });

        String[][] complains = new String[][]{
                {"Minato","1/2/2001"},
                {"XYZ","2/2/2001"},
                {"ABC","1/2/2001"},
                {"XYZ","2/2/2001"},
                {"ABC","1/2/2001"},
                {"XYZ","2/2/2001"},
                {"Abhi","1/2/2001"},
                {"XYZ","2/2/2001"},
                {"Abhi","1/2/2001"},
                {"XYZ","2/2/2001"},
                {"Abhi","1/2/2001"},
                {"XYZ","2/2/2001"},
        };

        recyclerView.setAdapter(new RecyclerViewAdapter(complains));
    }
}