package design.patterns.singleton.logger;

import java.io.File;

public class LoggerImpl implements Logger {

    public static LoggerImpl object;

    private File logFile;

    private String logFilePath;

    private LoggerImpl() {

    }

    @Override
    public void log(LogLevel level, String message) {

    }

    @Override
    public void setLogFile(String filePath) {
        this.logFilePath = filePath;

    }

    @Override
    public String getLogFile() {
        return logFilePath;
    }

    @Override
    public void flush() {

    }

    @Override
    public void close() {

    }

    public static Logger getInstance() {
        if(object == null) {
            synchronized(LoggerImpl.class) {
                if(object == null ) {
                    object = new LoggerImpl();
                }
            }

        }
        return object;
    }


    public static void resetInstance() {
        synchronized(LoggerImpl.class) {
            object = null;
        }
    }


}
