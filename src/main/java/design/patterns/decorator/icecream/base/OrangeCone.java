package design.patterns.decorator.icecream.base;

import design.patterns.decorator.icecream.Icecream;

public class OrangeCone implements Icecream {
    private Icecream icecream;

    private double cost = 10;

    public OrangeCone() {}

    public OrangeCone(Icecream icecream) {
        this.icecream = icecream;
    }

    @Override
    public double getCost() {
        if(this.icecream != null) {
            return this.icecream.getCost() + this.cost;
        }
        return 0;
    }

    @Override
    public String getDescription() {
        String description = " orange cone";
        if(this.icecream != null) {
            return this.icecream.getDescription() + description;
        }
        return description;
    }

}
