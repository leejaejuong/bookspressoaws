package com.example.bookspresso.controller.main;

import com.example.bookspresso.api.Aladen.Aladinitem;
import com.example.bookspresso.service.aladen.AladenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final AladenService aladenService;
    @GetMapping("/")
    public String mainpage(Model model)throws Exception{
        List<Aladinitem> aladin = aladenService.getApialadin();
        model.addAttribute("aladin", aladin);


        return "mainpage/mainpage";
    }
}
