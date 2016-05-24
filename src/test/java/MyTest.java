import com.manchey.service.UserServiceI;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Ray on 2016/5/20.
 */
public class MyTest {

    private UserServiceI service;

    @Before
    public void before() {
        String configLocation = "spring-hibernate.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(configLocation);

        service = (UserServiceI) ac.getBean("userService");
    }

    @Test
    public void test1() {
        service.addUser("王小二", 600);
    }


}
