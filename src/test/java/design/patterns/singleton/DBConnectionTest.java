package design.patterns.singleton;

import design.patterns.singleton.db.connection.DBConnection;
import org.junit.Test;
import org.testng.AssertJUnit;

public class DBConnectionTest {
    @Test
    public void getInstanceTest() {
        DBConnection dbc1 = DBConnection.getInstance("url", "username", "password");
        DBConnection dbc2 = DBConnection.getInstance("url", "username", "password");
        DBConnection dbc3 = DBConnection.getInstance("url", "username", "password");
        AssertJUnit.assertEquals(dbc1, dbc2);
        AssertJUnit.assertEquals(dbc2, dbc3);
    }
}
