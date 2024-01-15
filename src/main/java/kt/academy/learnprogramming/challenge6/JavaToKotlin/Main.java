package kt.academy.learnprogramming.challenge6.JavaToKotlin;

import java.io.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    boolean stop = false;
    int s = 0;
    public static void main(String[] args) {
        int x = 0;
        Main obj = new Main();
        int A[] = {2, 3, 6, 7};
        int b[] = A.clone();
        obj.doi(b);
//        for (int i = 0; i < A.length; i++) {
//            System.out.println(A[i] + " ");
//        }
        System.out.println(2*3/6);
//        int B = 7;
//        ArrayList<Integer> list = new ArrayList<>();
//        int arr[] = new int[500];
//        obj.generate(arr, B, A, 0, 0);
//        int ans[][] = new int[res.size()][];
//        for (int i = 0; i < res.size(); i++) {
//            ans[i] = new int[res.get(i).size()];
//            for (int j = 0; j < res.get(i).size(); j++) {
//                ans[i][j] = res.get(i).get(j);
//            }
//        }
//        System.out.println(x);
    }

    void doi(int m[]) {
        m[2] = 3;
    }

    int add(int arr[], int ind) {
        int sum = 0;
        for (int i = 0; i< ind; i++) {
            sum += arr[i];
        }
        return sum;
    }

    void generate(int arr[], int target, int[] A, int start, int index) {
        int sum = s;
        if (sum >= target) {
            if (sum == target) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i=0;i<index;i++){
                    list.add(arr[i]);
                }
                res.add(list);
            }
            stop = true;
            return;
        }

        for (int i = start; i < A.length; i++) {
            arr[index] = A[i];
            s += A[i];
            generate(arr, target, A, i, index + 1);
            s -= A[i];
            if (stop) break;
        }
        stop = false;
    }
}
