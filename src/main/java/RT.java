public class RT {



    public static void main(String[] args) {
        Logger.getInstance().log();
        Logger.getInstance().log();
        Naman.INSTANCE.printValue();
    }
}

enum Naman {
    INSTANCE(90);
    private int value;
    Naman(int value) {
        this.value = value;
    }
    void printValue() {
        System.out.println(value);
    }
}

class Logger {
    private Logger() {}
    private static Logger instance = null;

    void log() {

    }
    static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance =  new Logger();
                }
            }
        }
        return instance;
    }
}
