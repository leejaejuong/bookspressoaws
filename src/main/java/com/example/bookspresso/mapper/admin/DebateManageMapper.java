package com.example.bookspresso.mapper.admin;

import com.example.bookspresso.dto.admin.discussion.DebateSearchDTO;
import com.example.bookspresso.dto.admin.discussion.ManageDebateDTO;
import com.example.bookspresso.dto.admin.page.AdminPageRequestDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DebateManageMapper {

    List<ManageDebateDTO> selectDebateList(AdminPageRequestDTO adminPageRequestDTO);
//                                           DebateSearchDTO debateSearchDTO);

    int selectDebateCount();

    List<ManageDebateDTO> selectEndDebateList(AdminPageRequestDTO adminPageRequestDTO);

    int selectEndDebateCount();

    String selectBookName(Long debateId);

    void delectDebate(Long debateId);

    List<ManageDebateDTO> selectSearchDebateList(AdminPageRequestDTO adminPageRequestDTO,
                                                 DebateSearchDTO debateSearchDTO);



}
