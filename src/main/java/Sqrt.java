public class Sqrt {

    public static void main(String[] args) {

        System.out.println(new Sqrt().sqrtCalc(10));
    }

    int sqrtCalc(int x) {
       return calc(x, 1, x);
    }


//    int calc(int x, int start, int end) {
//        if (start > end) return -1;
//        int mid = (start+end)/2;
//        int d = mid * mid;
//        if (d == x) return mid;
//        if (d < x) {
//            return calc(x, mid + 1, end);
//        } else {
//            return calc(x, start, mid - 1);
//        }
//    }

    int calc(int x, int start, int end) {
        if (start > end) return start;  // Return the largest valid value

        int mid = start + (end - start) / 2;  // Avoid overflow
        int square = mid * mid;  // Avoid overflow

        if (square == x) return mid;

        if (square < x) {
            return calc(x, mid + 1, end);
        } else {
            return calc(x, start, mid - 1);
        }
    }
}
