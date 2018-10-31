package type.game.blackjack.v2.roles;

public abstract class Role {
    protected String name;

    /**
     * 初始化角色的游戏状态
     */
    protected abstract void initialize();

    /**
     * @return 角色的手牌分数
     */
    protected abstract int getPoint();

    protected abstract void printDetail();
}
