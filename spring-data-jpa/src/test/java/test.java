import com.luffy.data.dao.UserDao;
import com.luffy.data.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/12/27 10:33
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class test {


    @Autowired
    UserDao userDao;

    @Test
    public void test1(){
         User user1 = new User();
        user1.setAge(111);
        user1.setName("1111");
        userDao.save(user1);
        List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }
}
