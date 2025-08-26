package typecasting;

public class JavaTypeCasting {

    public static void main(String[] args) {
//        int a = 'd';
//        System.out.println(a);

//        byte b = (byte) 128;
//        System.out.println(b);

        int i = 9;
        if (i <= 1) System.out.println("non prime");
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                System.out.println("non prime");
                return;
            }
        }
        System.out.println("prime");
    }
}
