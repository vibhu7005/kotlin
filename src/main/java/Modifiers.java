public class Modifiers {

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

    }
}
