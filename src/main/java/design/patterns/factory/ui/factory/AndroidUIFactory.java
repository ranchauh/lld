package design.patterns.factory.ui.factory;

import design.patterns.factory.ui.components.button.AndroidButton;
import design.patterns.factory.ui.components.button.Button;
import design.patterns.factory.ui.components.menu.AndroidMenu;
import design.patterns.factory.ui.components.menu.Menu;

public class AndroidUIFactory implements UIFactory {

    @Override
    public Button createButton() {
        return new AndroidButton();
    }

    @Override
    public Menu createMenu() {
        return new AndroidMenu();
    }
}
