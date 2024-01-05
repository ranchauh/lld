package design.patterns.prototype;

public class Student implements Prototype<Student> {

    private String name;
    private int age;
    private double psp;
    private String batch;

    private double avgBatchPsp;
    private String companyName;

    Student() {}

    Student(Student student) {
        this.name = student.name;
        this.age = student.age;
        this.psp = student.psp;
        this.batch = student.batch;
        this.avgBatchPsp = student.avgBatchPsp;
        this.companyName = student.companyName;
    }

    private Student(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.psp = builder.psp;
        this.batch = builder.batch;
        this.avgBatchPsp = builder.avgBatchPsp;
        this.companyName = builder.companyName;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getPsp() {
        return psp;
    }

    public String getBatch() {
        return batch;
    }

    public double getAvgBatchPsp() {
        return avgBatchPsp;
    }

    public String getCompanyName() {
        return companyName;
    }

    @Override
    public Student clone() {
        return new Student(this);
    }

    public static class Builder {
        private String name;
        private String batch;
        private int age;
        private double psp;
        private String companyName;
        private double avgBatchPsp;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setBatch(String batch) {
            this.batch = batch;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setPsp(double psp) {
            this.psp = psp;
            return this;
        }

        public Builder setCompanyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Builder setAvgBatchPsp(double avgBatchPsp) {
            this.avgBatchPsp = avgBatchPsp;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
