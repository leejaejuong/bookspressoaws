package com.example.bookspresso.batch.Lib;

import com.example.bookspresso.dto.api.Lib.LibApiBody;
import com.example.bookspresso.dto.api.Lib.LibApiLib;
import com.example.bookspresso.dto.api.Lib.LibApiLibs;
import com.example.bookspresso.service.api.Lib.LibService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.List;

@RequiredArgsConstructor
public class LibItemReader implements ItemReader<LibApiLib> {
    private final LibService libService;
    private int nextIdx=0;
    private List<LibApiLibs> items;

    @Override
    public LibApiLib read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if(items==null){
            List<LibApiLibs> libApiLibsList = libService.getLib();
            items=libApiLibsList;
        }
        LibApiLibs libApiLibs=null;
        if(nextIdx < items.size()){
            libApiLibs=items.get(nextIdx);
            nextIdx++;
        }else{
            items=null;
            nextIdx=0;
        }

        if (libApiLibs == null) {
            return null;
        }

        return libApiLibs.getLib();
    }
}
