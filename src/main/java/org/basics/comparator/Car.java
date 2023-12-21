package org.basics.comparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Car implements Comparable {
    private int speed;
    private int power;
    public Car(int speed, int power){
        this.speed = speed;
        this.power = power;
    }

    @Override
    public String toString() {
        return "[S=" + this.speed + ", P=" + this.power + "]";
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Car) {
            return Integer.compare(this.speed, ((Car)o).speed);
        }
        return 0;
    }

    public static void main(String[] args) {
        List<Car> list = List.of(new Car(10, 20));
        Collections.sort(list, Comparator.comparingInt(c -> c.power));
    }
}