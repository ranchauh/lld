package design.patterns.builder.sophisticated;

public class Student {
    private String name;
    private int age;
    private String batch;
    private int gradeYear;

    private Student(Builder builder) {
        // validations
        if(builder.gradeYear > 2022) {
            throw new IllegalArgumentException("Grade Year can not be greater than 2022");
        }
        this.name = builder.name;
        this.age = builder.age;
        this.batch = builder.batch;
        this.gradeYear = builder.gradeYear;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBatch() {
        return batch;
    }

    public int getGradeYear() {
        return gradeYear;
    }

    public static class Builder {
        private String name;
        private int age;
        private String batch;
        private int gradeYear;

        public Student build() {
            return new Student(this);
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setBatch(String batch) {
            this.batch = batch;
            return this;
        }

        public Builder setGradeYear(int gradeYear) {
            this.gradeYear = gradeYear;
            return this;
        }
    }
}
