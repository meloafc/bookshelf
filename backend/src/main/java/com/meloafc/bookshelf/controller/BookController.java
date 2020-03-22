package com.meloafc.bookshelf.controller;

import com.meloafc.bookshelf.dto.BookDTO;
import com.meloafc.bookshelf.mapper.BookMapper;
import com.meloafc.bookshelf.model.Book;
import com.meloafc.bookshelf.service.BookService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Getter(AccessLevel.PRIVATE)
    @Setter(AccessLevel.PRIVATE)
    private BookMapper bookMapper;

    public BookController() {
        setBookMapper(new BookMapper());
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<BookDTO> getAll() {
        return getBookMapper().convertToListDTO(bookService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public BookDTO create(@Valid @RequestBody BookDTO bookDTO) {
        Book book = getBookMapper().convertToEntity(bookDTO);
        return getBookMapper().convertToDTO(bookService.add(book));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        bookService.removeById(id);
    }
}
