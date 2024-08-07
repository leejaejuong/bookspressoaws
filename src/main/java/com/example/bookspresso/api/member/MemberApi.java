package com.example.bookspresso.api.member;

import com.example.bookspresso.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberApi {

    private final MemberService memberService;

//    @PostMapping("v1/member/${loginId}/checkLoginId")
//    public checkLoginId(){

//    }


}
