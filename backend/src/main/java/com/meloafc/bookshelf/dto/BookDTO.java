package com.meloafc.bookshelf.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO extends BaseDTO {

    private Long id;
    private String title;
    private String description;
    private String author;
    private Integer year;

}
