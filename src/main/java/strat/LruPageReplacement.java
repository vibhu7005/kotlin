package strat;

import java.util.*;

public class LruPageReplacement implements PageReplacementStrategy {

    Queue<Integer> pages = new LinkedList<>();

    @Override
    public void removePage() {
        System.out.println("page removed");
        pages.remove();
    }

    @Override
    public void addPage() {
        pages.add(2);
    }

    @Override
    public void iNotify() {
        addPage();
    }
}
