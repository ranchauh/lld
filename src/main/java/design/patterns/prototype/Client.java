package design.patterns.prototype;

import java.util.Objects;

public class Client {
    private static void fillRegistry(Registry registry) {
        Student prototype = Student.builder()
                .setBatch("Morning")
                .setAvgBatchPsp(65.0)
                .build();
        registry.add(StudentPrototypeEnum.MORNING_BATCH, prototype);

        IntelligentStudent iPrototype = new IntelligentStudent(prototype);
        iPrototype.setIq(60);
        registry.add(StudentPrototypeEnum.MORNING_BATCH_INTELLIGENT, iPrototype);
    }

    public static void main(String[] args) {
        Registry registry = Registry.getInstance();
        fillRegistry(registry);

        Student student1 = registry.get(StudentPrototypeEnum.MORNING_BATCH).clone();
        assert Objects.equals(student1.getBatch(), "Morning");
        assert student1.getAvgBatchPsp() == 65.0;

        Student iStudent = registry.get(StudentPrototypeEnum.MORNING_BATCH_INTELLIGENT).clone();
        assert Objects.equals(iStudent.getBatch(), "Morning");
        assert iStudent.getAvgBatchPsp() == 65.0;
        assert ((IntelligentStudent) student1).getIq() == 60;
    }
}
