package com.nkufall2021.jobspage;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private final LinkedList<String> jobList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private JobListAdapter mJobListAdapter;
    private JobListAdapter.RecyclerViewClickListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Put initial data into the word list.
        for (int i = 0; i < 2; i++) {
            jobList.addLast("Word " + i);
        }
        setAdapter();
    }

    private void setAdapter() {
        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.jobListRecyclerView);
        // Create an adapter and supply the data to be displayed.
        mJobListAdapter = new JobListAdapter(this, jobList, listener);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mJobListAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        setOnClickListener();
    }

    private void setOnClickListener() {
        listener = new JobListAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), JobActivity.class);
                intent.putExtra("position", jobList.get(position));
                startActivity(intent);
            }
        };
    }
}