package strat;

import java.util.ArrayList;
import java.util.List;

class Page{}

public class Cpu {
    PageReplacementStrategy strategy;
    Cpu(PageReplacementStrategy strategy) {
        this.strategy = strategy;
        subscribers.add(strategy);
    }
    private List<Page> pages = new ArrayList<>();
    private List<Subscriber> subscribers = new ArrayList<>();

    void addPage() {
        pages.add(2);
        for (Subscriber subscriber : subscribers) {
            subscriber.iNotify();
        }
    }

    void remove() {
        strategy.removePage();
    }
}
