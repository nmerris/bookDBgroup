package com.group.bookdatabase.controller;

import javax.persistence.Id;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.group.bookdatabase.model.Book;

@Controller
public class MainController
{
    @GetMapping("/index")
    public String indexPage(Model model)
    {

        model.addAttribute("welcomemessage","Welcome to this book DB");
        return "index";
    }


    @GetMapping("/addbook")
    public String addBookPage(Model model)
    {
        model.addAttribute("newbook", new Book());

        model.addAttribute("addbookmessage","please add book");
        return "addbook";
    }


    // this method is called when the user clicks on the LoadBooks link from the index page
    // there is no new page to go to, all it does is load the db with a list of predefined books
    // all this happens righ here
    @GetMapping("/loadbooks")
    public void addBookPage()
    {

    }



}
