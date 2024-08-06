package com.example.bookspresso.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/staff")
public class AdminCotroller {

    @GetMapping("/list")
    public String staffList(){
        return "admin/admin/staffList";
    }


}
