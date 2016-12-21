package zjj.oa.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.lang.reflect.ParameterizedType;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

    private T t ;
    public T getModel() {
        return this.t;
    }

    public BaseAction(){
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        Class cls = (Class) type.getActualTypeArguments()[0];
        try {
            this.t = (T) cls.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static final String LISTACTION = "listAction";
    public static final String UPDATE_UI = "updateUI";
    public static final String ADD_UI = "addUI";
    public static final String ACTION2ACTION = "action2action";


    public String listAction = LISTACTION;
    public String updateUI = UPDATE_UI;
    public String addUI = ADD_UI;
    public String action2action = ACTION2ACTION;

}
