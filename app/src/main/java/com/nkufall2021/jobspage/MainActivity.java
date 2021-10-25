package com.nkufall2021.jobspage;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private final LinkedList<Job> jobs = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private JobListAdapter mJobListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 10; i++) {
            jobs.addLast(new Job(1, "Student Union Delivery", "Description"));
        }

        setAdapter();
    }

    private void setAdapter() {
        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.jobListRecyclerView);
        // Create an adapter and supply the data to be displayed.
        mJobListAdapter = new JobListAdapter(this, jobs);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mJobListAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}