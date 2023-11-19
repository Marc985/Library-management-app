package Model;
import DBConnection.ConnectionDB;
public class Author {

   private String id;
   private String name;
   private String sex;



    public Author(String id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }
    public Author(String id){
        this.id=id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }
    public  String getId(){
        return id;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
