package zjj.oa.dao.impl;

import org.springframework.stereotype.Repository;
import zjj.oa.dao.base.impl.BaseDaoImpl;
import zjj.oa.domain.system.Department;
import zjj.oa.dao.DepartmentDao;


/**
 * 注解形式无法注入HibernateDaoSupport(官方源码不可修改)类中的sessionFactory属性
 */
@Repository("departmentDao")
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao {

}
