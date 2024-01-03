package design.patterns.builder.simple;

public class Student {
    private String name;
    private int age;
    private String batch;
    private int gradeYear;

    public Student(Builder builder) {
        // validations
        if(builder.getGradeYear() > 2022) {
            throw new IllegalArgumentException("Grade Year can not be greater than 2022");
        }
        this.name = builder.getName();
        this.age = builder.getAge();
        this.batch = builder.getBatch();
        this.gradeYear = builder.getGradeYear();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public int getGradeYear() {
        return gradeYear;
    }

    public void setGradeYear(int gradeYear) {
        this.gradeYear = gradeYear;
    }
}
