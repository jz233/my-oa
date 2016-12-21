package zjj.oa.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zjj.oa.dao.UserDao;
import zjj.oa.domain.system.User;
import zjj.oa.service.UserService;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource(name = "userDao")
    private UserDao userDao;

    public Collection<User> getAllUsers() {
        return this.userDao.getAllEntities();
    }

    @Transactional(readOnly = false)
    public void saveUser(User user) {
        this.userDao.saveEntity(user);
    }

    public User getUserById(Serializable id) {
        return this.userDao.getEntityById(id);
    }

    @Transactional(readOnly = false)
    public void updateUser(User user) {
        this.userDao.updateEntity(user);
    }

    @Transactional(readOnly = false)
    public void deleteUser(Serializable id) {
        this.userDao.deleteEntity(id);
    }
}
