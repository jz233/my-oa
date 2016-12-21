package zjj.oa.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zjj.oa.dao.RoleDao;
import zjj.oa.domain.system.Role;
import zjj.oa.service.RoleService;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Resource(name = "roleDao")
    private RoleDao roleDao;

    public Collection<Role> getAllRoles() {
        return this.roleDao.getAllEntities();
    }

    @Transactional(readOnly = false)
    public void updateRole(Role role) {
        this.roleDao.updateEntity(role);
    }

    @Transactional(readOnly = false)
    public void addRole(Role role) {
        this.roleDao.saveEntity(role);
    }

    @Transactional(readOnly = false)
    public void deleteRoleById(Serializable id) {
        this.roleDao.deleteEntity(id);
    }

    public Role getRoleById(Serializable id) {
        return this.roleDao.getEntityById(id);
    }

    public Set<Role> getRolesByIds(Serializable[] ids) {
        return this.roleDao.getEntitiesByIds(ids);
    }

}
