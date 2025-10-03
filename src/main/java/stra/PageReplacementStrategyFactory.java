package stra;

public class PageReplacementStrategyFactory {
    static PageReplacementStrategy getPageReplacementStrategy (Cpu cpu) {
        return new LruPageReplacement(cpu);
    }
}
