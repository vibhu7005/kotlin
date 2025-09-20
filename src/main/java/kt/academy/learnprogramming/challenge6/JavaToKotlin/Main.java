package kt.academy.learnprogramming.challenge6.JavaToKotlin;
import java.util.ArrayList;

public class Main {
    static int B[] = new int[5];

    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    boolean stop = false;
    int s = 0;
    public static void main(String[] args) {
        Main obj = new Main();
        int A[] = {7,6,5,4,3};
        obj.mergeSort(A, 0, A.length-1);
        for (int i = 0; i < A.length; i++) {
            System.out.print(B[i] + " ");
        }
    }

    void mergeSort(int A[], int start, int end) {
        if (start == end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(A, start, mid);
        mergeSort(A, mid + 1, end);
        mergeArrays(A, start, mid, end);
    }

    void mergeArrays(int A[], int start, int mid, int end) {
        int l1 = start;
        int r1 = mid;
        int x = start;
        int l2 = mid + 1;
        int r2 = end;
        while (l1 <= r1 && l2 <= r2) {
            if (A[l1] < A[l2]) {
                B[x++] = A[l1];
                l1++;
            } else {
                B[x++] = A[l2];
                l2++;
            }
        }

        while (l1 <= r1) {
            B[x++] = A[l1];
            l1++;
        }

        while (l2 <= r2) {
            B[x++] = A[l2];
            l2++;
        }
        int p = start;
        for (int i = start; i <= end; i++) {
            A[i] = B[i];
        }
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
