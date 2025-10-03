public class IceCreamGenerator {

    interface IceCream extends Prototype{
        int getPrice();
        String getDescription();
        boolean containsScoob();
    }

    public static void main(String[] args) {
        IceCream i = new ChocolateCone();
        IceCream h = new ChocoScoob(i);
        try {
            IceCream doubleChcoclateScoob = new ChocoScoob(new ChocoScoob(new ChocolateCone()));
            System.out.println(doubleChcoclateScoob.getDescription());
            System.out.println(doubleChcoclateScoob.getPrice());

            IceCream clone = (IceCream) doubleChcoclateScoob.mClone();

            System.out.println(clone.getDescription());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    static class ChocolateCone implements IceCream {

        IceCream iceCream;
        ChocolateCone() {}

        ChocolateCone(IceCream iceCream)  {
            if (iceCream.containsScoob())
            this.iceCream = iceCream;
        }

        @Override
        public int getPrice() {
            if (iceCream == null) return 10;
            return iceCream.getPrice() + 10;
        }

        @Override
        public String getDescription() {
            if (iceCream == null) return "Chocolate cone";
            return iceCream.getDescription() + "Chocolate cone";
        }

        @Override
        public boolean containsScoob() {
            if (iceCream == null) return false;
            return iceCream.containsScoob();
        }

        @Override
        public Prototype mClone() {
            return new ChocolateCone(iceCream);
        }
    }

    static class VanillaCone implements IceCream  {

        IceCream iceCream;
        VanillaCone() {}

        VanillaCone(IceCream iceCream) {

            this.iceCream = iceCream;
        }

        @Override
        public int getPrice() {
            if (iceCream == null) return 5;
            return iceCream.getPrice() + 5;
        }

        @Override
        public String getDescription() {
            if (iceCream == null) return "Vanilla cone";
            return iceCream.getDescription() + "Vanilla cone";
        }

        @Override
        public boolean containsScoob() {
            if (iceCream == null) return false;
            return iceCream.containsScoob();
        }

        @Override
        public Prototype mClone() {
            return new VanillaCone(iceCream);
        }
    }

   static class ChocoScoob implements IceCream {

        IceCream iceCream;

        ChocoScoob(IceCream iceCream) {
            this.iceCream = iceCream;
        }

        @Override
        public int getPrice() {
            return iceCream.getPrice() + 50;
        }

        @Override
        public String getDescription() {
            return iceCream.getDescription() + "Choco scoob";
        }

       @Override
       public boolean containsScoob() {
           return true;
       }

       @Override
       public Prototype mClone() {
           return new ChocoScoob(iceCream);
       }
   }

   interface Prototype {
        Prototype mClone();
   }
}
