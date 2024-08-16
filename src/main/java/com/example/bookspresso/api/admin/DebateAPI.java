package com.example.bookspresso.api.admin;

import com.example.bookspresso.service.admin.ManageDebateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DebateAPI {

    private final ManageDebateService manageDebateService;

    @PostMapping("/debate/drop/{debateId}")
    public void dropDebate(@PathVariable("debateId") Long debateId) {
        manageDebateService.dropDebate(debateId);
    }
}
