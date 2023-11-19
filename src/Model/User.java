package Model;

public class User {
    String reference;
    String name;

    public User(String reference, String name) {
        this.reference = reference;
        this.name = name;
    }

    public String getReference() {
        return reference;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "reference='" + reference + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
