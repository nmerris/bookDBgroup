package com.group.bookdatabase.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;


@Entity
public class Book
{

    // id will be used in the Book table as the key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String sku;
    @NotNull
    private String title;
    @NotNull
    private String author;
    @NotNull
    private String description;
    @Max(99)
    @NotNull
    private double price;


    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
