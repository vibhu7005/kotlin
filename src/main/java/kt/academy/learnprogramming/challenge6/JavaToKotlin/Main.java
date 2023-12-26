package kt.academy.learnprogramming.challenge6.JavaToKotlin;

import java.io.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Main obj = new Main();
//        Integer x = 4;
//        obj.calc(x);
//        System.out.println(x);
        String s = "abc";
        StringBuilder sb  = new StringBuilder("xxx");
        Map<Character, Integer> map = new HashMap();
//        for (int i = 0; i < s.length(); i++) {
//            if (map.containsKey(s.charAt(i))) {
//                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
//            } else {
//                map.put(s.charAt(i), 1);
//            }
//            sb.append("x");
//        }
        boolean visited[] = new boolean[3];
        obj.subsets(s, 0, sb);
    }

    void calc(Integer x) {
        x++;
    }

    boolean check(int index, StringBuilder sb) {
        if (index < 2) return true;
        if (sb.length() < 2) return true;

        for (int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == 'a' && sb.charAt(i+1) == 'b')
                return false;
        }
        return true;
    }

     void permute(String s, int index, StringBuilder sb, boolean visited[]) {
        if (index == s.length()) {
            System.out.println(sb);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.setCharAt(index, s.charAt(i));
                permute(s, index + 1, sb, visited);
                visited[i] = false;
            }
        }
     }

    void subsets(String s, int index, StringBuilder sb) {
        if (index == s.length()) {
            System.out.println(sb);
            return;
        }
        sb.setCharAt(index, '0');
        subsets(s, index + 1, sb);
        sb.setCharAt(index, '1');
        subsets(s, index + 1, sb);
    }


     //abc
    //


}
