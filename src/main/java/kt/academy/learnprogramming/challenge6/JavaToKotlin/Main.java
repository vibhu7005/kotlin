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
//        String s = "abc";
//        StringBuilder sb  = new StringBuilder("xxx");
//        Map<Character, Integer> map = new HashMap();
////        for (int i = 0; i < s.length(); i++) {
////            if (map.containsKey(s.charAt(i))) {
////                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
////            } else {
////                map.put(s.charAt(i), 1);
////            }
////            sb.append("x");
////        }
//        boolean visited[] = new boolean[3];
//        obj.subsets(s, 0, sb);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4 * 2 ; i++) {
            sb.append('x');
        }
        obj.generate(sb, 0, 4 * 2);
//        String ans[] = new String[res.size()];
//        ArrayList<String> res = new ArrayList<>();
//        for (int i = 0; i < ans.length; i++) {
//            ans[i] = res.get(i);
//        }
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





        boolean isbalanced(String s) {
            int x = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    x += 1;
                } else {
                    x -= 1;
                }
                if (x < 0) {
                    return false;
                }
            }
            if (x != 0) {
                return false;
            }
            return true;
        }
        boolean checkLimit(String s, int A) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    count += 1;
                }
                if (count >= A) {
                    return false;
                }
            }
            return true;
        }


        void generate(StringBuilder sb, int index, int len) {
            if (index == len) {
                if (isbalanced(sb.toString())) {
                    System.out.println(sb.toString());
                }
                return;
            }
            if (checkLimit(sb.toString(), (len/2))) {
                sb.setCharAt(index, '(');
                generate(sb, index + 1, len);
            } else {
                sb.setCharAt(index, ')');
                generate(sb, index + 1, len);
            }
        }
    }



    //abc
    //


}
