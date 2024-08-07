package com.example.bookspresso.service.debate;

import com.example.bookspresso.dto.debate.BookinpoDTO;
import com.example.bookspresso.dto.debate.DebateInpoDTO;
import com.example.bookspresso.dto.debate.DebateTypeDTO;
import com.example.bookspresso.dto.debate.MettingTypeDTO;
import com.example.bookspresso.mapper.debate.DebateMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class Debateservice {
    private final DebateMapper debateMapper;
    //토론정보입력
    public void addInpo(DebateInpoDTO debateinpoDTO){ debateMapper.insertDebateInpo(debateinpoDTO);}
    //책 검색
    public List<BookinpoDTO> searchBookinpo(String title){return debateMapper.selectbookinpo(title);}

    //로론 정보찾기
    public List<DebateInpoDTO> findInpo(Long debateId){return debateMapper.selectdebateinpo(debateId);}




    //테스트코드용
    public void adddebate(DebateTypeDTO debateTypeDTO){debateMapper.insertDebateType(debateTypeDTO);}
    public void addmetting(MettingTypeDTO mettingTypeDTO){debateMapper.insertMettingType(mettingTypeDTO);}

}
