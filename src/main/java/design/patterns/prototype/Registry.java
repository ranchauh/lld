package design.patterns.prototype;

import java.util.HashMap;
import java.util.Map;

public class Registry {
    private final Map<StudentPrototypeEnum, Student> registry = new HashMap<>();
    private static final Registry instance = new Registry();

    private Registry() {}

    public static  Registry getInstance() {
        return instance;
    }

    public void add(StudentPrototypeEnum key, Student student) {
        registry.put(key, student);
    }

    public Student get(StudentPrototypeEnum key) {
        return registry.get(key);
    }

    public void remove(StudentPrototypeEnum key) {
        registry.remove(key);
    }

}
