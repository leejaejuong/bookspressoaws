package com.example.bookspresso.dto.admin;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor @Builder
public class AdminJoinDTO {

    private Long adminId;
    private String adminLoginId;
    private String adminPassword;

}
