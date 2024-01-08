package design.patterns.factory.ui;

import design.patterns.factory.ui.factory.UIFactory;
import design.patterns.factory.ui.factory.UIFactoryFactory;

public class Flutter {
    public UIFactory getUIFactory(UIPlatform platform) {
        return UIFactoryFactory.getUIFactory(platform);
    }
}
