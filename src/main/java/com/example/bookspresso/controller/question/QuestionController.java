package com.example.bookspresso.controller.question;

import com.example.bookspresso.dto.question.board.*;
import com.example.bookspresso.dto.question.page.QPageRequestDTO;
import com.example.bookspresso.dto.question.page.QPageSetDTO;
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
    public String qaList(Model model, HttpSession session,
                         QPageRequestDTO qPageRequestDTO){
        Long memberId = (Long) session.getAttribute("memberId");

        qPageRequestDTO.setMemberId(memberId);
        List<QuestionListDTO> list = questionService.findListWithPage(qPageRequestDTO);
        int total = questionService.selectTotal(memberId);

        QPageSetDTO qPageSetDTO = new QPageSetDTO(qPageRequestDTO, total);

        model.addAttribute("total", total);
        model.addAttribute("list", list);
        model.addAttribute("qPageSetDTO", qPageSetDTO);

        return "question/qList";
    }

    @GetMapping("/list/search")
    public String qaSearchList(QuestionSearchDTO questionSearchDTO,
                               QPageRequestDTO qPageRequestDTO,
                               HttpSession session,
                               Model model){

        Long memberId = (Long)session.getAttribute("memberId");
        questionSearchDTO.setMemberId(memberId);


        List<QuestionListDTO> list = questionService.findSearchListWithPage(memberId,questionSearchDTO.getKeyword(),
                qPageRequestDTO.getPage(), qPageRequestDTO.getAmount());

        int total = questionService.findSearchTotal(memberId, questionSearchDTO.getKeyword());

        QPageSetDTO qPageSetDTO = new QPageSetDTO(qPageRequestDTO, total);

        model.addAttribute("total", total);
        model.addAttribute("list", list);
        model.addAttribute("qPageSetDTO", qPageSetDTO);

        return "question/qList";
    }



    @GetMapping("/write")
    public String qaWrite(HttpSession session, Model model){

        Long memberId = (Long)session.getAttribute("memberId");

        //로그인 안하면 글쓰기 불가능
        if (memberId == null){
            return "redirect:/member/login";
        }

//        model.addAttribute("nickname", );

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
    public String qaDetail(Long qBoardId,
                           Model model){
        questionService.updateViewCount(qBoardId);

        QuestionDetailDTO question = questionService.findQuestion(qBoardId);
        model.addAttribute("question", question);

        return "question/answerDetail";
    }

    @GetMapping("/modify")
    public String qaModify(Model model, Long qBoardId){

        QuestionDetailDTO question = questionService.findQuestion(qBoardId);
        model.addAttribute("question", question);

        return "question/modifyQ";
    }

    @PostMapping("/modify")
    public String qaModify(QuestionModifyDTO questionModifyDTO,
                           RedirectAttributes redirectAttributes){

        questionService.modifyQuestion(questionModifyDTO);
        System.out.println("questionModifyDTO = " + questionModifyDTO);
        redirectAttributes.addAttribute("qBoardId", questionModifyDTO.getQBoardId());
        System.out.println("questionModifyDTO = " + questionModifyDTO);

        return "redirect:/qa/detail";
    }

    @GetMapping("/drop")
    public String qaDrop(Long qBoardId){

        questionService.dropQuesiton(qBoardId);

        return "redirect:/qa/list";
    }
}
