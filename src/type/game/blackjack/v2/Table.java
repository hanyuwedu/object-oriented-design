package type.game.blackjack.v2;

import type.game.blackjack.v2.cards.Card;
import type.game.blackjack.v2.exceptions.InvalidGameException;
import type.game.blackjack.v2.exceptions.InvalidTossException;
import type.game.blackjack.v2.roles.Dealer;
import type.game.blackjack.v2.roles.Player;
import type.game.blackjack.v2.util.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Table {
    private Dealer dealer;
    private List<Player> players;
    private Stack<Card> cardStack;

    private final int STACK = 2;
    private final int CARDS = 30;
    private final Random RANDOM = new Random(0);
    private final int MAX_PLAYER = 4;
    private final int MAX_POINT = 21;
    private final int INITIAL_CARDS = 2;

    public Table(Dealer dealer) {
        this.dealer = dealer;
        this.players = new ArrayList<>();
    }

    /**
     * 将赌客添加到当前牌局
     *
     * @param player 被添加的赌客
     */
    public void sit(Player player) {
        if (players.size() >= this.MAX_PLAYER) {
            throw new InvalidGameException("Players are overwhelming.");
        } else {
            this.players.add(player);
            player.setTable(this);  /// 双向关联
        }
    }

    /**
     * 将赌客从当前牌局中移除
     *
     * @param player 被移除的赌客
     */
    public void leave(Player player) {
        this.players.remove(player);
    }

    /**
     * 初始化本局游戏：
     *
     * 初始化所有赌客
     * 初始化新牌堆
     */
    public void initialize() {
        this.dealer.initialize();
        for (Player player : players) {
            player.initialize();
        }

        this.cardStack = Utility.getRandomStack(this.STACK, this.CARDS, this.RANDOM);
    }

    /**
     * 为本局所有赌客分发初始手牌
     */
    public void dealInitialCards() {
        for (int i = 1; i <= this.INITIAL_CARDS; i++) {
            for (Player player : players) {
                player.toss(0);
            }
        }
    }

    /**
     * 从本局牌堆中获得下一张牌
     *
     * @return 牌堆的下一张牌
     */
    public Card getNextCard() {
        if (cardStack == null || cardStack.isEmpty()) {
            throw new InvalidTossException("Card stack is running out.");
        }

        return this.cardStack.pop();
    }

    /**
     * 结算本局游戏：
     *
     * 如果有玩家没有听牌，则会抛出异常
     * 比较每位玩家的点数，并且为每他们清算筹码
     */
    public void summary() {
        for (Player player : this.players) {
            if (player.isOpen()) {
                throw new InvalidGameException("Player " + player.getName() + " is still open.");
            }
        }

        for (Player player : this.players) {
            System.out.println("Dealer has " + this.dealer.getPoint() + " points.");
            if (player.getPoint() > this.MAX_POINT || player.getPoint() <= this.dealer.getPoint()) {
                player.summary(false);
            } else {
                player.summary(true);
            }
        }
    }
}
