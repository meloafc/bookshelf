package com.meloafc.bookshelf.service;

import com.meloafc.bookshelf.exception.NotFoundException;
import com.meloafc.bookshelf.model.Book;
import com.meloafc.bookshelf.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService extends GenericService<Book, Long> {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @Override
    public Book add(Book entity) {
        entity.setUser(jwtUserDetailsService.getLoggedUser());
        return super.add(entity);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findByUser_Id(jwtUserDetailsService.getLoggedUser().getId());
    }

    @Override
    public void removeById(Long id) {
        Book book = bookRepository.findByIdAndUser_Id(id, jwtUserDetailsService.getLoggedUser().getId());
        if(book == null) {
            throw new NotFoundException("Book not found. Id: " + id);
        }
        super.remove(book);
    }
}
