public class NestedClass {


    public static void main(String[] args) {
        Ads ads = new Ads();
        Ads.InnerClass innerClass = ads.new InnerClass();
        Ads.StaticInnterClass staticInnterClass = new Ads.StaticInnterClass();

    }
}

class Ads {
    int g;
    static int sd;
    class InnerClass{
        void fg() {
            int d = g;
            class B {
                void f() {
//                    d++;
                }
            }
            g = 45;
        }
    }
    static class StaticInnterClass{
        int x =0;
        void sum() {}

    }
}
