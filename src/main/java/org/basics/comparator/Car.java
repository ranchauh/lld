package org.basics.comparator;

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
}