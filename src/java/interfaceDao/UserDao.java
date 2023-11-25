package interfaceDao;


import java.util.List;
import model.User;


public interface UserDao {
    



    void create(User p);
    
    void update(User p);
    
    void delete(int id);

    List<User> findAll();

    User findById(int id);
    User findByUserName(String userName);
}
