package com.example.bookspresso.service.admin;

import com.example.bookspresso.mapper.admin.AdminMainMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AdminServiceTest {

    @Mock
    AdminMainMapper adminMainMapper;

    @InjectMocks
    AdminService adminService;


    @BeforeEach
    void setUp() {
    }

    @Test
    void findAdmin() {
        Mockito.doReturn(Optional.of(1L)).when(adminMainMapper)
                .selectAdmin(Mockito.any(), Mockito.any());

        Long adminId = adminService.findAdminId("test", "1234");
        assertThat(adminId).isEqualTo(1L);



    }
}