package com.example.bookspresso.api.admin;

import com.example.bookspresso.service.admin.ManageDebateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
public class DebateAPI {

    private final ManageDebateService manageDebateService;

    @PostMapping("/admin/debate/drop/{dropDebateLists}")
    public void dropDebate(@PathVariable("dropDebateLists") ArrayList<Long> dropDebateLists) {

        for(Long debateId : dropDebateLists){
            manageDebateService.dropDebate(debateId);
        }

    }
}
