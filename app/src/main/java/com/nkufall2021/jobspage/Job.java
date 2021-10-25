package com.nkufall2021.jobspage;

public class Job {

    int jobId;

    String title;
    String job_description;
    String job_type;
    String job_post_date;
    String

    public Job() {

    }

    public Job(int jobId, String title, String description) {
        this.jobId = jobId;
        this.title = title;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public int getJobId() {
        return jobId;
    }

}
