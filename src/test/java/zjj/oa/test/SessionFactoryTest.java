package zjj.oa.test;

import org.junit.Test;
import zjj.oa.utils.SpringUtils;

public class SessionFactoryTest extends SpringUtils{

    @Test
    public void testSessionFactory() {
        context.getBean("sessionFactory");
    }
}
