import dao.UserDAO;
import model.User;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class DataBaseTest {
    @Test
    public void dataBaseCheck() throws SQLException, ClassNotFoundException {
        User expectedUser = new User();
        expectedUser.setFirstName("Dmitry");
        expectedUser.setLatName("Tester");
        expectedUser.setLatName("tester@test.lv");

        UserDAO userDAO = new UserDAO();
        userDAO.saveUser(expectedUser);
    }
}
