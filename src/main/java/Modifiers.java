public class Modifiers implements sd,SDFF {

    Modifiers(int x) {
        this.s = x;
    }
    static final int a;
    final int s;
    {
//       s = 34;
    }

    static  {
        a = 34;
    }

    int sum(int a, int b) {
        return a+b;
    }



    public static void main(String[] args) {
        Modifiers modifiers = new Modifiers(23);
        System.out.println(modifiers.s);
        System.out.println(Modifiers.a);

        String s = "a" + "b".toUpperCase();
        String sb = "aB";
        System.out.println(s);



    }

    @Override
    public void sum() {
        sd.super.sum();
    }
}

abstract class NJ  {
    NJ() {}
    static final int a = 5;

    final void sum() {

    }

}


interface sd {
     default void sum() {

    }
}



interface SDFF {
    default void sum() {

    }
}
