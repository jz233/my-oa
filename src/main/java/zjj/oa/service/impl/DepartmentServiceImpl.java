package zjj.oa.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zjj.oa.domain.system.Department;
import zjj.oa.dao.DepartmentDao;
import zjj.oa.service.DepartmentService;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;

/**
 * 注意涉及到事务的方法要加注解@Transactional(readOnly = false)
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService{

    @Resource(name = "departmentDao")
    private DepartmentDao departmentDao;


    public Collection<Department> getAllDepartments() {
        return this.departmentDao.getAllEntities();
    }

    public Department getDepartmentById(Serializable id) {
        return this.departmentDao.getEntityById(id);
    }

    @Transactional(readOnly = false)
    public void saveDepartment(Department department) {
        this.departmentDao.saveEntity(department);
    }

    @Transactional(readOnly = false)
    public void updateDepartment(Department department) {
        this.departmentDao.updateEntity(department);
    }

    @Transactional(readOnly = false)
    public void deleteDepartment(Serializable id) {
        this.departmentDao.deleteEntity(id);
    }
}
