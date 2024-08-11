package com.example.bookspresso.controller.debate;

import com.example.bookspresso.dto.debate.DebateInpoDTO;
import com.example.bookspresso.dto.debate.N_N.DebateBookDTO;
import com.example.bookspresso.dto.debate.N_N.MemberdebateDTO;
import com.example.bookspresso.dto.debate.board.*;
import com.example.bookspresso.dto.debate.debateMain.DebateMainPageDTO;
import com.example.bookspresso.dto.debate.page.DebatePageRequestDTO;
import com.example.bookspresso.dto.debate.page.PageRequestDTO;
import com.example.bookspresso.dto.debate.page.PageSetDTO;
import com.example.bookspresso.service.debate.DebateBoardService;
import com.example.bookspresso.service.debate.Debateservice;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/debate")
public class DebateController {
    private final Debateservice debateservice;
    private final DebateBoardService debateBoardService;

    @GetMapping("/")
    public String debate(PageRequestDTO pageRequestDTO,HttpSession session, Model model) {
//        메인페이지
        session.setAttribute("memberId", 1L);
        List<DebateMainPageDTO> debateMain = debateservice.findMainPage(pageRequestDTO);
        int total= debateservice.findTotal();
        PageSetDTO pageNum = new PageSetDTO(total, pageRequestDTO);
        model.addAttribute("debateMain", debateMain);
        model.addAttribute("pageNum", pageNum);

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
                          DebatePageRequestDTO debatePageRequestDTO,
                           HttpSession session,
                           Model model) {
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
//        검색 페이징 처리
//        int total= debateservice.findTotal();
//        DebatePageSetDTO debatePageSetDTO = new DebatePageSetDTO(total, debatePageRequestDTO);
//        debateservice.addInpo(debateinpoDTO);
//        model.addAttribute("pageNum", debateinpoDTO);
//     debateId 값은 시퀀스로 생성하기 때문에 위의 코드가 실행되야 생성되서 먼저 실행후 값을꺼내여 직접 넣어준다
        debateBookDTO.setDebateId(debateinpoDTO.getDebateId());
        memberDebateDTO.setDebateId(debateinpoDTO.getDebateId());
        debateservice.addConnection( debateBookDTO,memberDebateDTO);
//        최소생성시 바로 debateboard로 가기때문에 DB 연결을위해 세선에 값을 저장해줌
        session.setAttribute("debateId", debateinpoDTO.getDebateId());
//    세션에서 meetingId, debateType 제거
        session.removeAttribute("debateType");
        session.removeAttribute("debateType");
        return "debate/debateboard/debateboard";
    }



    @GetMapping("/board")
    public String debateboard(HttpSession session, Model model) {

        session.setAttribute("memberId", 1L);
//        로그인 체크
        Long memberId = (Long)session.getAttribute("memberId");
        if(memberId==null) {
            return "redirect:/member/login";
        }
       Long debateId = (Long) session.getAttribute("debateId");
//        if(debateId==null) {
//        }
        DebateBoardAsideDTO aside = debateBoardService.selectAside(69L);
        List<DebateBoardDTO> debateBoard = debateBoardService.selectcentent(69L);
        model.addAttribute("aside",aside);
        model.addAttribute("debateBoard",debateBoard);
//        model.addAttribute("boardComment",boardComment);
        return "debate/debateboard/debateboard";
    }
    @GetMapping("/write")
    public String debatewrite() {


        return "debate/debateboard/debatewrite";
    }
    @PostMapping("/write")
    public String debatewrite(DebateWriteDTO debateWriteDTO){
        debateWriteDTO.setDebateId(69L);
        debateBoardService.addWrite(debateWriteDTO);
        return "debate/debateboard/debateboard";
    }

}
