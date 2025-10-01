public class RT {



    public static void main(String[] args) {
        Logger.getInstance().log();
        Logger.getInstance().log();
    }
}

class Logger {
    private Logger() {}
    private static Logger instance = null;

    void log() {

    }
    static Logger getInstance() {
        if (instance == null) {
            synchronized (instance) {
                if (instance == null) {
                    instance =  new Logger();
                }
            }
        }
        return instance;
    }
}
