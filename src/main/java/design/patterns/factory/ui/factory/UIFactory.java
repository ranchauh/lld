package design.patterns.factory.ui.factory;

import design.patterns.factory.ui.components.button.Button;
import design.patterns.factory.ui.components.menu.Menu;

public interface UIFactory {
    Button createButton();
    Menu createMenu();
}
