package patterns.strategy;

public class StrategyFactory {
    private static StrategyFactory factory;

    private StrategyFactory() { }

    public static StrategyFactory getSingleton() {
        if (factory == null) {
            factory = new StrategyFactory();
        }
        return factory;
    }

    public IStrategy getStrategy(Class inputClass) {
        if (inputClass.equals(MostAvailableStrategy.class)) {
            return new MostAvailableStrategy();
        } else if (inputClass.equals(RandomStrategy.class)) {
            return new RandomStrategy();
        } else {
            return null;
        }
    }
}
