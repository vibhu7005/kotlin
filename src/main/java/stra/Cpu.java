package stra;

import java.util.ArrayList;
import java.util.List;

public class Cpu {
    List<Page> pageList = new ArrayList<>();
    PageReplacementStrategy strategy;
    List<PageAddedListener> observers = new ArrayList<>();

    Cpu() {
        this.strategy = PageReplacementStrategyFactory.getPageReplacementStrategy(this);
    }

    void subscribe(PageAddedListener listener) {
        observers.add(listener);
    }


    void unsubscribe(PageAddedListener listener) {
        observers.remove(listener);
    }


    void addPage(Page page) {
        pageList.add(page);
        for (PageAddedListener observer : observers) {
            observer.pageAdded(page);
        }
    }

    void cleanup() {
        strategy.replacePage();
    }
}
