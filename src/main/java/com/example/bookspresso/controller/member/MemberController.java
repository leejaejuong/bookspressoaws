package com.example.bookspresso.controller.member;

import com.example.bookspresso.dto.member.MemberJoinDTO;
import com.example.bookspresso.service.member.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/join")
    public String join(){
        return "member/join";
    }

    //회원가입 시 멤버 테이블의 데이터와 프로필 테이블의 데이터가 모두 들어가야함

    @PostMapping("/join")
    public String join(MemberJoinDTO memberJoinDTO){
// join.html에서 모든 input에 값을 입력하지 않으면 데이터가 전송되지 않게 설정
//      // 특정 조건에 알맞은 아이디/이메일 설정 해야함
        System.out.println("@@@@@ memberJoinDTO = " + memberJoinDTO);

        try {
            memberService.addMember(memberJoinDTO);
        } catch (IllegalStateException e) {
            log.error(e.toString());

            return "member/join";
        }


        return "redirect:/member/login";
    }

    @GetMapping("/login")
    public String login(){
        return "member/login";
    }

    @PostMapping("/login")
    public String login(String loginId, String password,
                        HttpSession session){
        Long memberId = null;

        try {
            memberId = memberService.findMemberId(loginId, password);
        } catch (IllegalArgumentException e) {
            System.out.println("존재하지 않는 회원정보");
            return "member/login";
        } catch (Exception e) {
            System.out.println("예상치 못한 예외");
            return "member/login";
        }

        session.setAttribute("memberId", memberId);
        System.out.println(loginId+" 회원의 회원번호 = " + session.getAttribute("memberId"));
        return "redirect:/";
//        redirect: => html의 경로가 아닌 링크의 주소로 사용할려고 할때
    }
// 이메일 검증 => 백 : 검증 라이브러리 사용 and 프론트 : js에서 정규표현식


    @GetMapping("/findId")
    public String findId(){
        return "member/findId";
    }

    @GetMapping("/findPassword")
    public String findPassword(){
        return "member/findPassword";
    }



}
