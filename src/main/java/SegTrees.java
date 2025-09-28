public class SegTrees {

    static int seg[] = new int[16];
    public static void main(String[] args) {
        int arr[] = {8,7,9,11,10};
        create(arr, 0, 0, arr.length-1);

        update(11, 5);

//        System.out.println(query(0,0, arr.length-1,0,1));



        for (int i = 0; i < seg.length; i++) {
            System.out.println(seg[i]);
        }

    }

    static void update(int source, int targetValue) {
        int index = 0;
       for (int i = seg.length-1; i>=0; i--) {
           if (seg[i] == source) {
               index = i;
               break;
           }
       }

       seg[index] = targetValue;
       index = (index-1)/2;
       while (index != 0) {
           seg[index] = Math.min(seg[2*index+1], seg[2*index+2]);
           index = (index-1)/2;
       }
       seg[index] = Math.min(seg[2*index+1], seg[2*index+2]);



    }

    static void create(int []arr, int index, int start, int end) {
        if (start >= end) {
            seg[index] = arr[end];
            return;
        }
        int mid = (start + end)/2;
        int lIndex = 2 * index + 1;
        int rIndex = lIndex + 1;
        create(arr, lIndex, start, mid);
        create(arr, rIndex, mid+1, end);
        seg[index] = Math.min(seg[lIndex], seg[rIndex]);
    }

    static int query(int index, int start, int end, int l, int r) {
       if (l > end || r < start) {
           return Integer.MAX_VALUE;
       }

       if (l <= start && end <= r) {
           return seg[index];
       }

       int lIndex = 2*index+1;
       int rIndex = lIndex+1;
       int mid = (start + end)/2;
       return Math.min(query(lIndex, start, mid, l, r), query(rIndex, mid+1, end, l,r));
    }
}
