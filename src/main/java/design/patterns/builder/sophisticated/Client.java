package design.patterns.builder.sophisticated;

public class Client {
    public static void main(String[] args) {
        Student student = Student.getBuilder()
                .setName("Randheer")
                .setAge(30)
                .setBatch("Morning")
                .setGradeYear(2020)
                .build();
        assert student != null;
    }
}
