package kt.interfaces.javaImpl;

import kt.interfaces.javaImpl.JavaInterface;

public class JavaSample implements JavaInterface {
    @Override
    public void connectDots() {
        System.out.println(num1 + num2);
    }
}


interface JavaInterface {
    public static final int num1 = 98;
    int num2 = 97;
    public void connectDots();
}
