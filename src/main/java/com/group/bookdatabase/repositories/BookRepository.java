package com.group.bookdatabase.repositories;

import com.group.bookdatabase.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
