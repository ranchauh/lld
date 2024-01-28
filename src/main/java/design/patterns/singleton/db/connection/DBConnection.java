package design.patterns.singleton.db.connection;

public class DBConnection {
    private static volatile DBConnection dbc;

    private String url;
    private String username;
    private String password;
    private DBConnection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static DBConnection getInstance(String url, String username, String password) {
        if(dbc == null) {
            synchronized (DBConnection.class) {
                if(dbc == null) {
                    dbc = new DBConnection(url, username, password);
                }
            }
        }
        return dbc;
    }
}



