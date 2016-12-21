package zjj.oa.service;

import zjj.oa.domain.menu.MenuItem;

import java.util.Collection;

public interface MenuItemService {

    Collection<MenuItem> getAllMenuItems();

    Collection<MenuItem> getMenuItemsByPid(Long pid);


}
