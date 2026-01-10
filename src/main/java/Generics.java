import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Generics {
    public static void main(String[] args) {
        List<SandBags> sandBags = new ArrayList<>();
        sandBags.add(new SandBags());
        sandBags.add(new SandBags());
        
        // Comparator<BuildingMaterials> can be used to sort List<SandBags>
        // because SandBags IS-A BuildingMaterials
        Comparator<BuildingMaterials> materialComparator = (a, b) -> 0;
        Collections.sort(sandBags, materialComparator);  // Contravariance in action!
        
        // ===== PRACTICAL USE 3: Consumer Interface =====
        // Consumer uses contravariance - can consume supertypes
        Consumer<BuildingMaterials> materialConsumer = (m) -> System.out.println("Processing: " + m);
        List<SandBags> sandBagList = new ArrayList<>();
        sandBagList.forEach(materialConsumer);  // Consumer<BuildingMaterials> works with List<SandBags>
        
        // ===== PRACTICAL USE 4: Custom Example =====
        Truck<BuildingMaterials> truck = new Truck<>();
        truck.load(new SandBags());
        truck.load(new Brick());
        
        // Can unload into List<BuildingMaterials> or List<Object>
        List<BuildingMaterials> materialsList = new ArrayList<>();
        List<Object> objectList = new ArrayList<>();
        
        truck.unloadAll(materialsList);  // ✓ Contravariance
        truck.unloadAll(objectList);     // ✓ Contravariance
    }
}

class BuildingMaterials { }

class SandBags extends BuildingMaterials { }

class Brick extends BuildingMaterials { }

class Truck<T> {
    List<T> goods = new ArrayList<>();

    // COVARIANCE: ? extends T - for READING from subtypes
    public void loadAll(List<? extends T> goods) {
        this.goods.addAll(goods);  // Reading from parameter list
    }

    public void load(T item) {
        goods.add(item);
    }
    
    // CONTRAVARIANCE: ? super T - for WRITING to supertypes
    // Practical use: Can write to List<BuildingMaterials> or List<Object>
    // This is how Java's Collections.addAll() works!
    public void unloadAll(List<? super T> destination) {
        destination.addAll(this.goods);  // Writing to destination (contravariance)
        this.goods.clear();
    }
}




