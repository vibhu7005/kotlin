import java.util.ArrayList;

public class Backtrack {

    static int []array = {1,2,3};

    static boolean []visited = new boolean[3];

    public static void main(String[] args) {
        int brr[] = new int[3];
        backt(0,brr);
    }

    static void backt( int index, int[] arr) {
        if (index == arr.length) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] +" ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                arr[index] = array[i];
                visited[i] = true;
                backt(index + 1, arr);
                visited[i] = false;
            }
        }
    }
}
