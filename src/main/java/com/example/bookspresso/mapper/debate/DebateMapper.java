package com.example.bookspresso.mapper.debate;

import com.example.bookspresso.dto.debate.BookinpoDTO;
import com.example.bookspresso.dto.debate.DebateInpoDTO;
import com.example.bookspresso.dto.debate.N_N.DebateBookDTO;
import com.example.bookspresso.dto.debate.N_N.MemberdebateDTO;
import com.example.bookspresso.dto.debate.debateMain.DebateMainPageDTO;
import com.example.bookspresso.dto.debate.page.DebatePageRequestDTO;
import com.example.bookspresso.dto.debate.page.PageRequestDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DebateMapper {
    //토론정보 입력(토론만들기)
    //토론정보 입력(토론만들기)
    void insertDebateInpo(DebateInpoDTO debateinpoDTO);
    //검색
    List<BookinpoDTO> selectbookinpo(String title);
    int selectBookTotal();

    //    다대다
    void insertMemberDebate(MemberdebateDTO memberDebateDTO);
    void insertDebateBook(DebateBookDTO debateBookDTO);
    //  다대다에 debateId를 넣기위한 select
    Long selectdebateId(Long debateId);


//    debateMainPage
//    페이징 처리
    List<DebateMainPageDTO> selectListWithPage(PageRequestDTO pageRequestDTO);
    int selectTotal();



}
