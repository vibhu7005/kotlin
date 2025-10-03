package strat;

import kt.academy.learnprogramming.challenge2.oop.C;

public class CpuClient {
    public static void main(String[] args) {
        Cpu cpu = new Cpu(new LruPageReplacement());
        cpu.addPage();
        cpu.addPage();
        cpu.remove();
    }
}
