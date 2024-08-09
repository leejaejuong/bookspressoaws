package com.example.bookspresso.batch.Aladin;



import com.example.bookspresso.api.Aladen.Aladinitem;
import com.example.bookspresso.service.aladen.AladinService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.List;

@RequiredArgsConstructor
public class AladinItemReader implements ItemReader<Aladinitem> {
    private final AladinService aladinService;
    private int nextIdx=0;
    private List<Aladinitem> items;

    @Override
    public Aladinitem read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if(items==null){
            items = aladinService.getApialadin();
//            위에선언한 List<Aladinitem> items 가 비어있으면 aladinService를 가동하여 설정한 개수만큼
//            가져와서 리스트에 저장(현재설정 100)
//            1.뭉탱이로 가져와서
        }
        Aladinitem nextItemDTO=null;
        if(nextIdx<items.size()){
            nextItemDTO=items.get(nextIdx);
            nextIdx++;
//          리스트에 저장한값을 한 문단씩꺼내서 반환 1개씩 반환한다 (쿼리 insert 문에 넣을준비)
//          2.하나씩반환
        }else{
            items=null;
            nextIdx=0;
//            다꺼냈으면 다시 null로 초기화
        }
        return nextItemDTO;
    }
}
