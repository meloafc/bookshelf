package com.meloafc.bookshelf.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends BaseDTO {

    private Long id;
    private String name;
    private String email;
    private String password;

}
