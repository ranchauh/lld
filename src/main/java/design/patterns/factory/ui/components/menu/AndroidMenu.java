package design.patterns.factory.ui.components.menu;

import design.patterns.factory.ui.components.button.Button;

public class AndroidMenu implements Menu {
    @Override
    public void checkMenu() {
        System.out.println("Android Menu");
    }
}
