package design.patterns.factory.ui;

import design.patterns.factory.ui.factory.AndroidUIFactory;
import design.patterns.factory.ui.factory.IOSUIFactory;
import design.patterns.factory.ui.factory.UIFactory;

public enum UIPlatform {
    ANDROID,
    IOS;

    public UIFactory getUIFactory() {
        switch (this) {
            case IOS -> {
                return new IOSUIFactory();
            }
            case ANDROID -> {
                return new AndroidUIFactory();
            }
        }
        throw new RuntimeException("Unsupported platform");
    }
}
