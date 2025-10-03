package strat;

public interface PageReplacementStrategy extends Subscriber {
    void removePage();
    void addPage();
}
