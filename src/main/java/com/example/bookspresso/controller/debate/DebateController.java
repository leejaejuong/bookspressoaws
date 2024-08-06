package com.example.bookspresso.controller.debate;

import com.example.bookspresso.dto.debate.DebateInpoDTO;
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
    public String debate() {
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
    public String inpoPost(DebateInpoDTO debateinpoDTO, HttpSession session) {
        //세션에서 값을 꺼내 넣어줌

        Long meetingId = (Long)session.getAttribute("meetingId");
        Long debateType = (Long)session.getAttribute("debateType");
        debateinpoDTO.setMeetingId(meetingId);
        debateinpoDTO.setDebateTypeId(debateType);
        debateservice.addInpo(debateinpoDTO);
        System.out.println("debateinpoDTO = " + debateinpoDTO);
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
