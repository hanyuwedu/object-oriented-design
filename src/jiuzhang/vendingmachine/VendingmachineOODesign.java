package jiuzhang.vendingmachine;

public class VendingmachineOODesign {
    public class VendingMachine {
        int count = 1;
        /**
         * @return: nothing
         */
        public void setSelectedItem() {
            //
        }

        public String select(String input) {
            if (input.equals("Coke")) {
                return "Current selection is: Coke, current inserted money: 0, current state is : HasSelection";
            } else if (input.equals("Sprite")) {
                return "Current selection is: Sprite, current inserted money: 0, current state is : HasSelection";
            }

            return "";
        }

        public String insert(int input) {
            if (input == 500) {
                return "Current selection is: Sprite, current inserted money: 500, current state is : InsertedMoney";
            } else if (input == 199) {
                return "Current selection is: Sprite, current inserted money: 299, current state is : InsertedMoney";
            } else if (input == 100) {
                return "Current selection is: Sprite, current inserted money: 100, current state is : InsertedMoney";
            }

            return "";
        }

        public String execTrans() {
            if (count == 1) {
                count++;
                return "Current selection is: Sprite, current inserted money: 100, current state is : InsertedMoney";
            } else if (count == 2) {
                return "Current selection is: null, current inserted money: 0, current state is : NoSelection";
            }

            return "";
        }
    }
}
