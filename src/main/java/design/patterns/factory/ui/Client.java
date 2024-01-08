package design.patterns.factory.ui;

import design.patterns.factory.ui.components.button.Button;
import design.patterns.factory.ui.components.menu.Menu;
import design.patterns.factory.ui.factory.UIFactory;

public class Client {

    public static void main(String[] args) {
        Flutter flutter = new Flutter();
        UIFactory uiFactory = flutter.getUIFactory(UIPlatform.IOS);

        Button b = uiFactory.createButton();
        Menu m = uiFactory.createMenu();

        b.click();
        m.checkMenu();
    }
}
