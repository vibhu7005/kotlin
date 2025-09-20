import java.util.ArrayList;

public class Backtrack {

    static int []arr = {1,2,3};

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        backt(0, list, 0);
    }

    static void backt( int index, ArrayList<Integer>list, int h) {
        if (index == arr.length) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = h; i < arr.length; i++) {
            list.add(arr[index]);
            backt(index + 1, list, h);
            list.remove(list.size() - 1);
        }

    }
}
