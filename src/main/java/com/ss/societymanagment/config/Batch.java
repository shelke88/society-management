/*
package com.ss.societymanagment.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BatchJobRunner implements CommandLineRunner {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job securityGuardJob;

    @Override
    public void run(String... args) throws Exception {
        jobLauncher.run(securityGuardJob, new org.springframework.batch.core.JobParameters());
    }
}*/
