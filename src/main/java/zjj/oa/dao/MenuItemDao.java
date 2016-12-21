package zjj.oa.dao;

import zjj.oa.dao.base.BaseDao;
import zjj.oa.domain.menu.MenuItem;

import java.util.Collection;

public interface MenuItemDao extends BaseDao<MenuItem> {

    Collection<MenuItem> getMenuItemsByPid(Long pid);


}
