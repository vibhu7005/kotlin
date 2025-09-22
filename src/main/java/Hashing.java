import kotlin.Pair;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Hashing {

    static ArrayList<ArrayList<Pair<Integer, Integer>>> list = new ArrayList<>();




    public static void main(String[] args) {
        String s = new String("xxyzxxyzwxxyzxxyzx");
        StringBuilder sb = new StringBuilder(s);

        int l = 0;
        int r = 0;
        int z[] = new int[s.length()];
        z[0] = s.length();

        for (int i = 1; i < sb.length(); i++) {
            if (i > r) {
                l = i;
                r = i;
                while (r < s.length() && sb.charAt(r) == sb.charAt(r-l)) {
                    r++;
                }
                z[i] = r - l;
                r--;
            } else {
                int d = z[i-l];

                if ((i-l+d) < (r - l + 1)) {
                    z[i] = d;
                } else {
                    l = i;
                    while (r < s.length() && sb.charAt(r) == sb.charAt(r-l)) {
                        r++;
                    }
                    z[i] = r - l;
                    r--;
                }
            }

        }

        for (int i = 0; i < z.length; i++) {
            System.out.println(z[i] + " ");
        }
    }

    static int hashcode(int n)  {
        return n % 10;
    }

    static void put (int key, int value) {
        int hash = hashcode(key);
        Pair<Integer,Integer> p = new Pair<>(key,value);


    }
}
