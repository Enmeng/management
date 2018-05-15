package scau.aotu.base;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;
import java.io.FileNotFoundException;

/**
 * Created by cyl on 2017/2/24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/spring/spring.xml")
public class BaseTest {
    @Before
    public void before() {
        try {
            Log4jConfigurer.initLogging("classpath:config/log/log4j.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
