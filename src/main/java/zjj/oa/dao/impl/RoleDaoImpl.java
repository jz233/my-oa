package zjj.oa.dao.impl;

import org.springframework.stereotype.Repository;
import zjj.oa.dao.RoleDao;
import zjj.oa.dao.base.impl.BaseDaoImpl;
import zjj.oa.domain.system.Role;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao{
}
