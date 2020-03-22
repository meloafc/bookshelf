package com.meloafc.bookshelf.repository;

import com.meloafc.bookshelf.model.Book;
import com.meloafc.bookshelf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByUser_Id(long userId);
    Book findByIdAndUser_Id(long bookId, long userId);
}
