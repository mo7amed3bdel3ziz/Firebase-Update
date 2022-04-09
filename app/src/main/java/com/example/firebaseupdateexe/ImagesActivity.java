package com.example.firebaseupdateexe;

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

import java.util.ArrayList;
import java.util.List;

public class ImagesActivity extends AppCompatActivity   {
    private RecyclerView recyclerView;
    private ImageAdapter mAdapter;
    private DatabaseReference mDatabaseRef;
    private List<Upload> muploads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);
        recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        muploads = new ArrayList<>();
        recyclerView.setAdapter(mAdapter);
       // mAdapter.setItemOnClickListener(ImagesActivity.this);
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("uploads");
        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Upload upload = dataSnapshot.getValue(Upload.class);
                    muploads.add(upload);
                }
                mAdapter = new ImageAdapter(ImagesActivity.this, muploads);
                recyclerView.setAdapter(mAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ImagesActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
/*
    @Override
    public void OnItemClick(int position) {
        Toast.makeText(ImagesActivity.this, "Normal click at position : " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnWhatEverClick(int position) {
        Toast.makeText(ImagesActivity.this, "Whatever click at position : " + position, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void OnDeleteClick(int position) {
        Toast.makeText(ImagesActivity.this, "Delete click at position : " + position, Toast.LENGTH_SHORT).show();

    }*/
}