package com.example.bookspresso.mapper.debate;

import com.example.bookspresso.dto.debate.BookinpoDTO;
import com.example.bookspresso.dto.debate.DebateInpoDTO;
import com.example.bookspresso.dto.debate.DebateTypeDTO;
import com.example.bookspresso.dto.debate.MettingTypeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DebateMapper {
    //토론정보 입력(토론만들기)
    void insertDebateInpo(DebateInpoDTO debateinpoDTO);
    //검색
    BookinpoDTO selectbookinpo(String title);

    List<DebateInpoDTO> selectdebateinpo(Long debateId);

//테스트용 코드
    void insertDebateType(DebateTypeDTO debateTypeDTO);
    void insertMettingType(MettingTypeDTO mettingTypeDTO);

}
