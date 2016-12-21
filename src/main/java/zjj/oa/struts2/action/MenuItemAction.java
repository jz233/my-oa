package zjj.oa.struts2.action;

import com.opensymphony.xwork2.ActionContext;
import org.springframework.stereotype.Controller;
import zjj.oa.domain.menu.MenuItem;
import zjj.oa.service.MenuItemService;

import javax.annotation.Resource;
import java.util.Collection;

@Controller("menuItemAction")
public class MenuItemAction extends BaseAction<MenuItem>{

    @Resource(name = "menuItemService")
    private MenuItemService menuItemService;


    public String showAllMenuItems() {
        Collection<MenuItem> menuItems = this.menuItemService.getAllMenuItems();
        ActionContext.getContext().getValueStack().push(menuItems);

        return SUCCESS;
    }

    public String showMenuItemsByPid() {
        Collection<MenuItem> itemsList = this.menuItemService.getMenuItemsByPid(this.getModel().getPid());
        ActionContext.getContext().getValueStack().push(itemsList);
        return SUCCESS;
    }
}
