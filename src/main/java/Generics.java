import java.util.ArrayList;
import java.util.List;

public class Generics {
    public static void main(String[] args) {
        Truck<BuildingMaterials> truck = new Truck<>();
        List<SandBags> sandBags = new ArrayList<>();
        List<Brick> brickList = new ArrayList<>();
        Brick brick = new Brick();
        truck.load(brick);
        truck.loadAll(sandBags);
        truck.loadAll(brickList);
    }
}

class BuildingMaterials { }

class SandBags extends BuildingMaterials { }

class Brick extends BuildingMaterials { }

class Truck<T> {
    List<T> goods = new ArrayList<>();

    public void loadAll(List<? extends T> goods) {
        this.goods.addAll(goods);
    }

    public void load(T item) {
        goods.add(item);
    }
}




