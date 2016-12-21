package zjj.oa.service;


import zjj.oa.domain.system.Department;

import java.io.Serializable;
import java.util.Collection;

public interface DepartmentService {
    Collection<Department> getAllDepartments();

    Department getDepartmentById(Serializable id);

    void saveDepartment(Department department);

    void updateDepartment(Department department);

    void deleteDepartment(Serializable id);

}
