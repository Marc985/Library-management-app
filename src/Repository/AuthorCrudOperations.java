package Repository;

import DBConnection.ConnectionDB;
import Model.Author;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.function.ToDoubleBiFunction;

public class AuthorCrudOperations implements CurdOperations<Author> {

    @Override
    public List<Author> findALL() {
        List<Author> authors=new ArrayList<>();
    try {
        String sql="select * from author";
        PreparedStatement preparedStatement= ConnectionDB
                .getInstance().Database().prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            authors.add(
                    new Author(
                            resultSet.getString("id_author"),
                            resultSet.getString("name"),
                            resultSet.getString("sex")
                    )
            );

        }
    }catch (Exception e){
        e.printStackTrace();
    }

        return authors;
    }

    @Override
    public List<Author> saveALl(List<Author> toSave) {
        String sql="insert into author (id_author,name,sex) values (?,?,?) " +
                "on conflict(id_author) do update " +
                "set name=EXCLUDED.name,sex=EXCLUDED.sex";

            try {
                PreparedStatement preparedStatement=ConnectionDB
                        .getInstance().Database().prepareStatement(sql);

                for(Author author: toSave){
                    preparedStatement.setString(1,author.getId());
                    preparedStatement.setString(2,author.getName());
                    preparedStatement.setString(3,author.getSex());
                    preparedStatement.addBatch();
                }
                preparedStatement.executeBatch();
            }
            catch (Exception e){
                e.printStackTrace();
            }

        return toSave;
    }

    @Override
    public Author save(Author toSave) {
        String sql="insert into author (id_author,name,sex) values (?,?,?) " +
                "on conflict(id_author) do update " +
                "set name=EXCLUDED.name,sex=EXCLUDED.sex";

        try {
           PreparedStatement preparedStatement= ConnectionDB.
                   getInstance().Database().prepareStatement(sql);
           preparedStatement.setString(1,toSave.getId());
           preparedStatement.setString(2,toSave.getName());
           preparedStatement.setString(3,toSave.getSex());
           preparedStatement.executeUpdate();
            System.out.println("inserted succefully");
        }catch (Exception e){
            e.printStackTrace();
        }
        return toSave;
    }

    @Override
    public Author delete(Author toDelete) {
        String sql="delete from author where id_author=?";
        try {
            PreparedStatement preparedStatement=ConnectionDB
                    .getInstance().Database().prepareStatement(sql);
            preparedStatement.setString(1,toDelete.getId());
            preparedStatement.executeQuery();
         


        }catch (Exception e){
            e.printStackTrace();
        }

        return toDelete;
    }
}
