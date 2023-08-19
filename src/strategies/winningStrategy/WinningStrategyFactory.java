package strategies.winningStrategy;

public class WinningStrategyFactory {
    public static WinningStrategy getWinningStrategy(int dimensions){ return new OrderOneWinningStrategy(dimensions);

    }
}
