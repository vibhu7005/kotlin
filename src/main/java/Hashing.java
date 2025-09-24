import kotlin.Pair;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Hashing {

    static ArrayList<ArrayList<Pair<Integer, Integer>>> list = new ArrayList<>();


    public static void main(String[] args) {
        System.out.println(stairs(3));
    }

    static int stairs(int n) {
        if (n == 0) {
           return 1;
        }
        if (n == 1) {
            return stairs(n - 1);
        } else {
            return stairs(n - 1) + stairs(n - 2);
        }
    }
}
