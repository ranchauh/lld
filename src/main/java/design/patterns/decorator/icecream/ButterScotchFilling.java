package design.patterns.decorator.icecream;

public class ButterScotchFilling implements Icecream {
    private Icecream icecream;

    private double cost = 5;

    public ButterScotchFilling(Icecream icecream) {
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
        String description = " butter scotch";
        if(this.icecream != null) {
            return this.icecream.getDescription() + description;
        }
        return description;
    }

}
