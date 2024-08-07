package com.example.bookspresso.batch.Aladin;

import com.example.bookspresso.dto.api.aladin.Aladinitem;
import com.example.bookspresso.mapper.api.aladin.AladinMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemProcessor;
@RequiredArgsConstructor
public class AladinitemProcessor implements ItemProcessor<Aladinitem,Aladinitem> {
    private final AladinMapper aladinMapper;
    @Override
    public Aladinitem process(Aladinitem item) throws Exception {

//        itme의 isbn을 select에 넣어줘서 isbn 값이 존재하는지 확인
//        값이나오면 존재함 null이 나오면 존재안함
        String isbn13 = aladinMapper.selectduplication(item.getIsbn13());
        if(isbn13 == null){
//            null이면 DB에 없기때문에 그대로 반환 하여 정상진행
            return item;
        }else{
//          null이 아니면 DB에 존재하기때문에 null 반환
            return null;
        }



    }
}
