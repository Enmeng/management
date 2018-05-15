package scau.aotu;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import scau.aotu.base.BaseTest;
import scau.aotu.business.entity.User;
import scau.aotu.business.service.IUserService;

/**
 * Created by cyl on 2017/2/24
 */
public class UserTest extends BaseTest {

    @Autowired
    private IUserService userService;

    @Test
    public void addUserTest() throws Exception {
//        User user = new User("cyl");
//        userService.add(user);
    }

}
