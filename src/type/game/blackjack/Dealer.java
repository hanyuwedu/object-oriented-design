package type.game.blackjack;

import java.util.Random;

public class Dealer {
    String name;

    public Dealer() {
        this.name = "dealer";
    }

    public int toss() {
        Random random = new Random();
        return random.nextInt(3) + 18;
    }
}
