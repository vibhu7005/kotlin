public class IceCreamGenerator {

    interface IceCream {
        int getPrice();
        String getDescription();
        boolean containsScoob();
    }

    public static void main(String[] args) {
        IceCream i = new ChocolateCone();
        IceCream h = new ChocoScoob(i);
        try {
            IceCream doubleChcoclateScoob = new ChocolateCone(new ChocoScoob(new ChocoScoob(new ChocolateCone())));
            System.out.println(doubleChcoclateScoob.getDescription());
            System.out.println(doubleChcoclateScoob.getPrice());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    static class ChocolateCone implements IceCream {

        IceCream iceCream;
        ChocolateCone() {}

        ChocolateCone(IceCream iceCream) throws Exception {
            if (iceCream.containsScoob()) throw new Exception("Not valid");
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
    }

    static class VanillaCone implements IceCream  {

        IceCream iceCream;
        VanillaCone() {}

        VanillaCone(IceCream iceCream) throws Exception {
            if (iceCream.containsScoob()) throw new Exception("Not valid");
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
   }
}
