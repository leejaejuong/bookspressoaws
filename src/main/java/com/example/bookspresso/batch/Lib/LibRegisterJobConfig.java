package com.example.bookspresso.batch.Lib;

import com.example.bookspresso.dto.api.Lib.Libitem;
import com.example.bookspresso.dto.api.Lib.Libitems;
import com.example.bookspresso.mapper.api.Lib.LibMapper;
import com.example.bookspresso.service.api.Lib.LibService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class LibRegisterJobConfig {
    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;
    private final LibMapper libMapper;
    private final LibService libService;

    @Bean
    public ItemReader<Libitems> apiItemReader1() {
        return new LibItemReader(libService);
    }
    @Bean
    public ItemProcessor<Libitems, Libitems> apiItemProcessor1() {
        return item -> item;
    }
    @Bean
    public ItemWriter<Libitems> apiWriter1() {
        return items ->{
            for(Libitems item : items) {
                libMapper.insertLib(item);
            }
        };
    }
    @Bean
    public Step apiStep1(){
        return new StepBuilder("apiStep",jobRepository)
                .<Libitems,Libitems>chunk(10,transactionManager)
                .reader(apiItemReader1())
                .processor(apiItemProcessor1())
                .writer(apiWriter1())
                .build();
    }
    @Bean
    public Job apiJob1(){
        return new JobBuilder("apiJob",jobRepository)
                .start(apiStep1())
                .preventRestart()
                .build();
    }







}
