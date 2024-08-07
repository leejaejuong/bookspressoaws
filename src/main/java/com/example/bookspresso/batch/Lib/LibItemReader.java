package com.example.bookspresso.batch.Lib;

import com.example.bookspresso.dto.api.Lib.LibHeader;
import com.example.bookspresso.dto.api.Lib.Libbody;
import com.example.bookspresso.dto.api.Lib.Libitem;
import com.example.bookspresso.dto.api.Lib.Libitems;
import com.example.bookspresso.dto.api.aladin.Aladinitem;
import com.example.bookspresso.service.api.Lib.LibService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.List;

@RequiredArgsConstructor
public class LibItemReader implements ItemReader<Libitems> {
    private final LibService libService;
    private int nextIdx=0;
    private List<Libitems> items;

    @Override
    public Libitems read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if(items==null){
            LibHeader lib = libService.getLib();
            items=lib.getResponse().getLibs();
        }
        Libitems nextItemDTO=null;
        if(nextIdx<items.size()){
            nextItemDTO=items.get(nextIdx);
            nextIdx++;
        }else{
            items=null;
            nextIdx=0;
        }
        return nextItemDTO;
    }
}
