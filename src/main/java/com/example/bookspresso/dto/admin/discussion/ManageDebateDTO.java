package com.example.bookspresso.dto.admin.discussion;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ManageDebateDTO {

    /*
    토론 제목, 모임 종류, 모집 시작일, 종료일
    토론 시작일, 종료일,

    토론 종류, 토론 책, 토론 개요
    토론 참여 회원
     */
    private Long debateId;
    private String bookName;
    private String title;
    private String meetingId;
    private String meetingType;
    private String groupStartDate;
    private String groupEndDate;
    private String debateStartDate;
    private String debateEndDate;
    private String debateTypeId;
    private String debateType;
    private String debateBookId;
    private String outline;

    // 토론 참여 한 회원 리스트
    private List<AttendMemberDTO> attendList;

//    String memberId;


}

















