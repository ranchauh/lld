package design.patterns.singleton.db.connection;

public class Main {
    DBConnection dbConnection = DBConnection.getInstance("url", "username", "password");
}
