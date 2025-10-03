package facto;

public class MongoDb implements Database{
    @Override
    public void getConnectionLimit() {

    }

    @Override
    public void getMemoryLimit() {

    }

    @Override
    public Query getQuery() {
        return new MongoDbQuery();
    }
}
