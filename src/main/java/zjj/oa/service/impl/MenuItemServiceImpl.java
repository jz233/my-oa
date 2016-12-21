package zjj.oa.service.impl;

import org.springframework.stereotype.Service;
import zjj.oa.dao.MenuItemDao;
import zjj.oa.domain.menu.MenuItem;
import zjj.oa.service.MenuItemService;

import javax.annotation.Resource;
import java.util.Collection;

@Service("menuItemService")
public class MenuItemServiceImpl implements MenuItemService {

    @Resource(name = "menuItemDao")
    private MenuItemDao menuItemDao;

    public Collection<MenuItem> getAllMenuItems() {
        return menuItemDao.getAllEntities();
    }

    public Collection<MenuItem> getMenuItemsByPid(Long pid) {
        return menuItemDao.getMenuItemsByPid(pid);
    }
}
