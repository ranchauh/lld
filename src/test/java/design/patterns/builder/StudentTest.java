package design.patterns.builder;

import design.patterns.builder.sophisticated.Student;
import org.junit.Assert;
import org.junit.Test;

public class StudentTest {
    @Test
    public void testStudent() {
        Student student = Student.getBuilder()
                .setName("Randheer")
                .setAge(30)
                .setBatch("Morning")
                .setGradeYear(2020)
                .build();
        Assert.assertNotNull(student);
        Assert.assertEquals(student.getAge(), 30);
        Assert.assertEquals(student.getName(), "Randheer");
        Assert.assertEquals(student.getBatch(), "Morning");
        Assert.assertEquals(student.getGradeYear(), 2020);
    }
}
