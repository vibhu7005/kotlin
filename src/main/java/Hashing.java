import kotlin.Pair;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Hashing {

    static ArrayList<ArrayList<Pair<Integer, Integer>>> list = new ArrayList<>();




    public static void main(String[] args) {
        for (int i = 0; i< 10; i++) {
            list.add(new ArrayList<Pair<Integer,Integer>>());
        }
    }

    static int hashcode(int n)  {
        return n % 10;
    }

    static void put (int key, int value) {
        int hash = hashcode(key);
        Pair<Integer,Integer> p = new Pair<>(key,value);
        if (list.size() <
        list.add(hash, p);

    }
}
