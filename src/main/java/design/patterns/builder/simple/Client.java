package design.patterns.builder.simple;

public class Client {
    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.setName("Randheer");
        builder.setAge(30);
        builder.setBatch("Morning");
        builder.setGradeYear(2024);
        Student student = new Student(builder);
        assert student != null;
    }
}
