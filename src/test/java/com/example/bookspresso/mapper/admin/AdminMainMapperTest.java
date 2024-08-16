package com.example.bookspresso.mapper.admin;

import com.example.bookspresso.dto.admin.main.AdminJoinDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Transactional
class AdminMainMapperTest {

    @Autowired AdminMainMapper adminMainMapper;

    AdminJoinDTO adminJoinDTO;

    @BeforeEach
    void setUp() {
        adminJoinDTO = AdminJoinDTO.builder()
                .adminId(2L)
                .adminLoginId("test")
                .adminPassword("test")
                .build();
    }

    @Test
    void selectAdmin() {
        Optional<Long> adminId = adminMainMapper.selectAdmin("admin01", "admin1234@@");
        boolean present = adminId.isPresent();
        System.out.println("present = " + present );
    }
}