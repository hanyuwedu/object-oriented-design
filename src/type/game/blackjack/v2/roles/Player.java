package type.game.blackjack.v2.roles;

import type.game.blackjack.v2.Table;
import type.game.blackjack.v2.cards.Hand;
import type.game.blackjack.v2.exceptions.InvalidGameException;
import type.game.blackjack.v2.exceptions.InvalidTossException;

public class Player extends Role {
    private Table table;
    private int asset;
    private int bet;
    private Hand hand;
    private boolean isOpen;

    public Player(String name, int asset) {
        if (asset <= 0) {
            throw new InvalidGameException("Player with invalid asset!");
        }

        this.name = name;
        this.asset = asset;
    }

    /**
     * 为赌客初始化状态
     * 清空手牌和筹码
     * 设置摸牌状态为是
     */
    @Override
    public void initialize() {
        this.bet = 0;
        this.isOpen = true;
        this.hand = new Hand();
    }

    /**
     * 押注并且从牌桌的牌堆中抽取一张牌
     * 如果摸牌状态为否则不可以摸牌，抛出异常
     * 如果押注超过筹码总额，则会抛出异常
     *
     * @param bets 下注筹码
     */
    public void toss(int bets) {
        if (this.hand == null) {
            throw new InvalidTossException("Game is not started yet");
        }

        if (!isOpen) {
            throw new InvalidTossException("Player " + this.name + " is closed for further toss.");
        }

        if (bets >= this.asset) {
            throw new InvalidTossException("Haven't got enough bet.");
        }

        this.setBet(this.getBet() + bets);
        this.setAsset(this.getAsset() - bets);

        this.hand.add(this.table.getNextCard());
    }

    /**
     * 赌客不继续摸牌，将摸牌状态设置为否
     */
    public void close() {
        this.setOpen(false);
    }

    /**
     * 结算赌客手牌不超过21的最大分数
     * @return 赌客的手牌不超过21的最大分数
     */
    @Override
    public int getPoint() {
        return this.hand.count();
    }

    /**
     * 为赌客结算本局
     * 如果获胜则赢得所有筹码，否则失去所有筹码
     *
     * @param win 该赌客是否获胜
     */
    public void summary(boolean win) {
        if (win) {
            System.out.println("Player " + this.name + " won with " + this.hand.count() + " points");
            this.setAsset(this.getAsset() + this.bet * 2);
        } else {
            System.out.println("Player " + this.name + " lost with " + this.hand.count() + " points");
        }

        System.out.println("His current asset is " + this.getAsset());
        this.initialize();
    }

    public String getName() {
        return name;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public int getAsset() {
        return asset;
    }

    public void setAsset(int asset) {
        this.asset = asset;
    }

    @Override
    public void printDetail() {
        System.out.println("Player " + this.name + " is " + (isOpen ? "open." : "closed."));
        System.out.println("His " + this.hand.toString());
        System.out.println("His current bet is " + this.bet);
        System.out.println("His total asset is " + this.asset);
    }
}
