package design.patterns.singleton.db.connection;

public class DBConnectionSimple {

    private String url;
    private String username;
    private String password;
    private DBConnectionSimple() {
    }

    private static final class DbcHolder {
        private static final DBConnectionSimple dbc = new DBConnectionSimple();
    }

    public static DBConnectionSimple getInstance() {
        return DbcHolder.dbc;
    }
}



