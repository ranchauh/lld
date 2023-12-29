package design.patterns.singleton;

public class Main {
    DBConnection dbConnection = DBConnection.getInstance("url", "username", "password");
}
