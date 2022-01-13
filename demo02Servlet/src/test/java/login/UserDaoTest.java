package login;

import login.dao.UserDao;
import login.domain.User;
import org.junit.jupiter.api.Test;

public class UserDaoTest {
    @Test
    public void testLogin() {
        User loginUser = new User();
        loginUser.setUsername("superuser");
        loginUser.setPassword("123456");

        UserDao dao = new UserDao();
        User user = dao.login(loginUser);
        System.out.println(user);
    }
}
