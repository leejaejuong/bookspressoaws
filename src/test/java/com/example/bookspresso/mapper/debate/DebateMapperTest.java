package com.example.bookspresso.mapper.debate;

import com.example.bookspresso.dto.debate.BookinpoDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class DebateMapperTest {
        @Autowired DebateMapper debateMapper;
        BookinpoDTO bookinpoDTO;
    @BeforeEach
    void setUp() {
        bookinpoDTO =BookinpoDTO.builder()
                .isbn13("9788975819605")
                .title("한자 속의 중국")
                .description("고대 문자형태가 담고 있는 정보를 해석하여 각 한자의 근원을 찾고, 고대의 계급, 종교, 옷과 음식, 주거 교통, 민속, 형벌 등의 역사문화 및 생활방식뿐만 아니라 고대인들의 사유 및 지혜를 심도 있고 명확하게 풀어낸다.")
                .author("한가준")
                .cover("https://image.aladin.co.kr/product/34438/87/coversum/8975819604_1.jpg','http://www.aladin.co.kr/shop/wproduct.aspx?ItemId=344388751&amp;partner=openAPI&amp;start=api")
                .pubdate("2024-07-22")
                .build();

    }



    @Test
    void selectbookinpo() {
        String title=bookinpoDTO.getTitle();
        // given
        BookinpoDTO selectbookinpo = debateMapper.selectbookinpo(title);

        //then
        Assertions.assertThat(title).isEqualTo(selectbookinpo.getTitle());
    }
}