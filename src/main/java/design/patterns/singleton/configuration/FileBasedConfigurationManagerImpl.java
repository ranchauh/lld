package design.patterns.singleton.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager {

    private static FileBasedConfigurationManagerImpl object;

    private FileBasedConfigurationManagerImpl() {
        super();
    }

    @Override
    public String getConfiguration(String key) {
        return this.getProperties().getProperty(key);
    }

    @Override
    public <T> T getConfiguration(String key, Class<T> type) {
        String value = this.getProperties().getProperty(key);
        if(value == null) {
            return (T) value;
        }
        return this.convert(value, type);
    }

    @Override
    public void setConfiguration(String key, String value) {
        this.getProperties().setProperty(key, value);
    }

    @Override
    public <T> void setConfiguration(String key, T value) {
        this.getProperties().setProperty(key, String.valueOf(value));
    }

    @Override
    public void removeConfiguration(String key) {
        this.getProperties().remove(key);
    }

    @Override
    public void clear() {
        this.getProperties().clear();
    }

    public static FileBasedConfigurationManager getInstance() {
        if(object == null) {
            synchronized(FileBasedConfigurationManager.class) {
                if(object == null) {
                    object = new FileBasedConfigurationManagerImpl();
                }
            }
        }
        return object;
    }

    public static void resetInstance() {
        synchronized(FileBasedConfigurationManager.class) {
            object = null;
        }
    }

}
