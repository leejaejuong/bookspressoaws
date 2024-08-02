package com.example.bookspresso.controller.debate;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/debate")
public class DebateController {
    @GetMapping("/")
    public String debate() {
        return "debate/debateboard/debatemain";
    }
    @GetMapping("/make")
    public String make() {
        return "debate/debateinpo/debatemake";
    }
    @PostMapping("/make")
    public String makePost() {
        return "debate/debateinpo/debatetype";
    }
    @GetMapping("/type")
    public String type() {
        return "debate/debateinpo/debatetype";
    }
    @PostMapping("/type")
    public String typePost() {
        return "debate/debateinpo/debateoutline";
    }
    @GetMapping("/inpo")
    public String inpo() {
        return "debate/debateinpo/debateoutline";
    }
    @PostMapping("/inpo")
    public String inpoPost() {
        return "debate/debateboard/debateboard";
    }
    @GetMapping("/board")
    public String debateboard() {
        return "debate/debateboard/debateboard";
    }
    @GetMapping("/write")
    public String debatewrite() {
        return "debate/debateboard/debatewrite";
    }
}
