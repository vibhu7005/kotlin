package facto;

public interface Database {
    void getConnectionLimit();
    void getMemoryLimit();

    //factory method
    Query getQuery();
}
