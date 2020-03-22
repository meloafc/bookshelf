package com.meloafc.bookshelf.mapper;

import com.meloafc.bookshelf.dto.BookDTO;
import com.meloafc.bookshelf.dto.UserDTO;
import com.meloafc.bookshelf.model.Book;
import com.meloafc.bookshelf.model.User;

public class BookMapper implements GenericMapper<Book, BookDTO> {

    @Override
    public BookDTO convertToDTO(Book entity) {
        return BookDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .author(entity.getAuthor())
                .year(entity.getYear())
                .build();
    }

    @Override
    public Book convertToEntity(BookDTO dto) {
        return Book.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .author(dto.getAuthor())
                .year(dto.getYear())
                .build();
    }

}
