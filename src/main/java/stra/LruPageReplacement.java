package stra;

import java.util.Stack;

public class LruPageReplacement implements PageReplacementStrategy, PageAddedListener {
    Cpu cpu;
    LruPageReplacement(Cpu cpu) {
        this.cpu = cpu;
        cpu.subscribe(this);
    }



    Stack<Page> pageStack = new Stack<>();
    @Override
    public void replacePage() {
        pageStack.pop();
    }


    @Override
    public void pageAdded(Page page) {
        pageStack.push(page);
    }
}
