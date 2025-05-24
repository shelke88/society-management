/**

package com.ss.societymanagment.config;

import com.ss.societymanagment.model.SecurityGuard;
import com.ss.societymanagment.services.SecurityGuardServices;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final SecurityGuardServices securityGuardServices;

    public BatchConfig(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, SecurityGuardServices securityGuardServices) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.securityGuardServices = securityGuardServices;
    }

    @Bean
    public ItemReader<SecurityGuard> securityGuardReader() {
        return new ItemReader<>() {
            private final List<SecurityGuard> guards = List.of(
                    new SecurityGuard(0, "John Doe", "+1-234-567-8900", "123 Main St, City, State", "Morning", "Block A", "Active", "2023-01-01", "5000", "photo_url_1"),
                    new SecurityGuard(0, "Jane Smith", "+1-987-654-3210", "456 Elm St, City, State", "Evening", "Block B", "Inactive", "2023-02-01", "4500", "photo_url_2"),
                    new SecurityGuard(0, "Mike Johnson", "+1-555-555-5555", "789 Oak St, City, State", "Night", "Block C", "Active", "2023-03-01", "4800", "photo_url_3"),
                    new SecurityGuard(0, "Alice Brown", "+1-111-222-3333", "101 Maple St, City, State", "Evening", "Block D", "Inactive", "2023-04-01", "4000", "photo_url_4"),
                    new SecurityGuard(0, "Bob White", "+1-444-555-6666", "202 Pine St, City, State", "Night", "Block E", "Inactive", "2023-05-01", "4200", "photo_url_5")
            );
            private int index = 0;

            @Override
            public SecurityGuard read() {
                if (index < guards.size()) {
                    return guards.get(index++);
                }
                return null; // End of data
            }
        };
    }
}
*/
