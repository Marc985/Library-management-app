import DBConnection.ConnectionDB;
import Model.Author;
import Model.Book;
import Model.Visitor;
import Repository.AuthorCrudOperations;
import Repository.BookCrudOperations;
import Repository.VisitorCrudOperations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;


public class Main {

    public static void main(String[] args){
        BookCrudOperations bookCrudOperations=new BookCrudOperations();
        System.out.println("\n\n"+"=".repeat(45)+"BOOK CRUD OPERATION"+"=".repeat(45));
       List<Book> allBooks=bookCrudOperations.findALL();
       if(allBooks.size()>0){
           System.out.println("\t\tList of all books");
       }
       for(Book book:allBooks){
           System.out.println(book);
       }


        //List of book to save
List<Book> BooksToSave=new ArrayList<>(
        Arrays.asList(
                new Book("11","tell me a story",
                        129,java.sql.Date.valueOf("2016-04-20"),new Author("30"),
                        "ROMANCE"),
                new Book("12","Prophetie",
                        140,java.sql.Date.valueOf("2016-04-20"),new Author("30"),
                        "ROMANCE")
        )

);
List<Book> responses= bookCrudOperations.saveALl(BooksToSave);
        System.out.println("=".repeat(50));

        System.out.println("list of all saved books");
for(Book response:responses){
    System.out.println(response);
}

        //The book to save
        Book book=new Book("10","harry potter",
                100,java.sql.Date.valueOf("2022-09-20"),
                new Author("10"),"ROMANCE");
        System.out.println("=".repeat(50));
        System.out.println(bookCrudOperations.save(book));


        //the book to delete
        Book bookToDelete=new Book("12");
        System.out.println("".repeat(30));
        System.out.println("this book is deleted succefully");
        System.out.println(bookCrudOperations.delete(bookToDelete));




    }


}