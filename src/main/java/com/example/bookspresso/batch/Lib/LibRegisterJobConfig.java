package com.example.bookspresso.batch.Lib;

import com.example.bookspresso.dto.api.Lib.LibApiLib;
import com.example.bookspresso.dto.api.Lib.LibApiLibs;
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
    public ItemReader<LibApiLib> libApiItemReader() {
        return new LibItemReader(libService);
    }
    @Bean
    public ItemProcessor<LibApiLib, LibApiLib> libApiItemProcessor() {
        return new LibItemProcessor(libMapper);
    }

    @Bean
    public ItemWriter<LibApiLib> libApiWriter() {
        return items ->{
            for(LibApiLib item : items) {
                log.info("Register lib: {}", item);
                libMapper.insertLib(item);
            }
        };
    }
    @Bean
    public Step libApiStep(){
        return new StepBuilder("libApiStep",jobRepository)
                .<LibApiLib, LibApiLib>chunk(10,transactionManager)
                .reader(libApiItemReader())
                .processor(libApiItemProcessor())
                .writer(libApiWriter())
                .build();
    }
    @Bean
    public Job libApiJob(){
        return new JobBuilder("libApiJob",jobRepository)
                .start(libApiStep())
                .preventRestart()
                .build();
    }
}
