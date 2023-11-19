package Repository;

import java.lang.reflect.Type;
import java.util.List;

public interface CurdOperations<T>{
    public List<T> findALL();
    public List<T> saveALl(List<T> toSave);
    public T save(T toSave);
    public T delete(T toDelete);

}
