package design.patterns.decorator.icecream;

import design.patterns.decorator.icecream.base.ChocolateCone;
import design.patterns.decorator.icecream.base.OrangeCone;

public class Client {
    public static void main(String[] args) {
        Icecream ic = new OrangeCone();
        ic = new ChocoSyrup(ic);
        ic = new ChocolateCone(ic);
        ic = new VanillaFilling(ic);
        ic = new ButterScotchFilling(ic);

        System.out.println(ic.getCost());
        System.out.println(ic.getDescription());
    }
}
