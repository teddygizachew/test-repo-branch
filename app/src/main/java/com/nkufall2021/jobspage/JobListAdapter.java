package com.nkufall2021.jobspage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class JobListAdapter extends RecyclerView.Adapter<JobListAdapter.JobViewHolder> {

    private final LinkedList<String> jobList;
    private final LayoutInflater layoutInflater;
    private final RecyclerViewClickListener listener;

    public JobListAdapter(Context context,
                          LinkedList<String> wordList,
                          RecyclerViewClickListener listener) {
        layoutInflater = LayoutInflater.from(context);
        this.jobList = wordList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public JobListAdapter.JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = layoutInflater.inflate(R.layout.joblist_item,
                parent, false);
        return new JobViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull JobListAdapter.JobViewHolder holder, int position) {
        String mCurrent = jobList.get(position);
        holder.jobItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return jobList.size();
    }

    public class JobViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView jobItemView;
        final JobListAdapter mAdapter;


        public JobViewHolder(View itemView, JobListAdapter adapter) {
            super(itemView);
            jobItemView = itemView.findViewById(R.id.word);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }
}
