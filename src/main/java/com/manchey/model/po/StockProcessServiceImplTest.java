package com.manchey.model.po;

import com.manchey.service.IStockProcessService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Ray on 2016/5/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class StockProcessServiceImplTest {

    @Autowired
    private IStockProcessService service;

//    @Before
//    public void before() {
//        String configLocation = "spring-config.xml";
//        ApplicationContext ac = new ClassPathXmlApplicationContext(configLocation);
//
//        service = (IStockProcessService) ac.getBean("stockService");
//        System.out.println("service = " +service);
//    }

    @Test
    public void openAccount() throws Exception {
        System.out.println(service);
        service.openAccount("王小二aa", 600);
    }

    @Test
    public void openStock() throws Exception {
        service.openStock("王者", 10);
    }

    @Test
    public void buyStock() throws Exception {
        service.buyStock("王小二", 230, "王者", 4);
    }

}