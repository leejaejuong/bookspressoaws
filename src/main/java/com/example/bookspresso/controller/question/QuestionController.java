package com.example.bookspresso.controller.question;

import com.example.bookspresso.dto.member.MemberJoinDTO;
import com.example.bookspresso.dto.question.QuestionDetailDTO;
import com.example.bookspresso.dto.question.QuestionListDTO;
import com.example.bookspresso.dto.question.QuestionSearchDTO;
import com.example.bookspresso.dto.question.QuestionWriteDTO;
import com.example.bookspresso.service.question.QuestionService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/qa")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;
    private final HttpSession httpSession;

    @GetMapping("/list")
    public String qaList(Model model, HttpSession session){
        Long memberId = (Long) session.getAttribute("memberId");
        List<QuestionListDTO> list = questionService.findList(memberId);

        model.addAttribute("total", questionService.selectTotal(memberId));
        model.addAttribute("list", list);
        model.addAttribute("aStatus", "답변 미완료");

        return "question/qList";
    }

    @GetMapping("/list/search")
    public String qaSearchList(QuestionSearchDTO questionSearchDTO,
                               HttpSession session,
                               Model model){

        Long memberId = (Long) session.getAttribute("memberId");

        List<QuestionListDTO> list = questionService.findSearchList(questionSearchDTO);
        model.addAttribute("total", questionService.selectTotal(memberId));
        model.addAttribute("list", list);


        return "question/qList";
    }



    @GetMapping("/write")
    public String qaWrite(HttpSession session, Model model){

        Long memberId = (Long)session.getAttribute("memberId");

        //로그인 안하면 글쓰기 불가능
        if (memberId == null){
            return "redirect:/member/login";
        }

//        model.addAttribute("nickname",);

        return "question/writeQ";
    }

    @PostMapping("/write")
    public String qaWrite(QuestionWriteDTO questionWriteDTO,
                          @SessionAttribute("memberId") Long memberId,
                          RedirectAttributes redirectAttributes,
                          Model model){
        questionWriteDTO.setMemberId(memberId); //memberId저장
        questionService.addQuestion(questionWriteDTO);  //boardId 저장

//        model.addAttribute("nickname", questionWriteDTO.getNickname());

        System.out.println("write = " + questionWriteDTO);
        redirectAttributes.addAttribute("qBoardId", questionWriteDTO.getQBoardId());
        return "redirect:/qa/detail";
//        return "redirect:/qa/list";
    }

    @GetMapping("/detail")
    public String qaDetail(Long qBoardId, Model model){
        questionService.updateViewCount(qBoardId);   //조회수 +1
        QuestionDetailDTO question = questionService.findQuestion(qBoardId);
        model.addAttribute("question", question);

        System.out.println("#### count = " + question.getViewCount());
        return "question/answerDetail";
    }

    @GetMapping("/modify")
    public String qaModify(Model model){

        return null;
    }
}
