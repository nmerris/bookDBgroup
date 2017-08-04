package com.group.bookdatabase.repositories;

import com.group.bookdatabase.model.Book;
import org.springframework.data.repository.CrudRepository;

// the table name in our db will be called Book, the unique key will be of type Long
public interface BookRepository extends CrudRepository<Book,Long> {

    // can add cool custom methods here, ie
    // call this a 'query by method'
    // this is IT!!! no implementation necessary!! it automagically knows what to do
    // you MUST name your methods as it expects though: [defined start of method][your field][opt other defined stuff]
//    Iterable<Book> findAllByAuthor(String author);
//    Iterable<Book> findAllByAuthorLike(String partialAuthor);
    // etc

}
