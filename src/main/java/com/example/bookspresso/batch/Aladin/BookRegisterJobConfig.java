package com.example.bookspresso.batch.Aladin;


import com.example.bookspresso.api.Aladen.Aladinitem;
import com.example.bookspresso.mapper.api.aladin.AladinMapper;
import com.example.bookspresso.service.aladen.AladinService;
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
public class BookRegisterJobConfig {
    //    JobRepository는 Spring Batch의 핵심 객체이다.
    //    배치 작업의 실행 상태, 진행 상황, 이력 등을 저장하고 관리한다.
    //    JobRepository는 DB에 배치작업에 관련된 여러 데이터를 저장한다.
    private final JobRepository jobRepository;
    //    스프링에서 트랜잭션을 관리하는 인터페이스
    //    배치작업에서 트랜잭션을 관리해야하므로 이 객체의 도움을 받는다.
    private final PlatformTransactionManager transactionManager;

    private final AladinMapper aladinMapper;
    private final AladinService aladinService;

    @Bean
    public ItemReader<Aladinitem> apiItemReader(){
//        api에서 뭉탱이로 가져와서 하나씩 아래로 넘겨준다
        return new AladinItemReader(aladinService);
    }
    @Bean
    public ItemProcessor<Aladinitem, Aladinitem> apiProcessor(){
//        3.하나씩 뽑아온 데이터를 ItemProcessor<들어와서, 변환후 반환> 여기서 타입변환? 등등을 진행후 아래로넘김
//        3.5 chunk단위로 묶음처리한다
//        여기서는 큰의미는없지만 필요한 순서
        return new AladinitemProcessor(aladinMapper);
//        return item->item;
    }
    @Bean
    public ItemWriter<Aladinitem> apiWriter(){
//        4.하나씩 들어온데이터를 실질적으로 mapper를 통해서 insert 한다
//        return items->items.forEach(bookMapper::insertBook);
        return items ->{
            for (Aladinitem item:items){
                aladinMapper.insertBook(item);
            }
        };
    }
    @Bean//위에서 만든것들을 chunk 설정 단위로 실행
    public Step apiStep(){
        return new StepBuilder("apiStep",jobRepository)
                .<Aladinitem,Aladinitem>chunk(10,transactionManager)
                .reader(apiItemReader())
                .processor(apiProcessor())
                .writer(apiWriter())
                .build();
    }
    @Bean
    public Job apiJob(){
        return new JobBuilder("apiJob",jobRepository)
                .start(apiStep())
                .preventRestart()//배치 작업이 실패했을 때 재시작하지 못하도록 설정
                .build();
    }
}
