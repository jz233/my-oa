package zjj.oa.dao.impl;

import org.springframework.stereotype.Repository;
import zjj.oa.dao.UserDao;
import zjj.oa.dao.base.impl.BaseDaoImpl;
import zjj.oa.domain.system.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
}
