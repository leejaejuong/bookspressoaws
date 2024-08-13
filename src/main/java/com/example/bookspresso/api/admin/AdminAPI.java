package com.example.bookspresso.api.admin;

import com.example.bookspresso.service.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdminAPI {

    private final AdminService adminService;

    @PostMapping("/login/findAdminId/{loginId}/{password}")
    public boolean login(@PathVariable String loginId, @PathVariable String password) {
        try {
            adminService.findAdminId(loginId, password);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
