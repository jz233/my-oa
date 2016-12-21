package zjj.oa.struts2.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import zjj.oa.domain.system.Department;
import zjj.oa.service.DepartmentService;

import javax.annotation.Resource;
import java.util.Collection;


/**
 * 注意Struts2的Action是多例, 要加注解@Scope("prototype")
 */
@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department> {

    @Resource(name = "departmentService")
    private DepartmentService departmentService;


    /**
     * 方法名以get开头可能会有问题，用其他单词代替
     *
     * @return
     */
    public String showAllDepartments() {
        Collection<Department> departments = this.departmentService.getAllDepartments();
        /**
         * 可放入: 对象栈 OR map栈
         * 回显数据放到map栈中更好
         */
        //放入map栈
        ActionContext.getContext().put("departments", departments);
        //放入对象栈
//        ActionContext.getContext().getValueStack().push(departments);

        return listAction;
    }

    public String addUI() {
        return addUI;
    }

    public String add() {
        /**
         * 一般不把模型驱动传递到dao层
         */
//        this.departmentService.saveDepartment(this.getModel());
        Department department = new Department();
        BeanUtils.copyProperties(this.getModel(), department);
        //应创建一个新对象，将其传入dao层
        this.departmentService.saveDepartment(department);

        return action2action;
    }

    public String updateUI() {
        //根据模型驱动中得到的id 回显部门信息
        Department department = this.departmentService.getDepartmentById(getModel().getDid());
        ActionContext.getContext().getValueStack().push(department);

        return updateUI;
    }

    public String update() {
        /**
         * 注意要在修改部门页面中添加隐藏域hidden,因为跳转页面后原值栈消失,did随着原值栈一起消失,无法得到值
         * <s:hidden name="did"/>
         */
        Department department = this.departmentService.getDepartmentById(this.getModel().getDid());
        BeanUtils.copyProperties(this.getModel(), department);
        this.departmentService.updateDepartment(department);

        return action2action;
    }

    public String delete() {
        this.departmentService.deleteDepartment(this.getModel().getDid());
        return action2action;
    }

}
