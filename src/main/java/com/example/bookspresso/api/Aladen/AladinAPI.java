package com.example.bookspresso.api.Aladen;

import com.example.bookspresso.service.aladen.AladenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AladinAPI {
    private final AladenService aladenService;
    @GetMapping("/aladen")
    public String aladen() {
        aladenService.getApialadin();
        return "aladen";
    }
}
