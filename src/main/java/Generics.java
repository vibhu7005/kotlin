import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Generics {
    public static void main(String[] args) {
        // ===== STEP-BY-STEP EXPLANATION: Collections.addAll() =====
        
        // STEP 1: What are we trying to do?
        // We want to add BuildingMaterials (and its subtypes) to different lists
        
        // STEP 2: Understanding the hierarchy
        // Object (most general)
        //   └── BuildingMaterials
        //         ├── SandBags
        //         └── Brick
        
        // STEP 3: What Collections.addAll() does
        // Signature: Collections.addAll(Collection<? super T> c, T... elements)
        // It adds elements of type T to a collection
        
        // STEP 4: Example - Adding BuildingMaterials to different lists
        
        // Case A: Adding to List<BuildingMaterials> (exact match)
        List<BuildingMaterials> materialsList = new ArrayList<>();
        Collections.addAll(materialsList, new SandBags(), new Brick());
        // ✓ WORKS! Why? List<BuildingMaterials> can hold BuildingMaterials
        System.out.println("Case A - Materials list: " + materialsList.size() + " items");
        
        // Case B: Adding to List<Object> (supertype)
        List<Object> objectList = new ArrayList<>();
        Collections.addAll(objectList, new SandBags(), new Brick());
        // ✓ WORKS! Why? List<Object> can hold ANYTHING, including BuildingMaterials
        // This is contravariance: we can write BuildingMaterials to a "bigger" container (Object)
        System.out.println("Case B - Object list: " + objectList.size() + " items");
        
        // Case C: What if we try List<SandBags>? (subtype)
        // List<SandBags> sandBagList = new ArrayList<>();
        // Collections.addAll(sandBagList, new Brick());  // ✗ ERROR!
        // ✗ DOESN'T WORK! Why? 
        //    - List<SandBags> can ONLY hold SandBags
        //    - Brick is NOT a SandBag (Brick and SandBag are siblings, both extend BuildingMaterials)
        //    - You can't put a Brick into a list that only accepts SandBags
        
        // STEP 5: The Key Insight
        // Contravariance (? super T) means: "Give me a container that can hold T or something BIGGER"
        // - List<BuildingMaterials> ✓ (can hold BuildingMaterials)
        // - List<Object> ✓ (can hold anything, including BuildingMaterials)
        // - List<SandBags> ✗ (can ONLY hold SandBags, not all BuildingMaterials)
        
        // VISUAL ANALOGY:
        // Think of it like boxes:
        // - Small box (List<SandBags>) - can only fit SandBags ✗
        // - Medium box (List<BuildingMaterials>) - can fit BuildingMaterials, SandBags, Bricks ✓
        // - Large box (List<Object>) - can fit ANYTHING ✓
        // 
        // Collections.addAll() says: "I need a box that's AT LEAST as big as BuildingMaterials"
        // So medium box ✓ and large box ✓ work, but small box ✗ doesn't
        
        // DEMONSTRATION: Let's see what's actually in the lists
        System.out.println("\n=== What's in each list? ===");
        System.out.println("Materials list contains: " + materialsList);
        System.out.println("Object list contains: " + objectList);
        System.out.println("\nBoth lists successfully received the BuildingMaterials!");
        
        // ===== PRACTICAL USE 2: Comparator Interface =====
        // Comparator uses contravariance - can compare supertypes
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




