package com.example.bookspresso.api.Lib;


import com.example.bookspresso.batch.Lib.LibRegisterJobConfig;
import com.example.bookspresso.dto.api.Lib.LibApiBody;
import com.example.bookspresso.dto.api.Lib.LibApiLib;
import com.example.bookspresso.dto.api.Lib.LibApiLibs;
import com.example.bookspresso.service.api.Lib.LibService;
import com.example.bookspresso.service.api.aladen.AladinService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LibApi {
    private final AladinService aladinService;
    private final JobLauncher jobLauncher;
    private final LibService libService;
    private final LibRegisterJobConfig libRegisterJobConfig;

    @GetMapping("/LibBatch")
    public void LibBetch() {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time",System.currentTimeMillis())
                .toJobParameters();
        try {
            jobLauncher.run(libRegisterJobConfig.libApiJob(),jobParameters);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @GetMapping("/Lib")
    public LibApiLib Lib() {
        List<LibApiLibs> lib = libService.getLib();
        return lib.getLast().getLib();
    }
}















