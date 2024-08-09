package com.example.bookspresso.controller.debate;

import com.example.bookspresso.dto.debate.DebateInpoDTO;
import com.example.bookspresso.dto.debate.N_N.DebateBookDTO;
import com.example.bookspresso.dto.debate.N_N.MemberdebateDTO;
import com.example.bookspresso.service.debate.Debateservice;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/debate")
public class DebateController {
    private final Debateservice debateservice;
    @GetMapping("/")
    public String debate(HttpSession session) {
        session.setAttribute("memberId", 1L);
        return "debate/debateboard/debatemain";
    }


    @GetMapping("/make")
    public String make() {
        return "debate/debateinpo/debatemake";
    }
    @PostMapping("/make")
    public String makePost(Long meetingId, HttpSession session) {
        if(meetingId==1 || meetingId==2) {
            session.setAttribute("meetingId", meetingId);
            return "/debate/debateinpo/debatetype";
        }else{
            session.setAttribute("meetingId", meetingId);
            session.setAttribute("debateType", 4L);

            return "/debate/debateinpo/debateoutline";
        }

    }
    @GetMapping("/type")
    public String type() {
        return "debate/debateinpo/debatetype";
    }
    @PostMapping("/type")
    public String typePost(Long debateType,HttpSession session) {
        session.setAttribute("debateType", debateType);
        return "debate/debateinpo/debateoutline";
    }
    @GetMapping("/inpo")
    public String inpo() {
//        @ModelAttribute("debateInpoDTO")DebateInpoDTO debateInpoDTO
        return "debate/debateinpo/debateoutline";
    }
    @PostMapping("/inpo")
    public String inpoPost(DebateInpoDTO debateinpoDTO,
                           DebateBookDTO debateBookDTO,
                           MemberdebateDTO memberDebateDTO,
                           HttpSession session) {
        //세션에서 값을 꺼내 저장
        Long memberId= (Long)session.getAttribute("memberId");
        Long meetingId = (Long)session.getAttribute("meetingId");
        Long debateType = (Long)session.getAttribute("debateType");
//        페이지를 넘기면서 세션에 meetingId, debateType 을 저장했기때문에 set 으로 직접 넣어줌
        debateinpoDTO.setMeetingId(meetingId);
        debateinpoDTO.setDebateTypeId(debateType);
//        멤버 아이디도 동일하게 직접 넣어줌
        debateBookDTO.setMemberId(memberId);
        memberDebateDTO.setMemberId(memberId);

        debateservice.addInpo(debateinpoDTO);
//     debateId 값은 시퀀스로 생성하기 때문에 위의 코드가 실행되야 생성되서 먼저 실행후 값을꺼내여 직접 넣어준다
        debateBookDTO.setDebateId(debateinpoDTO.getDebateId());
        memberDebateDTO.setDebateId(debateinpoDTO.getDebateId());
        debateservice.addConnection( debateBookDTO,memberDebateDTO);

        return "debate/debateboard/debateboard";
    }



    @GetMapping("/board")
    public String debateboard() {

        return "debate/debateboard/debateboard";
    }
    @GetMapping("/write")
    public String debatewrite() {
        return "debate/debateboard/debatewrite";
    }
}
