package design.patterns.factory.ui.factory;

import design.patterns.factory.ui.UIPlatform;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.util.Map;

public class UIFactoryFactory {

    private static final Map<UIPlatform, UIFactory> UI_FACTORY_MAP = Map.of(
            UIPlatform.IOS, new IOSUIFactory(),
            UIPlatform.ANDROID, new AndroidUIFactory()
    );

    public static UIFactory getUIFactory(UIPlatform platform) {
        if(UI_FACTORY_MAP.containsKey(platform)) {
            return UI_FACTORY_MAP.get(platform);
        } else {
            throw new RuntimeException("Unsupported platform");
        }
    }
}
