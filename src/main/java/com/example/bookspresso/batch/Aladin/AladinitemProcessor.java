package com.example.bookspresso.batch.Aladin;

import com.example.bookspresso.api.Aladen.Aladinitem;
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
        String itemIsbn13=item.getIsbn13();
        if(itemIsbn13 == null || "".equals(itemIsbn13)) {
            return null;
        }
        int isbn13 = aladinMapper.selectDuplication(item.getIsbn13());
        if(isbn13>=1){
//            1보다 같거나크면 DB에 존재하기때문에 null 반환
            return null;
        }
            return item;
    }
}
