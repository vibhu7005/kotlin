public class RT {


    public static void main(String[] args) {



    }
}

interface Database {
    int getConnectionLimit();
    int getMaxLoad();
    Query getQuery();
}

interface Query {

}

class PostGreyQuery implements Query { }

class MongoDbQuery implements Query { }

class PostgreyDb implements Database {

    @Override
    public int getConnectionLimit() {
        return 0;
    }

    @Override
    public int getMaxLoad() {
        return 0;
    }

    @Override
    public Query getQuery() {
        return null;
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
    private Logger() {
    }

    private static Logger instance = null;

    void log() {

    }

    static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }
}

 class Config {
    private int barrels;
    private int rollers;
    private Builder builder;



    private Config(Builder builder) {
        this.barrels = builder.barrels;
        this.rollers = builder.rollers;
    }

    static Builder getBuilder() {
        return new Builder();
    }

       static class Builder {
        private Builder() {
        }

        private int barrels;
        private int rollers;

        public Builder setBarrels(int barrels) {
            this.barrels = barrels;
            return this;
        }

        public Builder setRollers(int rollers) {
            this.rollers = rollers;
            return this;
        }

        public Config build() {
            return new Config(this);
        }
    }


}
