package design.patterns.prototype;

import java.util.logging.Logger;

public class IntelligentStudent extends Student {
    private double iq;


    public IntelligentStudent() {
        super();
    }

    public IntelligentStudent(Student student) {
        super(student);
    }

    public IntelligentStudent(IntelligentStudent student) {
        super(student);
        this.iq = student.iq;
    }

    public void setIq(double iq) {
        this.iq = iq;
    }

    public double getIq() {
        return iq;
    }

    @Override
    public IntelligentStudent clone() {
        return new IntelligentStudent(this);
    }
}
