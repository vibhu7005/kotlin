import java.util.ArrayList;

public class Backtrack {

    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        int []arr = {1,2,3};
        backt(arr, 0);
    }

    static void backt(int arr[], int index) {
        if (index == arr.length) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i)+ " ");
            }
            System.out.println();
            return;
        }

        for (int i = index; i < arr.length; i++) {
            list.add(arr[i]);
            backt(arr, index + 1);
            list.remove(list.size()-1);
        }
    }
}
