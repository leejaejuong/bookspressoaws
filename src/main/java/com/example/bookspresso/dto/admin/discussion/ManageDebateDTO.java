package com.example.bookspresso.dto.admin.discussion;

import lombok.*;

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
    Long debateId;

    String bookName;

    String title;
    String meetingId;
    String groupStartDate;
    String groupEndDate;
    String debateStartDate;
    String debateEndDate;

    String debateTypeId;
    String debateBookId;
    String outline;

//    String memberId;


}

















