package zjj.oa.test;

import org.junit.Test;
import zjj.oa.domain.system.Department;
import zjj.oa.service.DepartmentService;
import zjj.oa.struts2.action.DepartmentAction;
import zjj.oa.utils.SpringUtils;

import java.util.Collection;

public class DepartmentTest extends SpringUtils {

    @Test
    public void testSave() {
        DepartmentService service = (DepartmentService) context.getBean("departmentService");
        Department department = new Department();
        department.setName("开发部");
        department.setDescription("开发云");
        service.saveDepartment(department);

    }
    @Test
    public void testGetOne() {
        DepartmentService service = (DepartmentService) context.getBean("departmentService");
        Collection<Department> allDepartments = service.getAllDepartments();
        System.out.println(allDepartments.size());
    }

    @Test
    public void testDeptAction() {
        DepartmentAction action = (DepartmentAction) context.getBean("departmentAction");
        action.showAllDepartments();
    }
}
