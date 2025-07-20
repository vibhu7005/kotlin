package inheritance.vehicle;



public class Car extends Vehicle {
    public String engine;

    public static void fooo(Integer i) {
        System.out.println(i);
    }

    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("hulk");
        Integer i =12;
        fooo(i);
        i = 13;
        System.out.println(i);
    }



}
