package Model;

public class Visitor extends User{
    public Visitor(String reference, String name) {
        super(reference, name);
    }
    public Visitor(String reference){
        super(reference,"");
    }

}
