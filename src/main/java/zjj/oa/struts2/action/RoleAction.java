package zjj.oa.struts2.action;

import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import zjj.oa.domain.system.Role;
import zjj.oa.service.RoleService;

import javax.annotation.Resource;
import java.util.Collection;

@Controller("roleAction")
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {

    @Resource(name = "roleService")
    private RoleService roleService;

    public String showAllRoles() {
        Collection<Role> roles = this.roleService.getAllRoles();
        ActionContext.getContext().put("roles", roles);
        return listAction;
    }

    public String addUI() {
        return addUI;
    }

    public String updateUI() {
        Role role = this.roleService.getRoleById(this.getModel().getRid());
        ActionContext.getContext().getValueStack().push(role);
        return updateUI;
    }

    public String add() {
        Role role = new Role();
        BeanUtils.copyProperties(this.getModel(), role);
        this.roleService.addRole(role);
        return action2action;
    }

    public String update() {
        Role role = this.roleService.getRoleById(this.getModel().getRid());
        BeanUtils.copyProperties(this.getModel(), role);
        this.roleService.updateRole(role);
        return action2action;
    }

    /**
     * 用户和岗位多对多， 两者都可以维护关系，效果相同
     * 所以删除时自动维护了关系
     * @return
     */
    public String delete() {
        this.roleService.deleteRoleById(this.getModel().getRid());
        return action2action;
    }




}
