package design.patterns.factory.ui.components.menu;

public class IOSMenu implements Menu {
    @Override
    public void checkMenu() {
        System.out.println("Android Menu");
    }
}
