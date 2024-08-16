package com.example.bookspresso.controller.admin;

import com.example.bookspresso.dto.admin.page.AdminPageRequestDTO;
import com.example.bookspresso.dto.admin.page.AdminPageSetDTO;
import com.example.bookspresso.dto.admin.qa.ManageQuestionListDTO;
import com.example.bookspresso.dto.admin.qa.QuestionAnswerDTO;
import com.example.bookspresso.dto.question.board.QuestionDetailDTO;
import com.example.bookspresso.service.admin.ManageQuestionService;
import com.example.bookspresso.service.question.QuestionService;
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
@RequestMapping("/admin/question")
public class QandAController {

    private final ManageQuestionService manageQuestionService;
    private final QuestionService questionService;

    @GetMapping("/list")
    public String question(AdminPageRequestDTO adminPageRequestDTO,
                           Model model){

        List<ManageQuestionListDTO> list = manageQuestionService.findQuestionList(adminPageRequestDTO);
        int total = manageQuestionService.findQuestionCount();

        AdminPageSetDTO adminPageSetDTO = new AdminPageSetDTO(adminPageRequestDTO, total);

        model.addAttribute("total",total);
        model.addAttribute("list", list);
        model.addAttribute("adminPageSetDTO",adminPageSetDTO);

        return "admin/qa/question";
    }

    @GetMapping("/popup")
    public String popup(Long qBoardId, Model model){
//        return "redirect:/qa/detail";
        QuestionDetailDTO list = questionService.findQuestion(qBoardId);

        model.addAttribute("list",list);

        return "admin/qa/toAnswer";
    }

    @PostMapping("/popup")
    public String popup(QuestionAnswerDTO questionAnswerDTO,
                        HttpSession session){


        try {
            questionAnswerDTO.setAdminId((Long)session.getAttribute("adminId"));
            System.out.println("questionAnswerDTO =" + questionAnswerDTO);
            manageQuestionService.addAnswer(questionAnswerDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



        return "redirect:/admin/question/list";
    }

}
