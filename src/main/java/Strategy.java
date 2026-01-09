enum Strategy {
    Pending(0), Complete(1);
    private final int value;

    Strategy(int x) {
        this.value = x;
    }

    public void printValue() {
        System.out.println(this.value);
    }
}


class Jk {
    public static void main(String[] args) {
        Strategy s = Strategy.Pending;
        s.printValue();
    }
}

