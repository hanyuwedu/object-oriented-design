package type.game.blackjack.v2.roles;

import java.util.Random;

public class Dealer extends Role {
    private int point;

    public Dealer() {
        super.name = "Dealer";
    }

    /**
     * 为荷官初始化状态，生成一个18~19之间的随机数作为手牌点数
     */
    @Override
    public void initialize() {
        this.initialize(new Random());
    }

    /**
     * 为荷官初始化状态，生成一个18~19之间的随机数作为手牌点数
     *
     * @param random 生成随机数的机制
     */
    public void initialize(Random random) {
        this.point = random.nextInt(2) + 18;
    }

    /**
     * @return 荷官的手牌分数
     */
    @Override
    public int getPoint() {
        return this.point;
    }

    @Override
    public void printDetail() {
        System.out.println("Dealer has " + this.point + " points");
    }
}
