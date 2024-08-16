package com.example.bookspresso.controller.admin;

import com.example.bookspresso.dto.admin.discussion.ManageDebateDTO;
import com.example.bookspresso.dto.admin.page.AdminPageRequestDTO;
import com.example.bookspresso.dto.admin.page.AdminPageSetDTO;
import com.example.bookspresso.service.admin.ManageDebateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/debate")
@RequiredArgsConstructor
public class DiscussionController {

    private final ManageDebateService manageDebateService;

    public void modul(){

    }

    // 현재 진행 중인 토론
    @GetMapping("/onGoing")
    public String allDiscussion(Model model,
                                AdminPageRequestDTO adminPageRequestDTO){

        List<ManageDebateDTO> list = manageDebateService.findDebateList(adminPageRequestDTO);

        Map<String, String> debateTypeId = new HashMap<String, String>();
        debateTypeId.put("1","공고형");
        debateTypeId.put("2","자유형");
        debateTypeId.put("3","장르형");
        debateTypeId.put("4","혼자서");

        Map<String, String> meetingTypeId = new HashMap<String, String>();
        meetingTypeId.put("1", "온라인");
        meetingTypeId.put("2", "오프라인");
        meetingTypeId.put("3", "혼자서");

        list.forEach(manageDebateDTO ->{
            String debateType = manageDebateDTO.getDebateTypeId();
            manageDebateDTO.setDebateTypeId(debateTypeId.get(debateType));

            String meetingType = manageDebateDTO.getMeetingId();
            manageDebateDTO.setMeetingId(meetingTypeId.get(meetingType));

            String bookName = manageDebateService.findBookName(manageDebateDTO.getDebateId());
            model.addAttribute("bookName", bookName);
        });

        int total = manageDebateService.findDebateCount();
        AdminPageSetDTO adminPageSetDTO = new AdminPageSetDTO(adminPageRequestDTO, total);



        model.addAttribute("total", total);
        model.addAttribute("list", list);
        model.addAttribute("adminPageSetDTO", adminPageSetDTO);

        return "admin/discussion/onGoingDc";
    }

    @GetMapping("/finished")
    public String endDiscussion(Model model,
                                AdminPageRequestDTO adminPageRequestDTO){

        List<ManageDebateDTO> list = manageDebateService.findEndDebateList(adminPageRequestDTO);

        Map<String, String> debateTypeId = new HashMap<String, String>();
        debateTypeId.put("1","공고형");
        debateTypeId.put("2","자유형");
        debateTypeId.put("3","장르형");
        debateTypeId.put("4","혼자서");

        Map<String, String> meetingTypeId = new HashMap<String, String>();
        meetingTypeId.put("1", "온라인");
        meetingTypeId.put("2", "오프라인");
        meetingTypeId.put("3", "혼자서");

        list.forEach(manageDebateDTO ->{
            String debateType = manageDebateDTO.getDebateTypeId();
            manageDebateDTO.setDebateTypeId(debateTypeId.get(debateType));

            String meetingType = manageDebateDTO.getMeetingId();
            manageDebateDTO.setMeetingId(meetingTypeId.get(meetingType));

            String bookName = manageDebateService.findBookName(manageDebateDTO.getDebateId());
            model.addAttribute("bookName", bookName);
            System.out.println("#################bookName = " + bookName);
        });

        int total = manageDebateService.findEndDebateCount();
        AdminPageSetDTO adminPageSetDTO = new AdminPageSetDTO(adminPageRequestDTO, total);

        model.addAttribute("total", total);
        model.addAttribute("list", list);
        model.addAttribute("adminPageSetDTO", adminPageSetDTO);

        return "admin/discussion/finishedDc";
    }

    @GetMapping("/forcedOut")
    public String discussion(){
        return "admin/discussion/forcedOutDc";
    }


}
