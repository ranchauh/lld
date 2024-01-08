package design.patterns.factory.ui.factory;

import design.patterns.factory.ui.components.button.AndroidButton;
import design.patterns.factory.ui.components.button.Button;
import design.patterns.factory.ui.components.button.IOSButton;
import design.patterns.factory.ui.components.menu.AndroidMenu;
import design.patterns.factory.ui.components.menu.IOSMenu;
import design.patterns.factory.ui.components.menu.Menu;

public class IOSUIFactory implements UIFactory {

    @Override
    public Button createButton() {
        return new IOSButton();
    }

    @Override
    public Menu createMenu() {
        return new IOSMenu();
    }
}
