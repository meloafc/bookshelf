package com.meloafc.bookshelf.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponseDTO extends BaseDTO {

    private String email;
    private String token;

}
