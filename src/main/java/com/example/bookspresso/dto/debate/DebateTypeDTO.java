package com.example.bookspresso.dto.debate;

import lombok.*;
import org.apache.ibatis.annotations.Mapper;

@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DebateTypeDTO {
    Long debateTypeId;
    String debateType;

}
