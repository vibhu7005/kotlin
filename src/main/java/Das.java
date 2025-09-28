import java.util.Arrays;

public class Das {
    static int[][]lcs = new int[100][100];
    public static void main(String[] args) {
        for (int i = 0; i < lcs.length; i++) {
            Arrays.fill(lcs[i],-1);
        }
        char a[] = {'a','b','b','c','d','g','f'};
        char b[] = {'b','b','a','d','c','g','f','z','x','w'};
        System.out.println(lcs(a,b, a.length-1, b.length-1));
    }

    static int lcs(char a[],char b[], int i, int j) {
        if (i < 0 || j < 0) return 0;
        if (lcs[i][j] != -1) return lcs[i][j];
        if (a[i] == b[j]) {
            lcs[i][j] = 1 + lcs(a,b, i-1, j-1);
        }
        else lcs[i][j] = Math.max(lcs(a,b, i-1,j), lcs(a,b,i,j-1));
        return lcs[i][j];
    }
}
