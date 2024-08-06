package com.example.bookspresso.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/qa")
public class QandAController {

    @GetMapping("/question")
    public String question(){
        return "admin/qa/question";
    }

    @GetMapping("/popup")
    public String popup(){
        return "admin/qa/toAnswer";
    }

}
