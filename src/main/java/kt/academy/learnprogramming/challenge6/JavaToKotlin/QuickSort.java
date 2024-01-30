package kt.academy.learnprogramming.challenge6.JavaToKotlin;

public class QuickSort {

    public static void main(String args[]) {
        int arr[] = {1,3,2,6,1,2,2,3,6,7};
        QuickSort obj = new QuickSort();
        obj.quickSort(arr, 0 , arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    int arrangePivot(int arr[], int start, int n) {
        int pos = start;
        for (int i = start; i < n; i++) {
            if (arr[i] < arr[n]) {
                pos++;
            }
        }
        swap(arr, pos, n);
        int l = start;
        int r = n;
        while (l < pos) {
            if (arr[l] > arr[pos]) {
                while(r > pos) {
                    if (arr[r] < arr[pos]) {
                        swap(arr, l , r);
                        r--;
                        break;
                    }
                    r--;
                }
            }
            l++;
        }
        return pos;
    }
    void quickSort(int arr[], int start, int end) {
        if (start >= end) return;
        int pos = arrangePivot(arr, start, end);
        quickSort(arr, start, pos - 1);
        quickSort(arr, pos + 1, end);
    }
}
