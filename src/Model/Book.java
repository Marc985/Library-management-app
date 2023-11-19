package Model;

import java.util.List;

public class Book {
   private String idBook;
   private String name;
   private int pageNumbers;

   private java.sql.Date releaseDate;
   private Author author;
   private Visitor visitor;

   private String topic;

    public Book(String idBook, String name, int pageNumbers, java.sql.Date releaseDate, Author author,String topic) {
        this.idBook = idBook;
        this.name = name;
        this.pageNumbers = pageNumbers;
        this.releaseDate = releaseDate;
        this.author = author;
        this.topic = topic;
    }
public Book(String idBook){
        this.idBook=idBook;
}
    public String getIdBook() {
        return idBook;
    }

    public String getName() {
        return name;
    }

    public int getPageNumbers() {
        return pageNumbers;
    }

    public java.sql.Date getReleaseDate() {
        return releaseDate;
    }

    public Author getAuthor() {
        return author;
    }
    public String getTopic() {
        return topic;
    }


    public void setTopic(String topic) {
    if(topic=="COMEDY"||topic=="ROMANCE"||topic=="OTHER")
        this.topic = topic;

    }

    @Override
    public String toString() {
        return "Book{" +
                "idBook='" + idBook + '\'' +
                ", name='" + name + '\'' +
                ", pageNumbers=" + pageNumbers +
                ", releaseDate=" + releaseDate +
                ", author=" + author +
                ", topic='" + topic + '\'' +
                '}';
    }
}
