import com.manchey.dao.impl.SimpleBean;
import com.manchey.service.OxmExampleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * Created by Ray on 2016/5/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring*.xml")
public class TestOXM {

    @Autowired
    private OxmExampleService oxmExampleService;

    @Autowired
    private SimpleBean simpleBean;

    @Test
    public void go() throws IOException {

        simpleBean.setAge(35);

        simpleBean.setExecutive(false);

        simpleBean.setJobDescription("Janitor");

        simpleBean.setName("Mister Jones");

        oxmExampleService.saveSimpleBean();

    }


}
