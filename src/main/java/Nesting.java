public class Nesting {
    public static void main(String[] args) {
        Outers.Cout cout = new Outers.Cout();
        cout.eat();




        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}

class Outer {
    private int a;
    class Inner {
        void f() {
            int g = a;
        }
    }
}


class DF  {

}

interface Outers {
    void eat();
    class Cout implements Outers {
        @Override
        public void eat() {
            System.out.println("default eating pattern");
        }
    }
}
