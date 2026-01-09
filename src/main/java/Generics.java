public class Generics {
    public static void main(String[] args) {
        Xyz obj = new Xyz("abc", 34);
    }
}

class Xyz<T,E> {
    final T first;
    E second;
    public Xyz(T first, E second) {
        this.first = first;
        this.second = second;
    }
}



