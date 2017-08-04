package com.group.bookdatabase.controller;

import javax.persistence.Id;
import javax.validation.Valid;

import com.group.bookdatabase.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import com.group.bookdatabase.model.Book;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

@Controller
public class MainController
{

    // for this excercise, we need to load a bunch of books to the db at once
    // below are the sample books data

    private String[] sampleSkus = {"Java1001", "Java2002", "Orcl1003", "Python1004", "Zombie1005", "Rasp1006"};
    private String[] sampleTitles = {"Head First Java", "Thinking in Java", "OCP: Oracle Certified Professional Java SE", "Automate the Boring Stuff with Python", "The Maker's Guide to the Zombie Apocalypse", "Raspberry Pi Projects for the Evil Genius"};
    private String[] sampleAuthors = {"Kathy Sierra and Bert Bates", "Bruce Eckel", "Jeanne Boyarsky", "Al Sweigart", "Simon Monk", "Donald Norris"};
    private String[] sampleDescription = {"Easy to read Java workbook", "Details about Java under the hood", "Everything you need to know in one place","Fun with Python","Defend Your Base with Simple Circuits, Arduino, and Raspberry Pi","A dozen fiendishly fun projects for the Raspberry Pi!"};
    private double[] samplePrice = {47.50, 20.00, 45.00, 10.50, 16.50, 14.75};

    @Autowired
    BookRepository bookRepository;


    @GetMapping("/index")
    public String indexPage(Model model)
    {

        model.addAttribute("welcomemessage","Welcome to this book DB");
        return "index";
    }


    @GetMapping("/addbook")
    public String addBook(Model model)
    {
        model.addAttribute("newbook", new Book());

        model.addAttribute("addbookmessage","please add book");
        return "addbook";
    }

    @PostMapping("/addbook")
    public String postProduct(@ModelAttribute("newbook") Book book)
    {
        bookRepository.save(book); // save it to the db
        return "bookadditionconfirmation";
    }



    // this method is called when the user clicks on the LoadBooks link from the index page
    // there is no new page to go to, all it does is load the db with a list of predefined books
    // all this happens righ here
    @GetMapping("/loadbooks")
    public String loadExampleBooks()
    {



        // get all the books from out db
//        Iterable<Book> bookList = bookRepository.findAll();

        // save all out books to the db in one shot
         bookRepository.save(loadSampleBooks());
         return null;



    }

    private ArrayList<Book> loadSampleBooks(){


        ArrayList<Book> myBooks = new ArrayList<Book>();

        int length = Array.getLength(sampleSkus);

        for(int i = 0; i < length; i++) {
            Book newBook = new Book();

            newBook.setSku(sampleSkus[i]);
            newBook.setAuthor(sampleAuthors[i]);
            newBook.setTitle(sampleTitles[i]);
            newBook.setDescription(sampleDescription[i]);
            newBook.setPrice(samplePrice[i]);

            myBooks.add(newBook);


        }


        return myBooks;
    }




//
//    @GetMapping("/bookadditionconfirmation")
//    public String confirmBook()
//    {
//       return "bookadditionconfirmation";
//    }

}
