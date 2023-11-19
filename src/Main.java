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
        System.out.println("=".repeat(50));
        Book book=new Book("11","harry potter",
                100,java.sql.Date.valueOf("2022-09-20"),
                new Author("11"),"ROMANCE");
        System.out.println("\t\t book saved succefully:");
        System.out.println(bookCrudOperations.save(book));


        //the book to delete
        System.out.println("=".repeat(50));
        System.out.println("this book is deleted succefully");
        System.out.println(bookCrudOperations.delete(book));


//Author Crud operation
        AuthorCrudOperations authorCrudOperations=new AuthorCrudOperations();
        //find all authros
       List<Author> authorsToFind = authorCrudOperations.findALL();
        System.out.println("\n\n"+"=".repeat(50)+"AUTHOR CRUD OPERATION"+"=".repeat(50));
        System.out.println("\n\t\tList of all authors:");
       for(Author author:authorsToFind){
           System.out.println(author);
       }
       //add multiple authros
        System.out.println("=".repeat(50)+"\n");
        System.out.println("\t\tsave multiple author");

        List<Author> authorsToSave=new ArrayList<>(Arrays.asList(
                new Author("10","Kiosaki","M"),
                new Author("11","James","M")
        ));
        List<Author> authorsSaved =authorCrudOperations.saveALl(authorsToSave);
        System.out.println("\n\t\tlist of saved author:");
        for(Author author:authorsSaved){
            System.out.println(author);
        }
        //add one author
        System.out.println("=".repeat(50)+"\n ");
        System.out.println("\t\tsave one author");
        Author author=new Author("10","Stephen King","M");
       Author savedAuthor= authorCrudOperations.save(author);
        System.out.println("author saved succefully");
        System.out.println(savedAuthor);

        //delete author
        System.out.println("=".repeat(50));
        System.out.println("author deleted succefully:");
        Author authorToDelete=new Author("10","Kiosaki","M");
        System.out.println(authorCrudOperations.delete(authorToDelete));


        //Visitor crud operation
        System.out.println("\n\n"+"=".repeat(50)+"VISITOR CRUD OPERATION"+"=".repeat(50));
        VisitorCrudOperations visitorCrudOperations=new VisitorCrudOperations();
        //visitors to save
        System.out.println("\t\tAll visitors saved succefully:");
        List<Visitor> visitorsTOSaved=new ArrayList<>(
                Arrays.asList(
                        new Visitor("STD22010","Jean"),
                        new Visitor("STD220010","Razaka")
                )
        );
        List<Visitor> savedVisitors= visitorCrudOperations.saveALl(visitorsTOSaved);
    for(Visitor visitor:savedVisitors){
        System.out.println(visitor);
    }
    //Save one visitor
        System.out.println("=".repeat(50));

        Visitor visitorToSave=new Visitor("STD22009","Bema");
    Visitor savedVisitor=visitorCrudOperations.save(visitorToSave);
    if(savedVisitor!=null){
        System.out.println("\t\tvisitor saved succefully");
        System.out.println(savedVisitor);
    }
        //find all visitors

        System.out.println("=".repeat(50));
        List<Visitor> allVisitors= visitorCrudOperations.findALL();
        if(allVisitors.size()!=0){
            System.out.println("\t\tList of all visitors");
            for (Visitor visitor:allVisitors){
                System.out.println(visitor);
            }
        }

        //delete one visitor
        System.out.println("=".repeat(50));
        System.out.println("\t\t visitor deleled succefully:");
        System.out.println(visitorCrudOperations.delete(visitorToSave));

    }


}