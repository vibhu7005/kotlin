public class Generics {
    public static void main(String[] args) {
        Packet<Integer, String> p = new Packet<>();
        p.setA(23);
        p.setB("lol");
        System.out.println(p.produceA());
        System.out.println(p.produceB());
    }
}


class Packet<T, K> {
    private T a;
    private K b;
    T produceA () {
        return a;
    }

    void setA(T a) {
        this.a = a;
    }

    void setB(K b) {
        this.b = b;
    }

    K produceB() {
        return b;
    }
}