package com.example.bookspresso.controller.question;

import com.example.bookspresso.dto.member.MemberJoinDTO;
import com.example.bookspresso.dto.question.QuestionDetailDTO;
import com.example.bookspresso.dto.question.QuestionListDTO;
import com.example.bookspresso.dto.question.QuestionWriteDTO;
import com.example.bookspresso.service.question.QuestionService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/qa")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping("/list")
    public String qaList(Model model){

        List<QuestionListDTO> list = questionService.findList();

        model.addAttribute("total", questionService.selectTotal());
        model.addAttribute("list", list);

        return "question/qList";
    }



    @GetMapping("/write")
    public String qaWrite(HttpSession session, Model model){

        Long memberId = (Long)session.getAttribute("memberId");

        if (memberId == null){
            return "redirect:/member/login";
        }

//        model.addAttribute("nickname",);

        return "question/writeQ";
    }

    @PostMapping("/write")
    public String qaWrite(QuestionWriteDTO questionWriteDTO,
                          @SessionAttribute("memberId") Long memberId){
        questionWriteDTO.setMemberId(memberId);

        questionService.addQuestion(questionWriteDTO);
        System.out.println("write = " + questionWriteDTO);
//        return "redirect:/qa/detail";
        return "redirect:/qa/list";
    }

    @GetMapping("/detail")
    public String qaDetail(Long qBoardId,
                           Model model){

        QuestionDetailDTO question = questionService.findQuestion(qBoardId);

        model.addAttribute("question", question);
//        model.addAttribute("qTitle", question.getQTitle());
//        model.addAttribute("nickname", question.getNickname());
//        model.addAttribute("qContent", question.getQContent());
//        model.addAttribute("createDate", question.getCreateDate());
//        model.addAttribute("viewCount", question.getViewCount());

        System.out.println("#### = " + question);
        return "question/answerDetail";
    }
}
