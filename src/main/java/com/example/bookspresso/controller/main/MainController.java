package com.example.bookspresso.controller.main;

import com.example.bookspresso.dto.api.aladin.Aladinitem;
import com.example.bookspresso.service.api.aladen.AladinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final AladinService aladinService;
    @GetMapping("/")
    public String mainpage(Model model)throws Exception{
//        List<Aladinitem> aladin = aladinService.getApialadin();
//        model.addAttribute("aladin", aladin);


        return "mainpage/mainpage";
    }
}
