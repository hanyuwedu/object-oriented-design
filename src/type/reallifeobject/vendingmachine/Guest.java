package type.reallifeobject.vendingmachine;

public class Guest {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();
        Coke coke = new Coke();
        Sprite sprite = new Sprite();
        BottleWater bottleWater = new BottleWater();

        Item item;

        vm.refill(coke, 10);
        vm.refill(sprite, 1);

        System.out.println(vm.toString());

        vm.selectItem(coke);
        vm.pay(0.23);

        item = vm.get();

        vm.pay(2.00);
        item = vm.get();

        System.out.println(vm.toString());

        /// Exception
//        vm.get();

        vm.selectItem(sprite);
        vm.pay(1.25);
        item = vm.get();

        System.out.println(vm.toString());

        /// Exception
//        vm.selectItem(sprite);
    }
}
