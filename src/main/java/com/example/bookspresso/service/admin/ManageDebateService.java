package com.example.bookspresso.service.admin;

import com.example.bookspresso.dto.admin.discussion.AttendMemberDTO;
import com.example.bookspresso.dto.admin.discussion.FinishedDebateDTO;
import com.example.bookspresso.dto.admin.discussion.ManageDebateDTO;
import com.example.bookspresso.dto.admin.page.AdminPageRequestDTO;
import com.example.bookspresso.mapper.admin.DebateManageMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ManageDebateService {

    private final DebateManageMapper debateManageMapper;

    public List<ManageDebateDTO> findDebateList(AdminPageRequestDTO adminPageRequestDTO){
        return debateManageMapper.selectDebateList(adminPageRequestDTO);
    }

    public int findDebateCount(){
        return debateManageMapper.selectDebateCount();
    }

    public List<ManageDebateDTO> findSearchDebateList( String searchType,
                                                       String keyword,
                                                       int page,
                                                       int amount){
        return debateManageMapper.selectSearchDebateList(searchType, keyword, page, amount);
    }

    public int findSearchDebateTotal(String searchType,
                                     String keyword,
                                     int page,
                                     int amount){
        return debateManageMapper.selectSearchDebateTotal(searchType, keyword, page, amount);
    }

    public List<FinishedDebateDTO> findSearchEndDebateList(String searchType,
                                                           String keyword,
                                                           int page,
                                                           int amount){
        return debateManageMapper.selectSearchEndDebateList(searchType, keyword, page, amount);
    }

    public int findSearchEndDebateTotal(String searchType,
                                     String keyword,
                                     int page,
                                     int amount){
        return debateManageMapper.selectSearchEndDebateTotal(searchType, keyword, page, amount);
    }

// xxxxx
    public List<ManageDebateDTO> findEndDebateList(AdminPageRequestDTO adminPageRequestDTO){
        return debateManageMapper.selectEndDebateList(adminPageRequestDTO);
    }

    public int findEndDebateCount(){
        return debateManageMapper.selectEndDebateCount();
    }

    public String findBookName(Long debateId){
        return debateManageMapper.selectBookName(debateId);
    }

    public void dropDebate(Long debateId){
        debateManageMapper.delectDebate(debateId);
    }

    public List<AttendMemberDTO> findAttendMemberList(Long debateId){
        return debateManageMapper.selectAttendMember(debateId);
    }



}

