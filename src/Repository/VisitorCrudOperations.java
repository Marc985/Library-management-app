package Repository;

import DBConnection.ConnectionDB;
import Model.Author;
import Model.Visitor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VisitorCrudOperations implements CurdOperations<Visitor> {
    @Override
    public List<Visitor> findALL() {
        List<Visitor> visitors=new ArrayList<>();
        try {
            String sql="select * from visitor";
            PreparedStatement preparedStatement= ConnectionDB
                    .getInstance().Database().prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                visitors.add(
                        new Visitor(
                               resultSet.getString("reference"),
                                resultSet.getString("name")
                        )
                );


            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return visitors;
    }

    @Override
    public List<Visitor> saveALl(List<Visitor> toSave) {
        String sql="insert into visitor (reference,name) values (?,?) " +
                "on conflict(reference) do update " +
                "set name=EXCLUDED.name";
        try {
            PreparedStatement preparedStatement=ConnectionDB
                    .getInstance().Database().prepareStatement(sql);
            for(Visitor visitor:toSave){
                preparedStatement.setString(1,visitor.getReference());
                preparedStatement.setString(2,visitor.getName());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        }catch (Exception e){
            e.printStackTrace();
        }
        return toSave;
    }

    @Override
    public Visitor save(Visitor toSave) {
        String sql="insert into visitor (reference,name) values (?,?) " +
                "on conflict(reference) do update " +
                "set name=EXCLUDED.name";
        try {
            PreparedStatement preparedStatement=ConnectionDB
                    .getInstance().Database().prepareStatement(sql);
            preparedStatement.setString(1,toSave.getReference());
            preparedStatement.setString(2,toSave.getName());
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return toSave;
    }

    @Override
    public Visitor delete(Visitor toDelete) {
        String sql="delete from visitor where reference=?";
        try {
            PreparedStatement preparedStatement=ConnectionDB
                    .getInstance().Database().prepareStatement(sql);
            preparedStatement.setString(1,toDelete.getReference());
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return toDelete;
    }
}
