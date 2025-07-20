import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4));
        list.forEach(System.out::println);

        Nam nam = new Nam();
        nam.foo((a,b) -> System.out.println(a + b));
    }

    static class Nam {
        void foo(Vfg vfg) {}
    }

    interface Vfg {
        void attend(int a, int b);
    }
}


