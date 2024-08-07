package com.example.bookspresso.api.member;

import com.example.bookspresso.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberApi {

    private final MemberService memberService;

    @GetMapping("/member/check/{loginId}")
    public int checkLoginId(@PathVariable("loginId") String loginId){
        int loginIdCount = memberService.findLoginId(loginId);
        return loginIdCount;

    }

//    @PostMapping("/member/${loginId}/checkLoginId")
//    public void checkLoginId(){
//        memberService.
//    }


}
