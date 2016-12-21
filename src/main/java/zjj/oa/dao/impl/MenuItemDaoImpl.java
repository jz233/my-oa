package zjj.oa.dao.impl;

import org.springframework.stereotype.Repository;
import zjj.oa.dao.MenuItemDao;
import zjj.oa.dao.base.impl.BaseDaoImpl;
import zjj.oa.domain.menu.MenuItem;

import java.util.Collection;

@Repository("menuItemDao")
public class MenuItemDaoImpl extends BaseDaoImpl<MenuItem> implements MenuItemDao{

    public Collection<MenuItem> getMenuItemsByPid(Long pid) {

        return this.hibernateTemplate.find("FROM MenuItem WHERE pid = ?", pid);
    }
}
