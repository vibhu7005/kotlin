import java.util.Arrays;
import java.util.HashMap;

public class Hashing {

    public static void main(String[] args) {
        int [] arr = {2,0,1,2,0};
        Arrays.sort(arr);
        HashMap<Integer, Integer> map = new HashMap<>();
        int k = 1;
        int count =0;
        for(int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i] - k)) {
                count += map.get(arr[i]-k);
            }

            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else map.put (arr[i], 1);
        }

        System.out.println(count);
    }
}
