package kt.academy.learnprogramming.challenge6.JavaToKotlin;

import java.io.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Main obj = new Main();
        String s = "abc";
        StringBuilder sb  = new StringBuilder();
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i) , 1);
            sb.append("x");
        }
        obj.permute(s, 0, sb, map);
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

     void permute(String s, int index, StringBuilder sb, Map<Character,Integer>map) {
        if (index == s.length()) {
            System.out.println(sb);
            return;
        }
        for (int i = 0; i < map.size(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                sb.setCharAt(index, s.charAt(i));
                map.put(s.charAt(i), 0);
                permute(s, index + 1, sb, map);
                map.put(s.charAt(i), 1);
            }
        }
     }


     //abc
    //


}
