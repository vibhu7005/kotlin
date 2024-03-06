package kt.academy.learnprogramming.challenge5;

import kotlin.collections.CollectionsKt;
import kt.academy.learnprogramming.challenge2.Array;
import kt.academy.learnprogramming.challenge2.oop.A;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String arr[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        HashMap<String, ArrayList<Integer>> map = new HashMap();
        String arr2[] = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            char[] ar = arr[i].toCharArray();
            Arrays.sort(ar);
            String sorted = String.valueOf(ar);
            if (!map.containsKey(sorted)) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(sorted, list);
            } else {
                ArrayList<Integer> list = map.get(sorted);
                list.add(i);
                map.put(sorted, list);
            }
        }

        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            ArrayList<Integer> list = entry.getValue();
            for (int i = 0; i < list.size(); i++) {
                System.out.print(arr[list.get(i)] + " ");
            }
            System.out.println();
        }

    }
}




//class
