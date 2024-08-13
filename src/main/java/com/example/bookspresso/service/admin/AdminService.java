package com.example.bookspresso.service.admin;

import com.example.bookspresso.mapper.admin.AdminMainMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminService {
    private final AdminMainMapper adminMainMapper;

    public Long findAdminId(String adminLoginId, String amdinPassword){
        return adminMainMapper.selectAdmin(adminLoginId, amdinPassword)
                .orElseThrow(()->new IllegalArgumentException("아이디/비번이 일치하지 않습니다."));
    }

    public int findAdminCount(String adminLoginId, String amdinPassword){
        return adminMainMapper.selectAdminCount(adminLoginId, amdinPassword);
    }

    public String findAdminLoginId(Long adminId){
        return adminMainMapper.selectAdminLoginId(adminId);
    }

}
