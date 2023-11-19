package Repository;

import DBConnection.ConnectionDB;
import Model.Author;
import Model.Book;
import Model.Visitor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookCrudOperations implements CurdOperations<Book>{

    @Override
    public List<Book> findALL() {

        String sql="  SELECT book.*,\n" +
                "            author.id_author AS author_id,\n" +
                "                    author.name AS author_name,\n" +
                "            author.sex AS author_sex\n" +
                "            FROM book\n" +
                "            INNER JOIN author ON author.id_author = book.id_author;";
        List<Book> books=new ArrayList<>();

        try {
            PreparedStatement preparedStatement= ConnectionDB
                    .getInstance().Database().prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Author author= new Author(
                        resultSet.getString("author_id"),
                        resultSet.getString("author_name"),
                        resultSet.getString("author_sex")
                );



                books.add(
                        new Book(
                                resultSet.getString("id_book"),
                                resultSet.getString("book_name"),
                                resultSet.getInt("page_numbers"),
                                resultSet.getDate("release_date"),
                                author,
                                resultSet.getString("topic")


                        )
                );
            }


        }catch (Exception e){
            e.printStackTrace();
        }

        return books;
    }

    @Override
    public List<Book> saveALl(List<Book> toSave) {
        //making the insert idempotent
        String sql="insert into book (id_book,book_name,page_numbers,release_date,topic,id_author) " +
                "values (?,?,?,?,?,?)" +
                "on conflict(id_book) do update " +
                "set book_name=EXCLUDED.book_name,page_numbers=EXCLUDED.page_numbers,release_date=EXCLUDED.release_date," +
                "id_author=EXCLUDED.id_author";
       try {
           PreparedStatement preparedStatement=ConnectionDB.getInstance()
                   .Database().prepareStatement(sql);
           for(Book book:toSave){
               preparedStatement.setString(1,book.getIdBook());
               preparedStatement.setString(2,book.getName());
               preparedStatement.setInt(3,book.getPageNumbers());
               preparedStatement.setDate(4,book.getReleaseDate());
                       preparedStatement.setString(5,book.getTopic());
               preparedStatement.setString(6,book.getAuthor().getId());
                preparedStatement.addBatch();
           }
           preparedStatement.executeBatch();
       }catch (Exception e){
           e.printStackTrace();
       }

        return toSave;

    }
    @Override
    public Book save(Book toSave) {
        String sql="insert into book (id_book,book_name,page_numbers,release_date,topic,id_author) " +
                "values (?,?,?,?,?,?)" +
                "on conflict(id_book) do update "+
                "set book_name=EXCLUDED.book_name,page_numbers=EXCLUDED.page_numbers,release_date=EXCLUDED.release_date," +
                "id_author=EXCLUDED.id_author";
        try {
            PreparedStatement preparedStatement=ConnectionDB
                    .getInstance().Database().prepareStatement(sql);
            preparedStatement.setString(1,toSave.getIdBook());
            preparedStatement.setString(2,toSave.getName());
            preparedStatement.setInt(3,toSave.getPageNumbers());
            preparedStatement.setDate(4,toSave.getReleaseDate());
            preparedStatement.setString(5,toSave.getTopic());
            preparedStatement.setString(6,toSave.getAuthor().getId());
          int Result= preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return toSave;
    }

    @Override
    public Book delete(Book toDelete) {
        String sql="delete from book where id_book=?";
        try {
            PreparedStatement preparedStatement=ConnectionDB
                    .getInstance().Database().prepareStatement(sql);
            preparedStatement.setString(1,toDelete.getIdBook());
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return toDelete;
    }
}
