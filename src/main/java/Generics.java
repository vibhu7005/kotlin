public class Generics {
    public static void main(String[] args) {
        Xyz obj = new Xyz("abc", 34);
        modify(obj);
        System.out.println(obj.second);
    }

    static void modify(Xyz x) {
        x.second = "lop";
    }
}

class Xyz<T,E> {
    final T first;
    E second;
    public Xyz(T first, E second) {
        this.first = first;
        this.second = second;
    }


    void calc() {
        Integer a = Integer.valueOf(45);
        Runnable run = new Runnable() {

            @Override
            public void run() {
                 ;//1908
            }
        };

        Thread thread = new Thread(run);
        thread.start();
    }
}




