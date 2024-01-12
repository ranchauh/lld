package design.patterns.decorator.icecream.base;

import design.patterns.decorator.icecream.Icecream;

public class ChocolateCone implements Icecream {
    private Icecream icecream;

    private double cost = 20;

    public ChocolateCone() {}

    public ChocolateCone(Icecream icecream) {
        this.icecream = icecream;
    }

    @Override
    public double getCost() {
        if(this.icecream != null) {
            return this.icecream.getCost() + this.cost;
        }
        return this.cost;
    }

    @Override
    public String getDescription() {
        String description = " chocolate cone";
        if(this.icecream != null) {
            return this.icecream.getDescription() + description;
        }
        return description;
    }

}
