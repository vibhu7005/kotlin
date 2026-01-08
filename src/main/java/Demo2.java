public class Demo2 {

    public static void main(String[] args) {
        int a = -256;
        byte b = (byte)a;
        System.out.println(b);
        double d1 = 0.1;
        double d2 = 0.2;
        double d3 = 0.3;
        System.out.println((d1 + d2) == d3);
        int x = 3;
        fund(x);
        System.out.println(x);


    }

     static void fund(int x) {
        x = x + 4;
    }
}
