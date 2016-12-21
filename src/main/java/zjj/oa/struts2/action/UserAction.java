package zjj.oa.struts2.action;

import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import zjj.oa.domain.system.Department;
import zjj.oa.domain.system.Role;
import zjj.oa.domain.system.User;
import zjj.oa.service.DepartmentService;
import zjj.oa.service.RoleService;
import zjj.oa.service.UserService;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Set;

@Controller("userAction")
@Scope(value = "prototype")
public class UserAction extends BaseAction<User> {

    @Resource(name = "userService")
    private UserService userService;
    @Resource(name = "roleService")
    private RoleService roleService;
    @Resource(name = "departmentService")
    private DepartmentService departmentService;

    /**
     * 获取涉及多个表的信息
     * 模型驱动 + 属性驱动
     */
    private Long did;
    private Long[] rids;

    public Long getDid() {
        return did;
    }

    public Long[] getRids() {
        return rids;
    }

    public void setDid(Long did) {
        this.did = did;
    }

    public void setRids(Long[] rids) {
        this.rids = rids;
    }

    public String showAllUsers() {
        Collection<User> users = this.userService.getAllUsers();
        ActionContext.getContext().put("users", users);
        return listAction;
    }

    public String addUI() {
        Collection<Department> departments = this.departmentService.getAllDepartments();
        Collection<Role> roles = this.roleService.getAllRoles();
        ActionContext.getContext().put("departments", departments);
        ActionContext.getContext().put("roles", roles);
        return addUI;
    }

    public String add() {
        User user = new User();
        BeanUtils.copyProperties(this.getModel(), user);
        Department dept = this.departmentService.getDepartmentById(this.did);
        Set<Role> roles = this.roleService.getRolesByIds(rids);
        user.setDepartment(dept);
        user.setRoles(roles);
        this.userService.saveUser(user);

        return action2action;
    }

    public String updateUI() {
        User user = this.userService.getUserById(this.getModel().getUid());
        ActionContext.getContext().getValueStack().push(user);

        //赋值本Action类中已定义的did属性(属性驱动)，用于修改user时的数据回显
        this.did = user.getDepartment().getDid();

        Set<Role> roles = user.getRoles();
        this.rids = new Long[roles.size()];
        int index = 0;
        for (Role role : roles) {
            this.rids[index] = role.getRid();
            index++;
        }

        Collection<Department> departments = this.departmentService.getAllDepartments();
        Collection<Role> allRoles = this.roleService.getAllRoles();
        ActionContext.getContext().put("departments", departments);
        ActionContext.getContext().put("roles", allRoles);

        return updateUI;
    }

    public String update() {
        User user = this.userService.getUserById(this.getModel().getUid());
        BeanUtils.copyProperties(this.getModel(), user);

        Department department = this.departmentService.getDepartmentById(this.did);
        Set<Role> roles = this.roleService.getRolesByIds(this.rids);
        user.setDepartment(department);
        user.setRoles(roles);

        this.userService.updateUser(user);

        return action2action;
    }

    public String delete() {
        this.userService.deleteUser(this.getModel().getUid());

        return action2action;
    }

}
