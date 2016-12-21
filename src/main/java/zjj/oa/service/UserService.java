package zjj.oa.service;

import zjj.oa.domain.system.User;

import java.io.Serializable;
import java.util.Collection;

public interface UserService {

    Collection<User> getAllUsers();

    void saveUser(User user);

    User getUserById(Serializable id);

    void updateUser(User user);

    void deleteUser(Serializable id);

}
