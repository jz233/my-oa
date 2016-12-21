package zjj.oa.service;

import zjj.oa.domain.system.Role;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

public interface RoleService {

    Collection<Role> getAllRoles();

    void updateRole(Role role);

    void addRole(Role role);

    void deleteRoleById(Serializable id);

    Role getRoleById(Serializable id);

    Set<Role> getRolesByIds(Serializable[] ids);
}
