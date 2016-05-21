import com.manchey.service.UserServiceI;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Ray on 2016/5/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class TestSpring {

    @Autowired
    private UserServiceI userService;

    @Test
    public void test01() {
//        userService.findUserByName("raykr");
    }
}
