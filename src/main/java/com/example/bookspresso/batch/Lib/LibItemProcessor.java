package com.example.bookspresso.batch.Lib;

import com.example.bookspresso.dto.api.Lib.LibApiLib;
import com.example.bookspresso.mapper.api.Lib.LibMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemProcessor;
@RequiredArgsConstructor
public class LibItemProcessor implements ItemProcessor<LibApiLib,LibApiLib> {
    private final LibMapper libMapper;

    @Override
    public LibApiLib process(LibApiLib item) throws Exception {
        String ChacklibCode = item.getLibCode();
        if(ChacklibCode ==null || "".equals(ChacklibCode)) {
            return null;
        }
        int libCode = libMapper.libSelectduplication(item.getLibCode());
        if(libCode>=1){
            return null;
        }

        return item;
    }
}
